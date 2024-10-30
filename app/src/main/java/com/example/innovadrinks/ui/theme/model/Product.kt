package com.example.innovadrinks.ui.theme.model

import com.example.innovadrinks.R

data class Product(val name: String, val imageRes: Int, val category: String)

val productList = listOf(
    Product("Monster", R.drawable.monster_drink, "Energizantes"),
    Product("Raptor", R.drawable.monster_drink, "Energizantes"),
    Product("Adrenaline Rush", R.drawable.monster_drink, "Energizantes"),
    Product("RedBull", R.drawable.monster_drink, "Energizantes"),
    Product("Monster", R.drawable.monster_drink, "Energizantes"),
    Product("Raptor", R.drawable.monster_drink, "Energizantes"),
    Product("Adrenaline Rush", R.drawable.monster_drink, "Energizantes"),
    Product("RedBull", R.drawable.monster_drink, "Energizantes"),
    Product("Chips", R.drawable.monster_drink, "Snacks"),
    Product("Nachos", R.drawable.monster_drink, "Snacks"),
    Product("Galletas", R.drawable.monster_drink, "Snacks"),
    Product("Chocolates", R.drawable.monster_drink, "Snacks"),
    Product("Chips", R.drawable.monster_drink, "Snacks"),
    Product("Nachos", R.drawable.monster_drink, "Snacks"),
    Product("Galletas", R.drawable.monster_drink, "Snacks"),
    Product("Chocolates", R.drawable.monster_drink, "Snacks")

)