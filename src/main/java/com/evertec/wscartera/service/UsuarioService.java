package com.evertec.wscartera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evertec.wscartera.entity.*;
import com.evertec.wscartera.repo.*;

/**
* @author Oswaldo Tuberquia
**/
@Repository
public class UsuarioService {
	@Autowired
	UsuariosMapperRepository repo;
	
	public ResponseUser findUserByUsuarioClave(String user, String psw) {
		ResponseUser rst = new ResponseUser();
		Usuarios usr = repo.findUsuariosByUsuarioClave(user.trim(), psw.trim());
		if(usr!=null) {
			rst.setCodigo("202");
			rst.setMensaje("Usuario Autenticado");
		}else {
			rst.setCodigo("405");
			rst.setMensaje("Usuario no autorizado");
		}
		return rst;
	}
}
