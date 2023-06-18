package org.example.WT03;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
@Bean
    public Car details(){
        String color = "Red";
        String type = "RaceCar";
        return new Car(color,type);
    }
}
