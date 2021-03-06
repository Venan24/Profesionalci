import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LogovanAdmin {

	private JFrame frmAdminPanel;

	/**
	 * Launch the application.
	 */
	public void Admin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogovanAdmin window = new LogovanAdmin();
					window.frmAdminPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogovanAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPanel = new JFrame();
		frmAdminPanel.setResizable(false);
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setBounds(100, 100, 520, 410);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.getContentPane().setLayout(null);

		JButton btnDodajKorisnika = new JButton("Dodaj Korisnika");
		btnDodajKorisnika.setFont(new Font("Gadugi", Font.PLAIN, 12));
		btnDodajKorisnika.setBackground(SystemColor.activeCaptionBorder);
		btnDodajKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DodajKorisnika a = new DodajKorisnika();
				a.DodajK();
			}
		});
		btnDodajKorisnika.setBounds(340, 203, 165, 30);
		frmAdminPanel.getContentPane().add(btnDodajKorisnika);

		JButton btnObriiKorisnika = new JButton("Obri\u0161i Korisnika");
		btnObriiKorisnika.setFont(new Font("Gadugi", Font.PLAIN, 12));
		btnObriiKorisnika.setBackground(SystemColor.activeCaptionBorder);
		btnObriiKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BrisanjeKorisnika brisi = new BrisanjeKorisnika();
				brisi.ObrisiK();
			}
		});
		btnObriiKorisnika.setBounds(340, 254, 165, 30);
		frmAdminPanel.getContentPane().add(btnObriiKorisnika);

		JButton btnDodajAnketu = new JButton("Dodaj Anketu");
		btnDodajAnketu.setFont(new Font("Gadugi", Font.PLAIN, 12));
		btnDodajAnketu.setBackground(SystemColor.activeCaption);
		btnDodajAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DodajAnketu dodaj = new DodajAnketu();
				dodaj.DodajAnk();
			}
		});
		btnDodajAnketu.setBounds(340, 14, 165, 30);
		frmAdminPanel.getContentPane().add(btnDodajAnketu);

		JButton btnObriiAnketu = new JButton("Obri\u0161i Anketu");
		btnObriiAnketu.setFont(new Font("Gadugi", Font.PLAIN, 12));
		btnObriiAnketu.setBackground(SystemColor.activeCaption);
		btnObriiAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ObrisiAnketu obrisi = new ObrisiAnketu();
				obrisi.ObrisiA();
			}
		});
		btnObriiAnketu.setBounds(340, 61, 165, 30);
		frmAdminPanel.getContentPane().add(btnObriiAnketu);

		JButton btnPregeldStatistike = new JButton("PREGELD STATISTIKE");
		btnPregeldStatistike.setBackground(SystemColor.activeCaption);
		btnPregeldStatistike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PregledStatistike pregled = new PregledStatistike();
				pregled.PregledS();
			}
		});
		btnPregeldStatistike.setFont(new Font("Gadugi", Font.BOLD, 12));
		btnPregeldStatistike.setBounds(180, 333, 155, 37);
		frmAdminPanel.getContentPane().add(btnPregeldStatistike);

		JLabel lblPrijavljeniKao = new JLabel("Prijavljen kao:");
		lblPrijavljeniKao.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblPrijavljeniKao.setBackground(Color.DARK_GRAY);
		lblPrijavljeniKao.setBounds(10, 18, 85, 23);
		frmAdminPanel.getContentPane().add(lblPrijavljeniKao);

		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblIme.setBounds(10, 52, 85, 23);
		frmAdminPanel.getContentPane().add(lblIme);

		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblPrezime.setBounds(10, 86, 85, 23);
		frmAdminPanel.getContentPane().add(lblPrezime);

		JButton btnOdjaviSe = new JButton("ODJAVI SE");
		btnOdjaviSe.setBackground(SystemColor.activeCaption);
		btnOdjaviSe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login a = new Login();
				a.pojaviSe();
				frmAdminPanel.dispose();
				
			}
		});
		btnOdjaviSe.setFont(new Font("Gadugi", Font.BOLD, 12));
		btnOdjaviSe.setBounds(10, 333, 155, 37);
		frmAdminPanel.getContentPane().add(btnOdjaviSe);

		// Zakljucaj dugme

		JButton btnZakljucajAnketu = new JButton("Zakljucaj Anketu");
		btnZakljucajAnketu.setFont(new Font("Gadugi", Font.PLAIN, 12));
		btnZakljucajAnketu.setBackground(SystemColor.activeCaption);
		btnZakljucajAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ZakljucajAnketu zakljucaj = new ZakljucajAnketu();
				zakljucaj.ZakljucajA();
			}
		});
		btnZakljucajAnketu.setBounds(340, 156, 165, 30);
		frmAdminPanel.getContentPane().add(btnZakljucajAnketu);

		Login novi = new Login();
		JLabel prikaziUsername = new JLabel("<html><font color='red'>" + novi.getUsername() + "</font></html>");
		prikaziUsername.setBackground(SystemColor.activeCaption);
		prikaziUsername.setBounds(90, 18, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziUsername);

		JLabel prikaziIme = new JLabel("<html><font color='black'>" + novi.getFirstName() + "</font></html>");
		prikaziIme.setBounds(90, 52, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziIme);

		JLabel prikaziPrezime = new JLabel("<html><font color='black'>" + novi.getLastName() + "</font></html>");
		prikaziPrezime.setBounds(90, 86, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziPrezime);

		JLabel lblSpol = new JLabel("Spol:");
		lblSpol.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblSpol.setBounds(10, 120, 85, 23);
		frmAdminPanel.getContentPane().add(lblSpol);

		JLabel lblGodina = new JLabel("Godina:");
		lblGodina.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblGodina.setBounds(10, 160, 85, 23);
		frmAdminPanel.getContentPane().add(lblGodina);

		JLabel prikaziSpol = new JLabel("<html><font color='black'>" + novi.getGenderIs() + "</font></html>");
		prikaziSpol.setBounds(90, 120, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziSpol);

		JLabel prikaziGodine = new JLabel("<html><font color='black'>" + novi.getAgeIs() + "</font></html>");
		prikaziGodine.setBounds(90, 160, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziGodine);

		JButton btnOtkljucajAnketu = new JButton("Otkljucaj Anketu");
		btnOtkljucajAnketu.setFont(new Font("Gadugi", Font.PLAIN, 12));
		btnOtkljucajAnketu.setBackground(SystemColor.activeCaption);
		btnOtkljucajAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OtkljucajAnketu otkljucaj = new OtkljucajAnketu();
				otkljucaj.OtkljucajA();
			}
		});
		btnOtkljucajAnketu.setBounds(340, 107, 165, 30);
		frmAdminPanel.getContentPane().add(btnOtkljucajAnketu);

		JButton btnNewButton = new JButton("PRIKAZI GRESKE");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PrikaziGreskeAdmin Admin = new PrikaziGreskeAdmin();
				Admin.PrikaziGreskeAdmin();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}

		});
		btnNewButton.setBounds(350, 333, 155, 37);
		frmAdminPanel.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LogovanAdmin.class.getResource("/images/Untitled-2.png")));
		lblNewLabel.setBounds(10, 14, 210, 177);
		frmAdminPanel.getContentPane().add(lblNewLabel);
	}

}
