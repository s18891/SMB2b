package com.pjatk.smb2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var MyReceiver = MyBroadcastReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val intentFilter = IntentFilter("com.pjatk.smb2.MainActivity")
        if (intentFilter != null) {
            registerReceiver(MyReceiver, intentFilter)
        }
    }


    class MyBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Data Received from External App", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (MyReceiver != null) unregisterReceiver(MyReceiver)
    }
}