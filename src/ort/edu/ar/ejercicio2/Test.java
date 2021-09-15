package ort.edu.ar.ejercicio2;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Carrera carrera = new Carrera("100 metros planos");
		carrera.agregarAtleta("Delmer", 90);
		carrera.agregarAtleta("Max", 170);
		carrera.agregarAtleta("Ursula", 115);
		carrera.agregarAtleta("Gabriel", 180);
		carrera.agregarAtleta("Debora", 150);
		carrera.agregarAtleta("Matias", 90);
		carrera.agregarAtleta("Juan", 110);
		carrera.agregarAtleta("Maria", 110);
		carrera.agregarAtleta("Melina", 145);
		carrera.mostrar();
		System.out.println("\nLista de Ganadores\n" + carrera.mostrarGanadores());
		System.out.println("Cantidad de atletas ganadores: " + carrera.mostrarGanadores().size());
	}
}
