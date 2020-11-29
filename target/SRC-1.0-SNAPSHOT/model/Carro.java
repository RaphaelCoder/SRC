/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DAO;
import javax.persistence.*;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
@Entity
public class Carro {
    @Id
    @GeneratedValue
    private int id;
    private String placa;
    private String chassi;
    private String ano;
    private String cor;
    private String IPVA;
    private String seguro;
    private String garantia;
    private double valorComprado;
    private double valorVenda;
    @OneToMany
    private Modelo modelo;
    @OneToMany
    private Estacionamento estacionamento;
    
    private int idPrimariaEstacionamento;
    private int idPrimariaModelo;

    public Carro(int id, String placa, String chassi, String ano, String cor, String IPVA, String seguro, String garantia, double valorComprado, double valorVenda, Modelo modelo, Estacionamento estacionamento) {

        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.ano = ano;
        this.cor = cor;
        this.IPVA = IPVA;
        this.seguro = seguro;
        this.garantia = garantia;
        this.valorComprado = valorComprado;
        this.valorVenda = valorVenda;
        this.modelo = modelo;
        this.estacionamento = estacionamento;

    }

    public int getIdPrimariaEstacionamento() throws SQLException, ClassNotFoundException {
        return idPrimariaEstacionamento;
    }

    public void setIdPrimariaEstacionamento(int idPrimariaEstacionamento) {
        this.idPrimariaEstacionamento = idPrimariaEstacionamento;
    }
    
    public int getIdPrimariaModelo() throws ClassNotFoundException, SQLException {
        return idPrimariaModelo;
    }

    public void setIdPrimariaModelo(int idPrimariaModelo) {
        this.idPrimariaModelo = idPrimariaModelo;
    }

    public Estacionamento getEstacionamento() throws SQLException, ClassNotFoundException
    {
        if((this.idPrimariaEstacionamento != 0) && (this.estacionamento == null)){
            this.estacionamento = Estacionamento.obterEstacionamento(idPrimariaEstacionamento);
        }
        return estacionamento;
    }
    
    public void setEstacionamento(Estacionamento estacionamento)
    {
        this.estacionamento = estacionamento;
    }
    public Modelo getModelo() throws SQLException, ClassNotFoundException {
        if((this.idPrimariaModelo != 0) && (this.modelo == null)){
            this.modelo = Modelo.obterModelo(idPrimariaModelo);
        }
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getIPVA() {
        return IPVA;
    }

    public void setIPVA(String IPVA) {
        this.IPVA = IPVA;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public double getValorComprado() {
        return valorComprado;
    }

    public void setValorComprado(double valorComprado) {
        this.valorComprado = valorComprado;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public static List<Object> obterCarros() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return DAO.findAll(Carro.class);
    }

    public static Carro obterCarro(Long codCarro) throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        return (Carro) DAO.findOne(codCarro, Carro.class);
    }

    public void gravar() throws ClassNotFoundException, SQLException {
        DAO DAO = new DAO();
        DAO.save(this);
    }

    public void excluir() throws ClassNotFoundException, SQLException{
        DAO DAO = new DAO();
        DAO.delete(this);
    }

    public void alterar() throws ClassNotFoundException, SQLException{
        DAO DAO = new DAO();
        DAO.update(this);
    }
}
