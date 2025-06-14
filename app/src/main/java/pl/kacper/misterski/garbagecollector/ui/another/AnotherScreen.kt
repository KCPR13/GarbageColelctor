package pl.kacper.misterski.garbagecollector.ui.another

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
fun AnotherScreen(onBackPressed: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement =
            Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Another screen", fontSize = 40.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            System.gc()
            Runtime.getRuntime().gc()
            System.runFinalization()
            Log.d("GC_TEST", "Manual GC triggered.")
        }) {
            Text("Force GC")
        }

        Button(onClick = {
            onBackPressed.invoke()
        }) {
            Text("Back to MainActivity")
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}