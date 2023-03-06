package com.netec.feign.service;

import java.util.List;

import com.netec.entities.Articulo;

public interface ICarritoService {
	boolean insertArticulo(int id);
	List<Articulo> showAll();
	
}
