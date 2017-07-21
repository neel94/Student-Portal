package Controller;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class loginDAOTest {
	static String username;
	static String pass;
	static String c;
	static loginDAO sc;
	@BeforeClass
	public static void setUp() throws Exception {
		// TODO Auto-generated method stub
		//All set up activity goes here. e.g. setup db connections etc.
		sc = new loginDAO();
		username = "neel";
		pass="patel";
		c="Bond";
	}
	@Test
	public void testValidateStaff() {
		boolean ok = loginDAO.validateStaff(username, pass);
		Assert.assertEquals(false, ok);
	}

	@Test
	public void testValidateFaculty() {
		boolean ok = loginDAO.validateFaculty(username, pass);
		Assert.assertEquals(false, ok);
	}
	
	@Test
	public void checkres(){
		boolean ok = loginDAO.checkres(username,pass,c);
		Assert.assertEquals(false, ok);
	}

}
