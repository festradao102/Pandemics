package com.cenfotec.pandemics.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.cenfotec.pandemics.model.Especie;

public interface EspecieService {
	
	public void guardarEspecie(Especie especie);
	public List<Especie> listarEspecies();	
	public void actualizarEspecie(Especie especie);
	public Especie listarEspecieByGuid(int guid);
	public void EliminarEspecie(Especie especie);

}
