package test;
import domain.*;


import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class NanodegreeTest{
   
    
    public NanodegreeTest(){
    }


    @Before
    public void setUp(){    
    }

    @After
    public void tearDown(){
    }
    
 
    @Test
    public void shouldCalculateTheCostOfANanodegree(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        s.addCourse(new Course("INTRO TO JAVASCRIPT", 3));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", 2));
        try {
           assertEquals(8,s.weeks());
           assertEquals(8,s.weeks("max"));
           assertEquals(8,s.weeks("min"));
           assertEquals(8,s.weeks("avg"));
        } catch (IEMOISException e){
            fail("Threw a exception");
        }    
    }    
    
    @Test
    public void shouldThrowExceptionIfNanodegreeHasNoCourses(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 10);
        try { 
           int weeks=s.weeks();
           s.weeks("max");
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.NANO_EMPTY,e.getMessage());
        }    
    }    
    
    
   @Test
    public void shouldThrowExceptionIfThereIsErrorInweeks(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        s.addCourse(new Course("INTRO TO JAVASCRIPT",3));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        try { 
           int weeks=s.weeks();
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.WEEKS_ERROR,e.getMessage());
        }    
    }
    
    @Test
    public void shouldThrowExceptionIfThereIsErrorInweeksType(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        s.addCourse(new Course("INTRO TO JAVASCRIPT",3));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        try { 
           assertEquals(9,s.weeks("max"));
           assertEquals(8,s.weeks("min"));
           assertEquals(7,s.weeks("avg"));
        } catch (IEMOISException e) {
            fail("Did not throw exception");
        }    
    }
    
   @Test
    public void shouldThrowExceptionIfweeksIsNotKnown(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        s.addCourse(new Course("INTRO TO JAVASCRIPT",null));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        try { 
           int weeks=s.weeks();
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.WEEKS_EMPTY,e.getMessage());
        }    
    }  
    
    
    
}