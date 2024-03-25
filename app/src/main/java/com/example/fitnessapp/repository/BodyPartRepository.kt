package com.example.fitnessapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fitnessapp.api.BodyPartExerciseAPI
import com.example.fitnessapp.models.exerciesModel
import com.example.fitnessapp.util.NetworkResult
import org.json.JSONObject
import javax.inject.Inject

class BodyPartRepository @Inject constructor( private val bodyPartExerciseAPI: BodyPartExerciseAPI ) {
    private val _bodyPartLiveData = MutableLiveData<NetworkResult<exerciesModel>>()
    val bodyPartLiveData : LiveData<NetworkResult<exerciesModel>>
        get() = _bodyPartLiveData

    private val _statusLiveData = MutableLiveData<NetworkResult<String>>()
    val statusLiveData : LiveData<NetworkResult<String>>
        get() = _statusLiveData

    suspend fun getBodyPartExercise( bodyPart : String ){
        _bodyPartLiveData.postValue(NetworkResult.Loading())
        val response = bodyPartExerciseAPI.getBodyPart( bodyPart)
        Log.d("repoBodyPart" , response.body().toString())
        if (response.isSuccessful && response.body() != null) {
            _bodyPartLiveData.postValue(NetworkResult.Success(response.body()!!))
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            _bodyPartLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
        } else {
            _bodyPartLiveData.postValue(NetworkResult.Error("Something went wrong"))
        }
    }
}