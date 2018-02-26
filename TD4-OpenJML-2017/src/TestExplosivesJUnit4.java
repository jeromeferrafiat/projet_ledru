import static org.junit.Assert.*;

import org.jmlspecs.utils.JmlAssertionError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestExplosivesJUnit4 {

    static int nb_inconclusive = 0;
    static int nb_fail = 0;

    Explosives e = new Explosives();

    public static void main(String args[]) {
    	String testClass = "TestExplosivesJUnit4";
     	org.junit.runner.JUnitCore.main(testClass);
     }


    private void handleJMLAssertionError(JmlAssertionError e) {
    	if (e.getClass().equals(JmlAssertionError.PreconditionEntry.class)) {
    	    System.out.println("\n INCONCLUSIVE "+(new Exception().getStackTrace()[1].getMethodName())+ "\n\t "+ e.getMessage());
            nb_inconclusive++;}
    else{
	    // test failure	
	    nb_fail++;
	    fail("\n\t" + e.getMessage());	
		}  
    }
	
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nb_inconclusive = 0;
		nb_fail = 0;
		org.jmlspecs.utils.Utils.useExceptions = true;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	     System.out.println("\n inconclusive tests: "+nb_inconclusive+" -- failures : "+nb_fail );
	}
	
	@Test
	public void  testSequence_0() {
		try{
			e=new Explosives();
			e.add_incomp("Prod_Nitro","Prod_Glycerine");
			e.add_incomp("Prod_Dyna","Prod_Mite");
			e.add_assign("Bat_1","Prod_Dyna");
			e.add_assign("Bat_1","Prod_Nitro");
			e.add_assign("Bat_2","Prod_Mite");
			e.add_assign("Bat_1","Prod_Glycerine");
		} 	catch(JmlAssertionError e){
				handleJMLAssertionError(e);		
		}  
	}

	//test de prop1
	@Test
	public void testprop1(){
		try {
			e=new Explosives();
			for(int i=0; i<=25; i++) {
				e.add_incomp("Prod_" + i, "Prod_" + i + "a");
			}
		} catch(JmlAssertionError e) {
			handleJMLAssertionError(e);
		}
	}

	//test de prop2
	@Test
	public void testprop2(){
		try {
			e = new Explosives();
			for(int i=0; i<=30; i++) {
				e.add_assign("Bat_" + i, "Prod_" + i);
			}
		} catch(JmlAssertionError e) {
			handleJMLAssertionError(e);
		}
	}

	//test de prop3
	@Test
	public void testprop3(){
		try {
			e = new Explosives();
			e.add_incomp("Prod_a", "Prod_b");
			e.add_incomp("Prod_c", "Prod_d");
			e.add_incomp("Bat_a", "Prod_e");
		} catch(JmlAssertionError e) {
			handleJMLAssertionError(e);
		}
	}

	//test de prop4
	@Test
	public void testprop4(){
		try {
			e = new Explosives();
			e.add_assign("Bat_a", "Prod_a");
			e.add_assign("Bat_b", "Prod_b");
			e.add_assign("Prod_c", "Bat_c");
		} catch(JmlAssertionError e) {
			handleJMLAssertionError(e);
		}
	}

	//test de prop5
	@Test
	public void testprop5(){
		try {
			e = new Explosives();
			e.add_incomp("Prod_a", "Prod_b");
			e.add_incomp("Prod_c", "Prod_d");
			e.add_incomp("Prod_e", "Prod_e");
		} catch(JmlAssertionError e) {
			handleJMLAssertionError(e);
		}
	}

	//test de prop7
	@Test
	public void testprop7(){
		try{
			e=new Explosives();
			e.add_incomp("Prod_Nitro","Prod_Glycerine");
			e.add_incomp("Prod_Dyna","Prod_Mite");
			e.add_assign("Bat_1","Prod_Dyna");
			e.add_assign("Bat_1","Prod_Nitro");
			e.add_assign("Bat_2","Prod_Mite");
			e.add_assign("Bat_1","Prod_Glycerine");
		} 	catch(JmlAssertionError e){
				handleJMLAssertionError(e);		
		}  
	}
	
	//test de prop9
	@Test
	public void testprop9(){
		try{
			e=new Explosives();
			e.add_assign("Bat_1","Prod_Dyna");
			e.add_assign("Bat_2","Prod_Dyna");
			e.add_assign("Bat_3","Prod_Dyna");
			e.add_assign("Bat_4","Prod_Dyna");
			e.add_assign("Bat_1","Prod_Glycerine");
		} 	catch(JmlAssertionError e){
				handleJMLAssertionError(e);		
		}  
	}
}
