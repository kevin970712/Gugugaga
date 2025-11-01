package com.android.gugugaga

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val serviceIntent = Intent(this, AudioPlayerService::class.java)
        startService(serviceIntent)

        finish()
    }
}