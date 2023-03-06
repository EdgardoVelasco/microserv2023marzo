package com.netec.service;

import java.util.List;

import com.netec.entities.Articulo;

public interface IArticuloService {
	List<Articulo> findAll();
	Articulo findById(int id);
	Articulo save(Articulo art);
	void deleteById(int id);
	
}
