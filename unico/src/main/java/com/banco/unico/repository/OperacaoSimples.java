package com.banco.unico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacaoSimples extends JpaRepository<OperacaoSimples, Long>{
    
}