/*
 * Esta classe representa as características de endereço 
 * do objeto paciente.
 * 
 * 
 */
package cisaje.entidade;

/**
 *
 * @author LUIZ FELIPE
 */
public class Endereco {

    private String rua;
    private int numero;
    private String bairro;

    //Getters e Setters
    //Responsáveis pela inserçao e captura de valores 
    //para cada propriedade
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

}
