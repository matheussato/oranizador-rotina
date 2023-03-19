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

import br.com.fiap.organizadortarefas.models.Meta;

@RestController
public class MetaController {
    
    Logger log = LoggerFactory.getLogger(MetaController.class);

    List<Meta> metas = new ArrayList<>();

    @GetMapping("/api/metas")
    public List<Meta> index(){
        return metas;
    }

    @GetMapping("api/metas/{id}")//{id} - significa que é uma variável de path
    public ResponseEntity<Meta> show(@PathVariable Long id){
        log.info("buscar meta com id : " + id);
        var MetaEncontrada = metas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(MetaEncontrada.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(MetaEncontrada.get());
    }
    
    @PostMapping("api/metas")
    public ResponseEntity<Meta> create(@RequestBody Meta meta){
        log.info("cadastrar metas: " + meta);
        meta.setId(metas.size() + 1l);//1l converte para long
        metas.add(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(meta);
    }

    @DeleteMapping("api/despesa/{id}")
    public ResponseEntity<Meta> destroy(@PathVariable Long id){
        log.info("apagar meta" + id);
        
        var MetaEncontrada = metas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(MetaEncontrada.isEmpty()) 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        metas.remove(MetaEncontrada.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("api/despesa/{id}")
    public ResponseEntity<Meta> update(@PathVariable Long id, @RequestBody Meta meta){
        log.info("apagar despesa" + id);
        
        var metaEncontrada = metas
                                .stream().
                                filter((d) -> {return d.getId().equals(id);})
                                .findFirst();

        if(metaEncontrada.isEmpty()) 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        metas.remove(metaEncontrada.get());
        meta.setId(id);
        metas.add(meta);

        return ResponseEntity.ok(meta);
    }

}

