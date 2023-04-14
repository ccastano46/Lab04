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
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.NANO_EMPTY,e.getMessage());
        }
        try{
            s.weeks("max");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(IEMOISException.NANO_EMPTY,e.getMessage());
        }
        try{
            s.weeks("min");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(IEMOISException.NANO_EMPTY,e.getMessage());
        }
        try{
            s.weeks("avg");
            fail("Did not throw exception");
        }catch(IEMOISException e){
            assertEquals(IEMOISException.NANO_EMPTY,e.getMessage());
        }
        try{
            s.weeks(10);
            fail("Did not throw exception");
        }catch(IEMOISException e){
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
           int weeks=s.weeks();
            fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.WEEKS_ERROR,e.getMessage());
        }
        try { 
           int weeks=s.weeks(5);
           fail("Did not throw exception");
        } catch (IEMOISException e) {
           assertEquals(IEMOISException.WEEKS_ERROR,e.getMessage());
        }
    }
    
    @Test
    public void shouldNotThrowExceptionIfThereIsErrorInweeksType(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        s.addCourse(new Course("INTRO TO JAVASCRIPT",3));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        s.addCourse(new Course("JAVASCRIPT", -1));
        s.addCourse(new Course("SLQ", 5));
        try { 
           int weeks=s.weeks("max");
           assertEquals(weeks,21);
        } catch (IEMOISException e) {
           fail("Threw a exception");
        }
        try { 
           int weeks=s.weeks("min");
           assertEquals(weeks,15);
        } catch (IEMOISException e) {
           fail("Threw a exception");
        }
        try { 
           int weeks=s.weeks("avg");
           assertEquals(weeks,13);
        } catch (IEMOISException e) {
           fail("Threw a exception");
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
    
    @Test
    public void shouldThrowExceptionIfIsImposibleCalculateType(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 0));
        s.addCourse(new Course("INTRO TO JAVASCRIPT",0));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", 0));
        try { 
           int weeks=s.weeks("max");
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.IMPOSSIBLE,e.getMessage());
        }
        Nanodegree a = new Nanodegree("FRONT END DEVELOPER", 1);
        a.addCourse(new Course("INTRO TO HTML AND CSS", null));
        a.addCourse(new Course("INTRO TO JAVASCRIPT",0));
        a.addCourse(new Course("JAVASCRIPT AND THE DOM", 0));
        try { 
           int weeks=a.weeks("min");
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.IMPOSSIBLE,e.getMessage());
        }
        Nanodegree b = new Nanodegree("FRONT END DEVELOPER", 1);
        b.addCourse(new Course("INTRO TO HTML AND CSS", null));
        b.addCourse(new Course("INTRO TO JAVASCRIPT",0));
        b.addCourse(new Course("JAVASCRIPT AND THE DOM", -3));
        try { 
           int weeks=b.weeks("avg");
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.IMPOSSIBLE,e.getMessage());
        }
    }
    
    @Test
    public void shouldNotThrowExceptionIfweeksIsNotKnown(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        s.addCourse(new Course("INTRO TO JAVASCRIPT",null));
        s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        try { 
           int weeks=s.weeks("max");
           assertEquals(weeks,7);
        } catch (IEMOISException e) {
           fail("Threw a exception");
        }    
        try { 
           int weeks=s.weeks("min");
           assertEquals(weeks,7);
        } catch (IEMOISException e) {
           fail("Threw a exception");
        }
        try { 
           int weeks=s.weeks("avg");
           assertEquals(weeks,3);
        } catch (IEMOISException e) {
           System.out.println(e +"?");
        }
    }
    
    
    
}