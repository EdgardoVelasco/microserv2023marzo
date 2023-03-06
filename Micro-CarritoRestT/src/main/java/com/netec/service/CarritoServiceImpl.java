package com.netec.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netec.entities.Articulo;
import com.netec.entities.Carrito;

@Service
public class CarritoServiceImpl implements ICarritoService{
	@Autowired
	private Carrito carrito;
	@Autowired
	private RestTemplate rest;
	
	@Override
	public List<Articulo> showAll() {
		// TODO Auto-generated method stub
		return carrito.getArticulos();
	}
	@Override
	public Articulo searchByName(String nombre) {
		// TODO Auto-generated method stub
		return carrito.getArticulos()
				      .stream()
				      .filter(t->t.getNombre().equals(nombre))
				      .findFirst().orElse(null);
	}
	@Override
	public boolean insertArticulo(int id) {
		Map<String, String> mapa= new HashMap<>();
		mapa.put("id", String.valueOf(id));
		String url="http://localhost:9091/articulo/{id}";
		Articulo art=rest.getForObject(url, Articulo.class, mapa);
		if(art!=null) {
			this.carrito.getArticulos().add(art);
			return true;
			
		}
		
		
		
		
		return false;
	}
	@Override
	public boolean deleteArticuloByName(String nombre) {
		Articulo art=this.carrito.getArticulos()
				.stream().filter(t->t.getNombre().equals(nombre))
				.findFirst().orElse(null);
		
		return this.carrito.getArticulos().remove(art);
	}
	@Override
	public double calculateTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
