package test;
import domain.*;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Write a description of class IEMOISTEST here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IEMOISTEST
{
    @Test
    public void shouldThrowExceptionIfNameAlreadyExists(){
        IEMOIS ie = new IEMOIS();
        try{
            ie.addCourse("Aprendiendo a Aprender. MacMaster-California. Coursera","4");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.PROGRAMA_EXISTENTE);
        }
        try{
            ie.addCourse("Introduction to Computer Science and Programming Using Python","13");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.PROGRAMA_EXISTENTE);
        }
        try{
            ie.addCourse("Databases: Modeling and Theory","5");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.PROGRAMA_EXISTENTE);
        }
        try{
            ie.addCourse("Databases: Relational Databases and SQL","9");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.PROGRAMA_EXISTENTE);
        }
        try{
            ie.addCourse("Databases: MODELING AND TheOry","1");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.PROGRAMA_EXISTENTE);
        }
        try{
            ie.addCourse("Databases: RelatIonal DatabAses and sQL","4");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.PROGRAMA_EXISTENTE);
        }
        try{
            ie.addCourse("Developing Databases. Stanford Online. Edx.", "2");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.PROGRAMA_EXISTENTE);
        }
        try{
            ie.addNanodegree("Databases: RelatIonal DatabAses and sQL", "2","Databases: Advances Topics in SQL\nDatabases: Semistructured Data\nDatabases: Modeling and Theory\nDatabases: Relational Databases and SQL");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.PROGRAMA_EXISTENTE);
        }
    }
    
    @Test
    public void shouldNotThrowExceptionIfNameAlreadyExists(){
        IEMOIS ie = new IEMOIS();
        try{
            ie.addCourse("Programación Orientada a Objetos","16");
            ie.addCourse("Matematicas Discretas","12");
            ie.addCourse("Arquitectura Computacional","5");
            ie.addNanodegree("Ingeniería de Sistemas", "20", "Programación Orientada a Objetos\nMatematicas Discretas\nArquitectura Computacional");
        }catch(IEMOISException e){
            fail("Threw a exception");
        }
    }
    
    
}
