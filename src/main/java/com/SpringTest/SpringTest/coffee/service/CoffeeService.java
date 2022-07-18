package com.SpringTest.SpringTest.coffee.service;

import com.SpringTest.SpringTest.coffee.entity.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    public Coffee createCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee updateCoffee(Coffee coffee) {
        return coffee;
    }

    public Coffee findCoffee(long coffeeId) {

        Coffee coffee = new Coffee(coffeeId, "아메리카노", "Americano", 2500);

        return coffee;
    }

    public List<Coffee> findCoffees() {
        List<Coffee> coffees = List.of(
                new Coffee(1L, "아메리카노", "Americano", 2500),
                new Coffee(2L, "카라멜 라떼", "Caramel Latte", 5000)
        );

        return coffees;
    }

    public void deleteCoffee(long CoffeeId) {

    }
}
