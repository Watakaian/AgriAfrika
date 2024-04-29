package com.example.agriafrica.ui.theme.screens.animal

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.agriafrica.R
import com.example.agriafrica.data.AnimalViewModel
import com.example.agriafrica.navigation.ABOUT_URL
import com.example.agriafrica.navigation.HOME_URL
import com.example.agriafrica.navigation.VIEW_ANIMAL
import com.example.agriafrica.ui.theme.back_green
import com.example.agriafrica.ui.theme.card_green
import com.example.agriafrica.ui.theme.main_green
import com.example.agriafrica.ui.theme.secondary_green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateAnimalScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(back_green)
            .verticalScroll(rememberScrollState())
    ) {
        Column (
            modifier = Modifier.padding(horizontal = 12.dp)
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
                text = "Update Animal",
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
                        text = "Update Animal",
                        fontSize = 16.sp
                    )
                }
                Button(
                    onClick = { navController.navigate(VIEW_ANIMAL) },
                    shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                    colors = ButtonDefaults.buttonColors(card_green),
                ) {
                    Text(
                        text = "View Animals",
                        color = secondary_green,
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Spacer(modifier = Modifier.height(15.dp))

            var animalName by remember { mutableStateOf("") }
            var animalLocation by remember { mutableStateOf("") }
            var animalNumbers by remember { mutableStateOf("") }
            var animalHandler by remember { mutableStateOf("") }
            val context = LocalContext.current

            OutlinedTextField(
                value = animalName,
                onValueChange = { animalName = it },
                placeholder = { Text(text="eg. Cows") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "email icon"
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
                label = { Text(text = "Animal Name") }
            )


            Spacer(modifier = Modifier.height(13.dp))

            OutlinedTextField(
                value = animalNumbers,
                onValueChange = { animalNumbers = it },
                placeholder = { Text(text="eg. 1 male,3 females") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "email icon"
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
                label = { Text(text = "Animal Numbers") }
            )

            Spacer(modifier = Modifier.height(13.dp))

            OutlinedTextField(
                value = animalLocation,
                onValueChange = { animalLocation = it },
                placeholder = { Text(text="eg. paddock A and paddock B") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "email icon"
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
                label = { Text(text = "Animal Location") }
            )

            Spacer(modifier = Modifier.height(13.dp))

            OutlinedTextField(
                value = animalHandler,
                onValueChange = { animalHandler = it },
                placeholder = { Text(text="eg.Wanyoyi") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "email icon"
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
                label = { Text(text = "Animal Handler") }
            )

            Spacer(modifier = Modifier.height(20.dp))

            var modifier = Modifier
            ImagePick(modifier,context, navController, animalName.trim(), animalNumbers.trim(), animalLocation.trim(),animalHandler.trim())




        }
    }
}

@Composable
fun ImagePick(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, numbers:String, location:String, handler:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Selected Animal Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
                    .padding(vertical = 5.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(card_green),
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                border = BorderStroke(1.dp, main_green)
            ) {
                Text(
                    text = "Select Animal Image",
                    color = secondary_green,
                    fontSize = 18.sp
                )
            }


            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var animalRepository = AnimalViewModel(navController,context)
                animalRepository.uploadAnimal(name, numbers, location,handler,imageUri!!)
            },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(main_green),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 20.dp)
            ) {
                Text(
                    text = "Update Animal",
                    fontSize = 17.sp
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun UpdateAnimalScreenPreview(){
    UpdateAnimalScreen(navController = rememberNavController())
}