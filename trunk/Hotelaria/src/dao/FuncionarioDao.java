
package dao;

import conexao.BancoMySQL;
import dto.FuncionarioDto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Fernando
 */
public class FuncionarioDao {
    public void inserir(FuncionarioDto obj){
        BancoMySQL objBanco = new BancoMySQL();
        
        String nome = obj.getNome();
        String cpf = obj.getCpf();
        double salario = obj.getSalario();
        
        objBanco.conectar();
        try {
            String sql = "INSERT into funcionario(nome, cpf, salario) "
                    + "VALUES(?,?,?)";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
            
            objPst.setString(1, nome);
            objPst.setString(2, cpf);
            objPst.setDouble(3, salario);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Insert!" + ex.getMessage());
        }
    }
    
    public void alterar(FuncionarioDto obj){
        BancoMySQL objBanco = new BancoMySQL();
        
        String nome = obj.getNome();
        String cpf = obj.getCpf();
        double salario = obj.getSalario();
        
        objBanco.conectar();
        try {
            String sql = "UPDATE funcionario SET nome=?, salario=?"
                    + "WHERE cpf = ?";
            PreparedStatement objPst = objBanco.conexao.prepareStatement(sql);
                        
            objPst.setString(1, nome);
            objPst.setDouble(2, salario);
            objPst.setString(6, cpf);
            
            objPst.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na execução do Alterar!" + ex.getMessage());
        }
    }
    
    public void deletar(FuncionarioDto obj){
        BancoMySQL objBanco = new BancoMySQL();
        String cpf = obj.getCpf();
        
        objBanco.conectar();
        try {
            String sql = "DELETE FROM funcionario"
                    + "WHERE cpf = ?";
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
            String sql = "SELECT funcionario.* FROM funcionario WHERE nome like ? or cpf = ?";
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
