package org.example.kotlinvalidators;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

public class UserClass {

    private String name;
    private String email;

    public UserClass(@Length(min = 3, max = 10) String name, @Email String email) {
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
        UserClass userClass = (UserClass) o;
        return Objects.equals(name, userClass.name) && Objects.equals(email, userClass.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
