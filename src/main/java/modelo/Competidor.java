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
    private int ranking;
    private double estatura;
    private double peso;

    public Competidor(String nombre, int ranking, String pais, int edad, double estatura, double peso) {
        super(nombre, edad, pais);
        this.ranking = ranking;
        this.estatura = estatura;
        this.peso = peso;
    }
    
    //getters

    public int getRanking() {
        return ranking;
    }

    public double getEstatura() {
        return estatura;
    }

    public double getPeso() {
        return peso;
    }
    
    // Overload para puntos sin medalla
    public void actualizarRanking(int puntosObtenidos){
        ranking += puntosObtenidos;
    }
    
    // Overload para puntos CON bonificación (medalla)
    public void actualizarRanking(int puntosObtenidos, boolean ganoMedalla){
        int bonus;
        
        if (ganoMedalla){
            if(puntosObtenidos >= 100){
                bonus = 50;
            }else { bonus = 20; }
        }else { bonus = 0; }
        
        ranking += puntosObtenidos + bonus;
    }
    
    
    @Override
    public String toString(){
        return super.toString()+", Ranking: "+ranking+", Estatura: "+estatura+", Peso: "+peso+"kg";
    }
}
