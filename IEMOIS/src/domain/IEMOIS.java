package domain;


import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * IEMOIS
 * @author POOB  
 * @version ECI 2022
 */

public class IEMOIS{
    private LinkedList<Program> programs;
    private HashMap<String,Course> courses;

    /**
     * Create a IEMOIS
     */
    public IEMOIS(){
        programs = new LinkedList<Program>();
        courses = new HashMap<String,Course>();
        addSome();
    }

    private void addSome(){
        String [][] courses = {{"Aprendiendo a Aprender. MacMaster-California. Coursera","4"},
                               {"Introduction to Computer Science and Programming Using Python","8"},
                               {"Databases: Modeling and Theory","5"},{"Databases: Relational Databases and SQL","5"}, 
                               {"Databases: Advances Topics in SQL","5"},{"Databases: Semistructured Data", "5"},
                               {"Machine Learning","9"}};
        //Se van a añadir clases que no estan repetidas
        for (String [] c: courses){
            try
            {
                addCourse(c[0],c[1]);
            }
            catch (IEMOISException iemoise)
            {
                iemoise.printStackTrace();
            }
        }
        String [][] Nanodegrees = {{"Developing Databases. Stanford Online. Edx.", "2", "Databases: Modeling and Theory\nDatabases: Relational Databases and SQL"},
                                       {"Advanced Topics of Databases. Standford Online. Edx.", "2", "Databases: Advances Topics in SQL\nDatabases: Semistructured Data"}};
        for (String [] s: Nanodegrees){
            try
            {
                addNanodegree(s[0],s[1],s[2]);
            }
            catch (IEMOISException iemoise)
            {
                iemoise.printStackTrace();
            }
        }
    }

    /**
     * Consult a program
     * @param name
     * @return 
     */
    public Program consult(String name){
        Program p=null;
        for(int i=0;i<programs.size() && p == null;i++){
            if (programs.get(i).name().compareToIgnoreCase(name)==0) 
               p=programs.get(i);
        }
        return p;
    }

    
    /**
     * Add a new course
     * @param name, nombre del curso 
     * @param price, numero de semanas que dura el curso
     * @throws CURSO_EXISTENTE, si ya existe un curso con ese nombre
    */
    public void addCourse(String name, String price) throws IEMOISException{ 
        if(name.equals("")) throw new IEMOISException(IEMOISException.CURSO_EMPTY);
        if(price.equals("")) throw new IEMOISException(IEMOISException.SEMANA_EMPTY);
        if(Integer.parseInt(price) <= 0) throw new IEMOISException(IEMOISException.SEMANA_INACEPTADA);
        for(Program p: programs){
            if(p.name().toUpperCase().equals(name.toUpperCase())) throw new IEMOISException(IEMOISException.PROGRAMA_EXISTENTE);
        }
        Course nc=new Course(name,Integer.parseInt(price));
        programs.add(nc);
        courses.put(name.toUpperCase(),nc); 
    }
    
    /**
     * Add a new Nanodegree
     * @param name 
     * @param projectWeeks
     * @param courses
    */
    public void addNanodegree(String name, String projectWeeks, String courses) throws IEMOISException{ 
        for(Program p: programs){
            if(p.name().toUpperCase().equals(name.toUpperCase())) throw new IEMOISException(IEMOISException.PROGRAMA_EXISTENTE);
        }
        if(projectWeeks.equals("")) throw new IEMOISException(IEMOISException.SEMANA_EMPTY);
        if(Integer.parseInt(projectWeeks) <= 0) throw new IEMOISException(IEMOISException.SEMANA_INACEPTADA);
        Nanodegree s = new Nanodegree(name,Integer.parseInt(projectWeeks));
        String [] aCourses= courses.split("\n");
        for (String p : aCourses){
            s.addCourse(this.courses.get(p.toUpperCase()));
        }
        programs.add(s);
    }

    /**
     * Consults the programs that start with a prefix
     * @param  
     * @return 
     */
    public LinkedList<Program> select(String prefix){
        LinkedList <Program> answers=null;
        prefix=prefix.toUpperCase();
        for(int i=0;i<programs.size();i++){
            if(programs.get(i).name().toUpperCase().startsWith(prefix)){
                answers.add(programs.get(i));
            }   
        }
        return answers;
    }


    
    /**
     * Consult selected programs
     * @param selected
     * @return  
     */
    public String data(LinkedList<Program> selected){
        StringBuffer answer=new StringBuffer();
        answer.append(programs.size()+ " programas\n");
        for(Program p : programs) {
            try{
                answer.append(p.data());
                answer.append("\n");
            }catch(IEMOISException e){
                answer.append("**** "+e.getMessage());
            }
        }    
        return answer.toString();
    }
    
    
     /**
     * Return the data of programs with a prefix
     * @param prefix
     * @return  
     */ 
    public String search(String prefix){
        return data(select(prefix));
    }
    
    
    /**
     * Return the data of all programs
     * @return  
     */    
    public String toString(){
        return data(programs);
    }
    
    /**
     * Consult the number of Programs
     * @return 
     */
    public int numberPrograms(){
        return programs.size();
    }

}