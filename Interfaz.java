import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;


public class Interfaz {


	private final List<JButton> listaBotones = new ArrayList<JButton>();


	private JButton getGridButton(int r, int c) {
		int index = r * Las5Puertas.N + c;
		return listaBotones.get(index);
	}

	private JButton createGridButton(final int fila, final int col) {



		final JButton b = new JButton("      ");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean restart = false;
				JButton gb = Interfaz.this.getGridButton(fila, col);
				Las5Puertas.juega(fila, col);

				if (Las5Puertas.tablero[fila][col].equals("X")){
					gb.setText("X");
					gb.setBackground(Color.RED);
					gb.setEnabled(false);

				} else if(Las5Puertas.tablero[fila][col].equals("O")){
					gb.setText("O");
					gb.setBackground(Color.BLUE);
					gb.setEnabled(false);


				}

				if (Las5Puertas.haGanadoJugador1()) {
					JOptionPane.showMessageDialog(null,"Ha ganado el jugador 1","Fin de la partida",1);
					restart = true;

				}  else if (Las5Puertas.haGanadoJugador2()) {

					JOptionPane.showMessageDialog(null,"Ha ganado el jugador 2","Fin de la partida",1);
					restart = true;

				} else if (Las5Puertas.hanEmpatado()) {
					JOptionPane.showMessageDialog(null,"¡Empate!", "Fin de la partida", 1);
					restart = true;


				}
				

				if (restart) {
					Las5Puertas.nuevoTablero(); 
					JFrame frame = (JFrame) SwingUtilities.getRoot(b);
					frame.dispose();
					new Interfaz().display();
	
				}

			}
		});
		return b;
	}

	private JPanel createGridPanel() {
		JPanel p = new JPanel(new GridLayout(Las5Puertas.N, Las5Puertas.N));
		for (int i = 0; i < Las5Puertas.N * Las5Puertas.N; i++) {
			int row = i / Las5Puertas.N;
			int col = i % Las5Puertas.N;
			JButton gb = createGridButton(row, col);
			listaBotones.add(gb);
			p.add(gb);
		}
		return p;
	}

	private void display() {
		JFrame f = new JFrame("- Las 5 Puertas -");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(createGridPanel());
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}



	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {


			@Override
			public void run() {
				Las5Puertas.nuevoTablero();
				JOptionPane.showMessageDialog(null,"Completa 5 en línea"," - Las 5 Puertas - ",1);
				new Interfaz().display();
			}
		});
	}
}