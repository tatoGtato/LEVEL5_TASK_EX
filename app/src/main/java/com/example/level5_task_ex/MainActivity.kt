package com.example.level5_task_ex

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.level5_task_ex.ui.theme.LEVEL5_TASK_EXTheme
import com.example.level5_task_ex.ui.theme.screens.CreateQuizScreen
import com.example.level5_task_ex.ui.theme.screens.HomeScreen
import com.example.level5_task_ex.ui.theme.screens.PlayQuizScreen
import com.example.level5_task_ex.ui.theme.screens.screen
import com.example.level5_task_ex.viewmodel.QuizViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context: Context = this
            setContent {

                QuizApp(context)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizApp(context: Context) {
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        QuizNavHost(context, navController, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun QuizNavHost(context: Context, navController: NavHostController, modifier: Modifier = Modifier) {

    val viewModel: QuizViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = screen.HomeScreen.route,
        modifier = modifier
    ) {
        composable(screen.HomeScreen.route) {
            HomeScreen(navController = navController, viewModel = viewModel)
        }
        composable(screen.CreateQuizScreen.route) {
            CreateQuizScreen(navController = navController, viewModel = viewModel)
        }
        composable(screen.PlayQuizScreen.route) {
            PlayQuizScreen(navController = navController, viewModel = viewModel)
        }
    }
}