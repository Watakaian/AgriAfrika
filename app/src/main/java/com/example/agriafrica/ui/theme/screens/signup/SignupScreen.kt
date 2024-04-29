package com.example.agriafrica.ui.theme.screens.signup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agriafrica.R
import com.example.agriafrica.data.AuthViewModel
import com.example.agriafrica.navigation.LOGIN_URL
import com.example.agriafrica.ui.theme.WazitoECommerceTheme
import com.example.agriafrica.ui.theme.back_green
import com.example.agriafrica.ui.theme.main_green
import com.example.agriafrica.ui.theme.secondary_green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController:NavHostController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(main_green)
    ){
        // variables used in activity
        val mContext = LocalContext.current
        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        // end of variables used in activity
        //App column to center text and icon
        Spacer(modifier = Modifier.height(15.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Text(
                text = "AgriAfrica",
                color = Color.White,
                fontSize = 43.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.agriafricaicon),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = "Helping Africa Grow",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif
            )

            Spacer(modifier = Modifier.height(8.dp))

        }
        // End of column that centers text and icon

        Spacer(modifier = Modifier.height(12.dp))


        // Start of card having text field values
        val  scrollStateVertical = rememberScrollState()
        Card (
            shape = RoundedCornerShape(topStart = 23.dp, topEnd = 23.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(scrollStateVertical),
            colors = CardDefaults.cardColors(
                containerColor = back_green
            )
        ){
            //Column to allow centering of card contents
            Column (
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Spacer(modifier = Modifier.height(7.dp))

                Text(
                    text = "Create an Account",
                    textDecoration = TextDecoration.Underline,
                    fontSize = 30.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = { Text(text="eg. Wanyoyi") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "username icon"
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = secondary_green,
                        unfocusedBorderColor = main_green,
                        focusedLeadingIconColor = secondary_green,
                        unfocusedLeadingIconColor = main_green,
                        focusedLabelColor = secondary_green,
                        unfocusedLabelColor = main_green,
                    ),
                    label = { Text(text = "Username") }
                )

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text(text="eg. Wanyoyi@gmail.com") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "email icon"
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = secondary_green,
                        unfocusedBorderColor = main_green,
                        focusedLeadingIconColor = secondary_green,
                        unfocusedLeadingIconColor = main_green,
                        focusedLabelColor = secondary_green,
                        unfocusedLabelColor = main_green,
                    ),
                    label = { Text(text = "Email") }
                )

                Spacer(modifier = Modifier.height(10.dp))


                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text(text="eg. wany#456") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Lock"
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = secondary_green,
                        unfocusedBorderColor = main_green,
                        focusedLeadingIconColor = secondary_green,
                        unfocusedLeadingIconColor = main_green,
                        focusedLabelColor = secondary_green,
                        unfocusedLabelColor = main_green,
                    ),
                    label = { Text(text = "Password") },
                )

                Spacer(modifier = Modifier.height(13.dp))
                val context = LocalContext.current
                val authViewModel = AuthViewModel(navController, context)

                //Button
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = {
                    if (name == "" || email == "" || password == ""){
                        Toast.makeText(context, "Please input a value", Toast.LENGTH_SHORT).show()
                    }else{
                        authViewModel.signup(name, email, password)
                    }
                },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(main_green),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 0.dp)
                ) {
                    Text(text = "Sign up")
                }
                //End of button
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text="Have an account ? Log in instead",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(LOGIN_URL)
                        },
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Serif,
                    color = main_green
                )

            }
            //End of column to allow centering of card contents
        }
        //End of card holding text fields
    }
}

@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){
    WazitoECommerceTheme {
        SignupScreen(navController = rememberNavController())
    }
}