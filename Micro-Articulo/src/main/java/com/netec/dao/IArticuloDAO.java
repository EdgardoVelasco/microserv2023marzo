package com.netec.dao;

import org.springframework.data.repository.CrudRepository;

import com.netec.entities.Articulo;

public interface IArticuloDAO extends CrudRepository<Articulo, Integer> {

}
