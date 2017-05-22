package persistencia.dao;

/**
 * Created by claud on 22/05/2017.
 */
public class DAOException extends Exception {

    public DAOException(Throwable exception) {
        super(exception);
    }

    public DAOException(String mensagem) {
        super(mensagem);
    }

    public DAOException(String mensagem, Throwable exception) {
        super(mensagem, exception);
    }
}
