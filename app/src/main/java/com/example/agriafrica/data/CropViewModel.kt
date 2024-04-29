package com.example.agriafrica.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.agriafrica.models.Crop
import com.example.agriafrica.navigation.LOGIN_URL
import com.example.agriafrica.navigation.UPDATE_CROP
import com.example.agriafrica.navigation.VIEW_CROP
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class CropViewModel(var navController: NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress: ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(LOGIN_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadCrop(name:String, numbers:String, location:String, handler:String,filePath: Uri){
        val cropId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Crops/$cropId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()

                    val currentUser = FirebaseAuth.getInstance().currentUser
                    val userId = currentUser?.uid

                    var crop = Crop(name,numbers,location,handler,imageUrl,cropId,userId?:"")
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Crops/$cropId")
                    databaseRef.setValue(crop).addOnCompleteListener {
                        if (it.isSuccessful){
                            navController.navigate(VIEW_CROP)
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


    fun deleteCrop(cropId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Crops/$cropId")
        ref.removeValue()
        Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
    }

    fun updateCrop(cropId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Crops/$cropId")
        ref.removeValue()
        navController.navigate(UPDATE_CROP)
    }

    fun allCrops(
        crop: MutableState<Crop>,
        crops: SnapshotStateList<Crop>
    ): SnapshotStateList<Crop> {
        progress.show()

        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Crops")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                crops.clear()
                for (snap in snapshot.children){
                    var retrievedCrop = snap.getValue(Crop::class.java)
                    crop.value = retrievedCrop!!
                    crops.add(retrievedCrop)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return crops
    }

}