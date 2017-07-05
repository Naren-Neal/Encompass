package testjavacode;

import org.testng.IExecutionListener;
import org.testng.annotations.Test;

public class ExecutionListener1  implements IExecutionListener{
  
	    private long startTime;
	   
	    	 
	   
	    	    @Override
	
	    	    public void onExecutionStart() {
	  
	    	        startTime = System.currentTimeMillis();
	 
	    	        System.out.println("TestNG is going to start");    
	
	    	    }
	   
	    	 
	
	    	    @Override
	 
	    	    public void onExecutionFinish() {
	   
	    	        System.out.println("TestNG has finished, took around " + (System.currentTimeMillis() - startTime) + "ms");
	
	    	    }
	  
	    	
  }

