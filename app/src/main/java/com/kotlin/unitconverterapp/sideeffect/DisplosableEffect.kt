package com.kotlin.unitconverterapp.sideeffect

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun DisposableEffect() {
    val context = LocalContext.current

    DisposableEffect(Unit) {
        var mediaPlayer = MediaPlayer.create(context, com.kotlin.unitconverterapp.R.raw.sound)
        mediaPlayer.start()
        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
            Log.d("TAG", "DisposableEffect: media player released")
        }

    }
}


