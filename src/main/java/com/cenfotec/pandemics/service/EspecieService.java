package com.cenfotec.pandemics.service;

import java.util.List;

import com.cenfotec.pandemics.model.Especie;

public interface EspecieService {
	
	public void guardarEspecie(Especie especie);
	public List<Especie> listarEspecies();	
	public List<Especie> findById(int guid);	

}
