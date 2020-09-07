package com.cristianvillamil.platziwallet

class UserSingleton {

    var name = "Esteban"

    companion object {
        private var instance: UserSingleton? = null

        fun getInstance(): UserSingleton {
            if (instance == null) {
                instance = UserSingleton()
            }
            return instance as UserSingleton
        }
    }

}