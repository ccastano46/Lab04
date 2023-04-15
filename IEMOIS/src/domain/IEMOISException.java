package domain;


/**
 * Clase para manejo de excepciones dentro de nuestro programa IMOIS
 *
 * @author (Castaño - Camargo)
 * @version (31/03/2023)
 */
public class IEMOISException extends Exception
{
    public static final String WEEKS_EMPTY = "Empty";
    public static final String WEEKS_ERROR = "Error";
    public static final String NANO_EMPTY = "NANO_EMPTY";
    public static final String IMPOSSIBLE = "IMPOSSIBLE";
    public static final String PROGRAMA_EXISTENTE = "Ya existe un programa con ese nombre";
    public static final String CURSO_NO_REGISTRADO = "curso no registrado anteriormente";
    public static final String CURSO_EMPTY = "El curso que se va a registrar no tiene nombre";

    
    /**
     * Constructor de la excepcion IMOIS
     */
    public IEMOISException(String message){
        super(message);
    }
    
}