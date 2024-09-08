package com.cafe.CafeWonder.service;

import com.cafe.CafeWonder.entity.OrderDetails;
import com.cafe.CafeWonder.entity.User;
import com.cafe.CafeWonder.enums.OrderStatus;
import com.cafe.CafeWonder.exception.customexception.InvalidUserException;
import com.cafe.CafeWonder.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CakeService cakeService;
    @Autowired
    private UserService userService;

    public void placeOrder(Long cakeId)
    {
        OrderDetails order = new OrderDetails(userService.getLoggedInUser(),cakeService.getCake(cakeId));
        orderRepository.save(order);
    }

    public List<OrderDetails> getAllOrders()
    {
        return orderRepository.findAll();
    }

    public void updateOrder(Long orderId) throws InvalidUserException
    {
        User user = userService.getLoggedInUser();

        if(!user.getRole().equals("ROLE_ADMIN"))
            throw new InvalidUserException("Operation not permitted for the current user");

        OrderDetails orderDetails= orderRepository.getReferenceById(orderId);

        if(orderDetails.getStatus().equals(OrderStatus.INITIALIZED))
            orderDetails.setStatus(OrderStatus.PROCESSING);
        else
        if(orderDetails.getStatus().equals(OrderStatus.PROCESSING))
             orderDetails.setStatus(OrderStatus.COMPLETE);

        orderRepository.save(orderDetails);
    }

}
