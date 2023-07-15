package br.com.banco.api.mapper;

import br.com.banco.api.dto.ContaDTO;
import br.com.banco.api.model.Conta;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

public interface ContaMapper {

    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "transferencias", ignore = true)
    Conta toEntity(ContaDTO contaDTO);

    ContaDTO toDTO(Conta conta);
}
