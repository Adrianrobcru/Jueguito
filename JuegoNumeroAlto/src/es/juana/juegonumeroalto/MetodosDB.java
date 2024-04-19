package es.juana.juegonumeroalto;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetodosDB {

	Conexion con=new Conexion();
	
	protected void añadirPartida(int tiempoPartida,Jugador usurio,int intentos) throws SQLException {
		
		String sql="INSERT INTO Partida (num_intentos,tiempo,usuario) Values(?,?,?)";
		
		Connection link =con.abrirConsulta();
		
		PreparedStatement consulta=link.prepareStatement(sql);
		
		consulta.setInt(1, intentos);
		consulta.setInt(2, tiempoPartida);
		consulta.setString(3, usurio.getUsuario());
		
		consulta.execute();
	}
	
	protected void añadirUsurio(String usuario,String password,String nombre) throws SQLException {

		String sql="INSERT INTO Usuario (usuario,password,nombre) Values(?,?,?)";
		
		Connection link =con.abrirConsulta();
		
		PreparedStatement consulta=link.prepareStatement(sql);
		
		consulta.setString(1,usuario );
		consulta.setString(2, password);
		consulta.setString(3,nombre);
		
		consulta.execute();
	}
	
}
