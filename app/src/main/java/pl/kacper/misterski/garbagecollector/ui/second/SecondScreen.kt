package pl.kacper.misterski.garbagecollector.ui.second

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(onBack: () -> Unit, goToMain: () -> Unit,
                 openThirdScreen: () -> Unit,
                 createObjectWithContext: (Context) -> Unit) {
    val context = LocalContext.current.applicationContext

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement =
            Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("2", fontSize = 40.sp)

        Spacer(modifier = Modifier.height(24.dp))

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
            Text("Open new MainScreen")
        }
        Button(onClick = {
            openThirdScreen.invoke()
        }) {
            Text("Open new ThirdScreen")
        }

        Button(onClick = {
            createObjectWithContext.invoke(context)
        }) {
            Text("Create object with context")
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