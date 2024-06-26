package com.example.tweetly

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.image_library.ImagePreview
import com.example.tweetly.screens.CategoryScreen
import com.example.tweetly.screens.DetailScreen
import com.example.tweetly.api.TweetlyApi
import com.example.tweetly.ui.theme.TweetlyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContent {
            TweetlyTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Tweetly")
                            },
                        )
                    }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        ImagePreview(Image = painterResource(id = R.drawable.ic_launcher_background), modifier = Modifier.fillMaxSize() )
                    }
                }


            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {

        composable(route = "category") {
            CategoryScreen {
                navController.navigate("detail/$it")

            }
        }

        composable(route = "detail/{category}", arguments = listOf(navArgument("category") {
            type = NavType.StringType
        })) {
            DetailScreen()


        }

    }
}
