import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ZakljucajAnketu {

	// Definisi JDBC driver name i URL baze
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false";

	// Db podaci
	static final String USER = "root";
	static final String PASS = "123456";

	ArrayList<String> groupNames = new ArrayList<String>();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void ZakljucajA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZakljucajAnketu window = new ZakljucajAnketu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ZakljucajAnketu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Gadugi", Font.BOLD, 12));
		frame.setResizable(false);
		frame.setTitle("Zakljucaj anketu");
		frame.setBounds(100, 100, 520, 205);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblZakljucajAnketu = new JLabel("ODABERI ANKETU ZA ZAKLJUCAVANJE :");
		lblZakljucajAnketu.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblZakljucajAnketu.setBounds(10, 11, 360, 20);
		frame.getContentPane().add(lblZakljucajAnketu);

		// TRY
		Connection conn = null;
		Statement stmt = null;

		try {
			// Registruj JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Zapocni konekciju conn
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root",
					"123456");

			stmt = conn.createStatement();
			String sql;
			sql = ("SELECT question_text FROM questions WHERE is_closed=0");
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String groupName = rs.getString("question_text");
				// add group names to the array list
				groupNames.add(groupName);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Errors JDBC
			se.printStackTrace();
		} catch (Exception x) {
			// Errors za Class.forName
			x.printStackTrace();
		}
		// TRY

		final JComboBox comboBoxZakljucajAnketu = new JComboBox();
		comboBoxZakljucajAnketu.setBounds(10, 43, 484, 40);
		frame.getContentPane().add(comboBoxZakljucajAnketu);
		DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
		comboBoxZakljucajAnketu.setModel(model);

		JButton btnZakljucaj = new JButton("ZAKLJUCAJ ");
		btnZakljucaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String zakkank = (String) comboBoxZakljucajAnketu.getSelectedItem();
				// Spremi u varijable

				Connection conn = null;
				Statement stmt = null;
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root",
							"123456");
					stmt = conn.createStatement();

					int zakAnk = stmt.executeUpdate(
							"UPDATE questions SET is_closed = 1 WHERE question_text = '" + zakkank + "'");
					if (zakAnk > 0) {
						JOptionPane.showMessageDialog(null, "Anketa uspjesno zakljucana !");
						UgasiGa();
					}

					stmt.close();
					conn.close();
				} catch (SQLException se) {
					// Errors JDBC
					se.printStackTrace();
				} catch (Exception x) {
					// Errors za Class.forName
					x.printStackTrace();
				}
			}
		});
		btnZakljucaj.setBackground(SystemColor.activeCaption);
		btnZakljucaj.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnZakljucaj.setBounds(10, 121, 484, 31);
		frame.getContentPane().add(btnZakljucaj);

	}

	public void UgasiGa() {
		frame.dispose();
	}
}
