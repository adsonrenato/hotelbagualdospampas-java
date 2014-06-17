
package dto;

/**
 *
 * @author Luis Fernando
 */
public class QuartoDto {
    private int numero;
    private String tipoQuarto;
    private String tipoCama;
    private String estadoAtual;   
    private String descQuarto;
    private double preco;

    //Métodos get.
    public int getNumero() {
        return numero;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public String getEstadoAtual() {
        return estadoAtual;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public String getDescQuarto() {
        return descQuarto;
    }

    public double getPreco() {
        return preco;
    }
    
}
