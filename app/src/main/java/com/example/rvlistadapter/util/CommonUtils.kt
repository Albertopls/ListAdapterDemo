package com.example.rvlistadapter.util

import java.text.NumberFormat

fun Double.formatNumber(): String{
    return NumberFormat.getCurrencyInstance().format(this)
}

fun Int.isEven(): Boolean{
   return  this % 2 == 0
}