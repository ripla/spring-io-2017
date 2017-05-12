package com.vaadin.example.insurance;

import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    public PriceResult calculatePrice(AgeRange ageRange, City city) {
        if (ageRange == AgeRange.LOW) {
            return PriceResult.fail("Not old " + "enough");

        } else if (ageRange == AgeRange.MEDIUM) {
            return PriceResult.success(city.name()
                    .chars()
                    .sum());

        } else {
            return PriceResult.success(3 * city.name()
                    .chars()
                    .sum());
        }
    }
}
