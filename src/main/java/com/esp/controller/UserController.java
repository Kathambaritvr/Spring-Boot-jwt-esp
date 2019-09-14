package com.esp.controller;

import com.esp.model.ApiResponse;
import com.esp.model.User;
import com.esp.model.UserDto;
import com.esp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

   // @PostMapping
    //public ApiResponse<User> saveUser(@RequestBody UserDto user){
       // return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
   // }
    
    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
    	return userService.save(user);
    }
    
    @PostMapping("/login")
    public User loginUser(@Valid @RequestBody User user) throws Exception{
    	User userExists = userService.findByEmail(user.getEmail());
    	System.out.println(userExists);
    	
    	if(userExists == null ||!userExists.getPassword().contentEquals(user.getPassword())) {
    		   throw new Exception("403 error");
       }
    	return userExists;
    }
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List listUser(){
        return userService.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") String id){
        return userService.findById(id);
    }
    
    //@GetMapping
    //public ApiResponse<List<User>> listUser(){
      //  return new ApiResponse<>(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    //}

    //@GetMapping("/{id}")
    //public ApiResponse<User> getOne(@PathVariable int id){
       // return new ApiResponse<>(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(id));
    //}

    @PutMapping("/user/{id}")
    public ApiResponse<UserDto> update(@RequestBody UserDto userDto) {
        return new ApiResponse<>(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @DeleteMapping("/user/{id}")
    public ApiResponse<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}
