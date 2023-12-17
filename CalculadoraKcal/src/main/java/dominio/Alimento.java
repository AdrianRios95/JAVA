package dominio;

public class Alimento {

    // VARIABLES
    private int idAlimento;
    private String nombre;
    private double grasas;
    private double carbohidratos;
    private double proteinas;
    private double kcal;
    private boolean porcion;

    // CONSTRUCTORES
    public Alimento() {
    }

    public Alimento(int idAlimento) {
        this.idAlimento = idAlimento;
    }

    public Alimento(String nombre, double grasas, double carbohidratos, double proteinas, double kcal, boolean porcion) {
        this.nombre = nombre;
        this.grasas = grasas;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.kcal = kcal;
        this.porcion = porcion;
    }

    public Alimento(int idAlimento, String nombre, double grasas, double carbohidratos, double proteinas, double kcal, boolean porcion) {
        this.idAlimento = idAlimento;
        this.nombre = nombre;
        this.grasas = grasas;
        this.carbohidratos = carbohidratos;
        this.proteinas = proteinas;
        this.kcal = kcal;
        this.porcion = porcion;
    }

    // GETTER & SETTER
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

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public boolean getPorcion() {
        return porcion;
    }

    public void setPorcion(boolean porcion) {
        this.porcion = porcion;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Alimento{" + "idAlimento=" + idAlimento + ", nombre=" + nombre + ", grasas=" + grasas + ", carbohidratos=" + carbohidratos + ", proteinas=" + proteinas + ", kcal=" + kcal + ", porcion=" + porcion + '}';
    }

}
