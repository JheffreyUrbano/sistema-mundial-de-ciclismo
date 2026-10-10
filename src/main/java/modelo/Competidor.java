/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Jurbano
 */
public class Competidor extends Atleta {
    private String ranking;
    private double estatura;
    private double peso;

    public Competidor(String ranking, double estatura, double peso, String nombre, int edad, String pais) {
        super(nombre, edad, pais);
        this.ranking = ranking;
        this.estatura = estatura;
        this.peso = peso;
    }
    
    //getters

    public String getRanking() {
        return ranking;
    }

    public double getEstatura() {
        return estatura;
    }

    public double getPeso() {
        return peso;
    }
    
    @Override
    public String toString(){
        return super.toString()+", Ranking: "+ranking+", Estatura: "+estatura+", Peso: "+peso+"kg";
    }
}
