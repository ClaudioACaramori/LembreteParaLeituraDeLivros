package br.com.testejera.service.exception;

/**
 * Created by claud on 23/05/2017.
 */
public class ServiceException extends  Exception{
    private static final long serialVersionUID = 1L;

    public ServiceException(String msg){
        super(msg);
    }
    public ServiceException(String msg, Throwable causa){
        super(msg, causa);
    }
    public ServiceException(Throwable causa){
        super(causa);
    }
}
