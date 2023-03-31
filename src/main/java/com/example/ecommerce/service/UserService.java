package com.example.ecommerce.service;

import com.example.ecommerce.payload.PageableResponse;
import com.example.ecommerce.payload.UserDto;

import java.util.List;

public interface UserService {

    // Create User
    UserDto createUser(UserDto userdto);

    // Update User

    UserDto updateUser(UserDto userDto, Long userId);

    // Delete User
    void deleteUser(Long userId);

    // Get All User

    PageableResponse<UserDto> getAllUser(int pageNumber , int pageSize, String sortBy, String sortDir);

    //Get Single User
    UserDto getSingleUser(Long userId);

    //Get Single User By Email
    UserDto getUserByEmail(String email);

    UserDto getUserByEmailAndPassword(String email,String password);

    //search User
    List<UserDto> serachUser(String keyword);
}
