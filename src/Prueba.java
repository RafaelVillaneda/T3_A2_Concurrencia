import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
class Ventana extends JFrame{
	ArrayList<String> lista = new ArrayList<String>();
	JTextArea areaTexto1,areaTexto2;
	JScrollPane scroll1,scroll2;
	
	public Ventana() {
		getContentPane().setLayout(new FlowLayout());
		setTitle("Tarea de concurrencia");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for(int i=0; i<10000000; i++) {
			if((int)((Math.random()*2)+1)==1) {
				lista.add("Si");
			}else {
				lista.add("No");
			}
		}
		areaTexto1=new JTextArea(15,15);
		areaTexto1.setBackground(getForeground().cyan);
		
		areaTexto2=new JTextArea(15,15);
		areaTexto2.setBackground(getForeground().GRAY);
		
		areaTexto1.setEditable(false);
		areaTexto2.setEditable(false);
		
		scroll1=new JScrollPane(areaTexto1);
		scroll2=new JScrollPane(areaTexto2);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(scroll1);
		panel.setBorder(BorderFactory.createTitledBorder("Coincidencias 'SI´ "));
		add(panel);
		
		add(new JLabel("     "));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(scroll2);
		panel2.setBorder(BorderFactory.createTitledBorder("Coincidencias 'NO´ "));
		add(panel2);
		
		JProgressBar pg = new JProgressBar(0, 2);
		pg.setValue(0);
		pg.setStringPainted(true);
		pg.setString("En espera...");
		
		JProgressBar pg2 = new JProgressBar(0, 2);
		pg2.setValue(0);
		pg2.setStringPainted(true);
		pg2.setString("En espera...");
		/*
		Llenado llenado=new Llenado(lista, areaTexto1, areaTexto2, pg,pg2);
		Thread hiloLlenado=new Thread(llenado);
		hiloLlenado.start();
		*/
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.setPreferredSize(new Dimension(200,250));
		panel3.add(new JLabel("Concidencias Si"));
		panel3.add(pg);
		panel3.add(new JLabel("Concidencias NO"));
		panel3.add(pg2);
		add(panel3);
		
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	
	}
}
public class Prueba {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Ventana();
				
			}
		});

	}

}
