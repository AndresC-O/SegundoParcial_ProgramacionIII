package com.andres.Parcial2.Negocio;

import com.andres.Parcial2.DAO.LoginDAO;
import com.andres.Parcial2.Entidades.Usuario;

public class clsLogin {

	
	
	public int VerificarUsuario(Usuario usuario) {
		
		int Acceso = 0;
		LoginDAO validacion = new LoginDAO();
		
		var validar = validacion.Login(usuario);
		
		if(validar == true) {
			Acceso = 1;
		}
		
		return Acceso;
	}
}
