package br.com.banco.api.config;

import br.com.banco.api.mapper.ContaMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ContaMapper contaMapper() {
        return Mappers.getMapper(ContaMapper.class);
    }
}
