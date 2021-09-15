package ort.edu.ar.ejercicio3;

import java.util.ArrayList;

public class InformeDeGanadores {
	public int getPosicion() {
		return posicion;
	}

	private String nombre;
	private int posicion;
	private ArrayList<Atleta> ganadores;

	public InformeDeGanadores(int posicion, String nombre, ArrayList<Atleta> ganadores) {
		super();
		this.nombre = nombre;
		this.posicion = posicion+1;
		this.ganadores = ganadores;
	}

	@Override
	public String toString() {
		return "\n\nPuesto nro: " + posicion + ",\nCarrera " + nombre + mostrarPorPlural() + ganadores
				+ "\nCantidad de ganadores: " + ganadores.size();
	}

	private String mostrarPorPlural() {
		return ganadores.size() > 1 ? "\nLos ganadores son: " : "\nEl ganador es: ";
	}
}
