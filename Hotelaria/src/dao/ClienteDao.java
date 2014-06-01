
package dao;

import conexao.BancoMySQL;
import dto.ClienteDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Fernando
 */
public class ClienteDao {
    
    public void inserir(ClienteDto obj){
        BancoMySQL objBanco = new BancoMySQL();
        
        Integer id = obj.getId();
        String nome = obj.getNome();
        String cpf = obj.getCpf();
        String email = obj.getEmail();
        String telefone = obj.getTelefone();
        String endereco = obj.getEndereco();
        String cidade = obj.getCidade();     
        
        objBanco.conectar();
        try {
            String sql = "INSERT into cliente(id, nome, cpf, email, telefone, endereco, cidade) "
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
            
            objPst.setInt(1, id);
            objPst.setString(2, nome);
            objPst.setString(3, cpf);
            objPst.setString(4, email);
            objPst.setString(5, telefone);
            objPst.setString(6, endereco);
            objPst.setString(7, cidade);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Insert!" + ex.getMessage());
        }
    }
    
    public void alterar(ClienteDto obj){
        BancoMySQL objBanco = new BancoMySQL();
        
        Integer id = obj.getId();
        String nome = obj.getNome();
        String cpf = obj.getCpf();
        String email = obj.getEmail();
        String telefone = obj.getTelefone();
        String endereco = obj.getEndereco();
        String cidade = obj.getCidade();     
        
        objBanco.conectar();
        try {
            String sql = "UPDATE cliente SET nome=?, cpf=?, email=?, telefone=?, endereco=?, cidade=?"
                    + "WHERE id = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                        
            objPst.setString(1, nome);
            objPst.setString(2, cpf);
            objPst.setString(3, email);
            objPst.setString(4, telefone);
            objPst.setString(5, endereco);
            objPst.setString(6, cidade);
            objPst.setInt(7, id);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Alterar!" + ex.getMessage());
        }
    }
    
    public void deletar(ClienteDto obj){
        BancoMySQL objBanco = new BancoMySQL();
        Integer id = obj.getId();
        
        objBanco.conectar();
        try {
            String sql = "DELETE FROM cliente"
                    + "WHERE id = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                        
            objPst.setInt(1, id);
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Deletar!" + ex.getMessage());
        }
    }
    
    public ResultSet selecionar(){
        BancoMySQL objBanco = new BancoMySQL();               
        objBanco.conectar();
        
        try {
            String sql = "SELECT cliente.* FROM cliente";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);

            ResultSet objRst = objPst.executeQuery();
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Deletar!" + ex.getMessage());
          }
    return null;    
    }
}
