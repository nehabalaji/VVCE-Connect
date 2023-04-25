package com.project.student.ui.notification.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.domain.models.Notification
import com.project.domain.usecases.GetStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    val getStudentUseCase: GetStudentUseCase
) : ViewModel() {

    private val _notificationList = MutableStateFlow<Flow<List<Notification>>>(emptyFlow())
    val notificationList = _notificationList.asStateFlow()

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    val announcementList = arrayListOf<Notification>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            auth.currentUser?.email?.let {
                getNotificationList(it)
            }
        }
    }

    private fun getNotificationList(email: String) = viewModelScope.launch(Dispatchers.IO){
        val student = getStudentUseCase(email)
        db.collection("announcements").document(student?.branch.toString()).collection(student?.sem.toString()).document(student?.section.toString()).get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val notifications = it.result.get("notifications") as ArrayList<Map<String, String>>
                    for (notification in notifications) {
                        val message = notification["message"].toString()
                        val date = notification["date"].toString()
                        val teacher = notification["teacher"].toString()
                        announcementList.add(Notification(message, date, teacher))
                    }
                    _notificationList.value = flow {
                        emit(announcementList)
                    }
                } else {
                    Log.d("TAG", "Error getting documents: ", it.exception)
                }
            }
    }
}
