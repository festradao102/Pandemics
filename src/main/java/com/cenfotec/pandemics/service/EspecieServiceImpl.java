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
	public void actualizarEspecie(Especie Especie) {
		Especie.setFecha(java.time.LocalDateTime.now());
		repoEspecie.save(Especie);
	}

	@Override
	public Especie listarEspecieByGuid(int guid) {
		return repoEspecie.getOne(guid);
	}

	@Override
	public void EliminarEspecie(Especie especie) {
		repoEspecie.delete(especie);		
	}	
		
}
