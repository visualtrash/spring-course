package com.nik.demoannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.nik.demoannotation")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    //определяю bean для sadFortuneService
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    //определяю бин для SwimCoach и внедряю зависимости
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
