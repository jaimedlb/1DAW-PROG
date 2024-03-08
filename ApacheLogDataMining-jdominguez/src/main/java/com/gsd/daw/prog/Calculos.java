package com.gsd.daw.prog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculos {
	public static Map<String, Integer> calcularnumeroIpsMayorDiez(List<Log> objs) {
		Map<String, Integer> m1 = new HashMap<>();
		for (int i = 0; i < objs.size(); i++) {

			if (m1.containsKey(objs.get(i).getIp())) {
				m1.replace(objs.get(i).getIp(), m1.get(objs.get(i).getIp()) + 1);
			} else {
				m1.put(objs.get(i).getIp(), 1);
			}
		}
		return m1;

	}

	public static Map<String, Integer> numeroStatusCode(List<Log> objs) {
		Map<String, Integer> m1 = new HashMap<>();
		for (int i = 0; i < objs.size(); i++) {

			if (m1.containsKey(objs.get(i).getResult())) {
				m1.replace(objs.get(i).getResult(), m1.get(objs.get(i).getResult()) + 1);
			} else {
				m1.put(objs.get(i).getResult(), 1);
			}
		}
		return m1;
	}
	public static Map<String, Integer> numeroDeHoras(List<Log> objs)throws IndexOutOfBoundsException {
		Map<String, Integer> m1 = new HashMap<>();
		for (int i = 0; i < objs.size(); i++) {
			String[] valores= objs.get(i).getTimeStamp().split(":");
			if (m1.containsKey(valores[1])) {
				m1.replace(valores[1], m1.get(valores[1]) + 1);
			} else {
				m1.put(valores[1], 1);
			}
		}
		
		return m1;
	}
	public static Map<String, Integer> numeroBytesMes(List<Log> objs)throws IndexOutOfBoundsException {
		Map<String, Integer> m1 = new HashMap<>();
		for (int i = 0; i < objs.size(); i++) {
			String[] valores= objs.get(i).getTimeStamp().split("\\/|\\:");
			if (m1.containsKey(valores[1]+" "+valores[2])) {
				m1.replace(valores[1]+" "+valores[2], m1.get(valores[1]+" "+valores[2]) + objs.get(i).getBytes());
			} else {
				m1.put(valores[1]+" "+valores[2], objs.get(i).getBytes());
			}
		}
		
		return m1;
	}
	public static void imprimirIps(Map<String, Integer> m1) {

		m1.forEach((String, Integer) -> {
			Integer cant = Integer;
			String valor = String;
			if (cant >= 10) {
				System.out.println(valor + ": " + cant);
			}

		});
		System.out.println();
	}
	public static void imprimirResult(Map<String, Integer> m1) {

		m1.forEach((String, Integer) -> {
			Integer cant = Integer;
			String valor = String;
			System.out.println(valor + ": " + cant);

		});
		System.out.println();
	}
	public static void imprimirHoras(Map<String, Integer> m1) {

		m1.forEach((String, Integer) -> {
			Integer cant = Integer;
			String valor = String;
			System.out.println( java.lang.Integer.parseInt(valor)+ " H: " + cant);

		});
		System.out.println();
	}
	public static void imprimirBytesMensuales(Map<String, Integer> m1) {

		m1.forEach((String, Integer) -> {
			Integer cant = Integer;
			String valor = String;
			System.out.println( valor+ ": " + cant+" B");

		});
System.out.println();
	}

}
