import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Principal extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -638700231594027781L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPos01;
	private JTextField txtPos02;
	private JTextField txtPos03;
	private JTextField txtPos04;
	private JTextField txtPos05;
	private JTextField txtPos06;
	private JTextField txtPos07;
	private JTextField txtPos08;
	private JTextField txtPos09;
	
	private JTextField txtRef01;
	private JTextField txtRef02;
	private JTextField txtRef03;
	private JTextField txtRef04;
	private JTextField txtRef05;
	private JTextField txtRef06;
	private JTextField txtRef07;
	private JTextField txtRef08;
	private JTextField txtRef09;

	private Integer[] arrayNumero= new Integer[9];
	private String[] arrayAleatorio= new String[9];
	private String[] arrayReferencia= new String[9];
	private String[] arrayAlfabeto= {"A","B","C","D","E","F","G","H"," "};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Principal() {
		setTitle("Busca em Largura - Quebra cabe\u00E7a 8 pe\u00E7as");
		setBounds(100, 100, 761, 373);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblQuebraCabea = new JLabel("MODELO ALEAT\u00D3RIO");
			lblQuebraCabea.setForeground(new Color(0, 0, 0));
			lblQuebraCabea.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuebraCabea.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblQuebraCabea.setBounds(20, 11, 179, 25);
			contentPanel.add(lblQuebraCabea);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 36, 179, 154);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		txtPos01 = new JTextField();
		txtPos01.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPos01.setBounds(10, 11, 45, 35);
		panel.add(txtPos01);
		txtPos01.setColumns(10);
		
		txtPos02 = new JTextField();
		txtPos02.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPos02.setColumns(10);
		txtPos02.setBounds(65, 12, 45, 34);
		panel.add(txtPos02);
		
		txtPos03 = new JTextField();
		txtPos03.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPos03.setColumns(10);
		txtPos03.setBounds(122, 12, 45, 34);
		panel.add(txtPos03);
		
		txtPos04 = new JTextField();
		txtPos04.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPos04.setColumns(10);
		txtPos04.setBounds(10, 57, 45, 35);
		panel.add(txtPos04);
		
		txtPos05 = new JTextField();
		txtPos05.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPos05.setColumns(10);
		txtPos05.setBounds(65, 58, 45, 34);
		panel.add(txtPos05);
		
		txtPos06 = new JTextField();
		txtPos06.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPos06.setColumns(10);
		txtPos06.setBounds(122, 58, 45, 34);
		panel.add(txtPos06);
		
		txtPos07 = new JTextField();
		txtPos07.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPos07.setColumns(10);
		txtPos07.setBounds(10, 103, 45, 36);
		panel.add(txtPos07);
		
		txtPos08 = new JTextField();
		txtPos08.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPos08.setColumns(10);
		txtPos08.setBounds(65, 104, 45, 35);
		panel.add(txtPos08);
		
		txtPos09 = new JTextField();
		txtPos09.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPos09.setColumns(10);
		txtPos09.setBounds(122, 104, 45, 35);
		panel.add(txtPos09);
		
		JButton btnSortearAleatorio = new JButton("");
		btnSortearAleatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				arrayNumero= Principal.sortearNumeros();
				for (int i = 0; i < arrayNumero.length; i++) {
					if ( arrayNumero[i] == 0 ) {
						arrayAleatorio[i] = " ";
					} else {
						arrayAleatorio[i] = arrayAlfabeto[ arrayNumero[i] - 1 ];
					}
				}
				
				txtPos01.setText( arrayAleatorio[0] );
				txtPos02.setText( arrayAleatorio[1] );
				txtPos03.setText( arrayAleatorio[2] );
				txtPos04.setText( arrayAleatorio[3] );
				txtPos05.setText( arrayAleatorio[4] );
				txtPos06.setText( arrayAleatorio[5] );
				txtPos07.setText( arrayAleatorio[6] );
				txtPos08.setText( arrayAleatorio[7] );
				txtPos09.setText( arrayAleatorio[8] );
				
			}
		
		});
		btnSortearAleatorio.setIcon(new ImageIcon(Principal.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnSortearAleatorio.setForeground(new Color(0, 0, 255));
		btnSortearAleatorio.setBackground(new Color(218, 165, 32));
		btnSortearAleatorio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnSortearAleatorio.setBounds(20, 196, 179, 50);
		contentPanel.add(btnSortearAleatorio);
		
		JButton btnProcessar = new JButton("");
		btnProcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if ( txtPos01.getText() == ""  ) {
					JOptionPane.showMessageDialog(null, "Informe os valores para o modelo aleatório.");
				}
				
				if ( txtRef01.getText() == ""  ) {
					JOptionPane.showMessageDialog(null, "Informe os valores para o modelo referência.");
				}				
				
				arrayAleatorio[0]= txtPos01.getText();
				arrayAleatorio[1]= txtPos02.getText();
				arrayAleatorio[2]= txtPos03.getText();
				arrayAleatorio[3]= txtPos04.getText();
				arrayAleatorio[4]= txtPos05.getText();
				arrayAleatorio[5]= txtPos06.getText();
				arrayAleatorio[6]= txtPos07.getText();
				arrayAleatorio[7]= txtPos08.getText();
				arrayAleatorio[8]= txtPos09.getText();
				
				arrayReferencia[0]= txtRef01.getText();
				arrayReferencia[1]= txtRef02.getText();
				arrayReferencia[2]= txtRef03.getText();
				arrayReferencia[3]= txtRef04.getText();
				arrayReferencia[4]= txtRef05.getText();
				arrayReferencia[5]= txtRef06.getText();
				arrayReferencia[6]= txtRef07.getText();
				arrayReferencia[7]= txtRef08.getText();
				arrayReferencia[8]= txtRef09.getText();				
				
				// Inicia o processamento passando o no principal
				BuscaLargura.getIntance().iniciarProcessamento(arrayAleatorio, arrayReferencia);
				
				// Exibe o resultado do processamento
				String msg= BuscaLargura.getIntance().exibirTextoResultado();		
				System.out.println(msg);
			
			}
		});
		btnProcessar.setIcon(new ImageIcon(Principal.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));
		btnProcessar.setForeground(new Color(0, 0, 255));
		btnProcessar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnProcessar.setBackground(new Color(0, 0, 255));
		btnProcessar.setBounds(20, 257, 375, 50);
		contentPanel.add(btnProcessar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(100, 149, 237));
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(216, 36, 179, 154);
		contentPanel.add(panel_1);
		
		txtRef01 = new JTextField();
		txtRef01.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRef01.setColumns(10);
		txtRef01.setBounds(10, 11, 45, 35);
		panel_1.add(txtRef01);
		
		txtRef02 = new JTextField();
		txtRef02.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRef02.setColumns(10);
		txtRef02.setBounds(65, 12, 45, 34);
		panel_1.add(txtRef02);
		
		txtRef03 = new JTextField();
		txtRef03.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRef03.setColumns(10);
		txtRef03.setBounds(122, 12, 45, 34);
		panel_1.add(txtRef03);
		
		txtRef04 = new JTextField();
		txtRef04.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRef04.setColumns(10);
		txtRef04.setBounds(10, 57, 45, 35);
		panel_1.add(txtRef04);
		
		txtRef05 = new JTextField();
		txtRef05.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRef05.setColumns(10);
		txtRef05.setBounds(65, 58, 45, 34);
		panel_1.add(txtRef05);
		
		txtRef06 = new JTextField();
		txtRef06.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRef06.setColumns(10);
		txtRef06.setBounds(122, 58, 45, 34);
		panel_1.add(txtRef06);
		
		txtRef07 = new JTextField();
		txtRef07.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRef07.setColumns(10);
		txtRef07.setBounds(10, 103, 45, 36);
		panel_1.add(txtRef07);
		
		txtRef08 = new JTextField();
		txtRef08.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRef08.setColumns(10);
		txtRef08.setBounds(65, 104, 45, 35);
		panel_1.add(txtRef08);
		
		txtRef09 = new JTextField();
		txtRef09.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtRef09.setColumns(10);
		txtRef09.setBounds(122, 104, 45, 35);
		panel_1.add(txtRef09);
		
		JButton btnSortearReferencia = new JButton("");
		btnSortearReferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				arrayNumero= Principal.sortearNumeros();
				for (int i = 0; i < arrayNumero.length; i++) {
					if ( arrayNumero[i] == 0 ) {
						arrayReferencia[i] = " ";
					} else {
						arrayReferencia[i] = arrayAlfabeto[ arrayNumero[i] - 1 ];
					}
				}
				
				txtRef01.setText( arrayReferencia[0] );
				txtRef02.setText( arrayReferencia[1] );
				txtRef03.setText( arrayReferencia[2] );
				txtRef04.setText( arrayReferencia[3] );
				txtRef05.setText( arrayReferencia[4] );
				txtRef06.setText( arrayReferencia[5] );
				txtRef07.setText( arrayReferencia[6] );
				txtRef08.setText( arrayReferencia[7] );
				txtRef09.setText( arrayReferencia[8] );				
			}
		});
		btnSortearReferencia.setIcon(new ImageIcon(Principal.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		btnSortearReferencia.setForeground(Color.BLUE);
		btnSortearReferencia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnSortearReferencia.setBackground(new Color(102, 205, 170));
		btnSortearReferencia.setBounds(216, 196, 179, 50);
		contentPanel.add(btnSortearReferencia);
		
		JLabel lblModeloReferncia = new JLabel("MODELO REFER\u00CANCIA");
		lblModeloReferncia.setHorizontalAlignment(SwingConstants.CENTER);
		lblModeloReferncia.setForeground(Color.BLACK);
		lblModeloReferncia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModeloReferncia.setBounds(216, 11, 179, 25);
		contentPanel.add(lblModeloReferncia);
	}
	
	/** * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  SORTEIO
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * */		
	protected static Integer[] sortearNumeros() {
		Integer[] array= new Integer[9];
		Random gerador = new Random();
		int idx= 0;
		do {
			int numero= gerador.nextInt(9);
//			System.out.println(" - - - - -  - - - - - -  - - -  - - --- ");
//			System.out.println(" Numero: "+ numero);
//			System.out.println(" Array: " + Arrays.toString(array));
//			System.out.println(" Idx: " + idx);
//			System.out.println();
			if ( !existe( numero, array ) ) {
				array[idx++]= numero;
			}
			
		} while (idx < 9);
		
		return array;
	}

	protected static boolean existe(int numero, Integer[] array) {
		boolean retorno= false;
		for (int i = 0; i < array.length; i++) {
			if ( array[i]!= null && numero ==  array[i] ) {
				retorno= true;
			}
		}
		return retorno;
	}	
}
