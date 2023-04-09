package com.bash_psk.mech_studio.yts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.bash_psk.mech_studio.yts.ui.theme.YTsTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            YTsTheme {

                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme
                        .colorScheme
                        .background
                ) {

                    val coroutineScope = rememberCoroutineScope()
                    val sheetState = rememberModalBottomSheetState()

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement
                            .Center,
                        horizontalAlignment = Alignment
                            .CenterHorizontally
                    ) {

                        DemoSheet(
                            sheetState = sheetState,
                            onDismiss = {

                                coroutineScope.launch {

                                    sheetState.hide()
                                }
                            }
                        )

                        Button(
                            onClick = {

                                coroutineScope.launch {

                                    sheetState.partialExpand()
                                }
                            }
                        ) {

                            Text(text = "Open Sheet")
                        }
                    }
                }
            }
        }
    }
}