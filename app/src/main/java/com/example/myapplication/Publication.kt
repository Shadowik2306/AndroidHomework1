package com.example.myapplication

interface Publication {
    val price: Int
    val wordCount: Int

    fun getType() : String
}