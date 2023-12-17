
package dominio;

import java.util.Arrays;
import java.util.List;


public class Comida {
    
    
    // VARIABLES
    
    private int idDieta;
    private int idAlimento;
    private double cantidad;  //se expresara en gramos o en litros
    private String timing;
    public static final List<String> TIMINGS = Arrays.asList("desayuno","almuerzo","comida","merienda","cena");
    
    
    // CONSTRUCTORES

    public Comida() {
    }

    public Comida(int idDieta) {
        this.idDieta = idDieta;
    }
    
    public Comida(int idAlimento, double cantidad, String timing) {
        this.idAlimento = idAlimento;
        this.cantidad = cantidad;
        this.timing = timing;
    }

    public Comida(int idDieta, int idAlimento, double cantidad, String timing) {
        this.idDieta = idDieta;
        this.idAlimento = idAlimento;
        this.cantidad = cantidad;
        this.timing = timing;
    }
    
    
    // GETTER & SETTING

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public int getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
    
    
    //TO STRING

    @Override
    public String toString() {
        return "Comida{" + "idDieta=" + idDieta + ", idAlimento=" + idAlimento + ", cantidad=" + cantidad + ", timing=" + timing + '}';
    }
    
    
}
