package com.cafe.CafeWonder;

import com.cafe.CafeWonder.entity.Cake;
import com.cafe.CafeWonder.entity.User;
import com.cafe.CafeWonder.repository.UserRepository;
import com.cafe.CafeWonder.service.CakeService;
import com.cafe.CafeWonder.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CafeWonderApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(CafeWonderApplication.class, args);
		
//		CakeService cs =ac.getBean(CakeService.class);
//		cs.orderCake(new Cake("Black Forest","Black Forest.webp", "Cake made from Black Forest", 500,2000));
//		cs.orderCake(new Cake("Butterscotch","Butterscotch.webp", "Cake made from Butterscotch", 600,1500));
//		cs.orderCake(new Cake("Caramel","Caramel.webp", "Cake made from Caramel", 200,1200));
//		cs.orderCake(new Cake("Dutch Truffle","Dutch Truffle.webp", "Cake made from Dutch Truffle", 700,1400));
//		cs.orderCake(new Cake("Oreo","Oreo.webp", "Cake made from Oreo", 650,1600));
//		cs.orderCake(new Cake("White Forest","White Forestt.webp", "Cake made from White Forest", 1000,3000));
	}

}
