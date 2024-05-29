package com.s1511.ticketcine.application.mapper;

import org.mapstruct.Mapper;

import com.s1511.ticketcine.application.dto.user.CreateDtoUser;
import com.s1511.ticketcine.application.dto.user.ReadDtoUser;
import com.s1511.ticketcine.domain.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User createDtoToUser (CreateDtoUser createDtoUser);
    ReadDtoUser userToReadDto (User user);


}