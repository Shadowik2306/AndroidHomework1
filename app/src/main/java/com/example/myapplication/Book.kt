package com.example.myapplication

class Book(override val price: Int, override val wordCount: Int) : Publication {
    override fun getType(): String {
        if (wordCount < 1000) {
            return "Flash Fiction"
        }
        else if (wordCount < 7500) {
            return "Short Story"
        }
        else {
            return "Novel"
        }
    }

    override fun equals(other: Any?): Boolean {
        println("По ссылке: ${this === other}")
        println("C помощью equals: ${super.equals(other)}\n")
        return super.equals(other)
    }
}