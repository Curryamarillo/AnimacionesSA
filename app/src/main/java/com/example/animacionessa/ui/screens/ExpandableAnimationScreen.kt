package com.example.animacionessa.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.animacionessa.R
import com.example.animacionessa.ui.theme.splash

@Composable
fun ExpandableAnimationScreen() {

    // Expanded controla la apertura a tamaño completo de la letra de la canción
    var expanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 21.dp)
                .wrapContentHeight()
                .clip(RoundedCornerShape(12.dp))
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    )
                )
                .background(MaterialTheme.colorScheme.background)
        ) {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = stringResource(R.string.tombstone_blues),
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = MaterialTheme.splash.ring3)

            }
            Text(
                modifier = Modifier.padding(start = 16.dp),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 20.sp,
                text = stringResource(R.string.bob_dylan_highway_61_revisited_1968)
            )
            // El textbutton controla el valor de expanded
            TextButton(
                onClick = {expanded = !expanded}) {
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    fontSize = 18.sp,
                    text = if (expanded) stringResource(R.string.menos) else stringResource(R.string.leer_mas),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.padding(8.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Justify,
                    text = stringResource(R.string.letra_cancion)
                )
            }
        }
    }

}