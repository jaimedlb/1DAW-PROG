package com.gsd.daw.prog;

import java.util.*;

public class Calculos {
	public static Map<String, Integer> calcularnumeroIpsMayorDiez(List<Log> objs) {
		Map<String, Integer> m1 = new HashMap<>();
		for (int i = 0; i < objs.size(); i++) {

			if (m1.containsKey(objs.get(i).getIpAddress())) {
				m1.replace(objs.get(i).getIpAddress(), m1.get(objs.get(i).getIpAddress()) + 1);
			} else {
				m1.put(objs.get(i).getIpAddress(), 1);
			}
		}
		return m1;

	}

	public static Map<String, Integer> numeroStatusCode(List<Log> objs) {
		Map<String, Integer> m1 = new HashMap<>();
		for (int i = 0; i < objs.size(); i++) {

			if (m1.containsKey(objs.get(i).getHttpStatusCode())) {
				m1.replace(objs.get(i).getHttpStatusCode(), m1.get(objs.get(i).getHttpStatusCode()) + 1);
			} else {
				m1.put(objs.get(i).getHttpStatusCode(), 1);
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
}
