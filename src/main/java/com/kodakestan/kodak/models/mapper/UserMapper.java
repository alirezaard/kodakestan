package com.kodakestan.kodak.models.mapper;

import com.kodakestan.kodak.models.dto.ImageDto;
import com.kodakestan.kodak.models.dto.input.UserInputDto;
import com.kodakestan.kodak.models.dto.output.UserOutputDto;
import com.kodakestan.kodak.models.entities.Role;
import com.kodakestan.kodak.models.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;

/**
 * @author Alireza
 * @version 1.0.0
 * date 6.7.2020
 */
@Component
public class UserMapper {
    @Inject
    private PasswordEncoder encoder;
    @Inject
    private ImageMapper imgMapper;

    public User dtoToUser(UserInputDto dto) throws IOException {
        User user = new User();

        user.setActive(false);
        user.setBirthday(dto.getBirthday());
        user.setEmail(dto.getEmail());
        if (dto.getLogo() != null) {
            user.setLogo(imgMapper.fileToImage(dto.getLogo()));
        }
        user.setRole(Role.Buyer);
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setGender(dto.getGender());
        user.setFullName(dto.getFullName());

        return user;
    }

    public UserOutputDto userToDto(User user) {
        UserOutputDto dto = new UserOutputDto();

        dto.setUuid(user.getUuid());
        dto.setPhoneNumber(user.getPhoneNumber());
        //todo fix this
        dto.setLogo(user.getLogo());
        dto.setGender(user.getGender());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setBirthday(user.getBirthday());
        dto.setActive(user.getActive());

        return dto;
    }
}
