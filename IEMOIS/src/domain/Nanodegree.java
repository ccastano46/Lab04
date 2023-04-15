package domain;  
import java.util.*;

public class Nanodegree extends Program{
   

    private int projectWeeks;    
    private ArrayList<Course> courses;
    
    /**
     * Constructs a new nanodegree
     * @param name 
     * @param discount 
     */
    public Nanodegree(String name, int projectWeeks){
        this.name=name;
        this.projectWeeks=projectWeeks;
        courses= new ArrayList<Course>();
    }


     /**
     * Add a new course
     * @param c
     */   
    public void addCourse(Course c) throws IEMOISException{
        if(c==null) throw new IEMOISException(IEMOISException.CURSO_NO_REGISTRADO);
        courses.add(c);
    }
       
 
    
    /**
     * Función que calcula el numero de semanas totales destinadas para el proyecto
     * @return  todas las semanas para los cursos + semanas del proyecto.
     * @throws IEMOISException WEEK_EMPTY si el valor del numero de semanas de un curso es nulo. WEEK_ERROR si, el valor del numero de semanas de un curso es < 1. 
     * NANO_EMPTY, if it don't have courses.
     */
    @Override
    public int weeks() throws IEMOISException{
        if(courses.size() == 0) throw new IEMOISException(IEMOISException.NANO_EMPTY); 
        int weeks = projectWeeks;
        for(Course c : courses){
            weeks += c.weeks();
        }
        return weeks;
    }
    
    
     /**
     * Calculates an estimate of weeks
     * For courses where the weeks cannot be known or has error, the max, min or avg  of the known courses is assumed
     * @param type (max,min,avg) 
     * @return todas las semanas para los cursos + semanas del proyecto.
     * @throws IEMOISException NANO_EMPTY, if it don't have courses. IMPOSSIBLE, if it can't be calculated
     */
    public int weeks(String type) throws IEMOISException{
        int weeks = projectWeeks;
        int max = 0;
        double min = Double.POSITIVE_INFINITY;
        int suma = 0;
        int semanasAceptadas = 0;
        if(courses.size() == 0) throw new IEMOISException(IEMOISException.NANO_EMPTY);
        for(Course c : courses){
            try{
                suma += c.weeks();
                semanasAceptadas++;
                if(type.equals("max")){
                    if(c.weeks() > max) max = c.weeks();
                }else if(type.equals("min")){
                    if((double) c.weeks() < min) min = c.weeks();
                }
            }catch(IEMOISException e){
                e.printStackTrace();
            }
        }
        if(semanasAceptadas == 0) throw new IEMOISException(IEMOISException.IMPOSSIBLE);
        suma = (int) suma/semanasAceptadas;
        for(Course c : courses){
            try{
                weeks += c.weeks();
            }catch(IEMOISException e){
                if(type.equals("max")){
                    weeks += max;
                }else if(type.equals("min")){
                    weeks += min;
                }else{
                    weeks += suma;
                }
            }
        }
        return weeks;
    }   
    
    
     /**
     * Calculates an estimate of weeks
     * For courses where the weeks cannot be known, unknown is assumed
     * @param unknown 
     * @return todas las semanas para los cursos + semanas del proyecto.
     * @throws IEMOISException NANO_EMPTY, if it don't have courses. WEEKS_ERROR, if some course has error
     */
    public int weeks(int unknown) throws IEMOISException{
        int weeks = projectWeeks;
        if(courses.size() == 0) throw new IEMOISException(IEMOISException.NANO_EMPTY);
        for(Course c : courses){
            try{
                weeks += c.weeks();
            }catch(IEMOISException e){
                if(IEMOISException.WEEKS_ERROR.equals(e.getMessage())){
                    throw new IEMOISException(IEMOISException.WEEKS_ERROR);
                }else{
                    weeks += unknown;
                }
            }
        }
        return weeks;
    } 
    
    @Override
    public String data() throws IEMOISException{
        StringBuffer answer=new StringBuffer();
        answer.append(name+". Proyecto: "+ projectWeeks);
        for(Course c: courses) {
            answer.append("\n\t"+c.data());
        }
        return answer.toString();
    } 
    


    
    

}
