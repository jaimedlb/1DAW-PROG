package coop.gsd.daw.prog;

/**
 * Esta clase define una serie de metodos que pueden ser usados
 */
public class UtilidadesArrays {

	/**
	 * encuentra el mayor valor del array y devuelve dicho numero
	 * 
	 * @param array donde se va a buscar
	 * @return el numero mayor
	 */
	public static int maximo(int[] array) {

		int aux = 0;
		for (int i = 0; i < array.length; i++) {
			if (aux < array[i]) {
				aux = array[i];
			}
		}
		return aux;
	}

	/**
	 * encuentra el mayor valor del array y devuelve el indice del primero de ellos
	 * 
	 * @param array donde se va a buscar
	 * @return el indice del primero numero mayor
	 */
	public static int maximoIndice(int[] array) {

		int aux = 0;
		int j=0;
		for (int i = 0; i < array.length; i++) {
			if (aux < array[i]) {
				aux = array[i];
				j=i;
			}
		}
		return j;
	}

	/**
	 * encuentra el menor valor del array y devuelve dicho numero
	 * 
	 * @param array donde se va a buscar
	 * @return el numero menor
	 */
	public static int minimo(int[] array) {

		int aux = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] < aux) {
				aux = array[i];
			}
		}
		return aux;
	}

	/**
	 * encuentra el menor valor del array y devuelve el indice del primero de ellos
	 * 
	 * @param array donde se va a buscar
	 * @return el indice del primero numero menor
	 */
	public static int minimoIndice(int[] array) {
		int aux = array[0];
		int j=0;
		for (int i = 0; i < array.length; i++) {
			if (aux > array[i]) {
				aux = array[i];
				j=i;
			}
		}
		return j;
	}

	/**
	 * Calcula la media de valores del array
	 * 
	 * @param array del que se va a calcular la media
	 * @return la media de valores del array
	 */
	public static double media(int[] array) {
		double aux = 0;
		int i = 0;
		for (; i < array.length; i++) {
			aux = aux + array[i];
		}
		aux = aux / i;
		return aux;
	}

	/**
	 * invierte un array 
	 * 
	 * @param array del que se va a tomar los valores
	 * @return devuelve un nuevo array con los valores invertidos
	 */

	public static int[] invertir(int[] array) {
		int[] arrayCopia = new int[array.length];
		for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
			arrayCopia[j] = array[i];
		}

		return arrayCopia;
	}
	/**
	 *  modifica el array invirtiendole
	 * @param array que se va a invertir 
	 */
	public static void invertirArray(int[] array) {
		int[] arrayCopia = new int[array.length];
		for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
			arrayCopia[j] = array[i];
		}
		System.arraycopy(arrayCopia, 0, array, 0, array.length);
		
	}
	/**
	 * crea un nuevo array con cada miembro sumado un factor a partir del array pasado
	 * @param  array del que se va a tomar los valores
	 * @param numeroIncremento numero que va a sumar los valores del array
	 * @return devuelve un array invertido
	 */

	public static int[] incrementar(int[] array, int numeroIncremento) {
		int[] arrayCopia = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			arrayCopia[i] = array[i] + numeroIncremento;
		}
		return arrayCopia;
	}
	/**
	 * modifica el array sumando un factor a cada miembro
	 * @param  array del que se va a tomar los valores
	 * @param numeroIncremento numero que va a sumar los valores del array
	 */
	public static void incrementarArray(int[] array, int numeroIncremento) {

		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = array[i] + numeroIncremento;
		}
	}
}
