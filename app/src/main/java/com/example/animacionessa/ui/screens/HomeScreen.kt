package com.example.animacionessa.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animacionessa.R
import com.example.animacionessa.navigation.Routes
import com.example.animacionessa.ui.theme.splash

@Composable
fun HomeScreen(navController: NavController) {

    // Como repito estos valores, los he pasado a variables para mejor control
    val paddingTop: Dp = 50.dp
    val buttonSize = Modifier.padding(top = paddingTop).width(260.dp).height(60.dp)

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                Text(
                    modifier = Modifier
                        .padding(top = 40.dp),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    text = stringResource(R.string.animaciones),
                    color = MaterialTheme.colorScheme.onSurface
                )
                // Para probar he elegido diferentes botones, cada uno tiene un navController
                // que dirige a su página
                Button(
                    modifier = buttonSize,
                    // Los colores los he cambiado para que hagan referencia visual al tema
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.splash.ring4,
                        contentColor = MaterialTheme.splash.titleFront
                    ),
                    onClick = {
                        navController.navigate(Routes.ColorAnimationScreen.route)
                    },
                    content = {
                        Text(
                            text = stringResource(R.string.color),
                            fontSize = 30.sp
                        )
                    }
                )
                FilledTonalButton(
                    modifier = buttonSize,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.splash.titleMid,
                        contentColor = MaterialTheme.splash.titleFront
                    ),
                    onClick = {
                        navController.navigate(Routes.AlphaAnimationScreen.route)
                    },
                    content = {
                        Text(
                            text = stringResource(R.string.alpha),
                            fontSize = 30.sp
                        )
                    }
                )
                OutlinedButton(
                    modifier = buttonSize,
                    // En este botón al color del borde se accede mediante esta propiedad
                    border = BorderStroke(2.dp, MaterialTheme.splash.titleFront),
                    onClick = {
                        navController.navigate(Routes.VisibilityAnimationScreen.route)
                    },
                    content = {
                        Text(
                            text = stringResource(R.string.visibility),
                            fontSize = 30.sp
                        )
                    }
                )
                ElevatedButton(
                    modifier = buttonSize,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.splash.ring3
                    ),
                    onClick = {
                        navController.navigate(Routes.CounterAnimationScreen.route)
                    },
                    content = {
                        Text(
                            text = stringResource(R.string.counter),
                            fontSize = 30.sp
                        )
                    }
                )
                TextButton(
                    modifier = buttonSize,
                    onClick = {
                        navController.navigate(Routes.CrossfadeAnimationScreen.route)
                    },
                    content = {
                        Text(
                            text = stringResource(R.string.crossfade),
                            fontSize = 30.sp,
                            color = MaterialTheme.splash.ring3
                        )
                    }
                )
                Button(
                    modifier = buttonSize,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.splash.titleFront
                    ),
                    onClick = {
                        navController.navigate(Routes.ExpandableAnimationScreen.route)
                    },
                    content = {
                        Text(
                            text = stringResource(R.string.expandable),
                            fontSize = 30.sp
                        )
                    }
                )

            }
        )
    }
