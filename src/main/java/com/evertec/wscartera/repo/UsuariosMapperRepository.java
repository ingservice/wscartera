package com.evertec.wscartera.repo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.evertec.wscartera.entity.*;

/**
* @author Oswaldo Tuberquia
**/
@Mapper
public interface UsuariosMapperRepository {
	@Select("SELECT * FROM usuarios WHERE usuario=#{usuario} and clave=#{clave}")
	public Usuarios findUsuariosByUsuarioClave(@Param("usuario") String usuario, @Param("clave") String clave);
}
