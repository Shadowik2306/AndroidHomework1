package com.example.myapplication

class Login(private val user: User) : Action() {
    override fun doAction() {
        println("Auth started")
        auth({}, user)
    }
}