package com.agendador.agendadortarefas.business;

import com.agendador.agendadortarefas.business.dto.TarefaDTO;
import com.agendador.agendadortarefas.business.mapper.TarefaConverter;
import com.agendador.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.agendador.agendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.agendador.agendadortarefas.infrastructure.repository.TarefasRepository;
import com.agendador.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefaConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefaDTO gravarTarefa(String token, TarefaDTO dto){
        String email = jwtUtil.extractUsername(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);

        return tarefaConverter.paraTarefaDTO(tarefasRepository.save(entity));
    }
}
