package com.example.agriafrica.ui.theme.screens.products

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
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.agriafrica.R
import com.example.agriafrica.data.ProductViewModel
import com.example.agriafrica.models.Product
import com.example.agriafrica.navigation.ABOUT_URL
import com.example.agriafrica.navigation.ADD_PRODUCTS_URL
import com.example.agriafrica.navigation.HOME_URL
import com.example.agriafrica.ui.theme.WazitoECommerceTheme
import com.example.agriafrica.ui.theme.back_green
import com.example.agriafrica.ui.theme.card_green
import com.example.agriafrica.ui.theme.home_green
import com.example.agriafrica.ui.theme.main_green
import com.example.agriafrica.ui.theme.secondary_green
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ViewProductsScreen(navController:NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(back_green)
    ) {

        val context = LocalContext.current
        val productRepository = ProductViewModel(navController, context)

        val emptyProductState = remember { mutableStateOf(Product("","","","","","","","")) }
        val emptyProductsListState = remember { mutableStateListOf<Product>() }

        val products = productRepository.allProduct(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .background(back_green)
                .fillMaxSize(),
        ) {

            var isPopupDismissed by remember {
                mutableStateOf(false)
            }

            if (!isPopupDismissed){
                ScreenWithPopup {
                    isPopupDismissed = true
                }
            }else{
                Spacer(modifier = Modifier.height(5.dp))

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
                // icon row
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
                            painter = painterResource(id = R.drawable.agrisell),
                            contentDescription = "top icon",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(6.dp)
                        )
                    }
                    //end of card holding icon

                }
                // end of icon row
                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Sell Products",
                    fontSize = 24.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    color = secondary_green
                )

                Spacer(modifier = Modifier.height(3.dp))

                Row (
                    modifier=Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                        colors = ButtonDefaults.buttonColors(main_green)
                    ) {
                        Text(
                            text = "View Product",
                            fontSize = 16.sp
                        )
                    }
                    Button(
                        onClick = { navController.navigate(ADD_PRODUCTS_URL) },
                        shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                        colors = ButtonDefaults.buttonColors(card_green),
                    ) {
                        Text(
                            text = "Add Product",
                            color = secondary_green,
                            fontSize = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(7.dp))

                val currentUser = FirebaseAuth.getInstance().currentUser
                val currentUserId = currentUser?.uid

                LazyColumn(){
                    items(products){
                        if (it.userId == currentUserId){
                            ProductItem(
                                name = it.name,
                                description = it.description,
                                price = it.price,
                                phoneno = it.phoneno,
                                id = it.id,
                                navController = navController,
                                productRepository = productRepository,
                                productImage = it.imageUrl,
                                userId = it.userId,
                                location = it.location
                            )
                        }
                    }
                }
            }


        }
    }
}


@Composable
fun ProductItem(name:String, description:String, price:String, phoneno:String, location:String, id:String,userId:String,
                 navController: NavHostController,
                 productRepository: ProductViewModel, productImage:String) {

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
                        painter = rememberAsyncImagePainter(productImage),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp)
                            .clip(
                                RoundedCornerShape(3.dp)
                            )
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds,
                    )
                }
                Column {
                    Text(
                        text = "Name: $name",
                        color = secondary_green,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = "Description: $description",
                        color = secondary_green,
                        fontSize = 17.sp,
                    )
                    Spacer(modifier = Modifier.height(3.dp))

                    //price and cart row
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Price: Ksh. $price",
                            fontSize = 17.sp
                        )
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ){
                            Icon(
                                imageVector = Icons.Default.Warning,
                                contentDescription = "",
                                tint = secondary_green
                            )
                        }
                    }
                    //end of price and cart row
                    Spacer(modifier = Modifier.height(3.dp))

                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = secondary_green
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = location,
                            color = secondary_green,
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }

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
                                productRepository.updateProduct(id)
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
                                    productRepository.deleteProduct(id)
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
fun ScreenWithPopup(onDismiss:() -> Unit){
    // track whether popup showing or not
    var showDialog by remember {
        mutableStateOf(true)
    }
    //show dialog when first displayed
    if (showDialog){
        Dialog(onDismissRequest = {
            showDialog = false
            onDismiss() }
        ) {
            Box (
                modifier = Modifier
                    .padding(13.dp)
                    .background(home_green)
            ){
                Column (
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Hi. Here you can view all the products you have ever uploaded and have the ability to delete and update the product details.",
                        fontSize = 17.sp,
                        color = secondary_green
                    )
                    Text(
                        text = "NOTE: The only products you'll see are the ones that YOU have posted.",
                        fontSize = 17.sp,
                        color = secondary_green
                    )
                    Button(
                        onClick = {
                            showDialog = false
                            onDismiss()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 7.dp),
                        colors = ButtonDefaults.buttonColors(
                            main_green
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Okay",
                            fontSize = 17.sp
                        )
                    }
                }
            }
        }
    }

}

@Composable
@Preview(showBackground = true)
fun ViewProductsScreenPreview(){
    WazitoECommerceTheme {
        ViewProductsScreen(navController = rememberNavController())
    }
}