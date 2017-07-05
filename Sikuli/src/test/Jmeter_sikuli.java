package test;


import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;



public class Jmeter_sikuli {

	public static void main(String[] args) throws FindFailed {
		
         
        org.sikuli.script.Pattern open1= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Windows.PNG");
        org.sikuli.script.Pattern test_plan= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Test_plan.PNG");
        org.sikuli.script.Pattern Add= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Add.PNG");
        org.sikuli.script.Pattern Thread_user= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Thread_users.PNG");
        org.sikuli.script.Pattern Thread_Group= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Thread_group.PNG");
        org.sikuli.script.Pattern Workbench1= new org.sikuli.script.Pattern("C:\\Users\\narendra\\Desktop\\test\\Workbench.PNG");
        org.sikuli.script.Screen scr= new org.sikuli.script.Screen();
		
		scr.setAutoWaitTimeout(30);
		scr.type(open1, "C:\\apache-jmeter-3.0\\bin\\jmeter.bat");
		scr.type(Key.ENTER);
		scr.setAutoWaitTimeout(60);
		scr.rightClick(test_plan);
		scr.mouseMove(Add);
		scr.mouseMove(Thread_user);
		scr.click(Thread_Group);
		scr.setAutoWaitTimeout(60);
		scr.rightClick(Workbench1);
		
		
		
	}

}
 