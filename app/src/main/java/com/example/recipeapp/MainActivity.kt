package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewuserBtn=findViewById<Button>(R.id.viewBtn)
        val addusersbtn=findViewById<Button>(R.id.addusserBtn)
        val editTextTitle=findViewById<EditText>(R.id.editTextTitle)
        val editTextAuthor=findViewById<EditText>(R.id.editTextAuthor)
        val editTextIngredients=findViewById<EditText>(R.id.editTextIngredients)
        val editTextInstructions=findViewById<EditText>(R.id.editTextInstructions)
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)

        addusersbtn.setOnClickListener {
            val title=editTextTitle.text.toString()
            val author=editTextAuthor.text.toString()
            val ingredients=editTextIngredients.text.toString()
            val instructions=editTextInstructions.text.toString()


            apiInterface!!.addRecipe(RecipeDetailsItem(title,author,ingredients,instructions)).enqueue(object: Callback<RecipeDetailsItem>{
                override fun onResponse(
                    call: Call<RecipeDetailsItem>,
                    response: Response<RecipeDetailsItem>
                ) {
                    Toast.makeText(applicationContext, "The User Has Been Added Successfully!!", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<RecipeDetailsItem>, t: Throwable) {
                    Toast.makeText(applicationContext, "Sorry,The User Has Not Been Added Successfully!!", Toast.LENGTH_SHORT).show()
                }

            }
            )
        }
        viewuserBtn.setOnClickListener {
            val intent = Intent(this, ViewRecipe::class.java)
            startActivity(intent)
        }

    }
}