package com.SpringTest.SpringTest.coffee.dto;

import com.SpringTest.SpringTest.validator.NotSpace;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CoffeePatchDto {
    private long coffeeId;

    @NotSpace(message = "한글 커피명은 공백이 아니어야 합니다.")
    private String korName;

    @NotSpace(message = "영문 커피명은 공백이 아니어야 합니다.")
    @Pattern(regexp = "^([A-Za-z])(\\s?[A-Za-z])*$",
            message = "영문 커피명은 영문으로만 가능하고, 단어 사이에 공백은 한칸만 허용 됩니다. 예)Cafe Latte")
    private String engName;

    @Range(min = 100, max = 50000)
    private Integer price;
}
