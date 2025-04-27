package pl.kacper.misterski.garbagecollector.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.kacper.misterski.garbagecollector.ui.main.MainScreen
import pl.kacper.misterski.garbagecollector.ui.main.MainViewModel
import pl.kacper.misterski.garbagecollector.ui.second.SecondScreen
import java.util.UUID

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationItem.Start.route,
    ) {
        composable(NavigationItem.Start.route) {
           val key =  remember { mutableStateOf(UUID.randomUUID().toString()) }
            val viewModel: MainViewModel = hiltViewModel(key = key.value)
            MainScreen(
                showSecondScreen = {
                    navController.navigate(NavigationItem.Second.route)
                }
            )
        }
        composable(NavigationItem.Second.route) {
            SecondScreen(
                onBack = {
                    navController.navigateUp()
                },
                goToMain = {
                    navController.navigate(NavigationItem.Start.route)
                }
            )
        }


    }
}