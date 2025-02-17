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

import com.banco.unico.entities.Cliente;
import com.banco.unico.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        
        List<Cliente> clientes = clienteService.getAllClientes();

        if(!clientes.isEmpty()) {
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(clientes, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClientesById(@PathVariable Long id){
        
        Cliente cliente = clienteService.getClienteById(id);

        if (cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente novoCliente){

        Cliente cliente = clienteService.saveCliente(novoCliente);
        return ResponseEntity.ok(cliente);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente (@RequestBody Cliente clienteAtualizado, @PathVariable Long id) {

        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null){
            Cliente clienteNovo = clienteService.updateCliente(id, clienteAtualizado);
            return new ResponseEntity<>(clienteNovo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }

    }
    @PutMapping("/mapping/{id}")
    public ResponseEntity<Cliente> updateClienteMapping (@RequestBody Cliente clienteAtualizado, @PathVariable Long id) {

        Cliente cliente = clienteService.getClienteById(id);
        if (cliente != null){
            Cliente clienteNovo = clienteService.updateCliente(id, clienteAtualizado);
            return new ResponseEntity<>(clienteNovo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){

        Cliente cliente = clienteService.getClienteById(id);
        
        if (cliente != null){
            clienteService.deleteCliente(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cliente> logicalDeleteCliente(@PathVariable Long id){

        Cliente cliente = clienteService.getClienteById(id);
        
        if (cliente != null){
            clienteService.logicalDeleteCliente(id);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND);
        }
    }
    

}
