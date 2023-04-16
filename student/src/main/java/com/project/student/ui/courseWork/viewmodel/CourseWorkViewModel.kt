package com.project.student.ui.courseWork.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.domain.models.CourseWorkDetails
import com.project.domain.usecases.GetStudentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseWorkViewModel @Inject constructor(
    val getStudentUseCase: GetStudentUseCase
) : ViewModel() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db = Firebase.firestore

    private val _resourcesList = MutableStateFlow<Flow<List<CourseWorkDetails>>>(emptyFlow())
    val resourceList = _resourcesList.asStateFlow()

    private val _subjectList = MutableStateFlow<Flow<List<String>>>(emptyFlow())
    val subjects = _subjectList.asStateFlow()

    val subjectList = arrayListOf<String>()
    private val resources = listOf<String>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            auth.currentUser?.email?.let {
                getResources(it)
            }
        }
    }

    private fun getResources(email: String) = viewModelScope.launch(Dispatchers.IO) {
        val student = getStudentUseCase(email)
        val docRef = db.collection("subjects").document(student?.sem.toString()).collection(student?.branch.toString()).get()
        docRef.addOnCompleteListener {
            if (it.isSuccessful) {
                for (doc in it.result) {
                    subjectList.add(doc.id)
                }
                Log.d("TAG", subjectList.toString())
                _subjectList.value = flow {
                    emit(subjectList)
                }
            } else {
                Log.d("TAG", "Error getting documents: ", it.exception)
            }
        }
    }

    fun getResourcesForSubject(subjectId: String) = viewModelScope.launch(Dispatchers.IO) {
        val student = getStudentUseCase(auth.currentUser?.email.toString())
        val resList = mutableListOf<CourseWorkDetails>()
        val resourceRef = db.collection("subjects").document(student?.sem.toString()).collection(student?.branch.toString()).document(subjectId).get()
        resourceRef.addOnCompleteListener {
            if (it.isSuccessful) {
                val resources = it.result.get("resources") as ArrayList<Map<String, String>>
                if (resources != null) {
                    for (resource in resources) {
                        val date = resource["date"].toString()
                        val name = resource["name"].toString()
                        val resourceUrl = resource["resource_url"].toString()
                        val type = resource["type"].toString()
                        resList.add(CourseWorkDetails(name, date, resourceUrl, type, subjectId, student?.sem.toString()))
                        Log.d("TAG", resList.toString())
                    }
                    _resourcesList.value = flow {
                        emit(resList)
                    }
                }
            } else {
                Log.d("TAG", "Error getting documents: ", it.exception)
            }
        }
    }
}
