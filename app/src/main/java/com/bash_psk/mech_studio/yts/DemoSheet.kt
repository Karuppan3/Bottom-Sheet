package com.bash_psk.mech_studio.yts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoSheet(
    sheetState: SheetState,
    onDismiss: () -> Unit
) {

    when {

        sheetState.isVisible -> {

            ModalBottomSheet(
                modifier = Modifier.fillMaxSize(),
                onDismissRequest = onDismiss,
                sheetState = sheetState
            ) {

                Text(text = "Sheet Content Here!")
            }
        }
    }
}