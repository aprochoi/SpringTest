package com.SpringTest.SpringTest.coffee.controller;

import com.SpringTest.SpringTest.coffee.dto.CoffeePatchDto;
import com.SpringTest.SpringTest.coffee.dto.CoffeePostDto;
import com.SpringTest.SpringTest.coffee.dto.CoffeeResponseDto;
import com.SpringTest.SpringTest.coffee.entity.Coffee;
import com.SpringTest.SpringTest.coffee.mapper.CoffeeMapper;
import com.SpringTest.SpringTest.coffee.service.CoffeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v5/coffees")
@Validated
public class CoffeeController {
    private final CoffeeService coffeeService;
    private final CoffeeMapper mapper;

    //O coffeeService, CoffeeMapper DI
    public CoffeeController(CoffeeService coffeeService, CoffeeMapper mapper) {
        this.coffeeService = coffeeService;
        this.mapper = mapper;
    }

    //O 커피 정보 등록
    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDto coffeePostDto) {

        //O 매퍼를 이용하여 CoffeePostDto를 Coffee로 변환
        Coffee coffee = mapper.coffeePostDtoToCoffee(coffeePostDto);

        Coffee response = coffeeService.createCoffee(coffee);

        //O 매퍼를 이용하여 Coffee를 CoffeeResponseDto로 변환
        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.CREATED);

    }

    //O 커피 정보 수정
    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Positive long coffeeId,
                                      @Valid @RequestBody CoffeePatchDto coffeePatchDto) {
        coffeePatchDto.setCoffeeId(coffeeId);

        Coffee coffee = mapper.coffeePatchDtoToCoffee(coffeePatchDto);

        Coffee response = coffeeService.updateCoffee(coffee);

        return new ResponseEntity<>(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {

        Coffee response = coffeeService.findCoffee(coffeeId);

        return new ResponseEntity(mapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        List<Coffee> coffees = coffeeService.findCoffees();
        //O List와 Stream, 매퍼를 이용하여 List<Coffee>를 CoffeeResponseDto로 변환

        List<CoffeeResponseDto> response = mapper.coffeesToCoffeeResponseDto(coffees);

        return new ResponseEntity(response, HttpStatus.OK);
    }



    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {

        coffeeService.deleteCoffee(coffeeId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
