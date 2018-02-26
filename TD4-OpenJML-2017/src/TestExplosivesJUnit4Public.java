import static org.junit.Assert.*;

import org.jmlspecs.utils.JmlAssertionError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestExplosivesJUnit4Public {

    static int nb_inconclusive = 0;
    static int nb_fail = 0;

    Explosives e = new Explosives();

    public static void main(String args[]) {
    	String testClass = "TestExplosivesJUnit4Public";
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
	
	//test de prop6
		@Test
		public void testprop6(){
			try {
				e = new Explosives();
				e.add_incomp("Prod_a", "Prod_b");
				e.add_incomp("Prod_c", "Prod_d");
				e.nb_inc--;
				e.incomp[e.nb_inc][0] = "";
				e.incomp[e.nb_inc][1] = "";
				e.skip();
			} catch(JmlAssertionError e) {
				handleJMLAssertionError(e);
			}
		}

}
