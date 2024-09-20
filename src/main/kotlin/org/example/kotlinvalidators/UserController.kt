package org.example.kotlinvalidators

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController {

//    ###
//    GET http://localhost:8080/api/users
    @GetMapping(produces = ["application/json"])
    fun getAll() : List<User> {
        return listOf(User("aaa", "a@a.a"), User("bbb", "b@b.b"))
    }

//    ###
//    POST http://localhost:8080/api/users/data
//    Content-Type: application/json
//
//    {
//        "name": "veryLongExampleName",
//        "email": "example@example.com"
//    }
    @PostMapping(path = ["data"], consumes = ["application/json"], produces = ["application/json"])
    fun addUser(@RequestBody @Valid user: User): User {
        return user
    }

//    ###
//    POST http://localhost:8080/api/users/klass
//    Content-Type: application/json
//
//    {
//        "name": "veryLongExampleName",
//        "email": "example@example.com"
//    }
    @PostMapping(path = ["klass"], consumes = ["application/json"], produces = ["application/json"])
    fun addUserKlass(@RequestBody @Valid user: UserKlass): UserKlass {
        return user
    }

//    ###
//    POST http://localhost:8080/api/users/klass
//    Content-Type: application/json
//
//    {
//        "name": "veryLongExampleName",
//        "email": "example@example.com"
//    }
    @PostMapping(path = ["klassfields"], consumes = ["application/json"], produces = ["application/json"])
    fun addUserKlassFields(@RequestBody @Valid user: UserKlassFields): UserKlassFields {
        return user
    }


    //    ###
//    POST http://localhost:8080/api/users/class
//    Content-Type: application/json
//
//    {
//        "name": "veryLongExampleName",
//        "email": "example@example.com"
//    }
    @PostMapping(path = ["class"], consumes = ["application/json"], produces = ["application/json"])
    fun addUserClass(@RequestBody @Valid user: UserClass): UserClass {
        return user
    }

//    ###
//    POST http://localhost:8080/api/users/classfields
//    Content-Type: application/json
//
//    {
//        "name": "veryLongExampleName",
//        "email": "example@example.com"
//    }
    @PostMapping(path = ["classfields"], consumes = ["application/json"], produces = ["application/json"])
    fun addUserClassFields(@RequestBody @Valid user: UserClassFields): UserClassFields {
        return user
    }
}