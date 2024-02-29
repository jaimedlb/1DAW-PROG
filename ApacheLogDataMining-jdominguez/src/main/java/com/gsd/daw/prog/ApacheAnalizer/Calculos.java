package com.gsd.daw.prog.ApacheAnalizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculos {
	public static void numeroIps(List<Log> objs) {
		Map<String, Integer> m1 = new HashMap<>();
		for (int i = 0; i < objs.size(); i++) {

			if (m1.containsKey(objs.get(i).getIp())) {
				m1.replace(objs.get(i).getIp(), m1.get(objs.get(i).getIp()) + 1);
			}
			else {
				m1.put(objs.get(i).getIp(), 1);
			}
		}
		imprimirIp(m1);
	}

	private static void imprimirIp(Map<String, Integer> m1) {

m1.forEach((String, Integer)->{
	Integer cant=Integer;
	String ip = String;
	if (cant>=10) {
		System.out.println(ip+": "+cant);	}
	
});
		
	}
	
	
}
