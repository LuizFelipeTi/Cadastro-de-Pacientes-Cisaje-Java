/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisaje.visual;

import cisaje.conexao.Consultas;
import cisaje.entidade.Paciente;
import cisaje.utilitario.AcessaComunicaDados;
import cisaje.utilitario.Filtros;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author LUIZ FELIPE
 */
public final class Hiperdia extends javax.swing.JFrame {

    private AbstractModel model;//Modelo da tabela Alvorada de Minas
    private AbstractModel model2;//Modelo da tabela Diamantina
    private AbstractModel model3; // Modelo da tabela Carbonita
    private AbstractModel model4; // Modelo da tabela Coluna 
    private AbstractModel model5; // Modelo da tabela Congonhas do Norte 
    private AbstractModel model6;  // Modelo da tabela Couto Magal~haes de Minas
    private AbstractModel model7;  // Modelo da tabela Datas
    private AbstractModel model8;  // Modelo da tabela Felicio dos Santos 
    private AbstractModel model9;  // Modelo da tabela Gouveia
    private AbstractModel model10;  // Modelo da tabela Itamarandiba
    private AbstractModel model11; // Modelo da tabela Presidente Kubitschek 
    private AbstractModel model12;  // Modelo da tabela Santo Antônio do Itambé
    private AbstractModel model13; // Modelo da tabela São Gonçalo do Rio Preto
    private AbstractModel model14; // Modelo da tabela Senador Modestino
    private AbstractModel model15; // Modelo da tabela Serro 

    private final Paciente paciente = new Paciente();//Instancia objeto da classe paciente 
    private final Filtros filtros = new Filtros();//Instancia objeto da classe Filtros, responsável pelo filtro das Pesquisas na tabela

    private final DecoraTabela decoraTabela = new DecoraTabela();//Personaliza a tabela 
    private final DecoraComponentes decoraComponente = new DecoraComponentes();// Personaliza componentes
    private final AcessaComunicaDados dados = new AcessaComunicaDados();//Passa as informações cadastradas para o objeto paciente

    private final String diamantina = "atual_diamantina"; // Nome da tabela que contem os dados de Diamantina no Banco de Dados
    private final String alvorada = "atual_alvorada_de_minas"; // Nome da tabela que contem os dados de Alvorada de Minas no Banco de Dados
    private final String carbonita = "atual_carbonita"; // Nome da tabela que contem os dados de Carbonita no Banco de Dados
    private final String coluna = "atual_coluna"; // Nome da tabela que contem os dados de Coluna no Banco de Dados
    private final String congonhas = "atual_cong_norte"; // Nome da tabela que contem os dados de Congonhas do Norte no Banco de Dados
    private final String couto = "atual_couto_m_minas"; // Nome da tabela que contem os dados de Couto Magalhães no Banco de Dados
    private final String datas = "atual_datas"; // Nome da tabela que contem os dados de Datas no Banco de Dados
    private final String felicio = "atual_felicio_dos_santos"; // Nome da tabela que contem os dados de Felício dos Santos no Banco de Dados
    private final String gouveia = "atual_gouveia"; // Nome da tabela que contem os dados de Gouveia no Banco de Dados
    private final String itamarandiba = "atual_itamarandiba"; // Nome da tabela que contem os dados de Itamarandiba no Banco de Dados
    private final String presidente = "atual_presidente_kubitscheck"; // Nome da tabela que contem os dados de Presidente Kubitscheck no Banco de Dados
    private final String itambe = "atual_santo_antonio_do_itambe"; // Nome da tabela que contem os dados de Santo Antônio do Itambé no Banco de Dados
    private final String riopreto = "atual_sao_goncalo_do_rio_preto"; // Nome da tabela que contem os dados de Rio Preto no Banco de Dados
    private final String senador = "atual_senador_modestino"; // Nome da tabela que contem os dados de Senador Modestino no Banco de Dados
    private final String serro = "atual_serro"; // Nome da tabela que contem os dados de Serro no Banco de Dados

    private final Consultas consulta = new Consultas();//Instancia objeto consulta com as características da classe Consulta, responsável pela consulta ao banco de dados

    private List<Paciente> listaDiamantina = new ArrayList<>();//Intancia uma lista para pacientes de Diamantina
    private List<Paciente> listaAlvoradaDeMinas = new ArrayList<>();//Instancia uma lista para pacientes de Alvora de Minas
    private List<Paciente> listaCarbonita = new ArrayList<>(); // Instancia uma lista para pacientes de Carbonita
    private List<Paciente> listaColuna = new ArrayList<>(); // Instancia uma lista para pacientes de Coluna
    private List<Paciente> listaCongonhas = new ArrayList<>(); // Instancia uma lista para pacientes de Congonhas do Norte
    private List<Paciente> listaCouto = new ArrayList<>(); // Instancia uma lista para pacientes de Couto Magalhães
    private List<Paciente> listaDatas = new ArrayList<>(); // Instancia uma lista para pacientes de Datas
    private List<Paciente> listaFelicio = new ArrayList<>(); // Instancia uma lista para pacientes de Felicio dos Santos
    private List<Paciente> listaGouveia = new ArrayList<>(); // Instancia uma lista para pacientes de Gouveia
    private List<Paciente> listaItamarandiba = new ArrayList<>(); // Instancia uma lista para pacientes de Itamarandiba
    private List<Paciente> listaPresidente = new ArrayList<>(); // Instancia uma lista para pacientes de Presidente Kubitscheck
    private List<Paciente> listaItambe = new ArrayList<>(); // Instancia uma lista para pacientes de Santo Antonio do Itambé
    private List<Paciente> listaRiopreto = new ArrayList<>(); // Instancia uma lista para pacientes de Rio Preto
    private List<Paciente> listaSenador = new ArrayList<>(); // Instancia uma lista para pacientes de Senador Modestino
    private List<Paciente> listaSerro = new ArrayList<>(); // Instancia uma lista para pacientes de Serro

