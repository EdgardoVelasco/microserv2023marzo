package com.netec.feign.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import com.netec.entities.Articulo;
import com.netec.entities.Carrito;
import com.netec.feign.IArticuloFeign;

@Service
public class CarritoServiceImpl  implements ICarritoService{
	@Autowired
	private IArticuloFeign feign;
	
	@Autowired
	private Carrito carrito;
	
	@Autowired
	private CircuitBreakerFactory cb;
	
	private Logger LOG=LoggerFactory.getLogger(CarritoServiceImpl.class);
	
	

	@Override
	public boolean insertArticulo(int id) {
		
		return cb.create("articulos")
				 .run(()->{
					 
					 Articulo art=feign.findById(id);
						if(art!=null) {
							this.carrito.getArticulos().add(art);
							return true;
							
						}
						return false;
				 }, error->metodoAlternativo(id));
		
	}
	
	public boolean metodoAlternativo(int id) {
		LOG.info("Se ejecuta metodo alternativo");
		
		return false;
	}

	@Override
	public List<Articulo> showAll() {
		// TODO Auto-generated method stub
		return this.carrito.getArticulos();
	}

}
