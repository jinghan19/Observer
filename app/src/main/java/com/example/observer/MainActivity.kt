package com.example.observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Declare module-level variable
    private lateinit var counterViewModel:CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("main Activity","OnCreated")

        //Initialise the viewModel
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)
        //textViewCounter.text = counterViewModel.counter.toString()

        //add a observer to the counter
        counterViewModel.getCounter.observe(
            this,
            Observer {
                if(it.equals(4))
                    goodLuck()
            }
        )
        textViewCounter.text = counterViewModel.getCounter.value.toString()

        buttonIncrement.setOnClickListener{
            //counterViewModel.counter++
            //textViewCounter.text = counterViewModel.counter.toString()
            counterViewModel.increment()
            textViewCounter.text = counterViewModel.getCounter.value.toString()
        }

        buttonDecrement.setOnClickListener{
            //counterViewModel.counter--
            //textViewCounter.text = counterViewModel.counter.toString()
            counterViewModel.decrement()
            textViewCounter.text = counterViewModel.getCounter.value.toString()
        }
    }

    private fun goodLuck() {
        Toast.makeText(applicationContext,"good Luck!!!",Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        Log.d("Main Activity","onDestroy")
        super.onDestroy()
    }

}
