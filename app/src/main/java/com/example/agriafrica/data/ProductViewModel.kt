package com.example.agriafrica.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.agriafrica.models.Product
import com.example.agriafrica.navigation.LOGIN_URL
import com.example.agriafrica.navigation.ROUTE_UPDATE_PRODUCTS
import com.example.agriafrica.navigation.VIEW_PRODUCTS_URL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class ProductViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadProduct(name:String, description:String, price:String, phoneno:String, location:String,filePath:Uri){
        val productId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
                                .child("Agri_Products/$productId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()

                    val currentUser = FirebaseAuth.getInstance().currentUser
                    val userId = currentUser?.uid

                    var product = Product(name,description,price,phoneno,location,imageUrl,productId,userId?:"")
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Agri_Products/$productId")
                    databaseRef.setValue(product).addOnCompleteListener {
                        if (it.isSuccessful){
                            navController.navigate(VIEW_PRODUCTS_URL)
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allProducts(
        product:MutableState<Product>,
        products:SnapshotStateList<Product>):SnapshotStateList<Product>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
                    .child("Agri_Products")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                products.clear()
                for (snap in snapshot.children){
                    var retrievedProduct = snap.getValue(Product::class.java)
                    product.value = retrievedProduct!!
                    products.add(retrievedProduct)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return products
    }

    fun deleteProduct(productId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
                            .child("Agri_Products/$productId")
        ref.removeValue()
        Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
    }

    fun updateProduct(productId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Agri_Products/$productId")
        ref.removeValue()
        navController.navigate(ROUTE_UPDATE_PRODUCTS)
    }

    fun allProduct(
        product:MutableState<Product>,
        products:SnapshotStateList<Product>):SnapshotStateList<Product>{
        progress.show()

        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Agri_Products")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                products.clear()
                for (snap in snapshot.children){
                    var retrievedProduct = snap.getValue(Product::class.java)
                    product.value = retrievedProduct!!
                    products.add(retrievedProduct)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return products
    }


}