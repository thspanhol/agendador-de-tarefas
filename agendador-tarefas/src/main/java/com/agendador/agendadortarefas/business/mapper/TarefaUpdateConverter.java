package com.agendador.agendadortarefas.business.mapper;

import com.agendador.agendadortarefas.business.dto.TarefaDTO;
import com.agendador.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateConverter {

    void updateTarefas(TarefaDTO dto, @MappingTarget TarefasEntity entity);
}
