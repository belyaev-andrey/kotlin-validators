package org.example.kotlinvalidators

import jakarta.validation.constraints.Email
import org.hibernate.validator.constraints.Length

class UserKlass {

    val name: String
    val email: String

    constructor(@Length(min = 3, max = 10) name: String, @Email email: String) {
        this.name = name
        this.email = email
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserKlass

        if (name != other.name) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }

    override fun toString(): String {
        return "UserKlass(name='$name', email='$email')"
    }

}