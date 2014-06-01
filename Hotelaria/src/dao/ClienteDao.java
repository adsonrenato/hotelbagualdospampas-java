
package dao;

import conexao.BancoMySQL;
import dto.ClienteDto;
import java.sql.PreparedStatement;
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
    
    public void alterar(){
        
    }
    
    public void deletar(){
        
    }
    
    public void selecionar(){
        
    }
}
