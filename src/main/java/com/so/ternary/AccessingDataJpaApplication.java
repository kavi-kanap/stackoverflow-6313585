package com.so.ternary;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);
		UserService userService = context.getBean(UserService.class);
		userService.saveUser();

		List<Object[]> usEmail = userService.findShopAndRoleByUserEmail();
		for(Object[] arrayElem : usEmail) {
			Shop shop = (Shop) arrayElem[0];
			Role role = (Role) arrayElem[1];
			System.out.println(shop.getSh_name());
			System.out.println(role.getRoleName());
		}
		System.out.println("========");

		for(Map.Entry<Shop, Role> e : userService.findByEmail().entrySet()){
			System.out.println(e.getKey().getSh_name());
			System.out.println(e.getValue().getRoleName());
		};


	}

}