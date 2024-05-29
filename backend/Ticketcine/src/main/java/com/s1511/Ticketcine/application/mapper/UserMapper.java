package com.s1511.Ticketcine.application.mapper;

import com.s1511.Ticketcine.application.dto.user.CreateDtoUser;
import com.s1511.Ticketcine.application.dto.user.ReadDtoUser;
import com.s1511.Ticketcine.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User createDtoToUser (CreateDtoUser createDtoUser);
    ReadDtoUser userToReadDto (User user);


}