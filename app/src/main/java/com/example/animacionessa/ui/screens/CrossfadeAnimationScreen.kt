package com.example.animacionessa.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animacionessa.R
import com.example.animacionessa.ui.theme.splash
import java.nio.file.WatchEvent

@Composable
fun CrossfadeAnimationScreen() {

    val sections = arrayOf("Rolling Stones", "Beatles", "Beach Boys")
    var visibleContent by rememberSaveable { mutableStateOf(sections[0]) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        content = {
            Crossfade(
                targetState = visibleContent,
                label = ""
            ) { screen ->
                when (screen) {
                    "Rolling Stones" -> Image(
                        modifier = Modifier.size(350.dp).clip(RoundedCornerShape(12.dp)),
                        painter = painterResource(R.drawable.rolling_stones),
                        contentDescription = ""
                    )
                    "Beatles" -> Image(
                        modifier = Modifier.size(350.dp).clip(RoundedCornerShape(12.dp)),
                        painter = painterResource(R.drawable.sgt_peppers_lonely_hearts_club_band),
                        contentDescription = ""
                    )
                    "Beach Boys" -> Image(
                        modifier = Modifier.size(350.dp).clip(RoundedCornerShape(12.dp)),
                        painter = painterResource(R.drawable.pet_sounds),
                        contentDescription = ""
                    )

                }
            }
            Spacer(modifier = Modifier.size(28.dp))
            for (section in sections) {
                Button(
                    modifier = Modifier
                        .width(330.dp)
                        .padding(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.splash.ring3
                    ),
                    onClick = { visibleContent = section }
                ) {
                    Text(
                        text = section,
                        fontSize = 28.sp
                    )
                }

            }
        }
    )
}