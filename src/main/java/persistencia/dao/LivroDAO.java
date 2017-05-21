package persistencia.dao;

import entidades.Livro;
import persistencia.jdbc.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by claud on 20/05/2017.
 */
public class LivroDAO {


    private Connection connection = ConexaoFactory.getConnection();

    public void cadastrar(Livro livro){
        String sql = "INSERT INTO livro (nomeDoLivro, numeroDePaginas) VALUES(?,?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, livro.getNomeDoLivro());
            preparedStatement.setInt(2, livro.getNumeroDePaginas());

            preparedStatement.execute();
            preparedStatement.close();

            System.out.println("Cadastrado com sucesso!!");

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void alterar(Livro livro){
        String sql = "UPDATE livro SET nomeDoLivro = ?, numeroDePaginas = ? WHERE id = ?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, livro.getNomeDoLivro());
            preparedStatement.setInt(2, livro.getNumeroDePaginas());
            preparedStatement.setInt(3, livro.getId());

            preparedStatement.execute();
            preparedStatement.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public void salvar(Livro livro){
        if(livro.getId() == null){
            cadastrar(livro);
        }else{
            alterar(livro);
        }
    }

    public void remover(Livro livro){
        String sql = "DELETE livro WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, livro.getId());

            preparedStatement.execute();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public List<Livro> buscarTodos(){
        String sql = "SELECT * FROM livro";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Livro> livroList = new ArrayList<Livro>();

            while(resultSet.next()){
                Livro livro = new Livro();

                livro.setId(resultSet.getInt("id"));
                livro.setNomeDoLivro(resultSet.getString("nomeDoLivro"));
                livro.setNumeroDePaginas(resultSet.getInt("numeroDePaginas"));

                livroList.add(livro);
            }
            return livroList;
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }

    public Livro buscarPorNomeDoLivro(String nomeDoLivro){
        String sql = "SELECT * FROM livro WHERE nomeDoLivro = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, nomeDoLivro);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                Livro livro = new Livro();

                livro.setId(resultSet.getInt("id"));
                livro.setNomeDoLivro(resultSet.getString("nomeDoLivro"));
                livro.setNumeroDePaginas(resultSet.getInt("numeroDePaginas"));

                return livro;
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }
}
