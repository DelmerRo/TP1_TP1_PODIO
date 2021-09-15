package ort.edu.ar.ejercicio1;

import java.util.ArrayList;

public class Grupo {
	private String nombre;
	private ArrayList<String> integrantes;

////////////CONSTRUCTOR/////////////////////////////////
	public Grupo(String nombre) {
		super();
		this.setNombre(nombre);
		this.integrantes = new ArrayList<>();
	}

/////////////////GETTERS Y SETTERS//////////////////
	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

//////////////////TOSTRING/////////////////////////
	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", integrantes=" + integrantes + "]";
	}

//////////////////METODOS//////////////////////////
	public int getCantidadIntegrantes() {
		return this.integrantes.size();
	}

	public void agregarIntegrante(String nombreIntegrante) {
		if (this.buscarIntegrante(nombreIntegrante) == null) {
			this.integrantes.add(nombreIntegrante);
			System.out.println("[" + nombreIntegrante + "] fue asignado al grupo [" + this.nombre + "]");
		} else {
			System.out.println("Integrante " + nombreIntegrante + " ya existe!!");
		}
	}

	private int obtenerPosicionIntegrante(String nombreIntegrante) {
		int contador = 0;
		int posicion = -1;
		while (posicion == -1 && contador < integrantes.size()) {
			if (integrantes.get(contador).equals(nombreIntegrante)) {
				posicion = contador;
			}
			contador++;
		}
		return posicion;
	}

	public String obtenerIntegrante(int posicion) {
		return posicion >= 1 ? this.integrantes.get(posicion - 1) : null;
	}

	public String buscarIntegrante(String nombreIntegrante) {
		String nombre = null;
		int posicion = obtenerPosicionIntegrante(nombreIntegrante);
		if (posicion != -1) {
			nombre = integrantes.get(posicion);
		}
		return nombre;
	}

	public String removerIntegrante(String nombreIntegrante) {
		String integrante = this.buscarIntegrante(nombreIntegrante);
		if (integrante != null) {
			this.integrantes.remove(integrante);
		}
		return integrante;

	}

	private void mostrarIntegrantes() {
		for (String s : this.integrantes) {
			System.out.println(s);
		}
		System.out.println("Cantidad de integrantes: " + this.getCantidadIntegrantes());
	}

	public void mostrar() {
		System.out.println("\nGrupo: " + this.nombre);
		this.mostrarIntegrantes();
	}

	public void vaciar() {
		this.integrantes.clear();

	}

}
