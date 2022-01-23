package com.example.kentKart_v2.service;

import com.example.kentKart_v2.VO.ProductListDetails;
import com.example.kentKart_v2.dto.AppUserDto;
import com.example.kentKart_v2.entity.AppUser;
import com.example.kentKart_v2.entity.Product;
import com.example.kentKart_v2.entity.ProductList;
import com.example.kentKart_v2.entity.ProductListProperty;
import com.example.kentKart_v2.repository.AppUserRepository;
import com.example.kentKart_v2.repository.ProductListPropertyRepository;
import com.example.kentKart_v2.repository.ProductListRepository;
import com.example.kentKart_v2.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private ProductListRepository productlistRepository;

    @Autowired
    private ProductListPropertyRepository productListPropertyRepository;

    @Autowired
    private ProductRepository productRepository;

    // POST
    // Saves an AppUser
    public AppUser saveAppUser(AppUserDto appUserDTO) {
        log.info("Inside saveAppUser of AppUserService");
        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(appUserDTO, appUser);
        return appUserRepository.save(appUser);
    }

    // GET
    // Finds a AppUser by ID
    public AppUser findAppUserByAppUserId(Long appUserId) {
        log.info("Inside findAppUserByAppUserId of AppUserService");
        return appUserRepository.findByAppUserId(appUserId);
    }

    // Finds all details of a AppUser by ID
    public List<ProductListDetails> findAllDetailsOfAppUserByAppUserId(Long appUserId) {
        List<ProductList> productListOfAppUser = productlistRepository.findAllByDepartmentId(appUserId);
        List<ProductListDetails> productListDetailsList = new ArrayList<>();
        for (ProductList pl: productListOfAppUser
        ) {
            ProductListDetails productListDetails = new ProductListDetails();
            productListDetails.setProductListListName(pl.getProductListName());
            List<ProductListProperty> pls = productListPropertyRepository.findAllByProductListId(pl.getProductListId());
            List<Product> productList = new ArrayList<>();
            for (ProductListProperty productListProperty: pls
            ) {
                productList.add(productRepository.findByProductId(productListProperty.getProductId()));
            }
            productListDetails.setProductList(productList);
            productListDetailsList.add(productListDetails);
        }
        return productListDetailsList;
    }

    // PUT
    // Updates a AppUser
    public AppUser updateAppUserByAppUserId(Long appUserId, AppUserDto appUserDTO) {
        log.info("Inside updateAppUserByAppUserId of AppUserService");
        AppUser appUser = new AppUser();
        // DTO to Entity
        BeanUtils.copyProperties(appUserDTO, appUser);
        AppUser u = appUserRepository.findByAppUserId(appUserId);
        u.setEmail(appUser.getEmail());
        u.setUsername(appUser.getUsername());
        return appUserRepository.save(u);
    }

    // DELETE
    // Deletes a User
    public void deleteAppUserByAppUserId(Long appUserId) {
        log.info("Inside deleteUserByUserId of AppUserService");
        AppUser appUser = appUserRepository.findByAppUserId(appUserId);
        appUserRepository.delete(appUser);
    }
}
