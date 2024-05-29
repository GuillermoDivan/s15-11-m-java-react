package com.s1511.Ticketcine.application.implementations;

import com.s1511.Ticketcine.application.dto.user.CreateDtoUser;
import com.s1511.Ticketcine.application.dto.user.ReadDtoUser;
import com.s1511.Ticketcine.application.dto.user.UpdateDtoUser;
import com.s1511.Ticketcine.application.mapper.UserMapper;
import com.s1511.Ticketcine.application.validations.SelfValidation;
import com.s1511.Ticketcine.domain.entities.User;
import com.s1511.Ticketcine.domain.repository.UserRepository;
import com.s1511.Ticketcine.domain.services.UserService;
import com.s1511.Ticketcine.domain.utils.RolesEnum;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    public final SelfValidation selfValidation;

    @Transactional
    @Override
    public ReadDtoUser createUser(CreateDtoUser createDtoUser) {
        var userAlreadyExists = userRepository.findByEmail(createDtoUser.email());
        if(userAlreadyExists.isPresent()){ throw new EntityExistsException("¡Este email ya está en uso!"); }

        User user = this.userMapper.createDtoToUser(createDtoUser);
        user.setPassword(passwordEncoder.encode(createDtoUser.password()));

        
        user.setActive(Boolean.TRUE);
        user.setRole(RolesEnum.USER);
        var userAdded = userRepository.save(user);
        return  userMapper.userToReadDto(userAdded);
    }

    @Override
    public ReadDtoUser readUserById(String id, Boolean active) {
        User user = userRepository.findByIdAndActive(id, active)
                .orElseThrow(() -> new EntityNotFoundException("No se puede encontrar el usuario con el id " + id));

        return userMapper.userToReadDto(user);
    }

    @Override
    public ReadDtoUser readUserByEmail(String email, Boolean active) {
        User user = userRepository.findByEmailAndActive(email, active)
                .orElseThrow(() -> new EntityNotFoundException("No se puede encontrar el usuario con el email " + email));

        return userMapper.userToReadDto(user);
    }

    @Transactional
    @Override
    public ReadDtoUser updateUser(UpdateDtoUser updateDtoUser) {
        selfValidation.checkSelfValidation(updateDtoUser.id());
        User user = userRepository.findByIdAndActive(updateDtoUser.id(), true)
                .orElseThrow(() -> new EntityNotFoundException("No se puede encontrar el usuario con el id " + updateDtoUser.id()));

            if (updateDtoUser.firstName() != null){
                user.setFirstName(updateDtoUser.firstName());
            }
            if (updateDtoUser.lastName() != null){
                user.setLastName(updateDtoUser.lastName());
            }

        this.userRepository.save(user);
        return userMapper.userToReadDto(user);
    }

    @Transactional
    @Override
    public Boolean toggleUser(String id) {
        selfValidation.checkSelfValidation(id);
        User userEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se puede encontrar el usuario con el id " + id));
        userEntity.setActive(!userEntity.getActive());
        userRepository.save(userEntity);
        return true;
    }
}
