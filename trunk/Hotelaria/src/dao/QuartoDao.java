
package dao;

import conexao.BancoMySQL;
import dto.QuartoDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Fernando
 */
public class QuartoDao {
    public void inserir(QuartoDto obj){
        BancoMySQL objBanco = new BancoMySQL();
        
        int numero = obj.getNumero();
        String tipoQuarto = obj.getTipoQuarto();
        String tipoCama = obj.getTipoCama();
        String estadoAtual = obj.getEstadoAtual();
        String descQuarto = obj.getDescQuarto();
        double preco = obj.getPreco();
        
        objBanco.conectar();
        try {
            String sql = "INSERT into quarto(numero, tipoQuarto, tipoCama, estadoAtual, descQuarto, preco) "
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
            
            objPst.setInt(1, numero);
            objPst.setString(2, tipoQuarto);
            objPst.setString(3, tipoCama);
            objPst.setString(4, estadoAtual);
            objPst.setString(5, descQuarto);
            objPst.setDouble(6, preco);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Insert!" + ex.getMessage());
        }
    }
    
    public void alterar(QuartoDto obj){
        BancoMySQL objBanco = new BancoMySQL();
        
        int numero = obj.getNumero();
        String tipoQuarto = obj.getTipoQuarto();
        String tipoCama = obj.getTipoCama();
        String estadoAtual = obj.getEstadoAtual();
        String descQuarto = obj.getDescQuarto();
        double preco = obj.getPreco();     
        
        objBanco.conectar();
        try {
            String sql = "UPDATE quarto SET tipoQuarto=?, tipoCama=?, estadoAtual=?, descQuarto=?, preco=?"
                    + "WHERE numero = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                                    
            objPst.setString(1, tipoQuarto);
            objPst.setString(2, tipoCama);
            objPst.setString(3, estadoAtual);
            objPst.setString(4, descQuarto);
            objPst.setDouble(5, preco);
            objPst.setInt(6, numero);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Alterar!" + ex.getMessage());
        }
    }
    
    public void deletar(QuartoDto obj){
        BancoMySQL objBanco = new BancoMySQL();
        int numero = obj.getNumero();
        
        objBanco.conectar();
        try {
            String sql = "DELETE FROM quarto"
                    + "WHERE numero = ?";
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
            String sql = "SELECT quarto.* FROM quarto WHERE numero = ?";
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

