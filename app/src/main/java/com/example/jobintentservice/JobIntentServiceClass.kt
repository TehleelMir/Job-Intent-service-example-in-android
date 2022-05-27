package com.example.jobintentservice

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class JobIntentServiceClass: JobIntentService() {

    companion object {
        fun enqueueWork(context: Context, intent: Intent) {
            enqueueWork(context, JobIntentServiceClass::class.java, 123, intent)
        }
    }

    /*
        This method will run on a background thread, as same as the onHandleWork method of
        intent service.
     */
    override fun onHandleWork(intent: Intent) {
        val str = intent.extras?.getString("key") ?: ""
        Log.i("here22", "Inside OnHandleWork $str")

        for(i in 1..10) {
            if(isStopped) // it will be only true if onStopCurrentWork() was called.
                return

            Log.i("here22", "Running in background... $i")
            Thread.sleep(2000)
        }
    }

    /*
        This method gets called when the current job gets top if its running on
        job scheduler.
        return true to start it again later
        return false for otherwise
        default value is true
     */
    override fun onStopCurrentWork(): Boolean {
        return super.onStopCurrentWork()
    }
}