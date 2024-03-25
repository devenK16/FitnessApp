package com.example.fitnessapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fitnessapp.api.TargetExerciseAPI
import com.example.fitnessapp.models.exerciesModel
import com.example.fitnessapp.util.NetworkResult
import org.json.JSONObject
import javax.inject.Inject

class TargetRepository @Inject constructor( private val targetExerciseAPI: TargetExerciseAPI ) {

    private val _targetMuscleLiveData = MutableLiveData<NetworkResult<exerciesModel>>()
    val targetMuscleLiveData : LiveData<NetworkResult<exerciesModel>>
        get() = _targetMuscleLiveData

    private val _statusLiveData = MutableLiveData<NetworkResult<String>>()
    val statusLiveData : LiveData<NetworkResult<String>>
        get() = _statusLiveData
    suspend fun getTargetExercise( muscle : String ){
        _targetMuscleLiveData.postValue(NetworkResult.Loading())
        val response = targetExerciseAPI.getTargetPart(muscle)
        Log.d("repoTarget" , response.body().toString())
        if (response.isSuccessful && response.body() != null) {
            _targetMuscleLiveData.postValue(NetworkResult.Success(response.body()!!))
        } else if (response.errorBody() != null) {
            val errorObj = JSONObject(response.errorBody()!!.charStream().readText())
            _targetMuscleLiveData.postValue(NetworkResult.Error(errorObj.getString("message")))
        } else {
            _targetMuscleLiveData.postValue(NetworkResult.Error("Something went wrong"))
        }
    }
}