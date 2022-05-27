package com.example.jobintentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

/*
    JobIntentService combines the two services
    1. Job service i.e. jobScheduler
    2. IntentService

    The JobIntentService has been deprecated use workManger or foreground service instead.
    With job intent service we can set attributes on a job like we did with jobScheduler, it will start
    as soon as possible.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        val editText = findViewById<EditText>(R.id.editText)
        findViewById<Button>(R.id.enqueueWork)
            .setOnClickListener {
                val str = editText.text.toString()
                val intent = Intent(this, JobIntentServiceClass::class.java)
                intent.putExtra("key", str)
                JobIntentServiceClass.enqueueWork(this, intent)
            }
    }
}