package br.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.dto.MusicaDto;
import br.com.model.Musicas;
import br.com.service.MusicaService;

 @RestController
 @RequestMapping("/musicas")
public class MusicasController {
   @Autowired
   private MusicaService servico;

   @GetMapping 
   public ResponseEntity<List<MusicaDto>> obterMusicas(){
    return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
   }
    
   @GetMapping("/{id}")
   public ResponseEntity<MusicaDto> obterMusicasPorId(@PathVariable String id){
    Optional<MusicaDto> musicas = servico.obterPorId(id);

    if (musicas.isPresent()){
        return new ResponseEntity<>(musicas.get(), HttpStatus.OK);
    } else{
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   }

   @PostMapping
   public ResponseEntity<MusicaDto> cadastrarMusicas(@RequestBody MusicaDto musicas){
    return new ResponseEntity<>(servico.cadastrar(musicas), HttpStatus.CREATED);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> excluirMusicaPorId(@PathVariable String id) {
    servico.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Musicas> atualizarMusicas(@PathVariable String id, @RequestBody MusicaDto musicas){
    Optional<MusicaDto> musicasAtualizar = servico.atualizarPorId(id, musicas);
    if (musicasAtualizar != null) {
        return new ResponseEntity<>(HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
   }
}
