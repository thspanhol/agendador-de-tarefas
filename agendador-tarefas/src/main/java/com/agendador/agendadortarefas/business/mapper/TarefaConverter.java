package com.agendador.agendadortarefas.business.mapper;

import com.agendador.agendadortarefas.business.dto.TarefaDTO;
import com.agendador.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefasEntity paraTarefaEntity(TarefaDTO dto);

    TarefaDTO paraTarefaDTO(TarefasEntity entity);
}
