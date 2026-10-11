/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Jurbano
 */

import vista.VistaMundial;
import modelo.Competidor;

public class ControladorMundial {
    private static final int MAX = 50;
    private Competidor[] competidores = new Competidor[MAX];
    private int cantidad = 0;
    private VistaMundial vista;

    public ControladorMundial(VistaMundial vista) {
        this.vista = vista;
        this.vista.getBtnAgregar().addActionListener(e -> agregar());
        this.vista.getBtnActualizar().addActionListener(e -> actualizarRanking());
        this.vista.getBtnLimpiar().addActionListener(e -> vista.limpiarFormulario());
    }

    private void agregar() {
        if (cantidad == MAX) {
            vista.mostrarMensaje("Se alcanzó el máximo de " + MAX + " competidores.");
            return;
        }
        try {
            String nombre = vista.getNombre().trim();
            String pais = vista.getPais().trim();
            if (nombre.isEmpty() || pais.isEmpty()) {
                vista.mostrarMensaje("Nombre y país son obligatorios.");
                return;
            }
            int edad = Integer.parseInt(vista.getEdad().trim());
            int ranking = Integer.parseInt(vista.getRanking().trim());
            double estatura = Double.parseDouble(vista.getEstatura().trim());
            double peso = Double.parseDouble(vista.getPeso().trim());
            if (edad <= 0 || ranking < 0 || estatura <= 0 || peso <= 0) {
                vista.mostrarMensaje("Los valores numéricos deben ser positivos.");
                return;
            }
            competidores[cantidad] = new Competidor(nombre, edad, pais, ranking, estatura, peso);
            cantidad++;
            refrescar();
            vista.limpiarFormulario();
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Revise los campos numéricos.");
        }
    }

    private void actualizarRanking() {
        int fila = vista.getFilaSeleccionada();
        if (fila < 0) {
            vista.mostrarMensaje("Seleccione un competidor en la tabla.");
            return;
        }
        try {
            int puntos = Integer.parseInt(vista.getPuntos().trim());
            if (puntos < 0) {
                vista.mostrarMensaje("Los puntos no pueden ser negativos.");
                return;
            }
            Competidor c = competidores[fila];
            if (vista.isMedalla()) {
                c.actualizarRanking(puntos, true);
            } else {
                c.actualizarRanking(puntos);
            }
            refrescar();
        } catch (NumberFormatException ex) {
            vista.mostrarMensaje("Ingrese puntos válidos.");
        }
    }

    // Ordenamiento burbuja: mayor ranking primero
    private void ordenar() {
        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad - 1 - i; j++) {
                if (competidores[j].getRanking() < competidores[j + 1].getRanking()) {
                    Competidor aux = competidores[j];
                    competidores[j] = competidores[j + 1];
                    competidores[j + 1] = aux;
                }
            }
        }
    }

    private void refrescar() {
        ordenar();
        vista.cargarTabla(competidores, cantidad);
    }
}