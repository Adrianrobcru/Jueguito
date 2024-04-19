package es.juana.juegonumeroalto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
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

	private void iniciarJuego() throws IOException {
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
		int numeroAcertar=13;
		for (intentos = 0; intentos <= 10; intentos++) {
			System.out.println("Dime el numero para adivinar");
			Scanner scNum=new Scanner(System.in);
			int numPersona=scNum.nextInt();
			
			
			
			if (numeroAcertar==numeroAcertar) {
			
				FileReader fr=new FileReader("C:\\Users\\alumno\\Desktop\\Juegito\\"+per+"\\"+per+"Ganador.txt");
				BufferedReader br= new BufferedReader(fr);
				
				String texto="";
				String figura="";
				while ((texto=br.readLine())!= null) {
					figura+=texto;
					figura+="\n";
				}
				System.out.println(figura);
				String str= br.readLine();
			}
			if (numeroAcertar==numPersona) {
				File fMa=new File("C:\\Users\\alumno\\Desktop\\Juegito\\"+per+"\\"+per+"Mayor.txt");
			}
			if (numeroAcertar==numPersona) {
				File fMe=new File("C:\\Users\\alumno\\Desktop\\Juegito\\"+per+"\\"+per+"Menor.txt");
			}
			
		}
		
	}
	
}
