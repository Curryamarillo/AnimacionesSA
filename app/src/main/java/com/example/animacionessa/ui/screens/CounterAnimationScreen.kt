package com.example.animacionessa.ui.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animacionessa.ui.theme.splash

@Composable
fun CounterAnimationScreen() {

    var times by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = {
            Button(
                modifier = Modifier.padding(bottom = 20.dp),
                onClick = {
                    times++
                }
            ) {
                Text(
                    modifier = Modifier.padding(12.dp),
                    fontSize = 36.sp,
                    text = "+1"

                )
            }
            Button(
                modifier = Modifier.padding(bottom = 6.dp),
                onClick = {
                    times--
                }
            ) {
                Text(
                    modifier = Modifier.padding(12.dp),
                    fontSize = 36.sp,
                    text = "-1"

                )
            }
            AnimatedContent(
                targetState = times,
                transitionSpec = {
                    if (targetState < initialState) {
                        (slideInVertically { height -> height } + fadeIn())
                            .togetherWith(slideOutVertically { height -> -height } + fadeOut())
                    } else {
                        (slideInVertically { height -> -height } + fadeIn())
                            .togetherWith(slideOutVertically { height -> height } + fadeOut())
                    }
                },
                label = ""
            ) { targetCount ->
                        Text(
                            modifier = Modifier.padding(30.dp),
                            color = MaterialTheme.splash.ring1,
                            fontSize = 40.sp,
                            text = "$targetCount"
                        )
                    }
        }
    )
}