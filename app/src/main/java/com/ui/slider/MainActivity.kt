package com.ui.slider

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material.Slider as Slider1
import androidx.compose.material3.Slider as Slider3
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.ui.slider.ui.theme.SliderTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val slidingPaneLayout = findViewById<SlidingPaneLayout>(R.id.slidingPane)
        findViewById<View>(R.id.openDetailPane).setOnClickListener {
            slidingPaneLayout.openPane()
        }
        findViewById<ComposeView>(R.id.detailCompose).setContent {
            SliderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        var value1 by remember { mutableStateOf(0f) }
                        Slider1(value = value1, onValueChange = remember{ { value1 = it } })
                        var value3 by remember { mutableStateOf(0f) }
                        Slider3(value = value3, onValueChange = remember { { value3 = it } })
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SliderTheme {
        Greeting("Android")
    }
}