package dominio;

public class AlimentoComida {

    // VARIABLES
    private int idDieta;
    private int idAlimento;
    private String nombre;
    private double cantidad;  //se expresara en gramos o en litros
    private double totalGrasas;
    private double totalCarbohidratos;
    private double totalProteinas;
    private double totalKcal;
    private String timing;
    
    // CONSTRUCTOR

    public AlimentoComida(int idDieta, int idAlimento, String nombre, double cantidad, double totalGrasas, double totalCarbohidratos, double totalProteinas, double totalKcal, String timing) {
        this.idDieta = idDieta;
        this.idAlimento = idAlimento;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.totalGrasas = totalGrasas;
        this.totalCarbohidratos = totalCarbohidratos;
        this.totalProteinas = totalProteinas;
        this.totalKcal = totalKcal;
        this.timing = timing;
    }
    
    public AlimentoComida(Comida comida, Alimento alimento){
        this.idDieta = comida.getIdDieta();
        this.idAlimento = alimento.getIdAlimento();
        this.nombre = alimento.getNombre();
        this.cantidad = comida.getCantidad();
        this.totalGrasas = alimento.getGrasas();
        this.totalCarbohidratos = alimento.getCarbohidratos();
        this.totalProteinas = alimento.getProteinas();
        this.totalKcal = alimento.getKcal();
        this.timing = comida.getTiming();
    }
    
    
    // SETTER & GETTER

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalGrasas() {
        return totalGrasas;
    }

    public void setTotalGrasas(double totalGrasas) {
        this.totalGrasas = totalGrasas;
    }

    public double getTotalCarbohidratos() {
        return totalCarbohidratos;
    }

    public void setTotalCarbohidratos(double totalCarbohidratos) {
        this.totalCarbohidratos = totalCarbohidratos;
    }

    public double getTotalProteinas() {
        return totalProteinas;
    }

    public void setTotalProteinas(double totalProteinas) {
        this.totalProteinas = totalProteinas;
    }

    public double getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(double totalKcal) {
        this.totalKcal = totalKcal;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
    
    
    // TO STRING

    @Override
    public String toString() {
        return "AlimentoComida{" + "idDieta=" + idDieta + ", idAlimento=" + idAlimento + ", nombre=" + nombre + ", cantidad=" + cantidad + ", totalGrasas=" + totalGrasas + ", totalCarbohidratos=" + totalCarbohidratos + ", totalProteinas=" + totalProteinas + ", totalKcal=" + totalKcal + ", timing=" + timing + '}';
    }
    
    
}
