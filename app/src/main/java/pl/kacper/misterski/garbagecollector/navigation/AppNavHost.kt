package pl.kacper.misterski.garbagecollector.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pl.kacper.misterski.garbagecollector.ui.main.MainScreen
import pl.kacper.misterski.garbagecollector.ui.main.MainViewModel
import pl.kacper.misterski.garbagecollector.ui.second.SecondScreen
import pl.kacper.misterski.garbagecollector.ui.second.SecondViewModel
import pl.kacper.misterski.garbagecollector.ui.third.ThirdScreen
import pl.kacper.misterski.garbagecollector.ui.third.ThirdViewModel

//TODO K
//SCENARIOS
//1. Repository and UseCase
//2. DI configuration
//3. Standard Use Case
//4. Low battery mode
//5. Rotation
//6. Screen off
//7. NavigateUp (without and with screen rotation)
//8. 1 screen without any injection
//9. Force GC in both scenarios
//10. Another Activity
//11. Profiler (Track memory consumption / Analyze Memory Usage) and logcat comparison


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    openAnotherActivity: () -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationItem.Start.route,
    ) {
        composable(NavigationItem.Start.route) {
            //TODO K recomposition creates new VM
//           val key =  remember { mutableStateOf(UUID.randomUUID().toString()) }
//            val viewModel: MainViewModel = hiltViewModel(key = key.value)

            val viewModel: MainViewModel = hiltViewModel()
            MainScreen(
                showSecondScreen = {
                    navController.navigate(NavigationItem.Second.route)
                },
                openAnotherActivity = openAnotherActivity,
                logInfo = viewModel::log,
            )
        }
        composable(NavigationItem.Second.route) {
            val viewModel: SecondViewModel = hiltViewModel()
            SecondScreen(
                onBack = {
                    navController.navigateUp()
                },
                goToMain = {
                    navController.navigate(NavigationItem.Start.route)
                },
                openThirdScreen = {
                    navController.navigate(NavigationItem.Third.route)
                },
                logInfo = viewModel::log
            )
        }

        composable(NavigationItem.Third.route) {
            val viewModel: ThirdViewModel = hiltViewModel()

            ThirdScreen (
                onBack = {
                    navController.navigateUp()
                },
                goToMain = {
                    navController.navigate(NavigationItem.Start.route)
                },
                logInfo = viewModel::log,
            )
        }


    }
}