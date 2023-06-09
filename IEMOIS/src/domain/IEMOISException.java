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
    public static final String CURSO_NO_REGISTRADO = "Curso no registrado anteriormente";
    public static final String CURSO_EMPTY = "El curso que se va a registrar no tiene nombre";
    public static final String SEMANA_EMPTY = "El curso o proyecto que se va a registrar no tiene numero de semanas";
    public static final String SEMANA_INACEPTADA = "La semana del curso o proyecto no puede ser un valor negativo o 0 ";
    public static final String SEARCH_EMPTY = "Sin resultados :c";
    public static final String FORMATO_SEMANA_INAPROPIADO = "El formato de semana no es aceptado";
    /**
     * Constructor de la excepcion IMOIS
     */
    public IEMOISException(String message){
        super(message);
    }
    
}
