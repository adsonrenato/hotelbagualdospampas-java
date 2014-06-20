
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
public class ClienteModel {
    
    public void inserir(Cliente obj){
        //Objeto Banco.
        BancoMySQL objBanco = new BancoMySQL();
        
        //Os valores dos atributos nas variáveis que serão criadas... 
        String nome = obj.getNome();
        String cpf = obj.getCpf();
        String email = obj.getEmail();
        String telefone = obj.getTelefone();
        String endereco = obj.getEndereco();
        String cidade = obj.getCidade();     
        
        objBanco.conectar();
        try {
            String sql = "INSERT into cliente(nome, cpf, email, telefone, endereco, cidade) "
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                        
            objPst.setString(1, nome);
            objPst.setString(2, cpf);
            objPst.setString(3, email);
            objPst.setString(4, telefone);
            objPst.setString(5, endereco);
            objPst.setString(6, cidade);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Insert!" + ex.getMessage());
        }
    }
    
    public void alterar(Cliente obj){
        BancoMySQL objBanco = new BancoMySQL();
        
        String nome = obj.getNome();
        String cpf = obj.getCpf();
        String email = obj.getEmail();
        String telefone = obj.getTelefone();
        String endereco = obj.getEndereco();
        String cidade = obj.getCidade();     
        
        objBanco.conectar();
        try {
            String sql = "UPDATE cliente SET nome=?, email=?, telefone=?, endereco=?, cidade=?"
                    + " WHERE cpf = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                        
            objPst.setString(1, nome);
            objPst.setString(2, email);
            objPst.setString(3, telefone);
            objPst.setString(4, endereco);
            objPst.setString(5, cidade);
            objPst.setString(6, cpf);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Alterar!" + ex.getMessage());
        }
    }
 
    public void deletar(Cliente obj){
        BancoMySQL objBanco = new BancoMySQL();
        String cpf = obj.getCpf();
        
        objBanco.conectar();
        try {
            String sql = "DELETE FROM cliente"
                    + " WHERE cpf = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                        
            objPst.setString(1, cpf);
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Deletar!" + ex.getMessage());
        }
    }
    
    public ResultSet selecionar(String text){
        BancoMySQL objBanco = new BancoMySQL();               
        objBanco.conectar();
        
        try {
            String sql = "SELECT cliente.* FROM cliente WHERE nome like ? or cpf = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
            
            objPst.setString(1, "%"+text+"%");
            objPst.setString(2, text);
            
            ResultSet objRst = objPst.executeQuery();
            return objRst;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Consultar!" + ex.getMessage());
          }
    return null;    
    }
}