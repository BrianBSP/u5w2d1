package brianpelinku.u5w2d1.user;

/*
* ------user crud-------
* 1. Get: /users --> findAll
* 2. Get: /users/{userId} --> findById
* 3. Post: /users
* 4. Put: /users/{userId}
* 5. Delete: /users/{userId}
*
* */


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    // 1. Get: /users --> findAll
    @GetMapping
    public String getAllUsers(){
        return "Lista utenti";
    }

    // 2. Get: /users/{userId} --> findById
    @GetMapping("/{userId}")
    public int getUserById(@PathVariable int userId){
        return userId;
    }

    // 3. Post: /users
    @PostMapping
    public User createUser(@RequestBody User body){

    }


}
