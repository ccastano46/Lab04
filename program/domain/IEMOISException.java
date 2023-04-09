package domain;


/**
 * Clase para manejo de excepciones dentro de nuestro programa IMOIS
 *
 * @author (Castaño - Camargo)
 * @version (31/03/2023)
 */
public class IEMOISException extends Exception
{
    public static final String WEEKS_EMPTY = "";
    public static final String WEEKS_ERROR = "";
    public static final String NANO_EMPTY = "";
    public static final String IMPOSSIBLE = "";
    
    /**
     * Constructor de la excepcion IMOIS
     */
    public IEMOISException(String message){
        super(message);
    }
}
