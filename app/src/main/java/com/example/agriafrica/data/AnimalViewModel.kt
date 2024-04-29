package com.example.agriafrica.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.agriafrica.models.Animal
import com.example.agriafrica.navigation.LOGIN_URL
import com.example.agriafrica.navigation.UPDATE_ANIMAL
import com.example.agriafrica.navigation.VIEW_ANIMAL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class AnimalViewModel(var navController: NavHostController, var context: Context) {
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

    fun uploadAnimal(name:String, numbers:String, location:String, handler:String,filePath: Uri){
        val animalId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Animals/$animalId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()

                    val currentUser = FirebaseAuth.getInstance().currentUser
                    val userId = currentUser?.uid

                    var animal = Animal(name,numbers,location,handler,imageUrl,animalId,userId?:"")
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Animals/$animalId")
                    databaseRef.setValue(animal).addOnCompleteListener {
                        if (it.isSuccessful){
                            navController.navigate(VIEW_ANIMAL)
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


    fun deleteAnimal(animalId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Animals/$animalId")
        ref.removeValue()
        Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
    }

    fun updateAnimal(animalId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Animals/$animalId")
        ref.removeValue()
        navController.navigate(UPDATE_ANIMAL)
    }

    fun allAnimals(
        animal: MutableState<Animal>,
        animals: SnapshotStateList<Animal>): SnapshotStateList<Animal> {
        progress.show()

        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Animals")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                animals.clear()
                for (snap in snapshot.children){
                    var retrievedAnimal = snap.getValue(Animal::class.java)
                    animal.value = retrievedAnimal!!
                    animals.add(retrievedAnimal)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return animals
    }
}