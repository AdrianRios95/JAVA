package datos;

import dominio.Alimento;
import dominio.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlimentosDaoJDBC {

    // AGREGAMOS LAS SENTENCIAS SQL QUE SE VAN A UTILIZAR
    private static final String SQL_SELECT = "SELECT * FROM alimentos";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM alimentos WHERE id_alimento = ?";
    private static final String SQL_INSERT = "INSERT INTO alimentos(nombre, grasas, carbohidratos, proteinas, kcal, porcion) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE alimentos SET nombre=?, grasas=?, carbohidratos=?, proteinas=?, kcal=?, porcion=? WHERE id_alimento=?";
    private static final String SQL_DELETE = "DELETE FROM alimentos WHERE id_alimento=?";

    public List<Alimento> listarAlimentos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alimento alimento = null;
        List<Alimento> alimentos = new ArrayList<>();

        try {
            conn = ConexionAlimentos.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idAlimento = rs.getInt("id_alimento");
                String nombre = rs.getString("nombre");
                double grasas = rs.getDouble("grasas");
                double carbohidratos = rs.getDouble("carbohidratos");
                double proteinas = rs.getDouble("proteinas");
                double kcal = rs.getDouble("kcal");
                /* los boolean en my sql se almacenana como tinyint, 0=false y 1=true, por eso para recuperarlo
                primero recuperamos el int y se hace una condicion, y asi regresara un true o un false */
                boolean porcion = (rs.getInt("porcion") == 1);

                alimento = new Alimento(idAlimento, nombre, grasas, carbohidratos, proteinas, kcal, porcion);
                alimentos.add(alimento);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            ConexionAlimentos.close(conn);
            ConexionAlimentos.close(stmt);
            ConexionAlimentos.close(rs);
        }

        return alimentos;
    }

    public Alimento encontrar(Comida comida) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alimento alimento = null;

        try {
            conn = ConexionAlimentos.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1, comida.getIdAlimento());
            rs = stmt.executeQuery();
            rs.absolute(1);

            int idAlimento = rs.getInt("id_alimento");
            String nombre = rs.getString("nombre");
            double grasas = rs.getDouble("grasas");
            double carbohidratos = rs.getDouble("carbohidratos");
            double proteinas = rs.getDouble("proteinas");
            double kcal = rs.getDouble("kcal");
            boolean porcion = (rs.getInt("porcion") == 1);

            alimento = new Alimento(idAlimento, nombre, grasas, carbohidratos, proteinas, kcal, porcion);
            

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            ConexionAlimentos.close(conn);
            ConexionAlimentos.close(stmt);
            ConexionAlimentos.close(rs);
        }

        return alimento;
    }
    
    public Alimento encontrar(Alimento alimento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConexionAlimentos.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1, alimento.getIdAlimento());
            rs = stmt.executeQuery();
            rs.absolute(1);

            int idAlimento = rs.getInt("id_alimento");
            String nombre = rs.getString("nombre");
            double grasas = rs.getDouble("grasas");
            double carbohidratos = rs.getDouble("carbohidratos");
            double proteinas = rs.getDouble("proteinas");
            double kcal = rs.getDouble("kcal");
            boolean porcion = (rs.getInt("porcion") == 1);

            alimento = new Alimento(idAlimento, nombre, grasas, carbohidratos, proteinas, kcal, porcion);
            

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            ConexionAlimentos.close(conn);
            ConexionAlimentos.close(stmt);
            ConexionAlimentos.close(rs);
        }

        return alimento;
    }
    
    public int actualizar(Alimento alimento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionAlimentos.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alimento.getNombre());
            stmt.setDouble(2, alimento.getGrasas());
            stmt.setDouble(3, alimento.getCarbohidratos());
            stmt.setDouble(4, alimento.getProteinas());
            stmt.setDouble(5, alimento.getKcal());
            stmt.setBoolean(6, alimento.getPorcion());
            stmt.setInt(7, alimento.getIdAlimento());
            
            rows = stmt.executeUpdate();
            
        } 
        catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        finally {
            ConexionDieta.close(conn);
            ConexionDieta.close(stmt);
        }
        
        return rows;
    }
    
    public int eliminar(Alimento alimento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionAlimentos.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alimento.getIdAlimento());
            rows = stmt.executeUpdate();
            
        } 
        catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        finally {
            ConexionDieta.close(conn);
            ConexionDieta.close(stmt);
        }
        
        return rows;
    }
    
    public int insertarAlimento(Alimento alimento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionAlimentos.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alimento.getNombre());
            stmt.setDouble(2, alimento.getGrasas());
            stmt.setDouble(3, alimento.getCarbohidratos());
            stmt.setDouble(4, alimento.getProteinas());
            stmt.setDouble(5, alimento.getKcal());
            stmt.setBoolean(6, alimento.getPorcion());
            
            rows = stmt.executeUpdate();
            
        } 
        catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        finally {
            ConexionAlimentos.close(conn);
            ConexionAlimentos.close(stmt);
        }
        
        return rows;
    }
}
