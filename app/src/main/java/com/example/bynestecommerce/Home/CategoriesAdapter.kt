package com.example.bynestecommerce.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bynestecommerce.R



class CategoriesAdapter(private var categories: ArrayList<String>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {


    override fun getItemCount() = categories.size


    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val categoriesTextView: TextView


        init {
            categoriesTextView = view.findViewById(R.id.textcat)

        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.CategoriesViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_card2, parent, false)

        return CategoriesViewHolder(view)
    }


    override fun onBindViewHolder(
        holder: CategoriesAdapter.CategoriesViewHolder,
        position: Int
    ) {

       val cat_name =   categories[position]

        holder.categoriesTextView.text =  cat_name


    }


    fun updateProduct(newItemList: ArrayList<String>) {
        categories = newItemList
        notifyDataSetChanged()
    }


}














