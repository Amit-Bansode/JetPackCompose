package com.kotlin.unitconverterapp.sideeffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kotlin.unitconverterapp.ui.theme.UnitConverterAppTheme

class SideEffectsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterAppTheme {
//                SideEffect()
//                RememberUpdateState()
//                DisposableEffect()
                ProduceState()
            }
        }
    }
}
