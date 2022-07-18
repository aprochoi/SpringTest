package com.SpringTest.SpringTest.coffee.controller;

import com.SpringTest.SpringTest.coffee.dto.CoffeePatchDto;
import com.SpringTest.SpringTest.coffee.dto.CoffeePostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/coffees")
@Validated
public class CoffeeController {
    //O 커피 정보 등록
    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {
        System.out.println("engName : " + coffeePostDto.getEngName());
        System.out.println("korName : " + coffeePostDto.getKorName());
        System.out.println("price : " + coffeePostDto.getPrice());

        return new ResponseEntity<>(coffeePostDto, HttpStatus.CREATED);

    }

    //O 커피 정보 수정
    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);

        return new ResponseEntity<>(coffeePatchDto, HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getOrder(@PathVariable("coffee-id") long coffeeId) {
        System.out.println("coffeeId : " + coffeeId);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("get Coffees");

        return new ResponseEntity(HttpStatus.OK);
    }



    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteMapping(@PathVariable("coffee-id") long coffeeId) {

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
