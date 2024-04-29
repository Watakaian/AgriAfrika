package com.example.agriafrica.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agriafrica.ui.theme.screens.about.AboutScreen
import com.example.agriafrica.ui.theme.screens.animal.AddAnimalScreen
import com.example.agriafrica.ui.theme.screens.animal.UpdateAnimalScreen
import com.example.agriafrica.ui.theme.screens.animal.ViewAnimalScreen
import com.example.agriafrica.ui.theme.screens.crop.AddCropScreen
import com.example.agriafrica.ui.theme.screens.crop.UpdateCropScreen
import com.example.agriafrica.ui.theme.screens.crop.ViewCropScreen
import com.example.agriafrica.ui.theme.screens.home.HomeScreen
import com.example.agriafrica.ui.theme.screens.login.LoginScreen
import com.example.agriafrica.ui.theme.screens.more.MoreScreen
import com.example.agriafrica.ui.theme.screens.products.AddProductsScreen
import com.example.agriafrica.ui.theme.screens.products.UpdateProductScreen
import com.example.agriafrica.ui.theme.screens.products.ViewProductScreen
import com.example.agriafrica.ui.theme.screens.products.ViewProductsScreen
import com.example.agriafrica.ui.theme.screens.signup.SignupScreen
import com.example.agriafrica.ui.theme.screens.taskmanager.AddTaskScreen
import com.example.agriafrica.ui.theme.screens.taskmanager.UpdateTaskScreen
import com.example.agriafrica.ui.theme.screens.taskmanager.ViewTaskScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = LOGIN_URL
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL){
            HomeScreen(navController = navController)
        }
        composable(ADD_PRODUCTS_URL){
            AddProductsScreen(navController = navController)
        }
        composable(VIEW_PRODUCTS_URL){
            ViewProductsScreen(navController = navController)
        }

        composable(MORE_URL){
            MoreScreen(navController = navController)
        }
        composable(ABOUT_URL){
            AboutScreen(navController = navController)
        }
        composable(VIEW_USER_PRODUCT){
            ViewProductScreen(navController = navController)
        }
        composable(ROUTE_UPDATE_PRODUCTS){
            UpdateProductScreen(navController = navController)
        }

        composable(ADD_TASK){
            AddTaskScreen(navController = navController)
        }
        composable(VIEW_TASKS){
            ViewTaskScreen(navController = navController)
        }
        composable(ADD_ANIMAL){
            AddAnimalScreen(navController = navController)
        }
        composable(VIEW_ANIMAL){
            ViewAnimalScreen(navController = navController)
        }
        composable(ADD_CROP){
            AddCropScreen(navController = navController)
        }
        composable(VIEW_CROP){
            ViewCropScreen(navController = navController)
        }
        composable(UPDATE_TASK){
            UpdateTaskScreen(navController = navController)
        }
        composable(UPDATE_CROP){
            UpdateCropScreen(navController = navController)
        }
        composable(UPDATE_ANIMAL){
            UpdateAnimalScreen(navController = navController)
        }
    }
}