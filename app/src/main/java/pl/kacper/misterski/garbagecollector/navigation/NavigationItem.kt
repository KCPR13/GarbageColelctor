package pl.kacper.misterski.garbagecollector.navigation


sealed class NavigationItem(
    val route: String,
) {
    data object Start : NavigationItem(Screen.START.name)

    data object Second : NavigationItem(Screen.SECOND.name)

}