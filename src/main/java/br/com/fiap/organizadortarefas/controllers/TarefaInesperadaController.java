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

import br.com.fiap.organizadortarefas.models.TarefaInesperada;

@RestController
public class TarefaInesperadaController {

    Logger log = LoggerFactory.getLogger(MetaController.class);

    List<TarefaInesperada> tarefaInesperadas = new ArrayList<>();

    @GetMapping("/api/tarefaInesperada")
    public List<TarefaInesperada> index(){
        return tarefaInesperadas;
    }

    @GetMapping("api/taredaInesperada/{id}")//{id} - significa que é uma variável de path
    public ResponseEntity<TarefaInesperada> show(@PathVariable Long id){
        log.info("buscar tarefa inesperada com id : " + id);
        var TarefaInesperadaEncontrada = tarefaInesperadas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(TarefaInesperadaEncontrada.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(TarefaInesperadaEncontrada.get());
    }
    
    @PostMapping("api/tarefaInesperadas")
    public ResponseEntity<TarefaInesperada> create(@RequestBody TarefaInesperada tarefaInesperada){
        log.info("cadastrar tarefas inesperadas: " + tarefaInesperada);
        tarefaInesperada.setId(tarefaInesperadas.size() + 1l);//1l converte para long
        tarefaInesperadas.add(tarefaInesperada);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaInesperada);
    }

    @DeleteMapping("api/tarefaInesperada/{id}")
    public ResponseEntity<TarefaInesperada> destroy(@PathVariable Long id){
        log.info("apagar tarefa inesperada" + id);
        
        var TarefaInesperadaEncontrada = tarefaInesperadas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(TarefaInesperadaEncontrada.isEmpty()) 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        tarefaInesperadas.remove(TarefaInesperadaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("api/taredaInesperada/{id}")
    public ResponseEntity<TarefaInesperada> update(@PathVariable Long id, @RequestBody TarefaInesperada tarefaInesperada){
        log.info("apagar tareda inesperada" + id);
        
        var tarefaInesperadaEncontrada = tarefaInesperadas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(tarefaInesperadaEncontrada.isEmpty()) 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        tarefaInesperadas.remove(tarefaInesperadaEncontrada.get());
        tarefaInesperada.setId(id);
        tarefaInesperadas.add(tarefaInesperada);

        return ResponseEntity.ok(tarefaInesperada);
    }
    
}
