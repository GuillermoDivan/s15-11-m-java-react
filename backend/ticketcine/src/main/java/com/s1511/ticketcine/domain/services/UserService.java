package com.s1511.ticketcine.domain.services;
import com.s1511.ticketcine.application.dto.user.CreateDtoUser;
import com.s1511.ticketcine.application.dto.user.ReadDtoUser;
import com.s1511.ticketcine.application.dto.user.UpdateDtoUser;

public interface UserService {

    ReadDtoUser createUser(CreateDtoUser createDtoUser);
    ReadDtoUser readUserById(String id, Boolean active);
    ReadDtoUser readUserByEmail(String email, Boolean active);
    ReadDtoUser updateUser(UpdateDtoUser updateDtoUser);
    Boolean toggleUser(String id);
}
