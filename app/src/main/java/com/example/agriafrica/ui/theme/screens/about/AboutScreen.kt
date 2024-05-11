package com.example.agriafrica.ui.theme.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agriafrica.R
import com.example.agriafrica.navigation.HOME_URL
import com.example.agriafrica.ui.theme.card_green
import com.example.agriafrica.ui.theme.home_green
import com.example.agriafrica.ui.theme.secondary_green

@Composable
fun AboutScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(home_green)
            .verticalScroll(rememberScrollState())
    ) {
        Column (
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 3.dp)
        ){
            Spacer(modifier = Modifier.height(8.dp))
            // home icon
            Row (
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.clickable { navController.navigate(HOME_URL) },
                    tint = secondary_green
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Home",
                    modifier = Modifier.clickable { navController.navigate(HOME_URL) },
                    fontWeight = FontWeight.SemiBold,
                    color = secondary_green
                )
            }
            //end of home icon
            //intro row
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                //card holding icon
                Card (
                    modifier = Modifier
                        .size(70.dp),
                    shape = RoundedCornerShape(50),
                    colors = CardDefaults.cardColors(
                        containerColor = card_green
                    )
                ){
                    Image(
                        painter = painterResource(id = R.drawable.agriafricaicon),
                        contentDescription = "top icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp)
                    )
                }
                //end of card holding icon

            }
            Text(
                text = "How To Use",
                color = secondary_green,
                fontSize = 28.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )
            // intro row end
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "AgriAfrica is an application that intends to solve the issues facing small-scale " +
                    "farmers in Africa.",
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Buy Goods Screen",
                color = secondary_green,
                fontSize = 23.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .padding(horizontal = 45.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.agriafricabuyscreen),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "You will find products and goods which fellow users of AgriAfrica have " +
                    "uploaded with their quoted price and location. You can contact them through text messages " +
                    "or call them directly to negotiate on the price and try to strike a deal.",
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Sell Goods Screen",
                color = secondary_green,
                fontSize = 23.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .padding(horizontal = 45.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.agriafricasellscreen),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "You will be welcomed with a form that allows you to upload your product to " +
                    "the servers to allow buying of your goods by other AgriAfrica users. By clicking" +
                    " on \"View Products\" button (indicated by the orange arrow) you will be able to see " +
                    "all products that you have ever uploaded with your account and allows updating and deleting" +
                        " of the same.",
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Crop Manager Screen",
                color = secondary_green,
                fontSize = 23.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .padding(horizontal = 45.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.afriafricacropscreen),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "You will be able to have an inventory of all the crops you have planted or are planning to plant." +
                        "Clicking on the \"Add Crop\" button will take you to a form that will allow entry of a new crop into the" +
                        " inventory. Consider checking out the buy goods screen if you require a certain commodity. This saves your data online but" +
                        " but privately allowing access from multiple devices",
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Animal Manager Screen",
                color = secondary_green,
                fontSize = 23.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .padding(horizontal = 45.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.animalscreenshot),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "You will be able to have an inventory of all the animals you possess or are planning to possess." +
                        "Clicking on the \"Add Animal\" button will take you to a form that will allow entry of a new animal into the" +
                        " inventory. Consider checking out the buy goods screen if you require a certain commodity." ,
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Task Manager Screen",
                color = secondary_green,
                fontSize = 23.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .padding(horizontal = 45.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.taskscreenshot),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "Here you will be able to add tasks(to dos) which may relevant for your agricultural career." +
                        " By clicking on the \"Add Task\" you will be able to add a new task. This are saved online and you can" +
                        " access them from any android device as long as you logged into your account",
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "More Tasks Screen",
                color = secondary_green,
                fontSize = 23.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box (
                modifier = Modifier.fillMaxWidth()
                    .height(500.dp)
                    .padding(horizontal = 45.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.morescreenshot),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
            }

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                text = "Here you will be able to do additional tasks such as dealing with your account" +
                        " (creating an account, logging into a different account and logging out). You are also " +
                        "able to report bugs by use of email and share the application to your friends and colleagues",
                fontSize = 17.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AboutScreenPreview(){
    AboutScreen(navController = rememberNavController())
}