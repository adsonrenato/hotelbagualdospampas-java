
package hotelaria.model;

/**
 *
 * @author Luis Fernando
 */
public class Quarto {
    private String numero;
    private String tipoQuarto;
    private String tipoCama;
    private String estadoAtual;   
    private String descQuarto;
    private double preco;

    //Métodos get.
    public String getNumero() {
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

    //Métodos set.
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

    public void setEstadoAtual(String estadoAtual) {
        this.estadoAtual = estadoAtual;
    }

    public void setDescQuarto(String descQuarto) {
        this.descQuarto = descQuarto;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
