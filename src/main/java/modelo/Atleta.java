/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jurbano
 */
public class Atleta {
    private String nombre;
    private int edad;
    private String pais;

    public Atleta(String nombre, int edad, String pais) {
        this.nombre = nombre;
        this.edad = edad;
        this.pais = pais;
    }
    
    //getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getPais() {
        return pais;
    }

    
    @Override
    public String toString(){
        return "Nombre: "+nombre+", Edad: "+edad+", Pais: "+pais;
    }
    
}
