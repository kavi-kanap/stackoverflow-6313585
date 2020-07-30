package com.so.ternary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShopRepository shopRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public void saveUser(){

        Shop shopOne = shopRepository.save(new Shop("sh1", "ic1", "desc1", "tag1"));
        Shop shopTwo = shopRepository.save(new Shop("sh2", "ic2", "desc2", "tag2"));
        Shop shopThree = shopRepository.save(new Shop("sh3", "ic3", "desc3", "tag3"));

        Role roleOne = roleRepository.save(new Role("role1"));
        Role roleTwo = roleRepository.save(new Role("role2"));

        Map<Shop, Role> shopRoleMap = new HashMap<>();
        shopRoleMap.put(shopOne, roleOne);
        shopRoleMap.put(shopTwo, roleOne);
        shopRoleMap.put(shopThree, roleTwo);
        User user = new User("uuid", "usFname", "usLname", "usEmail");
        user.setShopRoleMap(shopRoleMap);
        userRepository.save(user);

    }

    @Transactional
    public List<Object[]> findShopAndRoleByUserEmail(){
       return userRepository.findShopAndRoleByUserEmail("usEmail");
    }

    @Transactional
    public Map<Shop, Role> findByEmail(){
        return userRepository.findByEmail("usEmail")
                .map(User::getShopRoleMap)
                .orElse(new HashMap<>());
    }



}
