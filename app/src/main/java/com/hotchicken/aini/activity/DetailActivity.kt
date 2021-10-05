package com.hotchicken.aini.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hotchicken.aini.R
import com.hotchicken.aini.databinding.ActivityDetail2Binding
import com.hotchicken.aini.databinding.FragmentVegetarianBinding
import com.hotchicken.aini.model.Recipes

class DetailActivity : AppCompatActivity() {
    companion object{
        const val RECIPE_DATA = "recipe_data"
    }

    private lateinit var detailBinding : ActivityDetail2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }
        setSupportActionBar(detailBinding.tbDetail)
        val dataRecipes = intent.getParcelableExtra<Recipes>(RECIPE_DATA) as Recipes

        Glide.with(this).load(dataRecipes.pictures).into(detailBinding.ivDetail)

        detailBinding.tvNameDetail.text = dataRecipes.name
        detailBinding.tvCalories.text = dataRecipes.calories
        detailBinding.tvCarbo.text = dataRecipes.carbo
        detailBinding.tvProtein.text = dataRecipes.protein
        detailBinding.tvDetailDescription.text = dataRecipes.description
        detailBinding.tvIngredients.text = dataRecipes.ingredients
        detailBinding.tvInstruction.text = dataRecipes.instructions
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}