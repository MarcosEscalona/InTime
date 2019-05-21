package com.MarcosEscalona.InTime.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.service.IEmpleadoService;

public class Util {
	
	@Autowired
	private static BCryptPasswordEncoder encoder;
	
	public static String calendarToStringDiaMesAnioHoraMinuto(Long timestamp) {
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(timestamp);
		
		return (c.get(Calendar.DAY_OF_MONTH)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR)+" "+c.get(Calendar.HOUR_OF_DAY)+":"+c.get(Calendar.MINUTE));
	}

	public static String calendarToStringDiaMesAnio(Long timestamp) {
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(timestamp);
		
		return (c.get(Calendar.DAY_OF_MONTH)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR));
	}
	
	public static long fechaStringConvertirMilisegundos(String fecha) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = sdf.parse(fecha); 
		long millis = date.getTime();
		
		return millis;
		
	}
	
	
	public static String formatearFecha(String fecha) {
		
		StringBuffer fechaFormateadaB = new StringBuffer();
		
		fechaFormateadaB.insert(0,fecha.charAt(8));

		fechaFormateadaB.insert(1,fecha.charAt(9));

		fechaFormateadaB.insert(2,'/');

		fechaFormateadaB.insert(3,fecha.charAt(5));

		fechaFormateadaB.insert(4,fecha.charAt(6));

		fechaFormateadaB.insert(5,'/');

		fechaFormateadaB.insert(6,fecha.charAt(0));

		fechaFormateadaB.insert(7,fecha.charAt(1));

		fechaFormateadaB.insert(8,fecha.charAt(2));

		fechaFormateadaB.insert(9,fecha.charAt(3));

				
		String fechaFormateada = fechaFormateadaB.toString(); 
	
		return fechaFormateada;
	}
	
	
	public static String encriptaClave(String clave) {
		
		String password = "1234";
		String encriptado = encoder.encode(password);
		System.out.println("Password encriptado: " + encriptado);
		
		return encriptado;
		
	}

	


}
