package com.android.gugugaga // 請確保這個 package 名稱與您專案的設定一致

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.android.gugugaga.R

class AudioPlayerService : Service() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if (mediaPlayer != null) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }


        mediaPlayer = MediaPlayer.create(this, R.raw.gugugaga_audio)

        mediaPlayer?.setOnCompletionListener {
            stopSelf()
        }

        mediaPlayer?.start()

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer != null) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}