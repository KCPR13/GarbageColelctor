package pl.kacper.misterski.garbagecollector.ui.another

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AnotherNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    goToMainActivity: ()-> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = "AnotherScreen"
    ) {
        composable("AnotherScreen") {
            AnotherScreen(
                onBackPressed = goToMainActivity,
            )
        }

    }
}