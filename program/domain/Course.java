package domain;  

public class Course extends Program{
    
    private Integer weeks;
    
    public Course(String name, Integer weeks){
        this.name=name;
        this.weeks=weeks;
    }    
    

    @Override
    public int weeks() throws IEMOISException{
       if (weeks == null) throw new IEMOISException(IEMOISException.WEEKS_EMPTY);
       if (weeks < 1) throw new IEMOISException(IEMOISException.WEEKS_ERROR);
       return weeks;
    }
     
    @Override
    public String data(){
        return name+". Semanas:" +weeks;
    }
    
    public String getName(){
        return name;
    }
}
