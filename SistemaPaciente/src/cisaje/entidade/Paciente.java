/*
 * Esta classe representa as características do objeto Paciente
 * 
 * 
 */
package cisaje.entidade;

/**
 *
 * @author LUIZ FELIPE
 */
public class Paciente {

    private int id;
    private String cat;
    private String situacao;
    private String nome;
    private String sexo;
    private String sisprenatal;
    private String cartaoSus;
    private String telefone;
    private String mes;
    private String ano;
    private String nasc;
    private String end;

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    //Propriedades relacionadas às informações de endereço
    //(Classe Endereço)
    public Endereco endereco = new Endereco();

    //Getters e Setters
    //Responsáveis pela inserçao e captura de valores 
    //para cada propriedade
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSisprenatal() {
        return sisprenatal;
    }

    public void setSisprenatal(String sisprenatal) {
        this.sisprenatal = sisprenatal;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    //Função da Classe Object é reestruturada internamente (Polimorfismo) para imprimir as informações do Paciente
    @Override
    public String toString() {
        return "Id: " + getId() + "\nCat: " + getCat() + "\nSituação: " + getSituacao() + "\nNome: " + getNome() + "\n SisPrenatal: " + getSisprenatal() + "\n CartãoSUS: " + getCartaoSus() + "\n Endereço: " + getEnd() + "\n Telefone/Celular: " + getTelefone() + "\n Mês: " + getMes() + "\n Ano: " + getAno() + "\n Data de nascimento: " + getNasc();
    }

}
