package ort.edu.ar.ejercicio3;

public class Test {
	public static void main(String[] args) {

		Carrera carrera = new Carrera("100 metros planos");

		carrera.agregarAtleta("Delmer", 110);
		carrera.agregarAtleta("Max", 170);
		carrera.agregarAtleta("Ursula", 115);
		carrera.agregarAtleta("Gabriel", 110);
		carrera.agregarAtleta("Debora", 150);
		carrera.agregarAtleta("Matias", 115);
		carrera.agregarAtleta("Juan", 110);
		carrera.agregarAtleta("Melina", 110);
		carrera.agregarAtleta("Maria", 110);
		carrera.agregarAtleta("Manuel", 111);
		carrera.agregarAtleta("Leo", 85);
		carrera.agregarAtleta("Luciano", 115);
		carrera.agregarAtleta("Noelia", 111);
		carrera.agregarAtleta("Liliana", 180);
		carrera.agregarAtleta("Mercedes", 115);
		carrera.agregarAtleta("Nelly", 170);
		carrera.agregarAtleta("Oscar", 101);
		carrera.agregarAtleta("Jose", 145);
		carrera.agregarAtleta("Jonmas", 140);
		carrera.agregarAtleta("Mena", 170);
		carrera.agregarAtleta("Esteban", 154);
		carrera.agregarAtleta("Emiliano", 180);
		carrera.agregarAtleta("Leila", 125);
		carrera.agregarAtleta("Jonathan", 115);
		carrera.agregarAtleta("Carlos", 210);
		carrera.agregarAtleta("Octavio", 250);
		carrera.agregarAtleta("Steve", 85);
		System.out.println("//////////////////////////////////////////////////////////////////////");
		System.out.println("\nPersonas que ganaron el 1er lugar: " + carrera.mostrarGanadores());
		System.out.println("//////////////////////////////////////////////////////////////////////");
		System.out.println("\n////////////////////////FORMA NUMERO 1///////////////////////////");
		System.out.println(carrera.mostrarTernaGanadora());
		System.out.println("\n////////////////////////FORMA NUMERO 2///////////////////////////");
		System.out.println(carrera.mostrarTernaGanadora1());
	}
}
