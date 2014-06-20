
package hotelaria.model;

import hotelaria.conexao.BancoMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Fernando
 */
public class ReservaQuartoModel {
     
    public void inserir(ReservaQuarto obj){
        //Objeto Banco.
        BancoMySQL objBanco = new BancoMySQL();
        
        //Os valores dos atributos nas variáveis que serão criadas... 
        int numero = obj.getNumero();
        int dias = obj.getDias();
        double preco = obj.getPreco();
        String nome = obj.getNome();
        String tipoQuarto = obj.getTipoQuarto();
        String tipoCama = obj.getTipoCama();     
        
        objBanco.conectar();
        try {
            String sql = "INSERT into reservaQuarto(numero, dias, preco, nome, tipoQuarto, tipoCama) "
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                        
            objPst.setInt(1, numero);
            objPst.setInt(2, dias);
            objPst.setDouble(3, preco);
            objPst.setString(4, nome);
            objPst.setString(5, tipoQuarto);
            objPst.setString(6, tipoCama);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Insert!" + ex.getMessage());
        }
    }
    
    public void alterar(ReservaQuarto obj){
        BancoMySQL objBanco = new BancoMySQL();
        
        int numero = obj.getNumero();
        int dias = obj.getDias();
        double preco = obj.getPreco();
        String nome = obj.getNome();
        String tipoQuarto = obj.getTipoQuarto();
        String tipoCama = obj.getTipoCama(); 
        
        objBanco.conectar();
        try {
            String sql = "UPDATE reservaQuarto SET dias=?, preco=?, nome=?, tipoQuarto=?, tipoCama=?"
                    + " WHERE numero = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                                    
            objPst.setInt(1, dias);
            objPst.setDouble(2, preco);
            objPst.setString(3, nome);
            objPst.setString(4, tipoQuarto);
            objPst.setString(5, tipoCama);
            objPst.setInt(6, numero);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Alterar!" + ex.getMessage());
        }
    }
 
    public void deletar(ReservaQuarto obj){
        BancoMySQL objBanco = new BancoMySQL();
        int numero = obj.getNumero();
        
        objBanco.conectar();
        try {
            String sql = "DELETE FROM reservaQuarto"
                    + " WHERE numero = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                        
            objPst.setInt(1, numero);
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Deletar!" + ex.getMessage());
        }
    }
    
    public ResultSet selecionar(String text){
        BancoMySQL objBanco = new BancoMySQL();               
        objBanco.conectar();
        
        try {
            String sql = "SELECT reservaQuarto.* FROM reservaQuarto WHERE numero = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
            
            objPst.setString(1, text);
            
            ResultSet objRst = objPst.executeQuery();
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Consultar!" + ex.getMessage());
          }
    return null;    
    }
}
