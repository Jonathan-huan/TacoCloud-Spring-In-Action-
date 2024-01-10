package com.hzh.tacocloud.api.controller;

import com.hzh.tacocloud.domain.entity.TacoOrder;
import com.hzh.tacocloud.domain.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(Model model){
        model.addAttribute("tacoOrder",new TacoOrder());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }
        orderRepository.save(order);
        sessionStatus.setComplete();
        log.info("Order submitted: "+order);
        return "redirect:/";
    }
}
