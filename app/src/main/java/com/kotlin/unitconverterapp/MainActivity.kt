package com.kotlin.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.kotlin.unitconverterapp.compose.BaseScreen
import com.kotlin.unitconverterapp.data.ConversionDB
import com.kotlin.unitconverterapp.data.ConversionRepositoryIMPL
import com.kotlin.unitconverterapp.ui.theme.UnitConverterAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factory: ConverterViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            UnitConverterAppTheme {
                BaseScreen(factory = factory, Modifier)
            }
        }
    }
}
