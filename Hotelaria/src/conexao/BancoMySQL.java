package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Fernando
 */
public class BancoMySQL {
    String URL = "jdbc:mysql://127.0.0.1:3306/hotel";
    String usuario = "root";
    String senha = "";
    public Connection conexao = null;
    
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexao = DriverManager.getConnection(URL, usuario, senha);
        } catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Problema no momento de carregar o Driver do Banco!");
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Problema ao se conectar no Banco!");
        }
    }
    
    public void desconectar() {
        try{
            this.conexao.close();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Problema ao fechar à conexão!");
        }
    }
    
    public void executarComando(String sql){
        try{
            Statement objStm = conexao.createStatement();
            objStm.execute(sql);
            JOptionPane.showMessageDialog(null, "Comando executado com sucesso!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao executar o comando!" + ex.getMessage());
        }
    } 
    
     public ResultSet executarConsulta(String sql){
        try{
            Statement objStm = conexao.createStatement();
            ResultSet objRs = objStm.executeQuery(sql);
            JOptionPane.showMessageDialog(null, "Comando executado com sucesso!");
            return objRs;
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao executar o comando!" + ex.getMessage());
        }
        return null;
    } 
}
