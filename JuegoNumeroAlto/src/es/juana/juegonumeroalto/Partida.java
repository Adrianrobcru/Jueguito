package es.juana.juegonumeroalto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	public static void main(String[] args) {
		
	}
	
	
	public void iniciarPartida() throws IOException {
		
		Partida p=new Partida();
		
		Scanner scOpcion= new Scanner(System.in);
		
		boolean partidaParar=false;
		
		while(!partidaParar) {
			System.out.println("Pilla el numero");
			System.out.println("1) Jugar");
			System.out.println("2) Ver mis estadisticas");
			System.out.println("3) Borrar estadísticas");
			System.out.println("4) Salir");
			int opcion=scOpcion.nextInt();
			
			switch (opcion) {
			case 1: {
				
				iniciarJuego();
				break;
			}
			case 2: {
				
				verEstadisticas();
				break;
			}
			
			case 3: {
				
				borrarEstadisticas();
				break;
			}
			case 4: {
				
				partidaParar=true;
				break;
			}
			default:
				System.err.println("Esa opcion no hace nada");
				System.out.println();
			}
			
			
			
			
		}
		
		
		
	}

	private void borrarEstadisticas() {
		// TODO Auto-generated method stub
		
	}

	private void verEstadisticas() {
		// TODO Auto-generated method stub
		
	}

	private void iniciarJuego() throws IOException, SQLException {
		
		Scanner scOpcion= new Scanner(System.in);
		
		
		System.out.println("Elige tu personaje");
		System.out.println("1) Homer");
		System.out.println("2) Sherk");
		System.out.println("3) Bender");
		System.out.println("3) Rick");
		
		
		int op=scOpcion.nextInt();
		
		
		String per = null;
		
		
		switch (op) {
		case 1:
			per="Homer";
			break;
		case 2:
			per="Sherk";
			break;
		case 3:
			per="Bender";
			break;
		case 4:
			per="Rick";
			break;
		}
		
		
		int intentos=0;
		
		
		Random r=new Random();
		int numeroAcertar=r.nextInt();
		
		
		System.out.println("Empieza el juego");
		 long startTime = System.currentTimeMillis();
		
		for (intentos = 0; intentos <= 5; ++intentos) {
			System.out.println("Dime el numero para adivinar");
			Scanner scNum=new Scanner(System.in);
			int numPersona=scNum.nextInt();
			
			
			if (numeroAcertar==numPersona) {
			
				System.out.println(crearFigura(per, "Ganador"));
				  
				break;
			}
			if (numeroAcertar>numPersona) {
				System.out.println(crearFigura(per, "Mayor"));
			}
			if (numeroAcertar<numPersona) {
				System.out.println(crearFigura(per, "Menor"));
			}
			
		}
		long finishTime = System.currentTimeMillis();
		if(intentos==5) {
			System.out.println(crearFigura(per, "Perdedor"));
		}
		
		System.out.println("Registrate en nuestra base de datos");
		Jugador j=crearUsuarioParaGuardar();
		int tiempoTotalSeg=(int) ((finishTime-startTime)/1000);
		MetodosDB mDB=new MetodosDB();
		mDB.añadirUsurio(j.getUsuario(), j.getContraseña(), j.getNombre());
		mDB.añadirPartida(tiempoTotalSeg, j, intentos);
		
	}
	private Jugador crearUsuarioParaGuardar() {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Usuario");
		String usuario=sc.nextLine();
		
		sc.next();
		
		System.out.println("Contraseña");
		String contraseña=sc.nextLine();
		sc.next();
		
		System.out.println("Nombre Completo");
		String nombreCompleto=sc.nextLine();
		
		Jugador j=new Jugador(usuario, contraseña, nombreCompleto);
		
		return j;
	}


	private String crearFigura(String personaje,String posicion) throws IOException {
		FileReader fr=new FileReader("C:\\Users\\alumno\\Desktop\\Juegito\\"+personaje+"\\"+personaje+posicion+".txt");
		BufferedReader br= new BufferedReader(fr);
		
		String texto="";
		String figura="";
		while ((texto=br.readLine())!= null) {
			figura+=texto;
			figura+="\n";
		}
		return figura;
		
		
	}
}
