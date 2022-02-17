package com.example.myapplication

import java.util.*

data class User(
    val id: Int,
    val name: String,
    val age: Int,
    val type: Type
) {
    val startTime: Date by lazy {
        Calendar.getInstance().time
    }
}



