package br.com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.model.Musicas;

public interface MusicasRepository extends MongoRepository<Musicas, String>{
    
}
