package com.MarcosEscalona.InTime.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.MarcosEscalona.InTime.model.Fichaje;
import com.MarcosEscalona.InTime.service.IEmpleadoService;

public class Util {
	
	
	
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
	
	
	


}
