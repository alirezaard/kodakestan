package com.kodakestan.kodak.models.dto.input;

import com.kodakestan.kodak.models.dto.ImageDto;
import com.kodakestan.kodak.models.entities.Children;
import com.kodakestan.kodak.models.entities.Gender;
import com.kodakestan.kodak.models.entities.Image;
import com.kodakestan.kodak.models.entities.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserInputDto {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private ImageDto logo;
    //private Role role;
    private Gender gender;
    private Long birthday;
    //private List<ChildrenInputDto> children;
    //private Boolean active = false;
}
