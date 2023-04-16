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
    public void shouldAdd(){
        IEMOIS ie = new IEMOIS();
        assertTrue(ie.contains(new Course("Aprendiendo a Aprender. MacMaster-California. Coursera", 4)));
        assertTrue(ie.contains(new Course("Introduction to Computer Science and Programming Using Python", 8)));
        try
        {
            ie.addCourse("MATD","16");
        }
        catch (IEMOISException iemoise)
        {
            fail("Threw an exception");
        }
        assertTrue(ie.contains(new Course("MATD", 16)));
        try
        {
            ie.addNanodegree("Ingeniería de Sistemas","360","MATD");
        }
        catch (IEMOISException iemoise)
        {
            fail("Threw an exception");
        }
        assertTrue(ie.contains(new Nanodegree("Ingeniería de Sistemas",360)));
        
    }
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
    @Test
    public void shouldThrowExceptionIfCourseNotRegistred(){
        IEMOIS ie = new IEMOIS();
        try{
            ie.addNanodegree("Ingeniería de Sistemas","5","Programación Orientada a Objetos\nAprendiendo a Aprender. MacMaster-California. Coursera");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.CURSO_NO_REGISTRADO);
        }
        try{
            ie.addNanodegree("Ingeniería de Sistemas","5","Aprendiendo a Aprender. MacMaster-California. Coursera\nProgramación Orientada a Objetosn\nIntroduction to Computer Science and Programming Using Python");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.CURSO_NO_REGISTRADO);
        }
        try{
            ie.addNanodegree("Ingeniería de Sistemas","5","Aprendiendo a Aprender. MacMaster-California. Coursera\nIntroduction to Computer Science and Programming Using Python\nProgramación Orientada a Objetos");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.CURSO_NO_REGISTRADO);
        }
    }
    
    @Test
    public void shouldThrowExceptionIfCourseIsEmpty(){
        IEMOIS ie = new IEMOIS();
        try{
            ie.addCourse("","5");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.CURSO_EMPTY);
        }
    }
    
    @Test
    public void shouldThrowExceptionWhenSearch(){
        IEMOIS ie = new IEMOIS();
        try{
            ie.search("I");
        }catch(Exception e){
            fail("Threw a exception");
        }
    }
    
    public void shouldThrowExceptionIfWeekIsEmpty(){
        IEMOIS ie = new IEMOIS();
        try{
            ie.addCourse("MATD","");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.SEMANA_EMPTY);
        }
        try{
            ie.addNanodegree("Sistemas","","Introduction to Computer Science and Programming Using Python");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.SEMANA_EMPTY);
        }
    }
    
    @Test
    public void shouldThrowExceptionIfWeekIsNegativeOrCero(){
        IEMOIS ie = new IEMOIS();
        try{
            ie.addCourse("MATD","-10");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.SEMANA_INACEPTADA);
        }
        try{
            ie.addCourse("MATD","0");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.SEMANA_INACEPTADA);
        }
        try{
            ie.addNanodegree("Sistemas","-6","Introduction to Computer Science and Programming Using Python");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.SEMANA_INACEPTADA);
        }
        try{
            ie.addNanodegree("Sistemas","0","Introduction to Computer Science and Programming Using Python");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.SEMANA_INACEPTADA);
        }
    }
    
    @Test
    public void shouldThrowExceptionifIsAnSpaceInWeeks(){
        IEMOIS ie = new IEMOIS();
        try{
            ie.addNanodegree("Sistemas","10 20","Introduction to Computer Science and Programming Using Python");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.FORMATO_SEMANA_INAPROPIADO);
        }
        try{
            ie.addNanodegree("Sistemas","10  ","Introduction to Computer Science and Programming Using Python");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(e.getMessage(), IEMOISException.FORMATO_SEMANA_INAPROPIADO);
        }
    }
}
