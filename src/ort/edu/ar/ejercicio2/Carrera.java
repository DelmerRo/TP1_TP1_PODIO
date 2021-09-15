package ort.edu.ar.ejercicio2;

import java.util.ArrayList;

public class Carrera {
	private static final int TERNA = 3;
	private String nombre;
	private ArrayList<Atleta> atletas;

////////////////CONSTRUCTOR///////////////////
	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
		this.atletas = new ArrayList<>();
	}

////////////////TOSTRING///////////////////
	@Override
	public String toString() {
		return "Carrera [nombre=" + nombre + ", atletas=" + atletas + "]";
	}

////////////////METODOS///////////////////
	public void agregarAtleta(String nombreIntegrante, int segundos) {
		if (this.buscarIntegrante(nombreIntegrante) == null) {
			this.atletas.add(new Atleta(nombreIntegrante, segundos));
			System.out.println("[" + nombreIntegrante + "] fue asignado a la carrera de[" + this.nombre + "]");
		} else {
			System.out.println("Atleta " + nombreIntegrante + " ya existe!!");
		}
	}

	public Atleta buscarIntegrante(String nombre) {
		Atleta atletaEncontrado = null;
		int i = 0;
		while (i < this.atletas.size() && atletaEncontrado == null) {
			if (this.atletas.get(i).getNombre().equals(nombre)) {
				atletaEncontrado = this.atletas.get(i);
			} else {
				i++;
			}
		}
		return atletaEncontrado;
	}

	public void mostrar() {
		System.out.println("\nCarrera: " + this.nombre);
		this.mostrarIntegrantes();
	}

	private void mostrarIntegrantes() {
		for (Atleta a : this.atletas) {
			System.out.println(a);
		}
		System.out.println("Cantidad de Atletas: " + this.getCantidadIntegrantes());

	}

	private int getCantidadIntegrantes() {
		return this.atletas.size();
	}

	public ArrayList<Atleta> mostrarGanadores() {
		ArrayList<Atleta> listaDeGanadores = new ArrayList<>();
		double tiempoMin = this.obtenerTiempoMin();
		for (Atleta a : this.atletas) {
			if (a.getSegundo() == tiempoMin) {
				listaDeGanadores.add(a);
			}
		}
		return listaDeGanadores;
	}

	private double obtenerTiempoMin() {
		double minSeg = Double.MAX_VALUE;
		for (Atleta a : this.atletas) {
			if (a.getSegundo() < minSeg) {
				minSeg = a.getSegundo();
			}
		}
		return minSeg;
	}

	public Atleta[] mostrarTernaGanadora() {
		Atleta[] ternaGanadora = new Atleta[TERNA];
		ArrayList<Atleta>listaAuxiliar=this.atletas;
		int cant = 0;
		int i = 0;
		double tiempoMin = this.obtenerTiempoMin();
		while (i < this.atletas.size() && cant < TERNA) {
			if (this.atletas.get(i).getSegundo() == tiempoMin) {
				Atleta atleta = this.atletas.remove(i);
				ternaGanadora[cant] = atleta;
				cant++;
				i = 0;
				tiempoMin = this.obtenerTiempoMin();
			} else {
				i++;
			}
		}
		this.reincorporarTerna(ternaGanadora);
		return ternaGanadora;
	}

	private void reincorporarTerna(Atleta[] ternaGanadora) {
		for(int i=0;i<ternaGanadora.length;i++) {
			this.atletas.add(ternaGanadora[i]);
		}
		
	}

}
