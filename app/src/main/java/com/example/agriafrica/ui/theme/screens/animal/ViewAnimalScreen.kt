package com.example.agriafrica.ui.theme.screens.animal

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.agriafrica.R
import com.example.agriafrica.data.AnimalViewModel
import com.example.agriafrica.models.Animal
import com.example.agriafrica.navigation.ABOUT_URL
import com.example.agriafrica.navigation.ADD_ANIMAL
import com.example.agriafrica.navigation.HOME_URL
import com.example.agriafrica.ui.theme.back_green
import com.example.agriafrica.ui.theme.card_green
import com.example.agriafrica.ui.theme.main_green
import com.example.agriafrica.ui.theme.secondary_green
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ViewAnimalScreen(navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(back_green)
    ) {

        val context = LocalContext.current
        val animalRepository = AnimalViewModel(navController, context)

        val emptyAnimalState = remember { mutableStateOf(Animal("","","","","","","")) }
        val emptyAnimalsListState = remember { mutableStateListOf<Animal>() }

        val animals = animalRepository.allAnimals(emptyAnimalState, emptyAnimalsListState)

        Column (
            modifier = Modifier
                .background(back_green)
                .fillMaxSize(),
        ){

            Spacer(modifier = Modifier.height(8.dp))
            // home icon
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 6.dp),
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
                        },
                        tint = secondary_green
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Help",
                        color = secondary_green,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable {
                            navController.navigate(ABOUT_URL)
                        }
                    )
                }
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
                        painter = painterResource(id = R.drawable.agrianimal),
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
                text = "View Animals",
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                color = secondary_green
            )
            // intro row end
            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                    colors = ButtonDefaults.buttonColors(main_green)
                ) {
                    Text(
                        text = "View Animals",
                        fontSize = 16.sp
                    )
                }
                Button(
                    onClick = { navController.navigate(ADD_ANIMAL) },
                    shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                    colors = ButtonDefaults.buttonColors(card_green),
                ) {
                    Text(
                        text = "Add Animal",
                        color = secondary_green,
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            val currentUser = FirebaseAuth.getInstance().currentUser
            val currentUserId = currentUser?.uid

            LazyColumn(){
                items(animals){
                    if (it.userId == currentUserId){
                        AnimalItem(
                            name = it.name,
                            numbers = it.numbers,
                            location = it.location,
                            handler = it.handler,
                            id = it.id,
                            userId = it.userId,
                            navController = navController,
                            animalRepository = animalRepository,
                            animalImage = it.imageUrl
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AnimalItem(name:String, numbers:String, location:String, handler:String, id:String, userId:String,
               navController: NavHostController,
               animalRepository: AnimalViewModel, animalImage:String) {

    val mContext = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 25.dp)
    ) {

        Card (
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = card_green
            )
        ){
            Column (
                modifier = Modifier.padding(horizontal = 10.dp)
            ){
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .padding(vertical = 9.dp)
                ){
                    Image(
                        painter = rememberAsyncImagePainter(animalImage),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .clip(
                                RoundedCornerShape(3.dp)
                            )
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds,
                    )
                }
                Column {
                    Text(
                        text = "Animal: $name",
                        color = secondary_green,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Location: $location",
                        fontSize = 18.sp,
                        color = secondary_green
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Handler: $handler",
                        fontSize = 18.sp,
                        color = secondary_green
                        )

                    //end of handler row
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Numbers: $numbers",
                        color = secondary_green,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    //button row
                    Row (
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        OutlinedButton(
                            onClick = {
                                animalRepository.updateAnimal(id)
                            },
                            shape = RoundedCornerShape(8.dp),

                            ) {
                            Row {
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "update",
                                    tint = main_green
                                )
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = "Update",
                                    color = main_green
                                )
                            }
                        }
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ){
                            Button(
                                onClick = {
                                    animalRepository.deleteAnimal(id)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    main_green
                                ),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Row {
                                    Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(
                                        text = "Delete",
                                        color = Color.White
                                    )
                                }
                            }
                        }

                    }
                    //end of button row
                }

            }

        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ViewAnimalScreenPreview(){
    ViewAnimalScreen(navController = rememberNavController())
}