package com.example.agriafrica.ui.theme.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agriafrica.R
import com.example.agriafrica.navigation.ABOUT_URL
import com.example.agriafrica.navigation.ADD_PRODUCTS_URL
import com.example.agriafrica.navigation.MORE_URL
import com.example.agriafrica.navigation.VIEW_ANIMAL
import com.example.agriafrica.navigation.VIEW_CROP
import com.example.agriafrica.navigation.VIEW_TASKS
import com.example.agriafrica.navigation.VIEW_USER_PRODUCT
import com.example.agriafrica.ui.theme.WazitoECommerceTheme
import com.example.agriafrica.ui.theme.card_green
import com.example.agriafrica.ui.theme.home_green
import com.example.agriafrica.ui.theme.home_green_main
import com.example.agriafrica.ui.theme.main_green
import com.example.agriafrica.ui.theme.secondary_green

@Composable
fun HomeScreen(navController:NavHostController){
    //Main column
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(home_green_main)
    ){

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
                modifier = Modifier.size(70.dp))
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


        val  scrollStateVertical = rememberScrollState()
        // Start of card having text field values
        Card (
            shape = RoundedCornerShape(topStart = 23.dp, topEnd = 23.dp),
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollStateVertical),
            colors = CardDefaults.cardColors(
                containerColor = home_green
            )
        ){
            //Column to allow centering of card contents
            Column (
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                
                Spacer(modifier = Modifier.height(5.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                    Text(
                        text = "Tabs",
                        fontSize = 27.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Left,
                        textDecoration = TextDecoration.Underline
                    )
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                navController.navigate(ABOUT_URL)
                            }
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "Help",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.clickable {
                                navController.navigate(ABOUT_URL)
                            }
                        )
                    }
                }

                //row 1
                Row {
                    //card 1
                    Card (
                        modifier = Modifier
                            .clickable {
                                navController.navigate(VIEW_USER_PRODUCT)
                            }
                            .height(160.dp)
                            .width(175.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = card_green
                        ),
                        border = BorderStroke(1.dp, main_green)
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(115.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.agribuy),
                                    contentDescription = null,
                                    modifier = Modifier.size(95.dp),
                                    )
                            }

                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "Buy Goods",
                                color = secondary_green,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    //end of card 1

                    Spacer(modifier = Modifier.width(13.dp))

                    //card 2
                    Card (
                        modifier = Modifier
                            .clickable {
                                navController.navigate(ADD_PRODUCTS_URL)
                            }
                            .height(160.dp)
                            .width(175.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = card_green
                        ),
                        border = BorderStroke(1.dp, main_green)
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(115.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.agrisell),
                                    modifier = Modifier.size(95.dp),
                                    contentDescription = null
                                )
                            }

                            Spacer(modifier = Modifier.width(3.dp))

                            Text(
                                text = "Sell Goods",
                                color = secondary_green,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    //end of card 2

                }
                //end of row 1

                Spacer(modifier = Modifier.height(15.dp))

                //row 2
                Row {
                    //card 1
                    Card (
                        modifier = Modifier
                            .clickable {
                                navController.navigate(VIEW_CROP)
                            }
                            .height(160.dp)
                            .width(175.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = card_green
                        ),
                        border = BorderStroke(1.dp, main_green)
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(115.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.agricrop),
                                    contentDescription = null,
                                    modifier = Modifier.size(95.dp),
                                )
                            }

                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "Crop Manager",
                                color = secondary_green,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    //end of card 1

                    Spacer(modifier = Modifier.width(15.dp))

                    //card 2
                    Card (
                        modifier = Modifier
                            .clickable {
                                navController.navigate(VIEW_ANIMAL)
                            }
                            .height(160.dp)
                            .width(175.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = card_green
                        ),
                        border = BorderStroke(1.dp, main_green)
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(105.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.agrianimal),
                                    modifier = Modifier.size(90.dp),
                                    contentDescription = null
                                )
                            }
                            Text(
                                text = "Animal",
                                color = secondary_green,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Manager",
                                color = secondary_green,
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    //end of card 2

                }
                //end of row 2

                Spacer(modifier = Modifier.height(15.dp))

                //row 3
                Row {
                    //card 1
                    Card (
                        modifier = Modifier
                            .clickable {
                                navController.navigate(VIEW_TASKS)
                            }
                            .height(160.dp)
                            .width(175.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = card_green
                        ),
                        border = BorderStroke(1.dp, main_green)
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(115.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.agritask),
                                    contentDescription = null,
                                    modifier = Modifier.size(95.dp),
                                )
                            }

                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "Task Manager",
                                color = secondary_green,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    //end of card 1

                    Spacer(modifier = Modifier.width(13.dp))

                    //card 2
                    Card (
                        modifier = Modifier
                            .clickable {
                                navController.navigate(MORE_URL)
                            }
                            .height(160.dp)
                            .width(175.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = card_green
                        ),
                        border = BorderStroke(1.dp, main_green)
                    ){
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(115.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ){
                                Image(
                                    painter = painterResource(id = R.drawable.agrimore),
                                    modifier = Modifier.size(95.dp),
                                    contentDescription = null
                                )
                            }

                            Spacer(modifier = Modifier.width(3.dp))

                            Text(
                                text = "More",
                                color = secondary_green,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                    //end of card 2

                }
                //end of row 3

            }
            //End of column to allow centering of card contents
        }
        //End of card holding text fields
    }
    //End of main column
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreview(){
    WazitoECommerceTheme {
        HomeScreen(navController = rememberNavController())
    }
}