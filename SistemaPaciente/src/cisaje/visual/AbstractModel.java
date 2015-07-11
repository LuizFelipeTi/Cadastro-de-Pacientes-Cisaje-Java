/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisaje.visual;

import cisaje.conexao.Consultas;
import cisaje.entidade.Paciente;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LUIZ FELIPE
 */
public class AbstractModel extends AbstractTableModel {

    private List<Paciente> pacientes;

    public AbstractModel() {
        pacientes = new ArrayList<Paciente>();
    }

    public AbstractModel(List<Paciente> lista) {
        this();
        pacientes.addAll(lista);
    }

    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "PACIENTE";
            case 1:
                return "SISPRENATAL";
            case 2:
                return "CARTÃO SUS";
            case 3:
                return "MÊS";
            case 4:
                return "ANO";
            case 5:
                return "Id";
            case 6:
                return "SEXO";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Paciente p = (Paciente) pacientes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getNome();
            case 1:
                return p.getSisprenatal();
            case 2:
                return p.getCartaoSus();
            case 3:
                return p.getMes();
            case 4:
                return p.getAno();
            case 5:
                return p.getId();
            case 6:
                return p.getSexo();
            default:
                return "";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        Paciente p = (Paciente) pacientes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                p.setNome(aValue.toString());
                break;
            case 1:
                if (aValue.toString().isEmpty()) {
                    p.setSisprenatal("-----");
                }
                p.setSisprenatal(aValue.toString());
                break;
            case 2:
                p.setCartaoSus(aValue.toString());
                break;
            case 3:
                p.setMes(aValue.toString());
                break;
            case 4:
                p.setAno(aValue.toString());
                break;
            case 5:
                p.setId(Integer.parseInt(aValue.toString()));
                break;
            case 6:
                p.setSexo(aValue.toString());
            default:
                System.out.println("Índice inválido");
        }

        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void inserir(String municipio, Paciente p) throws SQLException, InvocationTargetException {
        Consultas consulta = new Consultas();
        Hiperdia hiperdia = new Hiperdia();
        pacientes.add(p);

        pacientes = consulta.listaPacientes(municipio);
        //hiperdia.PreencheVazio(pacientes);

        fireTableDataChanged();
    }

    public void excluir(int pos) {
        pacientes.remove(pos);
        fireTableDataChanged();
    }

    public void excluir(String municipio, Paciente p) throws SQLException {
        Consultas consulta = new Consultas();
        pacientes.remove(p);
        pacientes = consulta.listaPacientes(municipio);
        fireTableDataChanged();
    }

    public void ordenarPorNome() {
        Collections.sort(pacientes, new Comparator<Paciente>() {

            @Override
            public int compare(Paciente o1, Paciente o2) {
                return o1.getNome().compareTo(o2.getNome());
            }

        });

        fireTableDataChanged();
    }

    public void ordenarPorId() {
        Collections.sort(pacientes, new Comparator<Paciente>() {

            @Override
            public int compare(Paciente o1, Paciente o2) {
                return o1.getId() - o2.getId();
            }

        });
        fireTableDataChanged();
    }

}
