package es.juana.juegonumeroalto;
import java.sql.*;

	public class Conexion {
		
			private final String database="jdbc:mysql://92.222.10.128/AdrianRobledo";
			private final String usario="adrianrobledo";
			private final String password="Clave123!";
			
			public Connection abrirConsulta() {
				Connection link = null;
				
				
				try {
					
					link=DriverManager.getConnection(database,usario,password);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				return link;
				
			}

			public Statement abrirconexion() {
				Connection link;
				Statement stm=null;
				
				try {
					
					link=DriverManager.getConnection(database,usario,password);
					stm=link.createStatement();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				return stm;
				
			}
			
			public static void cerrarConexion(Statement stm) {
				
				try {
					stm.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}
			
			
		
	}


