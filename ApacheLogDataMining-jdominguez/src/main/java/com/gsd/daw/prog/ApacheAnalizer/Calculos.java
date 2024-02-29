package com.gsd.daw.prog.ApacheAnalizer;

import java.util.List;

public class Calculos {
public static void numeroIps(List<Log> objs) {
	for (int i = 0; i < objs.size(); i++) {
		objs.get(i).getIp();
	}
}
}
