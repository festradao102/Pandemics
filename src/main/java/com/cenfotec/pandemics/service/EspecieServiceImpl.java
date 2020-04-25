package com.cenfotec.pandemics.service;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.pandemics.model.Especie;
import com.cenfotec.pandemics.respository.IEspecieRepo;

@Service
public class EspecieServiceImpl implements EspecieService{

	@Autowired
	private IEspecieRepo repoEspecie;	
		
	@Override
	public void guardarEspecie(Especie especie) {
		String lUUID = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		
		especie.setUUID(lUUID);
		especie.setFecha(java.time.LocalDateTime.now());
        repoEspecie.save(especie);   
	}

	@Override
	public List<Especie> listarEspecies() {
		return repoEspecie.findAll();
	}
	
	@Override
	public void actualizarEspecie(Especie especie) {
		especie.setFecha(java.time.LocalDateTime.now());
		repoEspecie.save(especie);
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
