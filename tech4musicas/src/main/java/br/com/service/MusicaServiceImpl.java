package br.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dto.MusicaDto;
import br.com.model.Musicas;
import br.com.repository.MusicasRepository;

@Service
public class MusicaServiceImpl implements MusicaService {
    @Autowired
    private MusicasRepository repositorio;

    @Override
    public Optional<MusicaDto> atualizarPorId(String id, MusicaDto dto) {
        Optional<Musicas> musicas = repositorio.findById(id);

        if (musicas.isPresent()) {
            Musicas musicasAtualizar = new Musicas(dto);
            musicasAtualizar.setId(id);
            repositorio.save(musicasAtualizar);
            return Optional.of(new MusicaDto(musicasAtualizar.getId(), musicasAtualizar.getTitulo(),
                    musicasAtualizar.getArtista(), musicasAtualizar.getGenero()));
        } else
            return Optional.empty();
    }

    @Override
    public MusicaDto cadastrar(MusicaDto dto) {
        Musicas musicas = new Musicas(dto);
        repositorio.save(musicas);
        return new MusicaDto(musicas.getId(), musicas.getTitulo(), musicas.getArtista(), musicas.getGenero());
    }

    @Override
    public void excluirPorId(String id) {
        repositorio.deleteById(id);
    }

   

    @Override
    public Optional<MusicaDto> obterPorId(String id) {
        Optional<Musicas> musicas = repositorio.findById(id);

        if (musicas.isPresent()) {
            return Optional.of(new MusicaDto(musicas.get().getId(), musicas.get().getArtista(),
                    musicas.get().getTitulo(), musicas.get().getGenero()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<MusicaDto> obterTodas() {
        return repositorio.findAll()
                .stream()
                .map(p -> new MusicaDto(p.getId(),p.getTitulo(),p.getArtista(),p.getGenero()))
                .toList();
    }

}
