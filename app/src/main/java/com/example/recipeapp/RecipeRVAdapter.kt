package com.example.recipeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class RecipeRVAdapter(private val list: List<RecipeDetailsItem>, val context: Context) : RecyclerView.Adapter<RecipeRVAdapter.ItemViewHolder>() {
    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val recipe = list[position]

        holder.itemView.apply {
            textView.text = " Title: ${recipe.title}"
            textView2.text =" Author: ${recipe.author}"

            textView3.text =" Author: ${recipe.ingredients}"
            textView4.text =" Author: ${recipe.instructions}"
            //  cvMain.setOnClickListener {
            //                Toast.makeText(context, recipe.instructions, Toast.LENGTH_SHORT).show()
            //            }
        }
    }

    override fun getItemCount(): Int = list.size
}