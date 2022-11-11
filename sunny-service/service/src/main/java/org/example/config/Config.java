package org.example.config;

import org.example.model.enums.GenreEnum;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new Converter<GenreEnum, String>() {
            @Override
            public String convert(MappingContext<GenreEnum, String> mappingContext) {
                return mappingContext.getSource().name();
            }
        });
        return modelMapper;
    }
}
