package com.banco.unico.controller;

import java.util.List;

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

import com.banco.unico.entities.OperacaoComplexa;
import com.banco.unico.service.OperacaoComplexaService;

@RestController
@RequestMapping("/operacaoComplexa")
public class OperacaoComplexaController {
    @Autowired
    private OperacaoComplexaService operacaoComplexaService;


    @GetMapping
    public ResponseEntity<List<OperacaoComplexa>> getAllOPeracaoComplexa(){        
         
        List<OperacaoComplexa> operacaoComplexa = operacaoComplexaService.getAllOPeracaoComplexa();

        if(!OperacaoComplexa.isEmpty()) {
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<OperacaoComplexa> getOperacaoComplexaById(@PathVariable Long id){
        
        OperacaoComplexa operacaoComplexa = OperacaoComplexaService.getOperacaocomplexaById(id);

        if (operacaoComplexa != null){
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<OperacaoComplexa> saveOperacaoComplexa(@RequestBody OperacaoComplexa novaOperacaoComplexa){

        OperacaoComplexa operacaoComplexa = operacaoComplexaService.saveOperacaoComplexa(novaOperacaoComplexa);
        return ResponseEntity.ok(operacaoComplexa);
    }
    @PutMapping("/{id}")
    public ResponseEntity<OperacaoComplexa> updateOperacaoComplexa (@RequestBody OperacaoComplexa operacaoComplexaAtualizada, @PathVariable Long id) {

        OperacaoComplexa operacaoComplexa = OperacaoComplexaService.getOperacaocomplexaById(id);
        if (operacaoComplexa != null){
            OperacaoComplexa operacaoComplexaNova = operacaoComplexaService.updateOperacaoComplexa(id, operacaoComplexaAtualizada);
            return new ResponseEntity<>(operacaoComplexaNova, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/mapping/{id}")
    public ResponseEntity<OperacaoComplexa> updateOperacaoComplexaMapping (@RequestBody OperacaoComplexa operacaoComplexaAtualizada, @PathVariable Long id) {

        OperacaoComplexa operacaoComplexa = OperacaoComplexaService.getOperacaocomplexaById(id);
        if (operacaoComplexa != null){
            OperacaoComplexa operacaoComplexaNova = operacaoComplexaService.updateOperacaoComplexa(id, operacaoComplexaAtualizada);
            return new ResponseEntity<>(operacaoComplexaNova, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<OperacaoComplexa> deleteOperacaoComplexa(@PathVariable Long id){

        OperacaoComplexa operacaoComplexa = OperacaoComplexaService.getOperacaocomplexaById(id);
        
        if (operacaoComplexa != null){
            operacaoComplexaService.deleteOperacaoComplexa(id);
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OperacaoComplexa> logicalDeleteOperacaoComplexa(@PathVariable Long id){

        OperacaoComplexa operacaoComplexa = OperacaoComplexaService.getOperacaocomplexaById(id);
        
        if (operacaoComplexa != null){
            operacaoComplexaService.logicalDeleteOpercaoComplexa(id);
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(operacaoComplexa, HttpStatus.NOT_FOUND);
        }
    }
    
    
}
