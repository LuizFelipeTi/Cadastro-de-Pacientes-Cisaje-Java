/*
 * Classe responsável por realizar as consultas ao banco de dados.
 * 
 * 
 */
package cisaje.conexao;

import cisaje.entidade.Paciente;
import cisaje.visual.TesteTabela;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author LUIZ FELIPE
 */
public class Consultas {

    private final Connection conect;
    private final Statement st;
    private PreparedStatement pst;
    private ResultSet rs;

    //Construtor da Classe
    public Consultas() throws SQLException {

        this.conect = Conexao.Conectar();//Cria conexão ao ser chamada a classe
        this.st = conect.createStatement();//Cria um createStatement ao ser chamada a classe

    }

    //Método responsável por inserir as informações do cadastro no banco
    public void cadastraPacientes(String municipio, String cat, String situacao, String nome, String sexo, String sisprenatal, String cartaosus, String endereco, String telefone, String mes, String ano, String nasc) {

        //String sql = "";
        try {

            String sql = "insert into  " + municipio + "(CAT, SITUACAO, CLIENTE, SEXO, SISPRENATAL, CARTAOSUS, ENDERECO, TELEFONECELULAR, MES, ANO, DATANASCIMENTO) values ('" + cat + "', '" + situacao + "', '" + nome + "', '" + sexo + "', '" + sisprenatal + "', '" + cartaosus + "', '" + endereco + "', '" + telefone + "', '" + mes + "', '" + ano + "', '" + nasc + "')";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso!");
        } catch (SQLException ex) {

            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alteraEspacoVazioSisprenatal(String municipio) {

        String espaco = "";
        String traco = "-----";

        try {

            String sql = "update " + municipio + " set SISPRENATAL = '" + traco + "' where SISPRENATAL = '" + espaco + "'";
            pst = conect.prepareStatement(sql);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alteraNaoSisPrenatal(String municipio) {
        String traco = "-----";
        String nao = "NÃO CONSTA";

        try {
            String sql = "update " + municipio + " set CARTAOSUS = '" + traco + "' where CARTAOSUS = '" + nao + "'";
            pst = conect.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alteraEspacoVazioCartaoSus(String municipio) {

        String espaco = "";
        String traco = "-----";

        try {
            String sql = "update " + municipio + " set CARTAOSUS = '" + traco + "' where CARTAOSUS = '" + espaco + "'";
            pst = conect.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Lista os pacientes na tabela por ordem de nome
    public List<Paciente> listaPacientes(String municipio) throws SQLException {

        String sql = "SELECT * from " + municipio + " order by ID";

        alteraEspacoVazioSisprenatal(municipio);
        alteraEspacoVazioCartaoSus(municipio);

        List<Paciente> pacientes = new ArrayList<>();
        pst = conect.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {

            Paciente paciente = new Paciente();
            paciente.setId(rs.getInt("ID"));
            paciente.setCat(rs.getString("CAT"));
            paciente.setSituacao(rs.getString("SITUACAO"));
            paciente.setNome(rs.getString("CLIENTE"));
            paciente.setSexo(rs.getString("SEXO"));

            paciente.setSisprenatal(rs.getString("SISPRENATAL"));

            paciente.setCartaoSus(rs.getString("CARTAOSUS"));
            paciente.setEnd(rs.getString("ENDERECO"));
            paciente.setTelefone(rs.getString("TELEFONECELULAR"));
            paciente.setMes(rs.getString("MES"));
            paciente.setAno(rs.getString("ANO"));
            paciente.setNasc(rs.getString("DATANASCIMENTO"));
            pacientes.add(paciente);

        }

        return pacientes;
    }

    //Seleciona todas as informações do paciente de acorso com o Id correspondente
    //(Id capaturado ao selecinar um paciente na tebela)
    public List<Paciente> listaCpf(String municipio, String ch) throws SQLException {
        String sql = "select * from " + municipio + " where ID = '" + ch + "'";

        List<Paciente> pacientes = new ArrayList<>();
        pst = conect.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {

            Paciente paciente = new Paciente();

            paciente.setId(rs.getInt("ID"));
            paciente.setCat(rs.getString("CAT"));
            paciente.setSituacao(rs.getString("SITUACAO"));
            paciente.setNome(rs.getString("CLIENTE"));
            paciente.setSexo(rs.getString("SEXO"));
            paciente.setSisprenatal(rs.getString("SISPRENATAL"));
            paciente.setCartaoSus(rs.getString("CARTAOSUS"));
            paciente.setEnd(rs.getString("ENDERECO"));
            paciente.setTelefone(rs.getString("TELEFONECELULAR"));
            paciente.setMes(rs.getString("MES"));
            paciente.setAno(rs.getString("ANO"));
            paciente.setNasc(rs.getString("DATANASCIMENTO"));
            pacientes.add(paciente);

        }

        return pacientes;
    }

    //Método responsável por alterar um cadastro de um paciente no banco de dados
    public void alteraCadastro(String municipio, String id, String cat, String situacao, String nome, String sexo, String sisprenatal, String cartaosus, String endereco, String telefone, String mes, String ano, String nasc) {

        try {
            String sql = "update " + municipio + " set CAT = ?, SITUACAO = ?, CLIENTE = ?, SEXO = ?, SISPRENATAL = ?, CARTAOSUS = ?, ENDERECO = ?, TELEFONECELULAR = ?, MES = ?, ANO = ?, DATANASCIMENTO = ? where ID = '" + id + "'";
            pst = conect.prepareStatement(sql);

            pst.setString(1, cat);
            pst.setString(2, situacao);
            pst.setString(3, nome);
            pst.setString(4, sexo);
            pst.setString(5, sisprenatal);
            pst.setString(6, cartaosus);
            pst.setString(7, endereco);
            pst.setString(8, telefone);
            pst.setString(9, mes);
            pst.setString(10, ano);
            pst.setString(11, nasc);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");

        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluirLinhasVazias() throws SQLException {
        String espaco = "";
        String sql = "delete from atual_serro where ID > 72";
        pst = conect.prepareStatement(sql);
        pst.execute();

    }

    //Método responsável por excluir um cadastro no banco de dados  
    public void excluirCadastro(String municipio, String id) {

        try {

            String sql = "delete from " + municipio + " where ID = '" + id + "'";
            pst = conect.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Método responsável por retornar o número total de cadastros no banco de dados  
    public int numeroRegistros(String municipio) throws SQLException {

        String sql = "select count(id) as C from " + municipio + "";
        rs = st.executeQuery(sql);
        rs.next();
        return rs.getInt("C");
    }

    public int numeroRegistrosMasc(String municipio) throws SQLException {

        String sqlMasc = "select count(id) as C from " + municipio + " where sexo = 'M'";
        rs = st.executeQuery(sqlMasc);
        rs.next();
        int c = rs.getInt("C");

        return c;
    }

    public int numeroRegistrosFem(String municipio) throws SQLException {

        String sqlFem = "select count(id) as C from " + municipio + " where sexo = 'F'";
        rs = st.executeQuery(sqlFem);
        rs.next();
        int c = rs.getInt("C");

        return c;
    }

    //Método responsável por retornar um valor indicando se o paciente já existe ou é um nvo cadastro. 
    public int verificaCpf(String municipio, String id) throws SQLException {

        List<Paciente> pacientes;
        int reg = 0;

        pacientes = listaPacientes(municipio);//Lista do tipo Paciente é criada.
        reg = numeroRegistros(municipio);

        int count = 0;//Um contador é inicializado
        int count2 = 0;

        for (int i = 0; i < reg; ++i) {//Verifica todos os cadastros no banco de dados
            if ((!id.isEmpty())) {//Se houver uma id ou um cpf existente
                //O contador é incrementado                 
                count++;
            }
        }
        return count;//Retorna o valor do contador.
    }

    public int verificaCpfExistente(String municipio, String id, String sisprenatal) throws SQLException {
        List<Paciente> pacientes = null;
        int reg = 0;

        pacientes = listaPacientes(municipio);
        reg = numeroRegistros(municipio);

        int count = 0;
        int count2 = 0;

        if (!id.isEmpty()) {

            for (int i = 0; i < reg; ++i) {

                if ((pacientes.get(i).getId() != Integer.parseInt(id)) && (sisprenatal.equals(pacientes.get(i).getSisprenatal()))) {
                    count++;
                }
            }
            return count;

        } else {

            for (int i = 0; i < reg; ++i) {

                if (sisprenatal.equals(pacientes.get(i).getSisprenatal())) {
                    count2++;
                }

            }

            return count2;
        }

    }

    public int verificaSusExistente(String municipio, String id, String cartaosus) throws SQLException {
        List<Paciente> pacientes = null;
        int reg = 0;

        pacientes = listaPacientes(municipio);
        reg = numeroRegistros(municipio);

        int count = 0;
        int count2 = 0;

        if (!id.isEmpty()) {
            for (int i = 0; i < reg; ++i) {

                if ((pacientes.get(i).getId() != Integer.parseInt(id)) && (cartaosus.equals(pacientes.get(i).getCartaoSus()))) {
                    count++;
                }
            }
            return count;
        } else {
            for (int i = 0; i < reg; ++i) {

                if (cartaosus.equals(pacientes.get(i).getCartaoSus())) {
                    count2++;
                }

            }
            return count2;
        }
    }

    public List<Paciente> filtraPesquisa(String municipio, String nome) throws SQLException {

        String sql = "select * from " + municipio + " where CLIENTE like '%" + nome + "%' order by ID";
        List<Paciente> pacientes = new ArrayList<>();
        pst = conect.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {

            Paciente paciente = new Paciente();
            paciente.setId(rs.getInt("ID"));
            paciente.setCat(rs.getString("CAT"));
            paciente.setSituacao(rs.getString("SITUACAO"));
            paciente.setNome(rs.getString("CLIENTE"));
            paciente.setSexo(rs.getString("SEXO"));
            paciente.setSisprenatal(rs.getString("SISPRENATAL"));
            paciente.setCartaoSus(rs.getString("CARTAOSUS"));
            paciente.setEnd(rs.getString("ENDERECO"));
            paciente.setTelefone(rs.getString("TELEFONECELULAR"));
            paciente.setMes(rs.getString("MES"));
            paciente.setAno(rs.getString("ANO"));
            paciente.setNasc(rs.getString("DATANASCIMENTO"));
            pacientes.add(paciente);

        }

        return pacientes;

    }

    public List<Paciente> filtraPesquisaSexo(String municipio, String sexo) throws SQLException {

        String sql = "select * from " + municipio + " where SEXO like '%" + sexo + "%' order by ID";
        List<Paciente> pacientes = new ArrayList<>();
        pst = conect.prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {

            Paciente paciente = new Paciente();
            paciente.setId(rs.getInt("ID"));
            paciente.setCat(rs.getString("CAT"));
            paciente.setSituacao(rs.getString("SITUACAO"));
            paciente.setNome(rs.getString("CLIENTE"));
            paciente.setSexo(rs.getString("SEXO"));
            paciente.setSisprenatal(rs.getString("SISPRENATAL"));
            paciente.setCartaoSus(rs.getString("CARTAOSUS"));
            paciente.setEnd(rs.getString("ENDERECO"));
            paciente.setTelefone(rs.getString("TELEFONECELULAR"));
            paciente.setMes(rs.getString("MES"));
            paciente.setAno(rs.getString("ANO"));
            paciente.setNasc(rs.getString("DATANASCIMENTO"));
            pacientes.add(paciente);

        }

        return pacientes;

    }

    //Método que exibe a tabela com a lista de pacientes atualizada.
    public void AtualizaTabela() throws SQLException {

        JTable jt = new JTable();
        jt.setModel(new TesteTabela());

    }

}
