package com.example.observer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel(){

    //var counter:Int=0

    private val _counter = MutableLiveData<Int>()

    //getter of counter
    val getCounter:LiveData<Int>
        get() = _counter


    init {
        Log.d("ViewModel","ViewModel initialised")
        _counter.value = 0
    }

    fun increment(){
        _counter.value = _counter.value?.plus(1)
    }

    fun decrement(){
        _counter.value = _counter.value?.minus(1)
    }

    override fun onCleared() {
        Log.d("ViewModel","ViewModel cleared")
        super.onCleared()
    }
}