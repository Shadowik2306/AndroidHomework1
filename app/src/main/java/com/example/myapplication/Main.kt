package com.example.myapplication

import java.lang.Exception

fun buy(pub: Publication?) {
    println("The purchase is complete. The purchase amount was ${pub?.price}\n")
}

val authCallback = object : AuthCallback {
    override fun authSuccess() {
        println("Authorisation Success")
    }

    override fun authFailed() {
        println("Authorisation Failed")
    }

}

fun User.adult() {
    if (this.age >= 18) {
        println("You are BIG boy")
    }
    else throw Exception()
}


inline fun auth(updateCache: () -> Unit, user: User) {
    try {
        user.adult()
        authCallback.authSuccess()
        updateCache()
    }
    catch (e: Exception) {
        authCallback.authFailed()
        updateCache()
    }
}

fun main() {
    val firstBook = Book(100, 1001)
    val secondBook = Book(200, 8001)
    val magazine = Magazine(25, 100)

    println("------------------------------")

    print(firstBook.getType() + "\t")
    print(secondBook.getType() + "\t")
    println(magazine.getType())

    print(firstBook.wordCount.toString() + "\t")
    print(secondBook.wordCount.toString() + "\t")
    println(magazine.wordCount)

    print(firstBook.price.toString() + "\t")
    print(secondBook.price.toString() + "\t")
    println(magazine.price)

    println("------------------------------\n")

    firstBook.equals(secondBook)
    firstBook.equals(firstBook)

    val thirdBook: Book? = null
    val fourthBook: Book? = Book(34, 43452)

    buy(thirdBook)
    buy(fourthBook)

    val sum = {a: Int, b: Int
        ->
        println(a + b)
    }

    sum(5, 10)
    println()

    val firstUser = User(0, "Max", 18, Type.DEMO)
    println(firstUser.startTime)
    Thread.sleep(1000)
    println(firstUser.startTime)
    println()

    val lstOfUsers = mutableListOf<User>(User(1, "Alex", 17, Type.FULL))
    lstOfUsers.apply {
        this.add(User(2, "Mark", 19, Type.FULL))
        this.add(User(3, "Kirill", 21, Type.DEMO))
    }

    val lstOfUsersFull = mutableListOf<User>()
    lstOfUsers.forEach() { user
        ->
        if (user.type == Type.FULL) println(user)
    }
    println()

    val lst = mutableListOf<String>()
    lstOfUsers.forEach() { user
        ->
        lst.add(user.name)
    }
    val lstOfUsersNames = lst

    println(lstOfUsersNames[0])
    println(lstOfUsersNames.last() + "\n")
}