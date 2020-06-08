package com.nik.demoannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.nik.demoannotation")
@PropertySource("classpath:sport.properties")
public class PracticeSportConfig {

    //определяю bean для sadFortuneService
    @Bean
    public FortuneService hungryFortuneService() {
        return new HungryFortuneService();
    }

    //определяю бин для SwimCoach и внедряю зависимости
    @Bean
    public Coach footballCoach() {
        return new FootballCoach(hungryFortuneService());
    }
}
