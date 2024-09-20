package org.example.kotlinvalidators

import jakarta.validation.constraints.Email
import org.hibernate.validator.constraints.Length

data class User  (@Length(min = 3, max = 10) val name: String,
                  @Email val email: String)