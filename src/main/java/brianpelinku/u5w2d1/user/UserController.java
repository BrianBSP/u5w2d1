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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 1. Get: /users --> findAll
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 2. Get: /users/{userId} --> findById
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    // 3. Post: /users
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User bodyUser) {
        return userService.saveUser(bodyUser);
    }

    // 4. Put: /users/{userId}
    @PutMapping("/{userId}")
    public User findUserByIdAndUpdate(@PathVariable int userId, @RequestBody User userUpdate) {
        return userService.getUserByIdAndUpdate(userId, userUpdate);
    }

    // 5. Delete: /users/{userId}
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findUserByIdAndDelete(@PathVariable int userId) {
        userService.getByIdAndDelete(userId);
    }


}
