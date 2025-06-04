package pl.kacper.misterski.garbagecollector.ui

import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pl.kacper.misterski.garbagecollector.core.ScreenReceiver
import pl.kacper.misterski.garbagecollector.navigation.AppNavHost
import pl.kacper.misterski.garbagecollector.ui.another.AnotherActivity
import pl.kacper.misterski.garbagecollector.ui.theme.GarbageCollectorTheme
import pl.kacper.misterski.garbagecollector.util.AppFileLogger
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val screenReceiver = ScreenReceiver()

    @Inject
    lateinit var appFileLogger: AppFileLogger


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GarbageCollectorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    AppNavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        navController = navController,
                        openAnotherActivity = {
                            startActivity(Intent(this, AnotherActivity::class.java))
                        }
                    )

                }
            }
        }
        val filter = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_ON)
            addAction(Intent.ACTION_SCREEN_OFF)
        }

        registerReceiver(screenReceiver, filter)
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(screenReceiver)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        when (newConffig.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                appFileLogger.log("GC_TEST", "MainActivity, Landscape mode")
            }
            Configuration.ORIENTATION_PORTRAIT -> {
                appFileLogger.log("GC_TEST", "MainActivity, Portrait mode")
            }
        }
    }
}




