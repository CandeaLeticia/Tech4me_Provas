package br.com.service;

import java.util.List;
import java.util.Optional;

import br.com.dto.MusicaDto;

public interface MusicaService {
    List<MusicaDto> obterTodas();
    Optional<MusicaDto> obterPorId(String id);
    MusicaDto cadastrar(MusicaDto dto);
    Optional<MusicaDto> atualizarPorId(String id, MusicaDto musicas);
    void excluirPorId(String id);
}

