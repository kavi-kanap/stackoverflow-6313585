package com.so.ternary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface UserRepository
            extends JpaRepository<User, Integer> {

        @Query("SELECT key(m), value(m) FROM User u join u.shopRoleMap m" +
                " where u.usEmail = :email")
        List<Object[]> findShopAndRoleByUserEmail(String email);

        @Query("SELECT u FROM User u join fetch u.shopRoleMap m" +
                " where u.usEmail = :email")
        Optional<User> findByEmail(String email);

    }


