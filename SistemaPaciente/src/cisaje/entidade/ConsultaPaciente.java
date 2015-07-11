/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisaje.entidade;

/**
 *
 * @author LUIZ FELIPE
 */
public class ConsultaPaciente extends Paciente {

    private int ang;
    private int as;
    private int card;
    private int end;
    private int enf;
    private int nefro;
    private int nut;
    private int oft;
    private int psi;
    private String dataConsulta;
    private String horarioConsulta;

//    public ConsultaPaciente(int ang, int as, int card, int end, int enf, int nefro, int nut, int oft, int psi){
//        this.ang = ang;
//        this.as = as;
//        this.card = card;
//        this.end = end;
//        this.enf = enf;
//        this.nefro = nefro;
//        this.nut = nut;
//        this.oft = oft;
//        this.psi = psi;
//    }
    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public int getAng() {
        return ang;
    }

    public void setAng(int ang) {
        this.ang = ang;
    }

    public int getAs() {
        return as;
    }

    public void setAs(int as) {
        this.as = as;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getEndo() {
        return end;
    }

    public void setEndo(int end) {
        this.end = end;
    }

    public int getEnf() {
        return enf;
    }

    public void setEnf(int enf) {
        this.enf = enf;
    }

    public int getNefro() {
        return nefro;
    }

    public void setNefro(int nefro) {
        this.nefro = nefro;
    }

    public int getNut() {
        return nut;
    }

    public void setNut(int nut) {
        this.nut = nut;
    }

    public int getOft() {
        return oft;
    }

    public void setOft(int oft) {
        this.oft = oft;
    }

    public int getPsi() {
        return psi;
    }

    public void setPsi(int psi) {
        this.psi = psi;
    }

    @Override
    public String toString() {
        return "Ang: " + getAng() + "\nA.S: " + getAs() + "\nCard: " + getCard() + "\nEnd: " + getEndo() + "\nEnf: " + getEnf() + "\nNefro: " + getNefro() + "\nNut: " + getNut() + "\nOft: " + getOft() + "\nPsi: " + getPsi();
    }

}
