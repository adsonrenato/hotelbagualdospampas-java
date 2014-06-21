
package hotelaria.model;

/**
 *
 * @author Luis Fernando
 */
public class ReservaQuarto {
    private String numero;
    private int dias;
    private double preco;
    private String nome;
    private String tipoQuarto;
    private String tipoCama;

    //Métodos get.
    public String getNumero() {
        return numero;
    }

    public int getDias() {
        return dias;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    //Métodos set.
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }
}
