package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                    LemonApp()
                }
            }
        }
    }

@Composable
fun LemonApp() {
    var currentStep by remember { mutableIntStateOf(1) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> LemonStep(
                textResId = R.string.lemon_tree,
                imageResId = R.drawable.lemon_tree
            ) { currentStep = 2 }

            2 -> LemonStep(
                textResId = R.string.lemon_squeeze,
                imageResId = R.drawable.lemon_squeeze
            ) { currentStep = 3 }

            3 -> LemonStep(
                textResId = R.string.lemon_drink,
                imageResId = R.drawable.lemon_drink
            ) { currentStep = 4 }

            4 -> LemonStep(
                textResId = R.string.lemon_restart,
                imageResId = R.drawable.lemon_restart
            ) { currentStep = 1 }
        }
    }
}


@Composable
fun LemonStep(
    textResId: Int,
    imageResId: Int,
    onImageClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = stringResource(textResId))
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(imageResId),
            contentDescription = stringResource(textResId),
            modifier = Modifier
                .wrapContentSize()
                .clickable { onImageClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
       LemonApp()
    }
}