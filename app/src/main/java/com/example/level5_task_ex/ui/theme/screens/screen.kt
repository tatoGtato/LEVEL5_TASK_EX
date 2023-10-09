package com.example.level5_task_ex.ui.theme.screens


sealed class screen(
    val route: String
) {
    object HomeScreen: screen("home_screen")
    object CreateQuizScreen: screen("create_quiz_screen")
    object PlayQuizScreen: screen("play_quiz_screen")
}

//In some sense, sealed classes are similar to enum classes: the set of values for an enum type is
//also restricted, but each enum constant exists only as a single instance, whereas a subclass of a
//sealed class can have multiple instances, each with its own state.