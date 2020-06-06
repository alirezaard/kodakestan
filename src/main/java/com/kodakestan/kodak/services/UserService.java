package com.kodakestan.kodak.services;

import com.kodakestan.kodak.dao.UserRepo;
import com.kodakestan.kodak.models.dto.Crud;
import com.kodakestan.kodak.models.dto.input.UserInputDto;
import com.kodakestan.kodak.models.dto.output.UserOutputDto;
import com.kodakestan.kodak.models.entities.Image;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserService implements Crud<UserInputDto, UserOutputDto> {
    @Inject
    private UserRepo repo;

    @Override
    public UserOutputDto insert(UserInputDto userInputDto) {
        return null;
    }

    @Override
    public void delete(UserInputDto userInputDto) {

    }

    @Override
    public List<UserInputDto> getAll() {
        return null;
    }

    @Override
    public UserOutputDto edit(UserInputDto userInputDto) {
        return null;
    }

    @Override
    public List<UserInputDto> deleteAll() {
        return null;
    }

    @Override
    public UserOutputDto addImage(Image img) {
        return null;
    }
}
