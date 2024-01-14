package com.leonardokazu.crudbasico.services;

import com.leonardokazu.crudbasico.entities.User;
import com.leonardokazu.crudbasico.entities.dtos.UserDTO;
import com.leonardokazu.crudbasico.exceptions.ResourceNotFoundException;
import com.leonardokazu.crudbasico.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserDTO userDTO){

        User user = new User();

        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        user.setName(userDTO.name());
        user.setPhone(userDTO.phone());

        return userRepository.save(user);
    }

    public List<User> findAll(){
        List<User> list = userRepository.findAll();
        if (list.isEmpty()){
            throw new ResourceNotFoundException("No users found!");
        }
        return list;
    }
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
    public User update(UserDTO userDTO, Long id){

        var user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);

        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        user.setName(userDTO.name());
        user.setPhone(userDTO.phone());

        return userRepository.save(user);
    }
    public void delete(Long id){
        var user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        userRepository.deleteById(id);
    }
}
