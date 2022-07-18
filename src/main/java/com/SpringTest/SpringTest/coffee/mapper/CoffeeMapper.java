package com.SpringTest.SpringTest.coffee.mapper;

import com.SpringTest.SpringTest.coffee.dto.CoffeePatchDto;
import com.SpringTest.SpringTest.coffee.dto.CoffeePostDto;
import com.SpringTest.SpringTest.coffee.dto.CoffeeResponseDto;
import com.SpringTest.SpringTest.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);

    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);

    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);

    List<CoffeeResponseDto> coffeesToCoffeeResponseDto(List<Coffee> coffees);
}
