
public class Las5Puertas {

	// Número de filas y columnas
	public static final int N = 10;
	/*
	 * Las celdas tendrán "X" para jugador 1, "O" para jugador 2
	 * y comenzará n con un valor de "".
	 */
	
	public static String[][] tablero = new String[N][N];
	//Si está a false juega el jugador2, a true es el turno del jugador1
	public static boolean jugador1 = true; 

	
	
	/**
	 * Crea un nuevo tablero.
	 * 
	 */
	
	static public void nuevoTablero() {

		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				tablero[i][j] ="";
			}
		}

	}

	/**
	 * 
	 * El jugador actual juega. Si elige una casilla ya utilizada no se produce ninguna acción 
	 * 
	 * @param fila
	 * @param columna
	 */
	
	static public void juega( int fila, int columna) {
		
		if (jugador1) {
			if (tablero[fila][columna].equals("")) {
				tablero[fila][columna]= "X";
			}
		} else {
			if (tablero[fila][columna].equals("")) {
				tablero[fila][columna]= "O";
			}
		}
			
		jugador1 = !jugador1;
		
	}
	
	/** 
	 * Comprueba si hay 5 X en línea
	 * 
	 * @param tablero
	 * @return
	 */
	static boolean haGanadoJugador1() {
		
		boolean haganado = false;
		for(int fila =0; fila<N; fila++) {
			for (int columna=0; columna<N-4;columna++) {
				if (tablero[fila][columna].equals("X") && tablero[fila][columna+1].equals("X")&&tablero[fila][columna+2].equals("X")&&tablero[fila][columna+3].equals("X")&&tablero[fila][columna+4].equals("X")){
					haganado = true;
				}
			}
		}
		
		for(int fila =0; fila<N-4; fila++) {
			for (int columna=0; columna<N;columna++) {
				if (tablero[fila][columna].equals("X") && tablero[fila+1][columna].equals("X")&&tablero[fila+2][columna].equals("X")&&tablero[fila+3][columna].equals("X")&&tablero[fila+4][columna].equals("X")){
					haganado = true;
				}
			}
		}

		for(int fila =0; fila<N-4; fila++) {
			for (int columna=0; columna<N-4;columna++) {
				if (tablero[fila][columna].equals("X") && tablero[fila+1][columna+1].equals("X")&&tablero[fila+2][columna+2].equals("X")&&tablero[fila+3][columna+3].equals("X")&&tablero[fila+4][columna+4].equals("X")){
					haganado = true;
				}
			}
		}
		
		for(int fila =4; fila<N; fila++) {
			for (int columna=0; columna<N-4;columna++) {
				if (tablero[fila][columna].equals("X") && tablero[fila-1][columna+1].equals("X")&&tablero[fila-2][columna+2].equals("X")&&tablero[fila-3][columna+3].equals("X")&&tablero[fila-4][columna+4].equals("X")){
					haganado = true;
				}
			}
		}
		
		
		return haganado;
	}
	/** 
	 * Comprueba si hay 5 O en línea
	 * 
	 * @param tablero
	 * @return
	 */
	static boolean haGanadoJugador2() {
		boolean haganado = false;
		for(int fila =0; fila<N; fila++) {
			for (int columna=0; columna<N-4;columna++) {
				if (tablero[fila][columna].equals("O") && tablero[fila][columna+1].equals("O")&&tablero[fila][columna+2].equals("O")&&tablero[fila][columna+3].equals("O")&&tablero[fila][columna+4].equals("O")){
					haganado = true;
				}
			}
		}
		
		for(int fila =0; fila<N-4; fila++) {
			for (int columna=0; columna<N;columna++) {
				if (tablero[fila][columna].equals("O") && tablero[fila+1][columna].equals("O")&&tablero[fila+2][columna].equals("O")&&tablero[fila+3][columna].equals("O")&&tablero[fila+4][columna].equals("O")){
					haganado = true;
				}
			}
		}

		for(int fila =0; fila<N-4; fila++) {
			for (int columna=0; columna<N-4;columna++) {
				if (tablero[fila][columna].equals("O") && tablero[fila+1][columna+1].equals("O")&&tablero[fila+2][columna+2].equals("O")&&tablero[fila+3][columna+3].equals("O")&&tablero[fila+4][columna+4].equals("O")){
					haganado = true;
				}
			}
		}
		
		for(int fila =4; fila<N; fila++) {
			for (int columna=0; columna<N-4;columna++) {
				if (tablero[fila][columna].equals("O") && tablero[fila-1][columna+1].equals("O")&&tablero[fila-2][columna+2].equals("O")&&tablero[fila-3][columna+3].equals("O")&&tablero[fila-4][columna+4].equals("O")){
					haganado = true;
				}
			}
		}
	return haganado;
		
	}
	/** 
	 * Si todas las celdas tienen un valor y nadie ha hecho
	 *  5 en raya entonces se establece el empate
	 * @param tablero
	 * @return
	 */
	static public boolean hanEmpatado() {
		boolean empate = true;
		for(int fila =0; fila<N; fila++) {
			for (int columna=0; columna<N;columna++) {
				if (!tablero[fila][columna].equals("") ){
					empate = false;
				}
			}
		}
		return empate && !haGanadoJugador1() && !haGanadoJugador2();
	}
	
}
