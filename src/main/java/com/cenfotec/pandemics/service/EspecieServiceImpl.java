package com.cenfotec.pandemics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.pandemics.model.Especie;
import com.cenfotec.pandemics.respository.IEspecieRepo;

@Service
public class EspecieServiceImpl implements EspecieService{

	@Autowired
	private IEspecieRepo repoEspecie;
		
	@Override
	public void guardarEspecie(Especie Especie) {
        Especie.setFecha(java.time.LocalDateTime.now());
        repoEspecie.save(Especie);   
	}

	@Override
	public List<Especie> listarEspecies() {
		return repoEspecie.findAll();
	}
	
	@Override
	public List<Especie> findById(int guid) {
		return null;
	}	
	
}
