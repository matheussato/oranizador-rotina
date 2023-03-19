package br.com.fiap.organizadortarefas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.organizadortarefas.models.Rotina;

@RestController
public class RotinaController {

    Logger log = LoggerFactory.getLogger(MetaController.class);

    List<Rotina> rotinas = new ArrayList<>();

    @GetMapping("/api/rotinas")
    public List<Rotina> index(){
        return rotinas;
    }

    @GetMapping("api/rotinas/{id}")//{id} - significa que é uma variável de path
    public ResponseEntity<Rotina> show(@PathVariable Long id){
        log.info("buscar meta com id : " + id);
        var RotinaEncontrada = rotinas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(RotinaEncontrada.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(RotinaEncontrada.get());
    }
    
    @PostMapping("api/rotinas")
    public ResponseEntity<Rotina> create(@RequestBody Rotina rotina){
        log.info("cadastrar rotinas: " + rotina);
        rotina.setId(rotinas.size() + 1l);//1l converte para long
        rotinas.add(rotina);
        return ResponseEntity.status(HttpStatus.CREATED).body(rotina);
    }

    @DeleteMapping("api/rotina/{id}")
    public ResponseEntity<Rotina> destroy(@PathVariable Long id){
        log.info("apagar rotina" + id);
        
        var RotinaEncontrada = rotinas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(RotinaEncontrada.isEmpty()) 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        rotinas.remove(RotinaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("api/rotina/{id}")
    public ResponseEntity<Rotina> update(@PathVariable Long id, @RequestBody Rotina rotina){
        log.info("apagar rotina" + id);
        
        var rotinaEncontrada = rotinas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(rotinaEncontrada.isEmpty()) 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        rotinas.remove(rotinaEncontrada.get());
        rotina.setId(id);
        rotinas.add(rotina);

        return ResponseEntity.ok(rotina);
    }
    
}
