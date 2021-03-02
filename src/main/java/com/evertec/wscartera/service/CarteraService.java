package com.evertec.wscartera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.evertec.wscartera.entity.*;
import com.evertec.wscartera.repo.CarteraMapperRepository;
import java.util.*;

/**
* @author Oswaldo Tuberquia
**/
@Repository
public class CarteraService {
	@Autowired
	CarteraMapperRepository repo;
	
	public Response findAllClient() {
		List<Cartera> item = repo.findAllCartera();
		Response rst = new Response();
		rst.setCodigo("200");
		rst.setMensaje("Clientes listados Correctamente");
		rst.setObjeto(item);
		return rst;
	}
	

	public Response updateCarteraCliente(Cartera cartera) {
		repo.updateCarteraCliente(cartera);
		Response rst = new Response();
		rst.setCodigo("204");
		rst.setMensaje("Cliente Actualizado Correctamente");
		List<Cartera> item = new ArrayList<Cartera>();
		item.add(repo.findCarteraByIdCliente(cartera.getIdcliente()));
		rst.setObjeto(item);
		return rst;
	}

	public Response insertCarteraCliente(Cartera cartera) {
		repo.insertCarteraCliente(cartera);
		Response rst = new Response();
		rst.setCodigo("201");
		rst.setMensaje("Cliente Creado Correctamente");
		List<Cartera> item = new ArrayList<Cartera>();
		item.add(repo.findCarteraByIdCliente(cartera.getIdcliente()));
		rst.setObjeto(item);
		return rst;
	}

	public Response deleteCarteraCliente(Cartera cartera) {
		repo.deleteCarteraCliente(cartera);
		Response rst = new Response();
		rst.setCodigo("203");
		rst.setMensaje("Cliente Eliminado Correctamente");
		List<Cartera> item = new ArrayList<Cartera>();
		item.add(cartera);
		rst.setObjeto(item);
		return rst;
	}
	
	public Response findClientbyIdentificador(String identificador) {		
		Response rst = new Response();
		Cartera objeto = repo.findCarteraByIdCliente(identificador);
		if(objeto != null) {
			rst.setCodigo("200");
			rst.setMensaje("Cliente encontrado Correctamente");
			List<Cartera> item = new ArrayList<Cartera>();
			item.add(objeto);
			rst.setObjeto(item);
		}else {
			rst.setCodigo("405");
			rst.setMensaje("Cliente no encontrado");
			List<Cartera> item = new ArrayList<Cartera>();
			item.add(objeto);
			rst.setObjeto(item);
		}		
		return rst;
	}

}
