package ort.edu.ar.ejercicio3;

import java.util.ArrayList;

public class Carrera {
	private static final int PRIMERO = 0;
	private static final int SEGUNDO = 1;
	private static final int TERCERO = 2;
	private static final int TERNA = 3;
	private String nombre;
	private ArrayList<Atleta> atletas;

	ArrayList<Atleta> primeros;
	ArrayList<Atleta> segundos;
	ArrayList<Atleta> terceros;

////////////////CONSTRUCTOR///////////////////
	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
		this.atletas = new ArrayList<>();
		primeros = new ArrayList<Atleta>();
		segundos = new ArrayList<Atleta>();
		terceros = new ArrayList<Atleta>();
	}

////////////////TOSTRING///////////////////
	@Override
	public String toString() {
		return "Carrera [nombre=" + nombre + ", atletas=" + atletas + "]";
	}

	////////////////////// GETTERS Y SETTERS///////////////////
	public String getNombre() {
		return nombre;
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

	public ArrayList<InformeDeGanadores> mostrarTernaGanadora() {
		ArrayList<InformeDeGanadores> ternaGanadora = new ArrayList<>();
		ArrayList<Atleta> listaPorPuesto = new ArrayList<>();
		ArrayList<Atleta> listaDeEliminados = new ArrayList<>();
		int puesto = 0;
		int i = 0;
		double tiempoMin = this.obtenerTiempoMin();
		while (i < this.atletas.size() && puesto < TERNA) {
			if (this.atletas.get(i).getSegundo() == tiempoMin) {
				listaPorPuesto = obtenerlistaPorPuesto(tiempoMin);
				ternaGanadora.add(new InformeDeGanadores(puesto, this.nombre, listaPorPuesto));
				listaDeEliminados.addAll(listaPorPuesto);
				puesto++;
				i = 0;
			} else {
				tiempoMin = this.obtenerTiempoMin();
				i++;
			}
		}
		this.reincorporarTerna(listaDeEliminados);
		return ternaGanadora;
	}

	public ArrayList<InformeDeGanadores> mostrarTernaGanadora1() {
		ArrayList<InformeDeGanadores> listaDeGanadores = new ArrayList<>();
		double tiempoPrimero = Double.MAX_VALUE;
		double tiempoSegundo = Double.MAX_VALUE;
		double tiempoTercero = Double.MAX_VALUE;

		for (Atleta atletaAux : this.atletas) {
			if (atletaAux.getSegundo() < tiempoPrimero) {
				tiempoTercero = tiempoSegundo;
				tiempoSegundo = tiempoPrimero;
				tiempoPrimero = atletaAux.getSegundo();
				terceros.clear();
				terceros.addAll(segundos);
				segundos.clear();
				segundos.addAll(primeros);
				primeros.clear();
				primeros.add(atletaAux);

			} else if (atletaAux.getSegundo() == tiempoPrimero) {
				primeros.add(atletaAux);
			} else if (atletaAux.getSegundo() < tiempoSegundo) {
				tiempoTercero = tiempoSegundo;
				tiempoSegundo = atletaAux.getSegundo();
				terceros.clear();
				terceros.addAll(segundos);
				segundos.clear();
				segundos.add(atletaAux);
			} else if (atletaAux.getSegundo() == tiempoSegundo) {
				segundos.add(atletaAux);
			} else if (atletaAux.getSegundo() < tiempoTercero) {
				tiempoTercero = atletaAux.getSegundo();
				terceros.clear();
				terceros.add(atletaAux);
			} else if (atletaAux.getSegundo() == tiempoTercero) {
				terceros.add(atletaAux);
			}
		}
		listaDeGanadores.add(new InformeDeGanadores(PRIMERO, this.nombre, primeros));
		listaDeGanadores.add(new InformeDeGanadores(SEGUNDO, this.nombre, segundos));
		listaDeGanadores.add(new InformeDeGanadores(TERCERO, this.nombre, terceros));
		return listaDeGanadores;
	}

	private ArrayList<Atleta> obtenerlistaPorPuesto(double tiempoMin) {
		ArrayList<Atleta> lista = new ArrayList<>();
		int i = 0;
		while (i < this.actualizarLista()) {
			if (this.atletas.get(i).getSegundo() == tiempoMin) {
				Atleta atleta = this.atletas.remove(i);
				lista.add(atleta);
				actualizarLista();
			} else {
				i++;
			}
		}
		return lista;
	}

	private int actualizarLista() {
		return this.atletas.size();
	}

	private void reincorporarTerna(ArrayList<Atleta> ternaGanadora) {
		for (Atleta a : ternaGanadora) {
			this.atletas.add(a);
		}

	}
}
