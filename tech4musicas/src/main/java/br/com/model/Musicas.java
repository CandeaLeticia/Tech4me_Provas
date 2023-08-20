package br.com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.dto.MusicaDto;


@Document("musicas")
public class Musicas {
    @Id
    private String id;
    private String titulo;
    private String artista;
    private String genero;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

  
    public Musicas(MusicaDto dto) {
        this.id = dto.id();
        this.titulo = dto.titulo();
        this.artista = dto.artista();
        this.genero = dto.genero();
    }
}


