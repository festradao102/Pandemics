package com.cenfotec.pandemics.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.pandemics.model.Especie;

@Repository
public interface IEspecieRepo extends JpaRepository<Especie,Integer> {

}

