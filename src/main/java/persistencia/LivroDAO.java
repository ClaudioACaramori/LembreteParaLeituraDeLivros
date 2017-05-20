package persistencia;

import entidades.Livro;
import persistencia.jdbc.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by claud on 20/05/2017.
 */
public class LivroDAO {


    private Connection connection = ConexaoFactory.getConnection();

    public void cadastrar(Livro livro){
        String sql = "INSERT INTO livro (nomeDoLivro, numeroDePaginas) VALUES(?,?)";

        try{
            PreparedStatement preparador = connection.prepareStatement(sql);
            preparador.setString(1, livro.getNomeDoLivro());
            preparador.setInt(2, livro.getNumeroDePaginas());

            preparador.execute();
            preparador.close();

            System.out.println("Cadastrado com sucesso!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
