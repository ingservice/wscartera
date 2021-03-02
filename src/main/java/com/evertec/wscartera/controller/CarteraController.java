package com.evertec.wscartera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.evertec.wscartera.entity.*;
import com.evertec.wscartera.service.CarteraService;
import com.evertec.wscartera.service.UsuarioService;

import java.util.*;

/**
 * @author Oswaldo Tuberquia
 **/
@RestController
public class CarteraController {
	@Autowired
	CarteraService repository;

	@Autowired
	UsuarioService repouser;

	@GetMapping("/cartera")
	public Response findAllClients(@RequestHeader MultiValueMap<String, String> headers) {
		String user = ((headers.containsKey("username") == true) ? headers.getFirst("username") : ""),
				pass = ((headers.containsKey("password") == true) ? headers.getFirst("password") : "");
		if (!user.isEmpty() && !pass.isEmpty()) {
			ResponseUser rstu = repouser.findUserByUsuarioClave(user, pass);
			if (rstu.getCodigo().trim().equals("405")) {
				return new Response(rstu.getCodigo().trim(), rstu.getMensaje().trim(), null);
			}
			return repository.findAllClient();
		}
		return new Response("401", "Acceso no autorizado", null);
	}

	@GetMapping("/cartera/{id}")
	public Response findClientbyId(@PathVariable String id, @RequestHeader MultiValueMap<String, String> headers) {
		String user = ((headers.containsKey("username") == true) ? headers.getFirst("username") : ""),
				pass = ((headers.containsKey("password") == true) ? headers.getFirst("password") : "");
		if (!user.isEmpty() && !pass.isEmpty()) {
			ResponseUser rstu = repouser.findUserByUsuarioClave(user, pass);
			if (rstu.getCodigo().trim().equals("405")) {
				return new Response(rstu.getCodigo().trim(), rstu.getMensaje().trim(), null);
			}
			return repository.findClientbyIdentificador(id);
		}
		return new Response("401", "Acceso no autorizado", null);
	}

	@PostMapping("/cartera")
	public Response insertClient(@RequestBody Cartera obj, @RequestHeader MultiValueMap<String, String> headers) {
		String user = ((headers.containsKey("username") == true) ? headers.getFirst("username") : ""),
				pass = ((headers.containsKey("password") == true) ? headers.getFirst("password") : "");
		if (!user.isEmpty() && !pass.isEmpty()) {
			ResponseUser rstu = repouser.findUserByUsuarioClave(user, pass);
			if (rstu.getCodigo().trim().equals("405")) {
				return new Response(rstu.getCodigo().trim(), rstu.getMensaje().trim(), null);
			}
			Response rsp = repository.findClientbyIdentificador(obj.getIdcliente());
			if (rsp.getCodigo().trim().equals("200")) {
				List<Cartera> item = new ArrayList<Cartera>();
				return new Response("202", "Cliente con ID:" + obj.getIdcliente() + " , Existe en base de datos!",
						item);
			}
			return repository.insertCarteraCliente(obj);
		}
		return new Response("401", "Acceso no autorizado", null);

	}

	@PutMapping("/cartera/{id}")
	public Response updateCarteraClient(@PathVariable String id, @RequestBody Cartera obj,
			@RequestHeader MultiValueMap<String, String> headers) {
		String user = ((headers.containsKey("username") == true) ? headers.getFirst("username") : ""),
				pass = ((headers.containsKey("password") == true) ? headers.getFirst("password") : "");
		if (!user.isEmpty() && !pass.isEmpty()) {
			ResponseUser rstu = repouser.findUserByUsuarioClave(user, pass);
			if (rstu.getCodigo().trim().equals("405")) {
				return new Response(rstu.getCodigo().trim(), rstu.getMensaje().trim(), null);
			}
			Response rsp = repository.findClientbyIdentificador(id);
			if (rsp.getCodigo().trim().equals("200")) {
				Cartera restore = rsp.getObjeto().get(0);
				restore.setNombrecliente(obj.getNombrecliente().trim());
				restore.setMontodeuda(obj.getMontodeuda());
				restore.setCorreo(obj.getCorreo().trim());
				restore.setVencimiento(obj.getVencimiento());
				return repository.updateCarteraCliente(restore);
			}
			return rsp;
		}
		return new Response("401", "Acceso no autorizado", null);
	}

	@DeleteMapping("/cartera/{id}")
	public Response deleteCarteraClient(@PathVariable String id, @RequestHeader MultiValueMap<String, String> headers) {
		String user = ((headers.containsKey("username") == true) ? headers.getFirst("username") : ""),
				pass = ((headers.containsKey("password") == true) ? headers.getFirst("password") : "");
		if (!user.isEmpty() && !pass.isEmpty()) {
			ResponseUser rstu = repouser.findUserByUsuarioClave(user, pass);
			if (rstu.getCodigo().trim().equals("405")) {
				return new Response(rstu.getCodigo().trim(), rstu.getMensaje().trim(), null);
			}
			Response rsp = repository.findClientbyIdentificador(id);
			if (rsp.getCodigo().trim().equals("200")) {
				Cartera restore = rsp.getObjeto().get(0);
				return repository.deleteCarteraCliente(restore);
			}
			return rsp;
		}
		return new Response("401", "Acceso no autorizado", null);
	}

}
