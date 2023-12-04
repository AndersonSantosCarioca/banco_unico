package com.banco.unico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.unico.entities.OperacaoComplexa;
import com.banco.unico.repository.OperacaoComplexaRepository;

@Service
public class OperacaoComplexaService {

    @Autowired
    private OperacaoComplexaRepository operacaoComplexaRepository;

    public List<OperacaoComplexa> getAllOperacaoComplexas(){
        List<OperacaoComplexa> operacaoComplexas = operacaoComplexa.findAll();
        
        return operacaoComplexas;
    }

    public OperacaoComplexa getOperacaoComplexaById(Long id){

        OperacaoComplexa operacaoComplexa = operacaoComplexaRepository.findAllById(null)
    }
   
    
}
// falta terminar