package com.example.kentKart_v2.controller;


import com.example.kentKart_v2.VO.ProductListDetails;
import com.example.kentKart_v2.dto.AppUserDto;
import com.example.kentKart_v2.entity.AppUser;
import com.example.kentKart_v2.service.AppUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appUsers")
@Slf4j
public class AppUserController {

    @Autowired
    private AppUserService appUserService;
    //POST
    //saves a user
    @PostMapping("/add-user")
    public AppUser saveAppUser(@RequestBody AppUserDto appUser){
        log.info("Inside saveUser of AppUserController");
        return appUserService.saveAppUser(appUser);
    }

    // GET
    // Finds a User by ID
    @GetMapping("/{id}")
    public AppUser findAppUserByAppUserId(@PathVariable("id") Long appUserId) {
        log.info("Inside findUserByUserId of UserController");
        return appUserService.findAppUserByAppUserId(appUserId);
    }

    // Finds all details of a User by ID
    @GetMapping("/details/{id}")
    public List<ProductListDetails> findAllDetailsOfAppUserByAppUserId(@PathVariable("id") Long appUserId) {
        log.info("Inside findUserByUserId of UserController");
        return appUserService.findAllDetailsOfAppUserByAppUserId(appUserId);
    }


    // PUT
    // Updates a User
    @PutMapping("/{id}")
    public AppUser updateAppUserByAppUserId(@PathVariable("id") Long appUserId, @RequestBody AppUserDto appUser) {
        log.info("Inside updateUserByUserId of UserController");
        return appUserService.updateAppUserByAppUserId(appUserId, appUser);
    }

    // DELETE
    // Deletes a User
    @DeleteMapping("/{id}")
    public void deleteAppUserByAppUserId(@PathVariable("id") Long appUserId) {
        log.info("Inside deleteUserByUserId of UserController");
        appUserService.deleteAppUserByAppUserId(appUserId);
    }

}
