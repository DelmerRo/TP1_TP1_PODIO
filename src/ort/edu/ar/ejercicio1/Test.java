package ort.edu.ar.ejercicio1;

public class Test {

	public static void main(String[] args) {
		Grupo grupo = new Grupo("Amigos Operativos");

		grupo.agregarIntegrante("Debora");
		grupo.agregarIntegrante("Ursula");
		grupo.agregarIntegrante("Max");
		grupo.agregarIntegrante("Delmer");
		grupo.agregarIntegrante("Gonzalo");
		grupo.agregarIntegrante("Jorge");
		grupo.agregarIntegrante("Debora");
		grupo.mostrar();
		System.out.println("\nPersona Eliminada: " + grupo.removerIntegrante("Jorge"));
		System.out.println("Persona Eliminada: " + grupo.removerIntegrante("Jorge"));
		grupo.mostrar();
		grupo.vaciar();
		grupo.mostrar();
//System.out.println("Cantidad de integrantes: "+grupo.getCantidadIntegrantes());
//System.out.println("Posicion integrante: "+grupo.obtenerIntegrante(5));
//System.out.println("Persona buscada: "+grupo.buscarIntegrante("Debora"));	
	}

}
