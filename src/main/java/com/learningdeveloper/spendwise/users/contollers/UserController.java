package com.learningdeveloper.spendwise.users.contollers;

import com.learningdeveloper.spendwise.users.dto.User;
import com.learningdeveloper.spendwise.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "v1/add-user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(path = "v1/update-user")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "v1/select-user-by-id")
    public ResponseEntity<User> selectUserById(@RequestParam("user-id") Long id) {
        User user = userService.selectUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "v1/select-user-by-mobile-number")
    public ResponseEntity<User> selectUserByMobileNumber(@RequestParam("mobile-number") String mobileNumber) {
        User user = userService.selectUserByMobileNumber(mobileNumber);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "v1/delete-user")
    public void deleteUser(@RequestParam("user-id") Long id) {
        userService.deleteUser(id);
    }

}
