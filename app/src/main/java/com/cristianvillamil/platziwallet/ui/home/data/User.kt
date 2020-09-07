package com.cristianvillamil.platziwallet.ui.home.data

import android.app.AlertDialog

class User private constructor(
    private val username: String,
    private val password: String
) {

    class Builder {
        private var username: String = ""
        private var password: String? = null

        fun setUsername(newUsername: String): Builder {
            this.username = newUsername
            return this
        }

        fun setPassword(newPassword: String): Builder {
            this.password = newPassword
            return this
        }

        fun build(): User {
            return User(username, password ?: "")
        }
    }

}