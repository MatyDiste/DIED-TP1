package reparaFix;
import java.util.ArrayList;
import java.util.Scanner;
import trabajador.*;
import usuario.*;

public class Main {
	
	public static ArrayList<Trabajador> trabajadores= new ArrayList<Trabajador>();
	
	public static ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
	
	public static Usuario sesionActual=null;
	
	public static void crearUsuario() {
		//TODO
		
	}
	
	public static Boolean iniciarSesion() {
		//TODO
		return false;
	}
	
	public static void modoAdmin() {
		//TODO
	}

	public static void main(String[] args) {
		/*
		 * TODO
		 * Completar men�es...
		 */
		
		System.out.println("NO ESTA TERMINADO!!!");
		@SuppressWarnings("resource")
		Scanner inp = new Scanner(System.in);
		Integer input=0;

		do {
			System.out.println("Seleccione una opci�n: ");
			System.out.print(
					  "1) Crear usuario\n"
					+ "2) Iniciar sesi�n\n"
					+ "3) Modo administrador\n"
					+ "4) Salir\n");
			input = inp.nextInt();
			switch(input) {
			case 1:
				crearUsuario();
				break;
			case 2:
				iniciarSesion();
				break;
			case 3:
				modoAdmin();
				break;
			case 4:
				break;
			default:
				break;
			}
		}while(input!=4);
		
	}

}
