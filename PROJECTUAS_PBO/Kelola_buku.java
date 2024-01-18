package com.perpus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;

import java.sql.*;
import javax.swing.*;

public class Kelola_buu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField KODE;
	private JTextField JUDUL_BUKU;
	private JTextField Pengarang;
	private JTextField Penerbit;
	private JTextField Lokasi;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kelola_buu frame = new Kelola_buu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  
	Connection connection = null;
	 private DefaultTableModel tableModel;
	/**
	 * Create the frame.
	 */
	public Kelola_buu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1151, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel Kelola_buku = new JLabel("KELOLA BUKU");
		Kelola_buku.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel KODE_BUKU = new JLabel("Kode Buku");
		KODE_BUKU.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel JUDUL = new JLabel("Judul Buku");
		JUDUL.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel PENGARANG = new JLabel("Pengarang");
		PENGARANG.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel PENERBIT = new JLabel("Penerbit");
		PENERBIT.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel LOKASI = new JLabel("Lokasi buku");
		LOKASI.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		KODE = new JTextField();
		KODE.setColumns(10);
		
		JUDUL_BUKU = new JTextField();
		JUDUL_BUKU.setColumns(10);
		
		Pengarang = new JTextField();
		Pengarang.setColumns(10);
		
		Penerbit = new JTextField();
		Penerbit.setColumns(10);
		
		Lokasi = new JTextField();
		Lokasi.setColumns(10);
		
		JButton SAVE = new JButton("SAVE");
		SAVE.setFont(new Font("Times New Roman", Font.BOLD, 20));
		SAVE.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveData();
                loadTableData();
            }
        });
		
		JButton UPDATE = new JButton("UPDATE ");
		UPDATE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
                loadTableData();
			}
		});
		UPDATE.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton DELETE = new JButton("DELETE");
		DELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
                loadTableData();
			}
		});
		DELETE.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton EXIT = new JButton("EXIT");
		EXIT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		tableModel = new DefaultTableModel();
        tableModel.addColumn("Kode Buku");
        tableModel.addColumn("Judul Buku");
        tableModel.addColumn("Pengarang");
        tableModel.addColumn("Penerbit");
        tableModel.addColumn("Lokasi");

		table = new JTable();		
		JButton LOAD_DATA = new JButton("LOAD DATA");
		LOAD_DATA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 loadTableData();
			}
		});
		LOAD_DATA.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Kelola_buku, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(KODE, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
									.addComponent(JUDUL, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addComponent(JUDUL_BUKU, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
									.addComponent(PENGARANG, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addComponent(Pengarang, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
									.addComponent(PENERBIT)
									.addComponent(Penerbit, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
									.addComponent(LOKASI, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addComponent(Lokasi, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(65)
										.addComponent(SAVE, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(UPDATE, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(EXIT, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addGap(62)
										.addComponent(DELETE, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
									.addComponent(table, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE))
								.addGap(485))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(KODE_BUKU, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
								.addGap(513)
								.addComponent(LOAD_DATA, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(49)
					.addComponent(Kelola_buku)
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(KODE_BUKU)
						.addComponent(LOAD_DATA, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(DELETE, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(EXIT, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addComponent(UPDATE, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addGap(86))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(KODE, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(JUDUL)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(JUDUL_BUKU, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(PENGARANG)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Pengarang, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(PENERBIT)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Penerbit, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(LOKASI)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Lokasi, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(SAVE, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(165))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void saveData() {
        try {
        	Connection connection = new Connection_DB().connect();;
            String sql = "INSERT INTO buku (kode_buku, judul_buku, pengarang, penerbit, lokasi_buku) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, KODE.getText());
                preparedStatement.setString(2, JUDUL_BUKU.getText());
                preparedStatement.setString(4, Pengarang.getText());
                preparedStatement.setString(5, Penerbit.getText());
                preparedStatement.setString(7, Lokasi.getText());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	private void updateData() {
        try {
        	Connection connection = new Connection_DB().connect();;
            String sql = "UPDATE buku SET judul_buku=?, pengarang=?, penerbit=?, lokasi_buku=? WHERE kode_buku=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, JUDUL_BUKU.getText());

                preparedStatement.setString(3, Pengarang.getText());
                preparedStatement.setString(4, Penerbit.getText());
                preparedStatement.setString(6, Lokasi.getText());
                preparedStatement.setString(7, KODE.getText());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteData() {
        try {
        	Connection connection = new Connection_DB().connect();;
            String sql = "DELETE FROM buku WHERE kode_buku=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, KODE.getText());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void loadTableData() {
        try {
        	Connection connection = new Connection_DB().connect();;
            String sql = "SELECT * FROM buku";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while (resultSet.next()) {
                    Object[] row = {
                            resultSet.getString("kode_buku"),
                            resultSet.getString("judul_buku"),
                            resultSet.getString("pengarang"),
                            resultSet.getString("penerbit"),
                            resultSet.getString("lokasi_buku")
                    };
                    model.addRow(row);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main1(String[] args) {	
        Login loginFrame = new Login();

        if (loginFrame.loginSuccessful()) {
            System.out.println("Login successful. Continue with your application logic.");
        }
    }
}
