
package datos;

import dominio.Alimento;
import dominio.Comida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DietaDaoJDBC {
    // AGREGAMOS LAS SENTENCIAS SQL QUE SE VAN A UTILIZAR
    private static final String SQL_SELECT = "SELECT * FROM dieta";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM dieta WHERE id_dieta = ?";
    private static final String SQL_INSERT = "INSERT INTO dieta(id_alimento, cantidad, timing) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE dieta SET id_alimento=?, cantidad=?, timing=? WHERE id_dieta=?";
    private static final String SQL_DELETE = "DELETE FROM dieta WHERE id_dieta=?";
    private static final String SQL_DELETE_FOR_DELETE_ALIMENTO = "DELETE FROM dieta WHERE id_alimento=?";


    public List<Comida> listarDieta(String timingComida){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Comida comida = null;
        List<Comida> dieta = new ArrayList<>();
        
        try {
            conn = ConexionDieta.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()){
                int id_dieta = rs.getInt("id_dieta");
                int id_alimento = rs.getInt("id_alimento");
                double cantidad = rs.getDouble("cantidad");
                String timing = rs.getString("timing");
                
                
                comida = new Comida(id_dieta, id_alimento, cantidad, timing);
                if (timingComida.equals(timing)) {
                    dieta.add(comida); 
                }
                
                             
            }
        } 
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
        finally {
            ConexionDieta.close(conn);
            ConexionDieta.close(stmt);
            ConexionDieta.close(rs);            
        }
        
        return dieta;
    }
    
    public Comida encontrarComida (Comida comida){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionDieta.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setInt(1, comida.getIdDieta());
            rs = stmt.executeQuery();
            rs.absolute(1);
            
            int idAlimento = rs.getInt("id_alimento");
            double cantidad = rs.getDouble("cantidad");
            String timing = rs.getString("timing");
            
            comida.setIdAlimento(idAlimento);
            comida.setCantidad(cantidad);
            comida.setTiming(timing);
            
        } 
        catch (Exception e) {
            e.printStackTrace(System.out);
        } 
        finally {
            ConexionDieta.close(conn);
            ConexionDieta.close(stmt);
            ConexionDieta.close(rs);
        }
        
        return comida;
    }
    
    public int insertarAlimentoADieta(Comida comida){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionDieta.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, comida.getIdAlimento());
            stmt.setDouble(2, comida.getCantidad());
            stmt.setString(3, comida.getTiming());
            
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
    
    public int actualizar(Comida comida){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionDieta.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, comida.getIdAlimento());
            stmt.setDouble(2, comida.getCantidad());
            stmt.setString(3, comida.getTiming());
            stmt.setInt(4, comida.getIdDieta());
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
    
    public int eliminar(Comida comida){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionDieta.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, comida.getIdDieta());
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
    
    public int eliminarPorEliminarAlimento(Alimento alimento){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionDieta.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE_FOR_DELETE_ALIMENTO);
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
}