    /**
     * Classe responsável pela composição da tela de pacientes do HIPERDIA
     * Creates new form TableModel
     *
     * @throws java.sql.SQLException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public Hiperdia() throws SQLException, InvocationTargetException {
        initComponents();//Componentes da tela criados pelo NetBeans são iniciados
        txtId.setVisible(false);//Torna campo ID invisível, pois o mesmo é criado autmomaticamente ao ser inserido no banco de dados
        lblId.setVisible(false);

        listaDiamantina = consulta.listaPacientes(diamantina);//A lista criada recebe a lista de pacientes da tabela de Diamantina no banco de dados.
        listaAlvoradaDeMinas = consulta.listaPacientes(alvorada);//A lista criada recebe a lista de pacientes da tabela de Alvorade de Minas no banco de dados.
        listaCarbonita = consulta.listaPacientes(carbonita); //A lista criada recebe a lista de pacientes da tabela de Carbonita no banco de dados.
        listaColuna = consulta.listaPacientes(coluna);//A lista criada recebe a lista de pacientes da tabela de Coluna no banco de dados.
        listaCongonhas = consulta.listaPacientes(congonhas);//A lista criada recebe a lista de pacientes da tabela de Congonhas do Norte no banco de dados.
        listaCouto = consulta.listaPacientes(couto);//A lista criada recebe a lista de pacientes da tabela de Couto Magalhães no banco de dados.
        listaDatas = consulta.listaPacientes(datas);//A lista criada recebe a lista de pacientes da tabela de Datas no banco de dados.
        listaFelicio = consulta.listaPacientes(felicio);//A lista criada recebe a lista de pacientes da tabela de Felicio dos Santos no banco de dados.
        listaGouveia = consulta.listaPacientes(gouveia);//A lista criada recebe a lista de pacientes da tabela de Gouveia no banco de dados.
        listaItamarandiba = consulta.listaPacientes(itamarandiba);//A lista criada recebe a lista de pacientes da tabela de Itamarandiba no banco de dados.
        listaPresidente = consulta.listaPacientes(presidente);//A lista criada recebe a lista de pacientes da tabela de Presidente Kubitscheck no banco de dados.
        listaItambe = consulta.listaPacientes(itambe);//A lista criada recebe a lista de pacientes da tabela de Santo Antônio do Itambé no banco de dados.
        listaRiopreto = consulta.listaPacientes(riopreto);//A lista criada recebe a lista de pacientes da tabela de Rio Preto no banco de dados.
        listaSenador = consulta.listaPacientes(senador);//A lista criada recebe a lista de pacientes da tabela de Senador Modestino no banco de dados.
        listaSerro = consulta.listaPacientes(serro);//A lista criada recebe a lista de pacientes da tabela de Serro no banco de dados.

        //PreencheVazio(listaDiamantina);
        //PreencheVazio(listaAlvoradaDeMinas);
        model = new AbstractModel(listaDiamantina);//O modelo da tabela de Diamantina instancia a lista com os pacientes da cidade para que sejam exibidas.
        model2 = new AbstractModel(listaAlvoradaDeMinas);//O modelo da tabela de Alvorada de Minas instancia a lista com os pacientes da cidade para que sejam exibidas.
        model3 = new AbstractModel(listaCarbonita); //O modelo da tabela de Carbonita instancia a lista com os pacientes da cidade para que sejam exibidas.
        model4 = new AbstractModel(listaColuna); //O modelo da tabela de Coluna instancia a lista com os pacientes da cidade para que sejam exibidas.
        model5 = new AbstractModel(listaCongonhas); //O modelo da tabela de Congonhas do Norte instancia a lista com os pacientes da cidade para que sejam exibidas.
        model6 = new AbstractModel(listaCouto); //O modelo da tabela de Couto Magalhães instancia a lista com os pacientes da cidade para que sejam exibidas.
        model7 = new AbstractModel(listaDatas); //O modelo da tabela de Datas instancia a lista com os pacientes da cidade para que sejam exibidas.
        model8 = new AbstractModel(listaFelicio); //O modelo da tabela de Felício do Santos instancia a lista com os pacientes da cidade para que sejam exibidas.
        model9 = new AbstractModel(listaGouveia); //O modelo da tabela de Gouveia instancia a lista com os pacientes da cidade para que sejam exibidas.
        model10 = new AbstractModel(listaItamarandiba); //O modelo da tabela de Itamarandiba instancia a lista com os pacientes da cidade para que sejam exibidas.
        model11 = new AbstractModel(listaPresidente); //O modelo da tabela de Presidente Kubitscheck instancia a lista com os pacientes da cidade para que sejam exibidas.
        model12 = new AbstractModel(listaItambe); //O modelo da tabela de Santo Antônio do Itambé instancia a lista com os pacientes da cidade para que sejam exibidas.
        model13 = new AbstractModel(listaRiopreto); //O modelo da tabela de Rio Preto instancia a lista com os pacientes da cidade para que sejam exibidas.
        model14 = new AbstractModel(listaSenador); //O modelo da tabela de Senador Modestino instancia a lista com os pacientes da cidade para que sejam exibidas.
        model15 = new AbstractModel(listaSerro); //O modelo da tabela de Serro instancia a lista com os pacientes da cidade para que sejam exibidas.

        tabDiamantina.setModel(model);//Tabela é moldada de acordo com o model criado
        tabAlvorada.setModel(model2);//Tabela é moldada de acordo com o model criado
        tabCarbonita.setModel(model3); //Tabela é moldada de acordo com o model criado
        tabColuna.setModel(model4); //Tabela é moldada de acordo com o model criado
        tabCongonhas.setModel(model5); //Tabela é moldada de acordo com o model criado
        tabCouto.setModel(model6); //Tabela é moldada de acordo com o model criado
        tabDatas.setModel(model7); //Tabela é moldada de acordo com o model criado
        tabFelicio.setModel(model8); //Tabela é moldada de acordo com o model criado
        tabGouveia.setModel(model9); //Tabela é moldada de acordo com o model criado
        tabItamarandiba.setModel(model10); //Tabela é moldada de acordo com o model criado
        tabPresidente.setModel(model11); //Tabela é moldada de acordo com o model criado
        tabSantoAntonio.setModel(model12); //Tabela é moldada de acordo com o model criado
        tabSaoGoncalo.setModel(model13); //Tabela é moldada de acordo com o model criado
        tabSenadorM.setModel(model14); //Tabela é moldada de acordo com o model criado
        tabSerro.setModel(model15); //Tabela é moldada de acordo com o model criado

        //Os dois sorters são criados para filtrar cada tabela criada
        TableRowSorter<AbstractModel> sorter = new TableRowSorter<AbstractModel>(model);
        TableRowSorter<AbstractModel> sorter2 = new TableRowSorter<AbstractModel>(model2);
        TableRowSorter<AbstractModel> sorter3 = new TableRowSorter<AbstractModel>(model3);
        TableRowSorter<AbstractModel> sorter4 = new TableRowSorter<AbstractModel>(model4);
        TableRowSorter<AbstractModel> sorter5 = new TableRowSorter<AbstractModel>(model5);
        TableRowSorter<AbstractModel> sorter6 = new TableRowSorter<AbstractModel>(model6);
        TableRowSorter<AbstractModel> sorter7 = new TableRowSorter<AbstractModel>(model7);
        TableRowSorter<AbstractModel> sorter8 = new TableRowSorter<AbstractModel>(model8);
        TableRowSorter<AbstractModel> sorter9 = new TableRowSorter<AbstractModel>(model9);
        TableRowSorter<AbstractModel> sorter10 = new TableRowSorter<AbstractModel>(model10);
        TableRowSorter<AbstractModel> sorter11 = new TableRowSorter<AbstractModel>(model11);
        TableRowSorter<AbstractModel> sorter12 = new TableRowSorter<AbstractModel>(model12);
        TableRowSorter<AbstractModel> sorter13 = new TableRowSorter<AbstractModel>(model13);
        TableRowSorter<AbstractModel> sorter14 = new TableRowSorter<AbstractModel>(model14);
        TableRowSorter<AbstractModel> sorter15 = new TableRowSorter<AbstractModel>(model15);

        selecionaPaciente(alvorada, tabAlvorada);// Seta as informações de Alvorada de Minas no painel de Visualização.
        setaEstatisticas(alvorada);// Seta as informações de Alvorada de Minas no painel de Estatísticas.

        // As tabelas são personalizadas com um retoque 
        decoraTabela.personalizaTabela(tabDiamantina);
        decoraTabela.personalizaTabela(tabAlvorada);
        decoraTabela.personalizaTabela(tabCarbonita);
        decoraTabela.personalizaTabela(tabColuna);
        decoraTabela.personalizaTabela(tabCongonhas);
        decoraTabela.personalizaTabela(tabCouto);
        decoraTabela.personalizaTabela(tabDatas);
        decoraTabela.personalizaTabela(tabFelicio);
        decoraTabela.personalizaTabela(tabGouveia);
        decoraTabela.personalizaTabela(tabItamarandiba);
        decoraTabela.personalizaTabela(tabPresidente);
        decoraTabela.personalizaTabela(tabSantoAntonio);
        decoraTabela.personalizaTabela(tabSaoGoncalo);
        decoraTabela.personalizaTabela(tabSenadorM);
        decoraTabela.personalizaTabela(tabSerro);

        // Os botões são decorados 
        decoraComponente.PersonalizaBotao(btnNovo, btnVisualizar, btnExcluir, btnSalvar);

        // As informações aparecem no painel de informações e de Alteração ao clicar ou descer/subir no direcional do teclado
        CliqueDigito(tabDiamantina, consulta, diamantina);
        CliqueDigito(tabAlvorada, consulta, alvorada);
        CliqueDigito(tabCarbonita, consulta, carbonita);
        CliqueDigito(tabColuna, consulta, coluna);
        CliqueDigito(tabCongonhas, consulta, congonhas);
        CliqueDigito(tabCouto, consulta, couto);
        CliqueDigito(tabDatas, consulta, datas);
        CliqueDigito(tabFelicio, consulta, felicio);
        CliqueDigito(tabGouveia, consulta, gouveia);
        CliqueDigito(tabItamarandiba, consulta, itamarandiba);
        CliqueDigito(tabPresidente, consulta, presidente);
        CliqueDigito(tabSantoAntonio, consulta, itambe);
        CliqueDigito(tabSaoGoncalo, consulta, riopreto);
        CliqueDigito(tabSenadorM, consulta, senador);
        CliqueDigito(tabSerro, consulta, serro);

        ListenerFiltros(tabAlvorada, tabDiamantina, tabCarbonita, tabColuna, tabCongonhas, tabCouto, tabDatas, tabFelicio, tabGouveia, tabItamarandiba, tabPresidente, tabSantoAntonio, tabSaoGoncalo, tabSenadorM, tabSerro, txtPesquisa, sorter, sorter2, sorter3, sorter4, sorter5, sorter6, sorter7, sorter8, sorter9, sorter10, sorter11, sorter12, sorter13, sorter14, sorter15, 0);// Cria o filtro por Nome.
        ListenerFiltros(tabAlvorada, tabDiamantina, tabCarbonita, tabColuna, tabCongonhas, tabCouto, tabDatas, tabFelicio, tabGouveia, tabItamarandiba, tabPresidente, tabSantoAntonio, tabSaoGoncalo, tabSenadorM, tabSerro, txtPesquisaSisprenatal, sorter, sorter2, sorter3, sorter4, sorter5, sorter6, sorter7, sorter8, sorter9, sorter10, sorter11, sorter12, sorter13, sorter14, sorter15, 1);// Cria o filtro por SISPrenatal.
        ListenerFiltros(tabAlvorada, tabDiamantina, tabCarbonita, tabColuna, tabCongonhas, tabCouto, tabDatas, tabFelicio, tabGouveia, tabItamarandiba, tabPresidente, tabSantoAntonio, tabSaoGoncalo, tabSenadorM, tabSerro, txtPesquisaCartaoSus, sorter, sorter2, sorter3, sorter4, sorter5, sorter6, sorter7, sorter8, sorter9, sorter10, sorter11, sorter12, sorter13, sorter14, sorter15, 2);// Cria o filtro por CartãoSUS.
        SexoItemListenerFiltros(tabAlvorada, tabDiamantina, tabCarbonita, tabColuna, tabCongonhas, tabCouto, tabDatas, tabFelicio, tabGouveia, tabItamarandiba, tabPresidente, tabSantoAntonio, tabSaoGoncalo, tabSenadorM, tabSerro, jrPesquisaMasc, "M", sorter, sorter2, sorter3, sorter4, sorter5, sorter6, sorter7, sorter8, sorter9, sorter10, sorter11, sorter12, sorter13, sorter14, sorter15);// Cria o filtro por Sexo masculino.
        SexoItemListenerFiltros(tabAlvorada, tabDiamantina, tabCarbonita, tabColuna, tabCongonhas, tabCouto, tabDatas, tabFelicio, tabGouveia, tabItamarandiba, tabPresidente, tabSantoAntonio, tabSaoGoncalo, tabSenadorM, tabSerro, jrPesquisaFemin, "F", sorter, sorter2, sorter3, sorter4, sorter5, sorter6, sorter7, sorter8, sorter9, sorter10, sorter11, sorter12, sorter13, sorter14, sorter15);// Cria o filtro por Sexo feminino.
        MesItemListener(tabAlvorada, tabDiamantina, tabCarbonita, tabColuna, tabCongonhas, tabCouto, tabDatas, tabFelicio, tabGouveia, tabItamarandiba, tabPresidente, tabSantoAntonio, tabSaoGoncalo, tabSenadorM, tabSerro, comboPesquisaMes, sorter, sorter2, sorter3, sorter4, sorter5, sorter6, sorter7, sorter8, sorter9, sorter10, sorter11, sorter12, sorter13, sorter14, sorter15);// Cria o filtro por Mês
        AnoChengeListener(tabAlvorada, tabDiamantina, tabCarbonita, tabColuna, tabCongonhas, tabCouto, tabDatas, tabFelicio, tabGouveia, tabItamarandiba, tabPresidente, tabSantoAntonio, tabSaoGoncalo, tabSenadorM, tabSerro, spPesquisaAno, sorter, sorter2, sorter3, sorter4, sorter5, sorter6, sorter7, sorter8, sorter9, sorter10, sorter11, sorter12, sorter13, sorter14, sorter15);// Cria o filtro por ano;

    }

    public void PreencheVazio(List<Paciente> paciente) {
        for (int i = 0; i < paciente.size(); ++i) {

            if (paciente.get(i).getSisprenatal().isEmpty()) {
                paciente.get(i).setSisprenatal("------");
                //lblSisPrenatal.setText("NÃO CONSTA");
            }
        }
    }

    // Método responsável pela filtragem por Nome, SISPrenatal e CartãoSUS
    private void ListenerFiltros(JTable tabela, JTable tabela2, JTable tabela3, JTable tabela4, JTable tabela5, JTable tabela6, JTable tabela7, JTable tabela8, JTable tabela9, JTable tabela10, JTable tabela11, JTable tabela12, JTable tabela13, JTable tabela14, JTable tabela15, JTextField texto, TableRowSorter<AbstractModel> sorter, TableRowSorter<AbstractModel> sorter2, TableRowSorter<AbstractModel> sorter3, TableRowSorter<AbstractModel> sorter4, TableRowSorter<AbstractModel> sorter5, TableRowSorter<AbstractModel> sorter6, TableRowSorter<AbstractModel> sorter7, TableRowSorter<AbstractModel> sorter8, TableRowSorter<AbstractModel> sorter9, TableRowSorter<AbstractModel> sorter10, TableRowSorter<AbstractModel> sorter11, TableRowSorter<AbstractModel> sorter12, TableRowSorter<AbstractModel> sorter13, TableRowSorter<AbstractModel> sorter14, TableRowSorter<AbstractModel> sorter15, int coluna) {

        try {

            texto.getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    String sexo = "";
                    if (painelMunicipios.getSelectedIndex() == 0) {// Se 1ª aba for selecionada
                        //filtros.newFilter(sorter2, texto.getText(), tabela, coluna);//1ª aba é filtrada de acordo com o que for digitado

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter2, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela);
                        //filtros.combinaFiltros(sorter2, "M", listaMes, tabColuna, WIDTH);

                    } else if (painelMunicipios.getSelectedIndex() == 1) {// Se 2ª aba for selecionada
                        //filtros.newFilter(sorter, texto.getText(), tabela2, coluna);//2ª aba é filtrada de acordo com o que for digitado
                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela2);
                    } else if (painelMunicipios.getSelectedIndex() == 2) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter3, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela3);

                    } else if (painelMunicipios.getSelectedIndex() == 3) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter4, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela4);

                    } else if (painelMunicipios.getSelectedIndex() == 4) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter5, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela5);

                    } else if (painelMunicipios.getSelectedIndex() == 5) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter6, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela6);

                    } else if (painelMunicipios.getSelectedIndex() == 6) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter7, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela7);

                    } else if (painelMunicipios.getSelectedIndex() == 7) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter8, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela8);

                    } else if (painelMunicipios.getSelectedIndex() == 8) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter9, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela9);

                    } else if (painelMunicipios.getSelectedIndex() == 9) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter10, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela10);

                    } else if (painelMunicipios.getSelectedIndex() == 10) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter11, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela11);

                    } else if (painelMunicipios.getSelectedIndex() == 11) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter12, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela12);

                    } else if (painelMunicipios.getSelectedIndex() == 12) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter13, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela13);

                    } else if (painelMunicipios.getSelectedIndex() == 13) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter14, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela14);

                    } else if (painelMunicipios.getSelectedIndex() == 14) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter15, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela15);

                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    String sexo = "";
                    if (painelMunicipios.getSelectedIndex() == 0) {// Se 1ª aba for selecionada
                        //filtros.newFilter(sorter2, texto.getText(), tabela, coluna);//1ª aba é filtrada de acordo com o que for digitado
                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter2, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela);
                    } else if (painelMunicipios.getSelectedIndex() == 1) {// Se 2ª aba for selecionada
                        //filtros.newFilter(sorter, texto.getText(), tabela2, coluna);//2ª aba é filtrada de acordo com o que for digitado
                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela2);
                    } else if (painelMunicipios.getSelectedIndex() == 2) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter3, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela3);

                    } else if (painelMunicipios.getSelectedIndex() == 3) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter4, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela4);

                    } else if (painelMunicipios.getSelectedIndex() == 4) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter5, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela5);

                    } else if (painelMunicipios.getSelectedIndex() == 5) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter6, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela6);

                    } else if (painelMunicipios.getSelectedIndex() == 6) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter7, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela7);

                    } else if (painelMunicipios.getSelectedIndex() == 7) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter8, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela8);

                    } else if (painelMunicipios.getSelectedIndex() == 8) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter9, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela9);

                    } else if (painelMunicipios.getSelectedIndex() == 9) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter10, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela10);

                    } else if (painelMunicipios.getSelectedIndex() == 10) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter11, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela11);

                    } else if (painelMunicipios.getSelectedIndex() == 11) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter12, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela12);

                    } else if (painelMunicipios.getSelectedIndex() == 12) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter13, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela13);

                    } else if (painelMunicipios.getSelectedIndex() == 13) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter14, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela14);

                    } else if (painelMunicipios.getSelectedIndex() == 14) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter15, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela15);

                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    String sexo = "";
                    if (painelMunicipios.getSelectedIndex() == 0) {// Se 1ª aba for selecionada
                        //filtros.newFilter(sorter2, texto.getText(), tabela, coluna);//1ª aba é filtrada de acordo com o que for digitado
                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter2, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela);
                    } else if (painelMunicipios.getSelectedIndex() == 1) {// Se 2ª aba for selecionada
                        //filtros.newFilter(sorter, texto.getText(), tabela2, coluna);//2ª aba é filtrada de acordo com o que for digitado
                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela2);
                    } else if (painelMunicipios.getSelectedIndex() == 2) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter3, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela3);

                    } else if (painelMunicipios.getSelectedIndex() == 3) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter4, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela4);

                    } else if (painelMunicipios.getSelectedIndex() == 4) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter5, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela5);

                    } else if (painelMunicipios.getSelectedIndex() == 5) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter6, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela6);

                    } else if (painelMunicipios.getSelectedIndex() == 6) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter7, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela7);

                    } else if (painelMunicipios.getSelectedIndex() == 7) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter8, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela8);

                    } else if (painelMunicipios.getSelectedIndex() == 8) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter9, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela9);

                    } else if (painelMunicipios.getSelectedIndex() == 9) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter10, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela10);

                    } else if (painelMunicipios.getSelectedIndex() == 10) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter11, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela11);

                    } else if (painelMunicipios.getSelectedIndex() == 11) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter12, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela12);

                    } else if (painelMunicipios.getSelectedIndex() == 12) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter13, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela13);

                    } else if (painelMunicipios.getSelectedIndex() == 13) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter14, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela14);

                    } else if (painelMunicipios.getSelectedIndex() == 14) {

                        if (jrPesquisaMasc.isSelected()) {
                            sexo = "M";
                        } else if (jrPesquisaFemin.isSelected()) {
                            sexo = "F";
                        }
                        filtros.combinaFiltros(sorter15, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela15);

                    }
                }
            });

        } catch (IndexOutOfBoundsException erro) {
            erro.getMessage();
        }
    }

    // Método responsável pela filtragem por sexo Masculino e Feminino
    private void SexoItemListenerFiltros(JTable tabela, JTable tabela2, JTable tabela3, JTable tabela4, JTable tabela5, JTable tabela6, JTable tabela7, JTable tabela8, JTable tabela9, JTable tabela10, JTable tabela11, JTable tabela12, JTable tabela13, JTable tabela14, JTable tabela15, JRadioButton botao, String sexo, TableRowSorter<AbstractModel> sorter, TableRowSorter<AbstractModel> sorter2, TableRowSorter<AbstractModel> sorter3, TableRowSorter<AbstractModel> sorter4, TableRowSorter<AbstractModel> sorter5, TableRowSorter<AbstractModel> sorter6, TableRowSorter<AbstractModel> sorter7, TableRowSorter<AbstractModel> sorter8, TableRowSorter<AbstractModel> sorter9, TableRowSorter<AbstractModel> sorter10, TableRowSorter<AbstractModel> sorter11, TableRowSorter<AbstractModel> sorter12, TableRowSorter<AbstractModel> sorter13, TableRowSorter<AbstractModel> sorter14, TableRowSorter<AbstractModel> sorter15) {
        botao.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (painelMunicipios.getSelectedIndex() == 0 && botao.isSelected()) {// Se 1ª aba for selecionada.
                    //filtros.newFilter(sorter2, sexo, tabela, 6);// A 1ª aba é filtrada de acordo com o sexo selecionado.
                    filtros.combinaFiltros(sorter2, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela);
                } else if (painelMunicipios.getSelectedIndex() == 1 && botao.isSelected()) {// Se 2ª aba for selecionada.
                    //filtros.newFilter(sorter, sexo, tabela2, 6);// A 2ª aba é filtrada de acordo com o sexo selecionado.
                    filtros.combinaFiltros(sorter, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela2);
                } else if (painelMunicipios.getSelectedIndex() == 2 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter3, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela3);
                } else if (painelMunicipios.getSelectedIndex() == 3 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter4, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela4);
                } else if (painelMunicipios.getSelectedIndex() == 4 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter5, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela5);
                } else if (painelMunicipios.getSelectedIndex() == 5 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter6, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela6);
                } else if (painelMunicipios.getSelectedIndex() == 6 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter7, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela7);
                } else if (painelMunicipios.getSelectedIndex() == 7 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter8, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela8);
                } else if (painelMunicipios.getSelectedIndex() == 8 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter9, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela9);
                } else if (painelMunicipios.getSelectedIndex() == 9 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter10, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela10);
                } else if (painelMunicipios.getSelectedIndex() == 10 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter11, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela11);
                } else if (painelMunicipios.getSelectedIndex() == 11 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter12, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela12);
                } else if (painelMunicipios.getSelectedIndex() == 12 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter13, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela13);
                } else if (painelMunicipios.getSelectedIndex() == 13 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter14, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela14);
                } else if (painelMunicipios.getSelectedIndex() == 14 && botao.isSelected()) {
                    filtros.combinaFiltros(sorter15, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, tabela15);
                }
            }
        });
    }

    // Método responsável pela filtragem por Mês
    private void MesItemListener(JTable tabela, JTable tabela2, JTable tabela3, JTable tabela4, JTable tabela5, JTable tabela6, JTable tabela7, JTable tabela8, JTable tabela9, JTable tabela10, JTable tabela11, JTable tabela12, JTable tabela13, JTable tabela14, JTable tabela15, JComboBox mes, TableRowSorter<AbstractModel> sorter, TableRowSorter<AbstractModel> sorter2, TableRowSorter<AbstractModel> sorter3, TableRowSorter<AbstractModel> sorter4, TableRowSorter<AbstractModel> sorter5, TableRowSorter<AbstractModel> sorter6, TableRowSorter<AbstractModel> sorter7, TableRowSorter<AbstractModel> sorter8, TableRowSorter<AbstractModel> sorter9, TableRowSorter<AbstractModel> sorter10, TableRowSorter<AbstractModel> sorter11, TableRowSorter<AbstractModel> sorter12, TableRowSorter<AbstractModel> sorter13, TableRowSorter<AbstractModel> sorter14, TableRowSorter<AbstractModel> sorter15) {

        mes.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                String sexo = "";
                if (painelMunicipios.getSelectedIndex() == 0) {// Se 1ª aba for selecionada
                    //filtros.newFilterCombo(sorter2, tabela, mes);// A 1ª aba será filtrada de acordo com o mês selecionado
                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter2, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela);
                } else if (painelMunicipios.getSelectedIndex() == 1) {// Se 2ª aba for selecionada
                    //filtros.newFilterCombo(sorter, tabela2, mes);// A 2ª aba será filtrada de acordo com o mês selecionado

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela2);
                } else if (painelMunicipios.getSelectedIndex() == 2) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter3, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela3);
                } else if (painelMunicipios.getSelectedIndex() == 3) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter4, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela4);
                } else if (painelMunicipios.getSelectedIndex() == 4) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter5, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela5);
                } else if (painelMunicipios.getSelectedIndex() == 5) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter6, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela6);
                } else if (painelMunicipios.getSelectedIndex() == 6) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter7, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela7);
                } else if (painelMunicipios.getSelectedIndex() == 7) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter8, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela8);
                } else if (painelMunicipios.getSelectedIndex() == 8) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter9, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela9);
                } else if (painelMunicipios.getSelectedIndex() == 9) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter10, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela10);
                } else if (painelMunicipios.getSelectedIndex() == 10) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter11, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela11);
                } else if (painelMunicipios.getSelectedIndex() == 11) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter12, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela12);
                } else if (painelMunicipios.getSelectedIndex() == 12) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter13, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela13);
                } else if (painelMunicipios.getSelectedIndex() == 13) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter14, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela14);
                } else if (painelMunicipios.getSelectedIndex() == 14) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    filtros.combinaFiltros(sorter15, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), mes, sexo, tabela15);
                }

            }
        });
    }

    // Método responsável pela filtragem por Ano
    public void AnoChengeListener(JTable tabela, JTable tabela2, JTable tabela3, JTable tabela4, JTable tabela5, JTable tabela6, JTable tabela7, JTable tabela8, JTable tabela9, JTable tabela10, JTable tabela11, JTable tabela12, JTable tabela13, JTable tabela14, JTable tabela15, JSpinner ano, TableRowSorter<AbstractModel> sorter, TableRowSorter<AbstractModel> sorter2, TableRowSorter<AbstractModel> sorter3, TableRowSorter<AbstractModel> sorter4, TableRowSorter<AbstractModel> sorter5, TableRowSorter<AbstractModel> sorter6, TableRowSorter<AbstractModel> sorter7, TableRowSorter<AbstractModel> sorter8, TableRowSorter<AbstractModel> sorter9, TableRowSorter<AbstractModel> sorter10, TableRowSorter<AbstractModel> sorter11, TableRowSorter<AbstractModel> sorter12, TableRowSorter<AbstractModel> sorter13, TableRowSorter<AbstractModel> sorter14, TableRowSorter<AbstractModel> sorter15) {

        ano.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {

                String sexo = "";
                if (painelMunicipios.getSelectedIndex() == 0) {// Se 1ª aba for selecionada
                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }

                    //filtros.newFilterAno(sorter2, ano.getValue().toString(), tabela);// A 1ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter2, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela);
                } else if (painelMunicipios.getSelectedIndex() == 1) {// Se 2ª aba for selecionada
                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela2);
                } else if (painelMunicipios.getSelectedIndex() == 2) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter3, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela3);
                } else if (painelMunicipios.getSelectedIndex() == 3) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter4, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela4);
                } else if (painelMunicipios.getSelectedIndex() == 4) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter5, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela5);
                } else if (painelMunicipios.getSelectedIndex() == 5) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter6, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela6);
                } else if (painelMunicipios.getSelectedIndex() == 6) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter7, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela7);
                } else if (painelMunicipios.getSelectedIndex() == 7) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter8, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela8);
                } else if (painelMunicipios.getSelectedIndex() == 8) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter9, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela9);
                } else if (painelMunicipios.getSelectedIndex() == 9) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter10, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela10);
                } else if (painelMunicipios.getSelectedIndex() == 10) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter11, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela11);
                } else if (painelMunicipios.getSelectedIndex() == 11) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter12, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela12);
                } else if (painelMunicipios.getSelectedIndex() == 12) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter13, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela13);
                } else if (painelMunicipios.getSelectedIndex() == 13) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter14, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela14);
                } else if (painelMunicipios.getSelectedIndex() == 14) {

                    if (jrPesquisaMasc.isSelected()) {
                        sexo = "M";
                    } else if (jrPesquisaFemin.isSelected()) {
                        sexo = "F";
                    }
                    //filtros.newFilterAno(sorter, ano.getValue().toString(), tabela2);// A 2ª aba será filtrada de acordo com o ano selecionado
                    filtros.combinaFiltrosAno(sorter15, txtPesquisa.getText(), txtPesquisaSisprenatal.getText(), txtPesquisaCartaoSus.getText(), comboPesquisaMes, sexo, ano.getValue().toString(), tabela15);
                }
            }
        });
    }

    // Método responsável pelo Listener do clique e das teclas direcionais cima/baixo e Enter 
    public void CliqueDigito(JTable tabela, Consultas consulta, String municipio) {
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {// Ajusta o listener.
                    int linha_selecionada = tabela.getSelectedRow();// Recupera a linha selecionada.

                    try {
                        // Lista pacientes 2 recebe os dados do paciente selecionado na tabela.
                        List<Paciente> pacientes2 = consulta.listaCpf(municipio, tabela.getValueAt(linha_selecionada, 5).toString());
                        // Lista pacientes2 com os dados do paciente selecionado é inserida em cada componente do painel de cadastro e alteração.
                        dados.recebe(pacientes2, txtId, txtCat, txtSituacao, txtNome, grupoBotoes, jrMasc, jrFem, txtSisprenatal, txtCartaosus, txtEndereco, txtTelefone, listaMes, spAno, txtNasc);
                        setaInformacao(pacientes2);// Informações do paciente selecionado são exibidas no paiinel de informação.
                    } catch (SQLException ex) {
                        Logger.getLogger(Hiperdia.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ArrayIndexOutOfBoundsException erro) {
                        erro.getMessage();
                    }
                    guiaPainel.setSelectedComponent(pnInformacao);// Painel de Informação é exibido ao ser selecionado algum paciente nas tabelas
                }
            }

        });
    }

    public JTextField DefinirTiposCaracteresETamanho(String caracteres) {

        try {

            String quantidade = "";

            for (int i = 0; i < 16; i++) {
                quantidade = quantidade + "*";
            }

            MaskFormatter nome = new MaskFormatter(quantidade);

            nome.setValidCharacters(caracteres);

            return new JFormattedTextField(nome);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
            return new JTextField();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        grupoPesquisaBotoes = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        pnTabela = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtPesquisaSisprenatal = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jrPesquisaMasc = new javax.swing.JRadioButton();
        jrPesquisaFemin = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        comboPesquisaMes = new javax.swing.JComboBox();
        jPanel15 = new javax.swing.JPanel();
        spPesquisaAno = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtPesquisaCartaoSus = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        painelMunicipios = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabAlvorada = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabDiamantina = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabCarbonita = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabColuna = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabCongonhas = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabCouto = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabDatas = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabFelicio = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabGouveia = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        tabItamarandiba = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tabPresidente = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tabSantoAntonio = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        tabSaoGoncalo = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        tabSenadorM = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        tabSerro = new javax.swing.JTable();
        pnInfo = new javax.swing.JPanel();
        pnIntDados = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        lblMulheres = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTotalPacientes = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblHomens = new javax.swing.JLabel();
        pnEmbaixo = new javax.swing.JPanel();
        guiaPainel = new javax.swing.JTabbedPane();
        pnInformacao = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblCat = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblSituacao = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblSisPrenatal = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNasc = new javax.swing.JLabel();
        lblCartaoSus = new javax.swing.JLabel();
        pnDados = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCat = new jTextFieldSomenteLetras();
        jLabel14 = new javax.swing.JLabel();
        txtSituacao = new jTextFieldSomenteLetras();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        listaMes = new javax.swing.JComboBox();
        spAno = new javax.swing.JSpinner();
        jrMasc = new javax.swing.JRadioButton();
        txtNasc = new javax.swing.JTextField();
        jrFem = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSisprenatal = new jTextFieldSomentenumeros();
        jLabel3 = new javax.swing.JLabel();
        txtCartaosus = new jTextFieldSomentenumeros();
        txtTelefone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        pnBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnVisualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Pacientes - HIPERDIA");
        setAutoRequestFocus(false);

        jPanel4.setPreferredSize(new java.awt.Dimension(1120, 891));

        pnTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)), "Pacientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Meiryo UI", 0, 12))); // NOI18N
        pnTabela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnTabela.setOpaque(false);
        pnTabela.setPreferredSize(new java.awt.Dimension(1115, 395));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.lightGray), "Pesquisar por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Meiryo UI", 0, 12))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Meiryo", 0, 12)); // NOI18N
        jLabel12.setText("Nome:");

        txtPesquisa.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        txtPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), java.awt.Color.lightGray));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel17.setText("SISPRENATAL:");

        txtPesquisaSisprenatal.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        txtPesquisaSisprenatal.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaSisprenatal, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPesquisaSisprenatal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel17))
        );

        jLabel28.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel28.setText("Sexo:");

        grupoPesquisaBotoes.add(jrPesquisaMasc);
        jrPesquisaMasc.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jrPesquisaMasc.setText("M");

        grupoPesquisaBotoes.add(jrPesquisaFemin);
        jrPesquisaFemin.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jrPesquisaFemin.setText("F");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrPesquisaMasc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrPesquisaFemin))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrPesquisaMasc, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28))
                    .addComponent(jrPesquisaFemin, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel30.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel30.setText("Mês:");

        comboPesquisaMes.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        comboPesquisaMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPesquisaMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPesquisaMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        spPesquisaAno.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        spPesquisaAno.setModel(new javax.swing.SpinnerNumberModel(2015, 2009, 2030, 1));

        jLabel31.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel31.setText("Ano:");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spPesquisaAno, javax.swing.GroupLayout.PREFERRED_SIZE, 64, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(spPesquisaAno)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel24.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel24.setText("CartãoSUS:");

        txtPesquisaCartaoSus.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        txtPesquisaCartaoSus.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.lightGray));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPesquisaCartaoSus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtPesquisaCartaoSus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel24))
        );

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cisaje/visual/imagens/btnPesquisa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel32))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelMunicipios.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                painelMunicipiosStateChanged(evt);
            }
        });

        tabAlvorada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabAlvorada);

        painelMunicipios.addTab("Alvorada de Minas", jScrollPane3);

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        tabDiamantina.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabDiamantina.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        tabDiamantina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabDiamantina);

        painelMunicipios.addTab("Diamantina", jScrollPane1);

        tabCarbonita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabCarbonita);

        painelMunicipios.addTab("Carbonita", jScrollPane2);

        tabColuna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tabColuna);

        painelMunicipios.addTab("Coluna", jScrollPane4);

        tabCongonhas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tabCongonhas);

        painelMunicipios.addTab("Congonhas do Norte", jScrollPane5);

        tabCouto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tabCouto);

        painelMunicipios.addTab("Couto Magalhães de Minas", jScrollPane6);

        tabDatas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tabDatas);

        painelMunicipios.addTab("Datas", jScrollPane7);

        tabFelicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tabFelicio);

        painelMunicipios.addTab("Felício dos Santos", jScrollPane8);

        tabGouveia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(tabGouveia);

        painelMunicipios.addTab("Gouveia", jScrollPane9);

        tabItamarandiba.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(tabItamarandiba);

        painelMunicipios.addTab("Itamarandiba", jScrollPane10);

        tabPresidente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(tabPresidente);

        painelMunicipios.addTab("Presidente Kubitsheck", jScrollPane11);

        tabSantoAntonio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tabSantoAntonio);

        painelMunicipios.addTab("Santo Antônio do Itambé", jScrollPane12);

        tabSaoGoncalo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(tabSaoGoncalo);

        painelMunicipios.addTab("São Gonçalo do Rio Preto", jScrollPane13);

        tabSenadorM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(tabSenadorM);

        painelMunicipios.addTab("Senador Modestino", jScrollPane14);

        tabSerro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(tabSerro);

        painelMunicipios.addTab("Serro", jScrollPane15);

        javax.swing.GroupLayout pnTabelaLayout = new javax.swing.GroupLayout(pnTabela);
        pnTabela.setLayout(pnTabelaLayout);
        pnTabelaLayout.setHorizontalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabelaLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelMunicipios, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTabelaLayout.setVerticalGroup(
            pnTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTabelaLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelMunicipios, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pnInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)), "Detalhes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Meiryo UI", 0, 12))); // NOI18N
        pnInfo.setOpaque(false);
        pnInfo.setPreferredSize(new java.awt.Dimension(305, 315));

        pnIntDados.setBackground(new java.awt.Color(255, 255, 255));
        pnIntDados.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jLabel26.setFont(new java.awt.Font("Meiryo UI", 1, 12)); // NOI18N
        jLabel26.setText("Mulheres:");

        lblMulheres.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        lblMulheres.setText("mulheres");

        jLabel11.setFont(new java.awt.Font("Meiryo UI", 1, 12)); // NOI18N
        jLabel11.setText("Total de Pacientes:");

        lblTotalPacientes.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        lblTotalPacientes.setText("pacientes");

        jLabel21.setFont(new java.awt.Font("Meiryo UI", 1, 12)); // NOI18N
        jLabel21.setText("Homens:");

        lblHomens.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        lblHomens.setText("homens");

        javax.swing.GroupLayout pnIntDadosLayout = new javax.swing.GroupLayout(pnIntDados);
        pnIntDados.setLayout(pnIntDadosLayout);
        pnIntDadosLayout.setHorizontalGroup(
            pnIntDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIntDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnIntDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnIntDadosLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHomens))
                    .addGroup(pnIntDadosLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalPacientes))
                    .addGroup(pnIntDadosLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMulheres)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        pnIntDadosLayout.setVerticalGroup(
            pnIntDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnIntDadosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnIntDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTotalPacientes))
                .addGap(18, 18, 18)
                .addGroup(pnIntDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lblHomens))
                .addGap(18, 18, 18)
                .addGroup(pnIntDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lblMulheres))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnInfoLayout = new javax.swing.GroupLayout(pnInfo);
        pnInfo.setLayout(pnInfoLayout);
        pnInfoLayout.setHorizontalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnIntDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnInfoLayout.setVerticalGroup(
            pnInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInfoLayout.createSequentialGroup()
                .addComponent(pnIntDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnEmbaixo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)), "Detalhes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Meiryo UI", 0, 12))); // NOI18N
        pnEmbaixo.setOpaque(false);
        pnEmbaixo.setPreferredSize(new java.awt.Dimension(785, 315));

        guiaPainel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        guiaPainel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        guiaPainel.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        guiaPainel.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jPanel1.setMaximumSize(new java.awt.Dimension(604, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(604, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(604, 246));

        lblCat.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblCat.setText("cat");

        lblAno.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblAno.setText("ano");

        jLabel19.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel19.setText("Situação:");

        lblNome.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblNome.setText("nome");

        lblSituacao.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblSituacao.setText("situação");

        jLabel16.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel16.setText("Sexo:");

        jLabel23.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel23.setText("Endereço:");

        lblSexo.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblSexo.setText("sexo");

        lblEndereco.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblEndereco.setText("endereço");

        jLabel18.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel18.setText("Data de Nascimento:");

        jLabel25.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel25.setText("Telefone/Celular:");

        lblTelefone.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblTelefone.setText("telefone/celular");

        jLabel27.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel27.setText("Mês:");

        lblMes.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblMes.setText("mês");

        jLabel20.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel20.setText("SisPrenatal:");

        lblSisPrenatal.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblSisPrenatal.setText("sisprenatal");

        jLabel22.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel22.setText("Cartão SUS:");

        jLabel29.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel29.setText("Ano:");

        jLabel7.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel7.setText("Cat:");

        jLabel6.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel6.setText("Nome:");

        lblNasc.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblNasc.setText("data de nascimento");

        lblCartaoSus.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        lblCartaoSus.setText("cartão SUS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSexo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCat, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTelefone))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSisPrenatal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblAno))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNasc))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSituacao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCartaoSus))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblNome))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(lblSexo))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNasc)
                        .addComponent(jLabel18)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCartaoSus)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(lblSisPrenatal)
                        .addComponent(jLabel22)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblCat)
                    .addComponent(jLabel19)
                    .addComponent(lblSituacao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lblEndereco))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(lblMes)
                        .addComponent(jLabel29)
                        .addComponent(lblAno))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(lblTelefone)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnInformacaoLayout = new javax.swing.GroupLayout(pnInformacao);
        pnInformacao.setLayout(pnInformacaoLayout);
        pnInformacaoLayout.setHorizontalGroup(
            pnInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        pnInformacaoLayout.setVerticalGroup(
            pnInformacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnInformacaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        guiaPainel.addTab("Visualizar", pnInformacao);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jPanel2.setPreferredSize(new java.awt.Dimension(604, 246));

        jLabel13.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel13.setText("Cat:");

        txtCat.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel14.setText("Situação:");

        txtSituacao.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel15.setText("Sexo:");

        jLabel10.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel10.setText("Ano:");

        jLabel4.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel4.setText("Dta Nasc:");

        listaMes.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        listaMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JANEIRO", "FEVEREIRO", "MARÇO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" }));

        spAno.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        spAno.setModel(new javax.swing.SpinnerNumberModel(2015, 2008, 2030, 1));

        jrMasc.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes.add(jrMasc);
        jrMasc.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jrMasc.setText("Masculino");

        try{
            MaskFormatter data = new MaskFormatter("##/##/####");
            txtNasc = new JFormattedTextField(data);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro");
        }
        txtNasc.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N

        jrFem.setBackground(new java.awt.Color(255, 255, 255));
        grupoBotoes.add(jrFem);
        jrFem.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jrFem.setText("Feminino");

        jLabel5.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel5.setText("Endereço:");

        txtEndereco.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel8.setText("Telefone/Celular:");

        jLabel1.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel1.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel2.setText("SisPrenatal:");

        txtSisprenatal.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel3.setText("Cartao SUS:");

        txtCartaosus.setFont(new java.awt.Font("Meiryo UI", 0, 12));

        try{         

            MaskFormatter telefone = new MaskFormatter("(**) ****-****");         
            txtTelefone = new JFormattedTextField(telefone); 

        }catch(Exception e){     
            JOptionPane.showMessageDialog(null, "Ocorreu um Erro"); 
        }
        txtTelefone.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        jLabel9.setText("Mês:");

        lblId.setText("Id:");

        btnSalvar.setBackground(new java.awt.Color(245, 250, 255));
        btnSalvar.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cisaje/visual/btnSalvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listaMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(194, 194, 194)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCartaosus)
                                    .addComponent(txtSituacao))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSisprenatal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrMasc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrFem)))
                        .addGap(0, 36, Short.MAX_VALUE))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCartaosus, txtSisprenatal, txtSituacao});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jrMasc)
                    .addComponent(jrFem))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCartaosus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSisprenatal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(listaMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(spAno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId)))
        );

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        guiaPainel.addTab("Cadastrar/Alterar", pnDados);

        pnBotoes.setOpaque(false);

        btnNovo.setBackground(new java.awt.Color(245, 250, 255));
        btnNovo.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cisaje/visual/imagens/btnNovo2.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnVisualizar.setBackground(new java.awt.Color(245, 250, 255));
        btnVisualizar.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        btnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cisaje/visual/imagens/btnVisualizar.jpg"))); // NOI18N
        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(245, 250, 255));
        btnExcluir.setFont(new java.awt.Font("Meiryo UI", 0, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cisaje/visual/btnExcluir.gif"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotoesLayout = new javax.swing.GroupLayout(pnBotoes);
        pnBotoes.setLayout(pnBotoesLayout);
        pnBotoesLayout.setHorizontalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createSequentialGroup()
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBotoesLayout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnBotoesLayout.setVerticalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnEmbaixoLayout = new javax.swing.GroupLayout(pnEmbaixo);
        pnEmbaixo.setLayout(pnEmbaixoLayout);
        pnEmbaixoLayout.setHorizontalGroup(
            pnEmbaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnEmbaixoLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(guiaPainel, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnEmbaixoLayout.setVerticalGroup(
            pnEmbaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEmbaixoLayout.createSequentialGroup()
                .addGroup(pnEmbaixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEmbaixoLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(pnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(guiaPainel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pnInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(pnEmbaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(pnTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(pnEmbaixo, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Método responsável pelas ações do botão Visualizar
    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed

        guiaPainel.setSelectedComponent(pnInformacao); // Painel de Informaçõe é exibido ao ser clicado o botão visualizar.

    }

    //Botão Cancelar
    private void txtCancelActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
//        Consultas consulta;
//        try {//Para verificação da comunicação com o banco de dados
//
//            consulta = new Consultas();//Cria objeto da classe Consultas
//            this.dispose();//Fecha esta tela
//            consulta.AtualizaTabela();//Abre a tela com a lista de pacientes atualizada
//
//        } catch (SQLException ex) {//Identifica erro de comunicação com o banco de dados    
//
//            Logger.getLogger(TelaCadastroPaciente.class.getName()).log(Level.SEVERE, null, ex);
//
//        }


    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void capturaDadosFormulario(String cat, String situacao, String nome, String sexo, String sisPrenatal, String cartaoSus, String endereco, String telefone, String mes, String ano, String nasc) {

        //As informações da tela de cadastro são capturadas    
        cat = txtCat.getText(); // Recupera CAT do paciente
        situacao = txtSituacao.getText(); // Recupera Situação do paciente
        nome = txtNome.getText(); // Recupera Nome do paciente
        sexo = ""; // Inicializa variável sexo para recuperar sexo do paciente

        if (jrMasc.isSelected()) { // Se o botão Masculino for selecionado
            sexo = "M"; // Variável sexo recebe o valor "M"
        }

        if (jrFem.isSelected()) { // Se o botão Feminino for selecionado
            sexo = "F"; // Variável sexo sexo recebe o valor "F"
        }

        sisPrenatal = txtSisprenatal.getText(); // Recupera o SISPrenatal do paciente
        cartaoSus = txtCartaosus.getText(); // Recupera o CartãoSUS do paciente
        endereco = txtEndereco.getText(); // Recupera o Endereço do paciente

        telefone = txtTelefone.getText(); // Recupera o Telefone do paciente
        mes = listaMes.getSelectedItem().toString(); // Recupera o Mês em que o paciente foi cadastrado
        ano = spAno.getValue().toString(); // Recupera o Ano em que o paciente foi cadastrado
        nasc = txtNasc.getText(); // Recupera a Data de Nascimento do paciente

//                setaDadosObjeto(cat, situacao, nome, sexo, sisPrenatal, cartaoSus, endereco, telefone, mes, ano, nasc);
//
    }

    private void setaDadosObjeto(String cat, String situacao, String nome, String sexo, String sisPrenatal, String cartaoSus, String endereco, String telefone, String mes, String ano, String nasc) {
        List<Paciente> pacientes = new ArrayList<>(); // Cria lista do tipo Paciente para inserir os valores capturados no cadastro/alteração dentro do objeto paciente

        // As informações de cadastro são inseridas dentro do objeto Paciente      
        paciente.setCat(cat); // Insere o CAT capturado no objeto Paciente
        paciente.setSituacao(situacao); // Insere a Situação capturada no objeto Paciente
        paciente.setNome(nome); // Insere o Nome capturada no objeto Paciente
        paciente.setSexo(sexo); // Insere o Sexo capturado no objeto Paciente
        paciente.setSisprenatal(sisPrenatal); // Insere o SISPrenatal capturado no objeto Paciente
        paciente.setCartaoSus(cartaoSus); // Insere o cartão SUS capturado no objeto Paciente
        paciente.setEnd(endereco); // Insere o Endereço capturado no objeto Paciente

        paciente.setTelefone(telefone); // Insere o Telefone capturado no objeto Paciente
        paciente.setMes(mes); // Insere o Mês capturado no objeto Paciente
        paciente.setAno(ano); // Insere o Ano capturado no objeto Paciente
        paciente.setNasc(nasc); // Insere a Data de Nascimento capturada no objeto Paciente
        pacientes.add(paciente); // Insere o objeto Paciente em uma lista
    }

    // Método responsável pelas ações que serão executas ao selecionar o botão Salvar.
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        try {//Para verificação da comunicação com o banco de dados

            try {//Para verificação de preenchimento correto de acordo com o formato númerico dos campos CPF, RG e Número.

//                //As informações da tela de cadastro são capturadas    
                String cat = txtCat.getText(); // Recupera CAT do paciente
                String situacao = txtSituacao.getText(); // Recupera Situação do paciente
                String nome = txtNome.getText(); // Recupera Nome do paciente
                String sexo = ""; // Inicializa variável sexo para recuperar sexo do paciente

                if (jrMasc.isSelected()) { // Se o botão Masculino for selecionado
                    sexo = "M"; // Variável sexo recebe o valor "M"
                }

                if (jrFem.isSelected()) { // Se o botão Feminino for selecionado
                    sexo = "F"; // Variável sexo sexo recebe o valor "F"
                }

                String sisPrenatal = txtSisprenatal.getText(); // Recupera o SISPrenatal do paciente
//                if(txtSisprenatal.getText().isEmpty()){
//                   sisPrenatal = "NÃO CONSTA"; 
//                }

                String cartaoSus = txtCartaosus.getText(); // Recupera o CartãoSUS do paciente
                String endereco = txtEndereco.getText(); // Recupera o Endereço do paciente

                String telefone = txtTelefone.getText(); // Recupera o Telefone do paciente
                String mes = listaMes.getSelectedItem().toString(); // Recupera o Mês em que o paciente foi cadastrado
                String ano = spAno.getValue().toString(); // Recupera o Ano em que o paciente foi cadastrado
                String nasc = txtNasc.getText(); // Recupera a Data de Nascimento do paciente

                setaDadosObjeto(cat, situacao, nome, sexo, sisPrenatal, cartaoSus, endereco, telefone, mes, ano, nasc);

                String cidade = ""; // Inicializa a variável cidade (será passada como parâmetro para determinar em qual tabela inserir os dados capturados no formulário)
                if (painelMunicipios.getSelectedIndex() == 0) { // Se 1ª aba estiver selecionada
                    cidade = alvorada; // Variável cidade recebe o nome da tabela Alvorada de Minas armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 1) { // Se 2ª aba estiver selecionada
                    cidade = diamantina; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 2) { // Se 2ª aba estiver selecionada
                    cidade = carbonita; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 3) { // Se 2ª aba estiver selecionada
                    cidade = coluna; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 4) { // Se 2ª aba estiver selecionada
                    cidade = congonhas; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 5) { // Se 2ª aba estiver selecionada
                    cidade = couto; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 6) { // Se 2ª aba estiver selecionada
                    cidade = datas; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 7) { // Se 2ª aba estiver selecionada
                    cidade = felicio; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 8) { // Se 2ª aba estiver selecionada
                    cidade = gouveia; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 9) { // Se 2ª aba estiver selecionada
                    cidade = itamarandiba; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 10) { // Se 2ª aba estiver selecionada
                    cidade = presidente; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 11) { // Se 2ª aba estiver selecionada
                    cidade = itambe; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 12) { // Se 2ª aba estiver selecionada
                    cidade = riopreto; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 13) { // Se 2ª aba estiver selecionada
                    cidade = senador; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                } else if (painelMunicipios.getSelectedIndex() == 14) { // Se 2ª aba estiver selecionada
                    cidade = serro; // Variável cidade recebe o nome da tabela Diamantina armazenada no Banco
                }

                //Variável contador recebe verificação se há existência de uma id ainda não preenchida, ou um cpf não existente(contador = 0)
                int contador = consulta.verificaCpf(cidade, txtId.getText());
                int cpfExistente = consulta.verificaCpfExistente(cidade, "", sisPrenatal); // Variável cpfExistente verifica a existência de um SISPrenatal ou CartãoSUS não existente
                int SisSusExistente = consulta.verificaCpfExistente(cidade, txtId.getText(), sisPrenatal);
                int cpfExistente2 = consulta.verificaSusExistente(cidade, "", cartaoSus);
                int SisSusExistente2 = consulta.verificaSusExistente(cidade, txtId.getText(), cartaoSus);

                // Janelas de teste para verificar se as verificações de id, SISPrenatal e CartãoSUS estão funcionando
                // Se os doi tiverem valor igual 0, foram salvos pela 1ª vez corretamente
                JOptionPane.showMessageDialog(null, "Contador: " + contador);
                JOptionPane.showMessageDialog(null, "SISPrenatal Existente Cadastro: " + cpfExistente);// Verifica Sisprenatal existente para cadastro
                JOptionPane.showMessageDialog(null, "Cartão SUS Existente Cadastro: " + cpfExistente2); // Verifica CartãoSus existente para cadastro
                JOptionPane.showMessageDialog(null, "SISPrenatal Existente Alteração: " + SisSusExistente); // Verifica Sisprenatal existente para alteração
                JOptionPane.showMessageDialog(null, "Cartão SUS Existente Alteração: " + SisSusExistente2); // Verifica CartãoSus existente para alteração
                //Se não existir Id, SISPrenatal ou Cartão SUS
                if (contador == 0) {

                    //Se os campos Cat, Nome, Sexo, Telefone, Mês e Ano não forem preenchidos
                    //A mensagem preencha todos os campos é emitida  
                    if (nome.isEmpty() || sexo.isEmpty() || telefone.isEmpty() || mes.isEmpty() || ano.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos! 1");

                        // Senão se um SISPrenatal ou CartãoSUS digitado já existir no Banco de Dados
                        // A mensagem Sisprenatal ou CartãoSUS já existente é exibida
                    } else if (cpfExistente > 0 || cpfExistente2 > 0) {
                        JOptionPane.showMessageDialog(null, "Sisprenatal ou CartãoSUS já existente");
                    } else { // Senão

                        //O paciente é cadastrado no Banco de Dados
                        consulta.cadastraPacientes(cidade, cat, situacao, nome, sexo, sisPrenatal, cartaoSus, endereco, telefone, mes, ano, nasc);

                        if (painelMunicipios.getSelectedIndex() == 0) { // Se 1ª aba estiver selecionada

//                            PreencheVazio(listaAlvoradaDeMinas);
//                            model2 = new AbstractModel(listaAlvoradaDeMinas);//O modelo da tabela de Alvorada de Minas instancia a lista com os pacientes da cidade para que sejam exibidas.
//                            tabAlvorada.setModel(model2);
//                            decoraTabela.personalizaTabela(tabAlvorada);
                            model2.inserir(cidade, paciente); // A tabela Alvorada de Minas é atualizada com o novo paciente cadastrado 
                            model2.ordenarPorId(); // A tabela é ordenada novamente por ID
                            selecionaPaciente(cidade, tabAlvorada); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                PreencheVazio(listaDiamantina);
//                                int linha_selecionada = tabAlvorada.getSelectedRow();
//                                tabAlvorada.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 1) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabDiamantina); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 2) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model3.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model3.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabCarbonita); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 3) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model4.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model4.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabColuna); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 4) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model5.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model5.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabCongonhas); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 5) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model6.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model6.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabCouto); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 6) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model7.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model7.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabDatas); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 7) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model8.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model8.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabFelicio); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 8) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model9.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model9.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabGouveia); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 9) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model10.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model10.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabItamarandiba); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 10) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model11.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model11.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabPresidente); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 11) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model12.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model12.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabSantoAntonio); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 12) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model13.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model13.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabSaoGoncalo); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 13) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model14.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model14.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabSenadorM); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        } else if (painelMunicipios.getSelectedIndex() == 14) { // Se a 2ª aba estiver selecionada
                            //PreencheVazio(listaDiamantina);
                            //model = new AbstractModel(listaDiamantina);
                            //tabDiamantina.setModel(model);
                            //decoraTabela.personalizaTabela(tabDiamantina);
                            model15.inserir(cidade, paciente); // A tabela Diamantina é atualizada com o novo paciente cadastrado
                            model15.ordenarPorId(); // A tabela é ordenada por ID

                            selecionaPaciente(cidade, tabSerro); // As informações do paciente cadastrado são setadas no painel de informação

//                            if (sisPrenatal.isEmpty()) {
//                                int linha_selecionada = tabDiamantina.getSelectedRow();
//                                tabDiamantina.setValueAt("-----", linha_selecionada, 1);
//                            }
                        }

                        resetarCampo(); // Os campos do formulário são resetados

                    }

                    //Se Id existir (Se o paciente já existe)                
                } else {
                    //Se os campos Cat, Nome, Sexo, Telefone, Mês e Ano não forem preenchidos
                    //A mensagem preencha todos os campos é emitida  
                    if (nome.isEmpty() || sexo.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || mes.isEmpty() || ano.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos!");

                        // Senão se um SISPrenatal ou CartãoSUS digitado já existir no Banco de Dados
                        // A mensagem Sisprenatal ou CartãoSUS já existente é exibida    
                    } else if ((sisPrenatal.equals("-----") && SisSusExistente2 > 0 && !cartaoSus.equals("-----")) || (!sisPrenatal.equals("-----") && SisSusExistente2 > 0 && !cartaoSus.equals("-----")) || (cartaoSus.equals("-----") && SisSusExistente > 0 && !sisPrenatal.equals("-----")) || (!cartaoSus.equals("-----") && SisSusExistente > 0 && !sisPrenatal.equals("-----"))) {
                        JOptionPane.showMessageDialog(null, "Sisprenatal ou CartãoSUS já existente");

                    } else {
                        //As informações do paciente são alteradas    
                        consulta.alteraCadastro(cidade, txtId.getText(), cat, situacao, nome, sexo, sisPrenatal, cartaoSus, endereco, telefone, mes, ano, nasc);

                        if (painelMunicipios.getSelectedIndex() == 0) { // Se 1ª aba é selecionada
                            //PreencheVazio(listaAlvoradaDeMinas);
                            consulta.alteraEspacoVazioSisprenatal(alvorada);
                            consulta.alteraEspacoVazioCartaoSus(alvorada);
                            dados.setaAlteracaoTabela(tabAlvorada, nome, sisPrenatal, cartaoSus, listaMes, spAno);//Os dados alterados são exibdos na tabela Alvorada de Minas
                            model2.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(alvorada, tabAlvorada); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 1) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(diamantina);
                            consulta.alteraEspacoVazioCartaoSus(diamantina);
                            dados.setaAlteracaoTabela(tabDiamantina, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(diamantina, tabDiamantina); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 2) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(carbonita);
                            consulta.alteraEspacoVazioCartaoSus(carbonita);
                            dados.setaAlteracaoTabela(tabCarbonita, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model3.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(carbonita, tabCarbonita); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 3) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(coluna);
                            consulta.alteraEspacoVazioCartaoSus(coluna);
                            dados.setaAlteracaoTabela(tabColuna, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model4.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(coluna, tabColuna); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 4) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(congonhas);
                            consulta.alteraEspacoVazioCartaoSus(congonhas);
                            dados.setaAlteracaoTabela(tabCongonhas, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model5.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(congonhas, tabCongonhas); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 5) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(couto);
                            consulta.alteraEspacoVazioCartaoSus(couto);
                            dados.setaAlteracaoTabela(tabCouto, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model6.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(couto, tabCouto); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 6) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(datas);
                            consulta.alteraEspacoVazioCartaoSus(datas);
                            dados.setaAlteracaoTabela(tabDatas, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model7.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(datas, tabDatas); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 7) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(felicio);
                            consulta.alteraEspacoVazioCartaoSus(felicio);
                            dados.setaAlteracaoTabela(tabFelicio, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model8.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(felicio, tabFelicio); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 8) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(gouveia);
                            consulta.alteraEspacoVazioCartaoSus(gouveia);
                            dados.setaAlteracaoTabela(tabGouveia, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model9.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(gouveia, tabGouveia); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 9) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(itamarandiba);
                            consulta.alteraEspacoVazioCartaoSus(itamarandiba);
                            dados.setaAlteracaoTabela(tabItamarandiba, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model10.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(itamarandiba, tabItamarandiba); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 10) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(presidente);
                            consulta.alteraEspacoVazioCartaoSus(presidente);
                            dados.setaAlteracaoTabela(tabPresidente, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model11.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(presidente, tabPresidente); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 11) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(itambe);
                            consulta.alteraEspacoVazioCartaoSus(itambe);
                            dados.setaAlteracaoTabela(tabSantoAntonio, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model12.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(itambe, tabSantoAntonio); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 12) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(riopreto);
                            consulta.alteraEspacoVazioCartaoSus(riopreto);
                            dados.setaAlteracaoTabela(tabSaoGoncalo, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model13.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(riopreto, tabSaoGoncalo); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 13) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(senador);
                            consulta.alteraEspacoVazioCartaoSus(senador);
                            dados.setaAlteracaoTabela(tabSenadorM, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model14.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(senador, tabSenadorM); // Os dados alterados são setados no painel de informação

                        } else if (painelMunicipios.getSelectedIndex() == 14) { // Se 2ª tabela  é selecionada
                            consulta.alteraEspacoVazioSisprenatal(serro);
                            consulta.alteraEspacoVazioCartaoSus(serro);
                            dados.setaAlteracaoTabela(tabSerro, nome, sisPrenatal, cartaoSus, listaMes, spAno); // Os dados alterados são exibidos na tabela Diamantina
                            model15.ordenarPorId(); // Os dados da tabela são novamente ordenados por ID
                            selecionaPaciente(serro, tabSerro); // Os dados alterados são setados no painel de informação

                        }
                        resetarCampo(); // Reseta todos os campos do painel de formulário
                    }

                }

                //Verifica erros de formato de tipos numéricos (SISPrenatal, CartãoSUS, Número)
                //Se em um desses campos não houver nenhuma informação ou 
                //as informações inseridas forem diferentes do tipo determinado
                //a mensagem preencha todos os campos aparecerá.
            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Preencha todos os campos!! 2");

            } catch (InvocationTargetException ex) {
                Logger.getLogger(Hiperdia.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Identifica erro de comunicação com o banco de dados    
        } catch (SQLException ex) {

            Logger.getLogger(TelaCadastroPaciente.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalArgumentException ile) {
            ile.getMessage();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Método responsável pela ação de excluir que será executada ao clicar no botão Excluir
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        try {
            String cidade = ""; // Inicializa a variável cidade
            String id = ""; // Inicializa a varipavel ID

            if (painelMunicipios.getSelectedIndex() == 0) { // Se 1ª aba estiver selecionada
                cidade = alvorada; // Variável cidade recebe a cidade Alvorada de Minas
                int num_linha = tabAlvorada.getSelectedRow();//variável recebe a linha selecionada;
                id = tabAlvorada.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 1) { // Se 2ª aba for selecionada
                cidade = diamantina; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabDiamantina.getSelectedRow();//variável recebe a linha selecionada;
                id = tabDiamantina.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 2) { // Se 2ª aba for selecionada
                cidade = carbonita; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabCarbonita.getSelectedRow();//variável recebe a linha selecionada;
                id = tabCarbonita.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 3) { // Se 2ª aba for selecionada
                cidade = coluna; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabColuna.getSelectedRow();//variável recebe a linha selecionada;
                id = tabColuna.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 4) { // Se 2ª aba for selecionada
                cidade = congonhas; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabCongonhas.getSelectedRow();//variável recebe a linha selecionada;
                id = tabCongonhas.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 5) { // Se 2ª aba for selecionada
                cidade = couto; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabCouto.getSelectedRow();//variável recebe a linha selecionada;
                id = tabCouto.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 6) { // Se 2ª aba for selecionada
                cidade = datas; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabDatas.getSelectedRow();//variável recebe a linha selecionada;
                id = tabDatas.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 7) { // Se 2ª aba for selecionada
                cidade = felicio; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabFelicio.getSelectedRow();//variável recebe a linha selecionada;
                id = tabFelicio.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 8) { // Se 2ª aba for selecionada
                cidade = gouveia; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabGouveia.getSelectedRow();//variável recebe a linha selecionada;
                id = tabGouveia.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 9) { // Se 2ª aba for selecionada
                cidade = itamarandiba; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabItamarandiba.getSelectedRow();//variável recebe a linha selecionada;
                id = tabItamarandiba.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 10) { // Se 2ª aba for selecionada
                cidade = presidente; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabPresidente.getSelectedRow();//variável recebe a linha selecionada;
                id = tabPresidente.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 11) { // Se 2ª aba for selecionada
                cidade = itambe; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabSantoAntonio.getSelectedRow();//variável recebe a linha selecionada;
                id = tabSantoAntonio.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 12) { // Se 2ª aba for selecionada
                cidade = riopreto; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabSaoGoncalo.getSelectedRow();//variável recebe a linha selecionada;
                id = tabSaoGoncalo.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 13) { // Se 2ª aba for selecionada
                cidade = senador; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabSenadorM.getSelectedRow();//variável recebe a linha selecionada;
                id = tabSenadorM.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            } else if (painelMunicipios.getSelectedIndex() == 14) { // Se 2ª aba for selecionada
                cidade = serro; // Variável cidade recebe a cidade Diamantina
                int num_linha = tabSerro.getSelectedRow();//variável recebe a linha selecionada;
                id = tabSerro.getValueAt(num_linha, 5).toString();// variável id recebe o valor do id da linha selecionada
            }

            // Exibe janela de Confirmando a exclusão do Paciente
            Object[] options = {"Sim", "Não"};
            int r = JOptionPane.showOptionDialog(null, "Você realmente deseja excluir este paciente?", "Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (r == JOptionPane.YES_OPTION) {

                consulta.excluirCadastro(cidade, id);//Método excluirCadastro é chamado para ser excluído um paciente no banco através do parâmetro Id

                if (painelMunicipios.getSelectedIndex() == 0) { // Se 1ª aba for selecionada

                    model2.excluir(cidade, paciente); // Paciente é excluido da tabela Alvorada de Minas
                    model2.ordenarPorId(); // Tabela Alvorada de Minas é reordenada por ID após exclusão
                } else if (painelMunicipios.getSelectedIndex() == 1) { // Se 2ª aba for selecionada
                    model.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 2) { // Se 2ª aba for selecionada
                    model3.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model3.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 3) { // Se 2ª aba for selecionada
                    model4.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model4.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 4) { // Se 2ª aba for selecionada
                    model5.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model5.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 5) { // Se 2ª aba for selecionada
                    model6.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model6.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 6) { // Se 2ª aba for selecionada
                    model7.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model7.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 7) { // Se 2ª aba for selecionada
                    model8.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model8.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 8) { // Se 2ª aba for selecionada
                    model9.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model9.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 9) { // Se 2ª aba for selecionada
                    model10.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model10.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 10) { // Se 2ª aba for selecionada
                    model11.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model11.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 11) { // Se 2ª aba for selecionada
                    model12.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model12.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 12) { // Se 2ª aba for selecionada
                    model13.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model13.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 13) { // Se 2ª aba for selecionada
                    model14.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model14.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                } else if (painelMunicipios.getSelectedIndex() == 14) { // Se 2ª aba for selecionada
                    model15.excluir(cidade, paciente); // Paciente é excluído da tabela Diamantina
                    model15.ordenarPorId(); // Tabela Diamantina é reordenada por ID após exlusão
                }
                resetarCampo(); // Os campos do formulário são resetados
            }
            // Tratamento de erros na conexão com o banco de dados
        } catch (SQLException ex) {
            Logger.getLogger(Hiperdia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    // Método responsável pela ações que serão executadas ao clicar no botao Novo
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        resetarCampo(); // Setar os campos do painel de formulário
        guiaPainel.setSelectedComponent(pnDados); // Seleciona a aba do painel de formulários para que possa ser cadastrado um novo paciente

    }//GEN-LAST:event_btnNovoActionPerformed

    // Método responsável por ouvir as ações (Listeners) que forem executadas entre as abas do jTabbedPane
    private void painelMunicipiosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_painelMunicipiosStateChanged

        try {
            if (painelMunicipios.getSelectedIndex() == 0) { // Se 1ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão do Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(alvorada); // Seta estatísticas da Alvorada de Minas
                selecionaPaciente(alvorada, tabAlvorada); // Seta dados do último paciente cadasrado de Alvorada de Minas

            } else if (painelMunicipios.getSelectedIndex() == 1) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(diamantina); // Seta estatísticas de Diamantina
                selecionaPaciente(diamantina, tabDiamantina); // Seta dados do último paciente cadastrado de Diamantina

            } else if (painelMunicipios.getSelectedIndex() == 2) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(carbonita); // Seta estatísticas de Diamantina
                selecionaPaciente(carbonita, tabCarbonita); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 3) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(coluna); // Seta estatísticas de Diamantina
                selecionaPaciente(coluna, tabColuna); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 4) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(congonhas); // Seta estatísticas de Diamantina
                selecionaPaciente(congonhas, tabCongonhas); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 5) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(couto); // Seta estatísticas de Diamantina
                selecionaPaciente(couto, tabCouto); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 6) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(datas); // Seta estatísticas de Diamantina
                selecionaPaciente(datas, tabDatas); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 7) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(felicio); // Seta estatísticas de Diamantina
                selecionaPaciente(felicio, tabFelicio); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 8) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(gouveia); // Seta estatísticas de Diamantina
                selecionaPaciente(gouveia, tabGouveia); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 9) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(itamarandiba); // Seta estatísticas de Diamantina
                selecionaPaciente(itamarandiba, tabItamarandiba); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 10) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(presidente); // Seta estatísticas de Diamantina
                selecionaPaciente(presidente, tabPresidente); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 11) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(itambe); // Seta estatísticas de Diamantina
                selecionaPaciente(itambe, tabSantoAntonio); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 12) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(riopreto); // Seta estatísticas de Diamantina
                selecionaPaciente(riopreto, tabSaoGoncalo); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 13) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(senador); // Seta estatísticas de Diamantina
                selecionaPaciente(senador, tabSenadorM); // Seta dados do último paciente cadastrado de Diamantina
            } else if (painelMunicipios.getSelectedIndex() == 14) { // Se 2ª aba for selecionada

                if (jrPesquisaMasc.isSelected() || jrPesquisaFemin.isSelected()) { // Se algum botão Sexo estiver selecionado
                    grupoPesquisaBotoes.clearSelection(); // Ao clicar na aba, limpar seleção
                }

                setaEstatisticas(serro); // Seta estatísticas de Diamantina
                selecionaPaciente(serro, tabSerro); // Seta dados do último paciente cadastrado de Diamantina
            }

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) { // Trata erros referentes ao JRadioButton e ao erro de seleção fora do limite de índices da tabela
            e.getMessage();
        } catch (SQLException ex) { // Trata erros de conexão ao Banco de Dados
            Logger.getLogger(Hiperdia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_painelMunicipiosStateChanged

    // Método responsável por resetar os campos do painel de formulário
    private void resetarCampo() {
        txtId.setText(null); // Reseta campo ID
        txtCat.setText(null); // Reseta campo CAT
        txtSituacao.setText(null); // Reseta campo Situação
        txtNome.setText(null); // Reseta campo Nome
        grupoBotoes.setSelected(jrMasc.getModel(), true); // Reseta seleção dos botões de Sexo 
        txtSisprenatal.setText(null); // Reseta campo SISPrenatal
        txtCartaosus.setText(null); // Reseta campo Cartao SUS
        txtEndereco.setText(null); // Reseta campo Endereço
        txtTelefone.setText(null); // Reseta campo Telefone
        listaMes.setSelectedItem("JANEIRO"); // Reseta para o 1º mês do ano
        spAno.setValue(2015); // Reseta para o ano de 2015
        txtNasc.setText(null); // Reseta o campo Data de Nascimento
    }

    // Método responsável por setar as informações no painel de informação
    public void setaInformacao(List<Paciente> informacao) {

        lblCat.setText(informacao.get(0).getCat()); // Seta o CAT do paciente
        lblSituacao.setText(informacao.get(0).getSituacao()); // Seta a Situação do paciente
        lblNome.setText(informacao.get(0).getNome()); // Seta o Nome do paciente

        if (informacao.get(0).getSexo().equals("M")) { // Se o sexo for igual a "M"
            lblSexo.setText("M"); // Seta sexo masculino no Sexo do paciente
        }
        if (informacao.get(0).getSexo().equals("F")) { // Se o sexo for igual  a "F"
            lblSexo.setText("F"); // Seta sexo feminino no Sexo do paciente
        }

//        if (informacao.get(0).getSisprenatal().isEmpty()) {
//            lblSisPrenatal.setText("----"); // Seta o SISPrenatal do paciente
//        } else {
        lblSisPrenatal.setText(informacao.get(0).getSisprenatal()); // Seta o SISPrenatal do paciente
        //}
        lblCartaoSus.setText(informacao.get(0).getCartaoSus()); // Seta o Cartão SUS do paciente
        lblEndereco.setText(informacao.get(0).getEnd()); // Seta o Endereço do paciente
        lblTelefone.setText(informacao.get(0).getTelefone()); // Seta o número de Telefone do paciente
        lblMes.setText(informacao.get(0).getMes()); // Seta o mês do paciente
        lblAno.setText(informacao.get(0).getAno()); // Seta o ano do paciente
        lblNasc.setText(informacao.get(0).getNasc()); // Seta a data de nascimento do paciente

    }

    // Método responsável por setar as Estatísticas no painel de Estatísticas
    public void setaEstatisticas(String municipio) throws SQLException {

        lblTotalPacientes.setText(Integer.toString(consulta.numeroRegistros(municipio))); // Seta o total de pacientes do município selecionado
        lblHomens.setText(Integer.toString(consulta.numeroRegistrosMasc(municipio))); // Seta o total de pacientes homens do municipio selecionado
        lblMulheres.setText(Integer.toString(consulta.numeroRegistrosFem(municipio))); // Seta o total de pacientes mulheres do municipio selecionado

    }

    // Método responsável pela seleção de um paciente na tabela
    public void selecionaPaciente(String municipio, JTable tabela) {
        try {

            // Determina intervalo de seleção ao selecionar paciente ao clicar ou com tecla direcional
            tabela.setRowSelectionInterval(consulta.numeroRegistros(municipio) - 1, consulta.numeroRegistros(municipio) - 1);

            int linha_selecionada = tabela.getSelectedRow(); // Variável recebe a linha selecionada

            List<Paciente> pacientes2 = consulta.listaCpf(municipio, tabela.getValueAt(linha_selecionada, 5).toString()); // Lista recebe o s valores do paciente selecionado
            //System.out.println(pacientes2);
            // Os dados são inseridos nos campos do painel de formulário 
            dados.recebe(pacientes2, txtId, txtCat, txtSituacao, txtNome, grupoBotoes, jrMasc, jrFem, txtSisprenatal, txtCartaosus, txtEndereco, txtTelefone, listaMes, spAno, txtNasc);
            setaInformacao(pacientes2); // Os dados são inseridos no painel de Informação
        } catch (SQLException ex) { // Tratamento de erros em relação a conexão de banco de dados
            Logger.getLogger(Hiperdia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException erro) { // Tratamento de erros relacinados a campos numéricos vazios
            erro.getMessage();
        } catch (IllegalArgumentException ile) {
            ile.getMessage();
        }
    }

    /**
     * @param args the command line arguments
     */
    // Método principal responsável pela execução da Tela
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hiperdia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hiperdia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hiperdia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hiperdia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Hiperdia().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(Hiperdia.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Hiperdia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JComboBox comboPesquisaMes;
    private javax.swing.ButtonGroup grupoBotoes;
    private javax.swing.ButtonGroup grupoPesquisaBotoes;
    private javax.swing.JTabbedPane guiaPainel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JRadioButton jrFem;
    private javax.swing.JRadioButton jrMasc;
    private javax.swing.JRadioButton jrPesquisaFemin;
    private javax.swing.JRadioButton jrPesquisaMasc;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCartaoSus;
    private javax.swing.JLabel lblCat;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblHomens;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMulheres;
    private javax.swing.JLabel lblNasc;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSisPrenatal;
    private javax.swing.JLabel lblSituacao;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTotalPacientes;
    private javax.swing.JComboBox listaMes;
    private javax.swing.JTabbedPane painelMunicipios;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnEmbaixo;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnInformacao;
    private javax.swing.JPanel pnIntDados;
    private javax.swing.JPanel pnTabela;
    private javax.swing.JSpinner spAno;
    private javax.swing.JSpinner spPesquisaAno;
    private javax.swing.JTable tabAlvorada;
    private javax.swing.JTable tabCarbonita;
    private javax.swing.JTable tabColuna;
    private javax.swing.JTable tabCongonhas;
    private javax.swing.JTable tabCouto;
    private javax.swing.JTable tabDatas;
    private javax.swing.JTable tabDiamantina;
    private javax.swing.JTable tabFelicio;
    private javax.swing.JTable tabGouveia;
    private javax.swing.JTable tabItamarandiba;
    private javax.swing.JTable tabPresidente;
    private javax.swing.JTable tabSantoAntonio;
    private javax.swing.JTable tabSaoGoncalo;
    private javax.swing.JTable tabSenadorM;
    private javax.swing.JTable tabSerro;
    private javax.swing.JTextField txtCartaosus;
    private javax.swing.JTextField txtCat;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNasc;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtPesquisaCartaoSus;
    private javax.swing.JTextField txtPesquisaSisprenatal;
    private javax.swing.JTextField txtSisprenatal;
    private javax.swing.JTextField txtSituacao;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
