package pl.kacper.misterski.garbagecollector.ui.main

import android.os.Handler
import android.os.Looper
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
import pl.kacper.misterski.garbagecollector.utils.TestObject
import java.lang.ref.WeakReference

@Composable
fun MainScreen(showSecondScreen: () -> Unit) {
    var mainScreenObject: WeakReference<TestObject>? = null
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement =
            Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Testing DI + GC", fontSize = 20.sp)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            System.gc()
            Runtime.getRuntime().gc()
            Log.d("GC_TEST", "Manual GC triggered.")
        }) {
            Text("Force GC")
        }

        Button(onClick = {
            showSecondScreen.invoke()
        }) {
            Text("Open second screen")
        }

        Button(onClick = {
            val obj = TestObject("Weak reference")
            mainScreenObject = WeakReference(obj)
        }) {
            Text("Create object")
        }
        Button(onClick = {
            System.gc()
            Handler(Looper.getMainLooper()).postDelayed({
                val isAlive = mainScreenObject?.get() != null
                Log.d("GC_TEST", "Is object alive? $isAlive")
            }, 3000) // daj GC trochę czasu
        }) {
            Text("Remove object")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Check Logcat with tag: GC_TEST", fontSize = 14.sp)
    }
}