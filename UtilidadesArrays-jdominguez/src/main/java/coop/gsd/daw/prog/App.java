package coop.gsd.daw.prog;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(array));
		UtilidadesArrays.invertirArray(array);
		System.out.println(Arrays.toString(array));
	}
}
