package pruebaConexion;

import java.util.Calendar;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConexion {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(1558269126866l);
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		// get Date
		System.out.println(c.getTime());

		
		context.close();

	}

}
