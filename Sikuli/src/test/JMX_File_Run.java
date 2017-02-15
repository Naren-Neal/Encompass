package test;



import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;

public class JMX_File_Run {

	public static void main(String[] args) throws FindFailed {
		
		//object creation for pattern function
		 org.sikuli.script.Pattern open1= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Windows.PNG");
		 org.sikuli.script.Pattern open_file= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\File.PNG");
		 org.sikuli.script.Pattern open_file1= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Openfile.PNG");
		 org.sikuli.script.Pattern Scripts= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Scripts.PNG");
		 org.sikuli.script.Pattern Scripts_name= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Script_name.PNG");
		 org.sikuli.script.Pattern Run_Script= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Run.PNG");
		
		//Object creation for screen class
		 org.sikuli.script.Screen scr= new org.sikuli.script.Screen();
		    scr.setAutoWaitTimeout(30);
			scr.type(open1, "C:\\apache-jmeter-3.0\\bin\\jmeter.bat");
			scr.type(Key.ENTER);
			scr.setAutoWaitTimeout(60);
			scr.click(open_file);
			scr.click(open_file1);
			scr.setAutoWaitTimeout(60);
			scr.doubleClick(Scripts);
			scr.doubleClick(Scripts_name);
			
			scr.click(Run_Script);
			scr.setAutoWaitTimeout(60);
			
			scr.waitVanish(Run_Script, 200000000);
			System.out.println("Execution over");
			 
		
			
	}

}
 