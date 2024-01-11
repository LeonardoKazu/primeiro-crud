package com.leonardokazu.crudbasico.services;

import com.leonardokazu.crudbasico.entities.User;
import com.leonardokazu.crudbasico.entities.dtos.UserDTO;
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
            return null;
        }
        return list;
    }
    public User findById(Long id){
        return userRepository.findById(id).get();
    }
    public User update(UserDTO userDTO, Long id){
        User user = userRepository.findById(id).get();

        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        user.setName(userDTO.name());
        user.setPhone(userDTO.phone());

        return userRepository.save(user);
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
