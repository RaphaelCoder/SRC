package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Marca;

/**
 *
 * @author Alisson
 */
public class MarcaDAO {


    public static List<Marca> obterMarcas() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Marca> marcas = new ArrayList<Marca>();
        Marca marca = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("Select * from marca");
            while(rs.next())
            {
                marca = instanciarMarca(rs);
                marcas.add(marca);
            }
        }   finally {
            fecharConexao(conexao, comando);
        }
        return marcas;
    }
    
    /*
    public Marca(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    */
    
    public static Marca instanciarMarca(ResultSet rs) throws SQLException
    {
        Marca marca = new Marca
                (
                        rs.getInt("id"),
                        rs.getString("nome")
                );
        return marca;
    }
    public static  Marca obterMarca(int codMarca) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Marca marca = null;
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery( "select * from marca where id =" + codMarca);
            rs.first();
            marca = instanciarMarca(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return marca;
    }
}