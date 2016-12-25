import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JToggleButton;
import javax.swing.JSpinner;


public class DodajKorisnika {
	
	// Definisi JDBC driver name i URL baze
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false";

	// Db podaci
	static final String USER = "root";
	static final String PASS = "123456";

	private JFrame frmDodajNovogKorisnika;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField imeField;
	private JTextField prezimeField;

	/**
	 * Launch the application.
	 */
	public void DodajK() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajKorisnika window = new DodajKorisnika();
					window.frmDodajNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodajKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodajNovogKorisnika = new JFrame();
		frmDodajNovogKorisnika.setTitle("Dodaj Novog Korisnika");
		frmDodajNovogKorisnika.setBounds(100, 100, 450, 300);
		frmDodajNovogKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDodajNovogKorisnika.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 11, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 36, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblPassword);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(10, 61, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(10, 86, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblPrezime);
		
		JLabel lblGodine = new JLabel("Godine:");
		lblGodine.setBounds(10, 111, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblGodine);
		
		JLabel lblSpol = new JLabel("Spol:");
		lblSpol.setBounds(10, 136, 46, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblSpol);
		
		JLabel lblIfAdmin = new JLabel("Da li je administrator?");
		lblIfAdmin.setBounds(10, 161, 153, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblIfAdmin);
		
		usernameField = new JTextField();
		usernameField.setBounds(91, 8, 102, 20);
		frmDodajNovogKorisnika.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		passwordField.setBounds(91, 33, 102, 20);
		frmDodajNovogKorisnika.getContentPane().add(passwordField);
		
		imeField = new JTextField();
		imeField.setColumns(10);
		imeField.setBounds(91, 58, 102, 20);
		frmDodajNovogKorisnika.getContentPane().add(imeField);
		
		prezimeField = new JTextField();
		prezimeField.setColumns(10);
		prezimeField.setBounds(91, 83, 102, 20);
		frmDodajNovogKorisnika.getContentPane().add(prezimeField);
		
		JRadioButton rdbtnMusko = new JRadioButton("Musko");
		rdbtnMusko.setBounds(91, 133, 84, 20);
		frmDodajNovogKorisnika.getContentPane().add(rdbtnMusko);
		
		JRadioButton rdbtnensko = new JRadioButton("\u017Densko");
		rdbtnensko.setBounds(177, 135, 102, 17);
		frmDodajNovogKorisnika.getContentPane().add(rdbtnensko);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnMusko);
	    group.add(rdbtnensko);
		
		JCheckBox chckbxAdmin = new JCheckBox("");
		chckbxAdmin.setBounds(169, 161, 97, 14);
		frmDodajNovogKorisnika.getContentPane().add(chckbxAdmin);
		
		JButton btnDodajNovogKorisnika = new JButton("Dodaj Novog Korisnika");
		btnDodajNovogKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(usernameField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Username mora biti unesen");
			}
			if(passwordField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Password mora biti unesen");
			}
			if(imeField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Ime mora biti uneseno");
			}
			if(prezimeField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Prezime mora biti uneseno");
			}
			}
		});
		btnDodajNovogKorisnika.setBounds(21, 212, 220, 23);
		frmDodajNovogKorisnika.getContentPane().add(btnDodajNovogKorisnika);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(91, 108, 46, 20);
		frmDodajNovogKorisnika.getContentPane().add(spinner);
	}
}