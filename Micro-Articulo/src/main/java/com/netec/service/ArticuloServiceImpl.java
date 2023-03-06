package com.netec.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netec.dao.IArticuloDAO;
import com.netec.entities.Articulo;

@Service
public class ArticuloServiceImpl implements IArticuloService{
	
	@Autowired
	private IArticuloDAO dao;
	
	@Value("${server.port}")
	private int port;

	@Override
	public List<Articulo> findAll() {
		// TODO Auto-generated method stub
		return (List<Articulo>)dao.findAll();
	}

	@Override
	public Articulo findById(int id) {
		// TODO Auto-generated method stub
		return Stream.of(dao.findById(id).orElse(null))
				.filter(t->t!=null)
				.peek(t->t.setPort(port))
				.findFirst().orElse(null);
	}

	@Override
	public Articulo save( Articulo art) {
		
		return dao.save(art);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);	
	}

}
