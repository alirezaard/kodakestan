package com.kodakestan.kodak.models.dto.output;

import com.kodakestan.kodak.models.dto.ImageDto;
import com.kodakestan.kodak.models.entities.Gender;
import com.kodakestan.kodak.models.entities.Role;
import lombok.Data;

@Data
public class UserOutputDto {
    private String uuid;
    private String fullName;
    private String email;
    private String phoneNumber;
    private ImageDto logo;
    private Role role;
    private Gender gender;
    private Long birthday;
    //private List<ChildrenInputDto> children;
    private Boolean active;

}
