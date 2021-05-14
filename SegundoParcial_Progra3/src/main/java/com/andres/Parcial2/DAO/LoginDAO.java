package com.andres.Parcial2.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.andres.Parcial2.Conexion.ConexionBD;
import com.andres.Parcial2.Entidades.Usuario;

public class LoginDAO {
	ConexionBD conexion = new ConexionBD();
	Connection con = conexion.RetornarConexion();
	
	public boolean Login(Usuario usu) {
		
		boolean verificar = false;
		
		try {
			CallableStatement consulta = con.prepareCall("call Sp_s_Login(?,?)");
			consulta.setString("PNombre", usu.getNombre());
			consulta.setString("PContrasena", usu.getContrasena());
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				verificar = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return verificar;
	}
}
