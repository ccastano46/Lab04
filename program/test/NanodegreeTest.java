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
        try
        {
            s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("INTRO TO JAVASCRIPT", 3));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("JAVASCRIPT AND THE DOM", 2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try {
           assertEquals(8,s.weeks());
           assertEquals(8,s.weeks("max"));
           assertEquals(8,s.weeks("min"));
           assertEquals(8,s.weeks("avg"));
        } catch (IEMOISException e){
            fail("Threw a exception");
        }    
        Nanodegree a = new Nanodegree("FRONT END DEVELOPER", 1);
        try
        {
            a.addCourse(new Course("INTRO TO HTML AND CSS", null));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            a.addCourse(new Course("INTRO TO JAVASCRIPT", 3));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            a.addCourse(new Course("JAVASCRIPT AND THE DOM", 2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try {
           assertEquals(8,a.weeks(2));
           assertEquals(10,a.weeks(4));
           assertEquals(15,a.weeks(9));
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
        try
        {
            s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("INTRO TO JAVASCRIPT",3));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try { 
           int weeks=s.weeks();
           int weeks2 = s.weeks(5);
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.WEEKS_ERROR,e.getMessage());
        }    
    }
    
    @Test
    public void shouldThrowExceptionIfThereIsErrorInweeksType(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        try
        {
            s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("INTRO TO JAVASCRIPT",3));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
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
        try
        {
            s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("INTRO TO JAVASCRIPT",3));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("JAVASCRIPT", -1));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("SLQ", 5));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
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
           assertEquals(weeks,17);
        } catch (IEMOISException e) {
           fail("Threw a exception");
        }
        
    }
    
   @Test
    public void shouldThrowExceptionIfweeksIsNotKnown(){
        Nanodegree s = new Nanodegree("FRONT END DEVELOPER", 1);
        try
        {
            s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("INTRO TO JAVASCRIPT",null));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
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
        try
        {
            s.addCourse(new Course("INTRO TO HTML AND CSS", 0));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("INTRO TO JAVASCRIPT",0));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("JAVASCRIPT AND THE DOM", 0));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try { 
           int weeks=s.weeks("max");
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.IMPOSSIBLE,e.getMessage());
        }
        Nanodegree a = new Nanodegree("FRONT END DEVELOPER", 1);
        try
        {
            a.addCourse(new Course("INTRO TO HTML AND CSS", null));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            a.addCourse(new Course("INTRO TO JAVASCRIPT",0));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            a.addCourse(new Course("JAVASCRIPT AND THE DOM", 0));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try { 
           int weeks=a.weeks("min");
           fail("Did not throw exception");
        } catch (IEMOISException e) {
            assertEquals(IEMOISException.IMPOSSIBLE,e.getMessage());
        }
        Nanodegree b = new Nanodegree("FRONT END DEVELOPER", 1);
        try
        {
            b.addCourse(new Course("INTRO TO HTML AND CSS", null));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            b.addCourse(new Course("INTRO TO JAVASCRIPT",0));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            b.addCourse(new Course("JAVASCRIPT AND THE DOM", -3));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
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
        try
        {
            s.addCourse(new Course("INTRO TO HTML AND CSS", 2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("INTRO TO JAVASCRIPT",null));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
        try
        {
            s.addCourse(new Course("JAVASCRIPT AND THE DOM", -2));
        }
        catch (IEMOISException iemoise)
        {
            iemoise.printStackTrace();
        }
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
           assertEquals(weeks,7);
        } catch (IEMOISException e) {
           fail(e.getMessage());
        }
    }
    
    
    
}