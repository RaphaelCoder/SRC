/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.ModeloDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class Modelo {

    private int id;
    private String nome;
    private Marca marca;
    private int idPrimariaMarca;

    public Modelo(int id, String nome, Marca marca) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public int getIdPrimariaMarca() throws ClassNotFoundException, SQLException {
        if ((this.idPrimariaMarca != 0) && (this.marca == null)) {
            this.marca = Marca.obterMarca(this.idPrimariaMarca);
        }
        return idPrimariaMarca;
    }

    public void setIdPrimariaMarca(int idPrimariaMarca) {
        this.idPrimariaMarca = idPrimariaMarca;
    }

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

    public Marca getMarca() throws SQLException, ClassNotFoundException {
        if((this.idPrimariaMarca != 0) && (this.marca == null)){
            this.marca = Marca.obterMarca(idPrimariaMarca);
        }
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public static List<Modelo> obterModelos() throws ClassNotFoundException, SQLException {
        return ModeloDAO.obterModelos();
    }

    public static Modelo obterModelo(int codModelo) throws ClassNotFoundException, SQLException {
        return ModeloDAO.obterModelo(codModelo);
    }
    
    public void gravar() throws ClassNotFoundException, SQLException {
        ModeloDAO.gravar(this);
    }
    
    public void alterar() 
            throws 
            ClassNotFoundException, 
            SQLException {
        ModeloDAO.alterar(this);
    }
    
    public void excluir() 
            throws 
            ClassNotFoundException, 
            SQLException {
        ModeloDAO.excluir(this);
    }    
    
}
