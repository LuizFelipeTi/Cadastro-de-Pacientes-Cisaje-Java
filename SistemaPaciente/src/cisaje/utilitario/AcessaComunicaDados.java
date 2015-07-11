/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisaje.utilitario;

import cisaje.entidade.Paciente;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Classe auxiliar ao JFrame Hiperdia com métodos responsáveis pelo e acesso e
 * comunicação de dados
 *
 * @author LUIZ FELIPE
 */
public class AcessaComunicaDados {

    // Método responsável por setar os dados do paciente selecionado em uma lista
    public void recebe(List<Paciente> dados, JTextField id, JTextField cat, JTextField situacao, JTextField nome, ButtonGroup grupoBotoes, JRadioButton jrMasc, JRadioButton jrFem, JTextField sisPrenatal, JTextField cartaoSus, JTextField endereco, JTextField telefone, JComboBox listaMes, JSpinner spAno, JTextField nasc) {

        id.setText(Integer.toString(dados.get(0).getId())); // Seta id do paciente
        cat.setText(dados.get(0).getCat()); // Seta CAT do paciente
        situacao.setText(dados.get(0).getSituacao()); // Seta Situação do paciente
        nome.setText(dados.get(0).getNome()); // Seta Nome do paciente

        if (dados.get(0).getSexo().equals("M")) { // Se o Sexo setado for igual a "M"

            grupoBotoes.setSelected(jrMasc.getModel(), true); // O botão do sexo Masculino é selecionado
        }

        if (dados.get(0).getSexo().endsWith("F")) { // Se o Sexo setado for igual a "F"
            grupoBotoes.setSelected(jrFem.getModel(), true); // O botão do sexo Feminino é selecionado
        }
        sisPrenatal.setText(dados.get(0).getSisprenatal()); // Seta o SISPrenatal do paciente
        cartaoSus.setText(dados.get(0).getCartaoSus()); // Seta o cartão SUS do paciente
        endereco.setText(dados.get(0).getEnd()); // Seta o Endereço do paciente
        telefone.setText(dados.get(0).getTelefone()); // Seta o Telefone do paciente
        listaMes.setSelectedItem(dados.get(0).getMes()); // Seta o Mês do paciente
        spAno.setValue(Long.parseLong(dados.get(0).getAno())); // Seta o Ano do paciente
        nasc.setText(dados.get(0).getNasc()); // Seta a Data de Nascimento do paciente
    }

    // Método responsável por setar a alteração do paciente feita da tabela
    public void setaAlteracaoTabela(JTable tabela, String nome, String sisPrenatal, String cartaoSus, JComboBox mes, JSpinner ano) {

        int linha_selecionada = tabela.getSelectedRow(); // Variável recebe linha selecionada
        tabela.setValueAt(nome, linha_selecionada, 0); // O nome alterado é inserido na coluna Nome

        if (sisPrenatal.isEmpty()) {
            tabela.setValueAt("-----", linha_selecionada, 1); // O número de SISPrenatal alterado é inserido na coluna SISPrenatal 
        } else {
            tabela.setValueAt(sisPrenatal, linha_selecionada, 1); // O número de SISPrenatal alterado é inserido na coluna SISPrenatal
        }
        if (cartaoSus.isEmpty()) {
            tabela.setValueAt("-----", linha_selecionada, 2); // O número de SISPrenatal alterado é inserido na coluna SISPrenatal 
        } else {
            tabela.setValueAt(cartaoSus, linha_selecionada, 2); // O número de Cartão SUS alterado é inserido na coluna Cartão SUS
        }
        tabela.setValueAt(mes.getSelectedItem(), linha_selecionada, 3); // O mês alterado é inserido na coluna Mês
        tabela.setValueAt(ano.getValue(), linha_selecionada, 4); // O ano alterado é inserido na coluna Ano

    }

//    public void selecionaPaciente(Consultas consulta, String municipio, JTable tabela, JTextField id, JTextField cat, JTextField situacao, JTextField nome, ButtonGroup grupoBotoes, JRadioButton jrMasc, JRadioButton jrFem, JTextField sisPrenatal, JTextField cartaoSus, JTextField endereco, JTextField telefone, JComboBox listaMes, JSpinner spAno, JTextField nasc) {
//        try {
//            Hiperdia hiperdia = new Hiperdia();
//            //Consultas consulta = new Consultas();
//            tabela.setRowSelectionInterval(consulta.numeroRegistros(municipio) - 1, consulta.numeroRegistros(municipio) - 1);
//
//            int linha_selecionada = tabela.getSelectedRow();
//
//            List<Paciente> pacientes2;
//
//            pacientes2 = consulta.listaCpf(municipio, tabela.getValueAt(linha_selecionada, 5).toString());
//            recebe(pacientes2, id, cat, situacao, nome, grupoBotoes, jrMasc, jrFem, sisPrenatal, cartaoSus, endereco, telefone, listaMes, spAno, nasc);
//            hiperdia.setaInformacao(pacientes2);
//        } catch (SQLException ex) {
//            Logger.getLogger(Hiperdia.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InvocationTargetException ex) {
//            Logger.getLogger(AcessaComunicaDados.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
