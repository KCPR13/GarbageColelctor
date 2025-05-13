package pl.kacper.misterski.garbagecollector.ui.second

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(onBack: () -> Unit, goToMain: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement =
            Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("SecondScreen", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            onBack.invoke()
        }) {
            Text("Back")
        }
        Button(onClick = {
            goToMain.invoke()
        }) {
            Text("Open new main fragment")
        }
        Button(onClick = {
            System.gc()
            Runtime.getRuntime().gc()
            System.runFinalization()
            Log.d("GC_TEST", "Manual GC triggered.")
        }) {
            Text("Force GC")
        }
    }
}