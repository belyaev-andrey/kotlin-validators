package org.example.kotlinvalidators;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

public class UserClassFields {

    @Length(min = 3, max = 10)
    private String name;

    @Email
    private String email;

    public UserClassFields(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserClassFields userClass = (UserClassFields) o;
        return Objects.equals(name, userClass.name) && Objects.equals(email, userClass.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
