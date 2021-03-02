package com.evertec.wscartera.repo;

import org.apache.ibatis.annotations.*;

import com.evertec.wscartera.entity.Cartera;

import java.util.*;

/**
* @author Oswaldo Tuberquia
**/
@Mapper
public interface CarteraMapperRepository {
	@Select("SELECT * FROM cartera WHERE idcliente=#{idcliente}")
	public Cartera findCarteraByIdCliente(@Param("idcliente") String idcliente);

	@Update("UPDATE cartera SET montodeuda=#{montodeuda},vencimiento=#{vencimiento},correo=#{correo},nombrecliente=#{nombrecliente} "
			+ " WHERE idcliente=#{idcliente}")
	public void updateCarteraCliente(Cartera cartera);

	@Insert("INSERT INTO cartera (idcliente,nombrecliente,correo,montodeuda,iddeuda,vencimiento) "
			+ " VALUES(#{idcliente},#{nombrecliente},#{correo},#{montodeuda},#{iddeuda},#{vencimiento})")
	public int insertCarteraCliente(Cartera cartera);

	@Delete("DELETE FROM cartera WHERE idcliente=#{idcliente}")
	public void deleteCarteraCliente(Cartera cartera);

	@Select("SELECT * FROM cartera order by idcliente")
	public List<Cartera> findAllCartera();

}
