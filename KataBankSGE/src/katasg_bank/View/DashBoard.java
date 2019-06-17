/*
 */
package katasg_bank.View;

import katasg_bank.Models.SimpleUser;
import katasg_bank.Models.User;
import katasg_bank.Utils.MyController;
import katasg_bank.Utils.StorageEngine;

import java.awt.event.*;


import javax.swing.*;

import static katasg_bank.KataSG_Bank.usersLoaded;

/**
 *
 * @author Nad
 */
public class DashBoard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form DashBoard
	 */
	public static SimpleUser currentUser ;
	public DashBoard(SimpleUser user) {
		currentUser=user;
		initJframe(currentUser);
		this.setLocationRelativeTo(null);
		
	}


	private void initJframe(SimpleUser user) {

		jLabel1 = new JLabel();
		labelBalance = new JLabel();
		withdrawBtn = new JButton();
		depositBtn = new JButton();
		withdrawAmountLabel = new JTextField();
		depositAmountLabel = new JTextField();
		transactionHistoryBtn = new JButton();
		labelBalance1 = new JLabel();
		saveBtn = new JButton();

		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				for(User tempUsr : usersLoaded){
					if (tempUsr.getPassWord().equals(currentUser.getPassWord())&& 
							tempUsr.getUserName().equals(currentUser.getUserName())){
						tempUsr.updateUser(currentUser);
					}
					StorageEngine.StoreDataToFile(usersLoaded);
						
				}
				System.exit(0);
			}});

		setResizable(false);

		labelBalance.setText(String.valueOf(user.getBalance()));

		withdrawBtn.setText("WITHDRAW ");
		withdrawBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				withdrawBtnActionPerformed(evt);
			}
		});

		depositBtn.setText("DEPOSIT");
		depositBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				depositBtnActionPerformed(evt);
			}
		});

		withdrawAmountLabel.setText("AMOUNT OF WITHDRAW");
		withdrawAmountLabel.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt) {
				withdrawAmountLabelFocusGained(evt);
			}
		});
		withdrawAmountLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				withdrawAmountLabelActionPerformed(evt);
			}
		});

		depositAmountLabel.setText("AMOUNT OF DEPOSIT");
		depositAmountLabel.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent evt) {
				depositAmountLabelFocusGained(evt);
			}
		});

		transactionHistoryBtn.setText("Transactions history");
		transactionHistoryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				transactionHistoryBtnActionPerformed(evt);
			}
		});

		labelBalance1.setText("Your amount is :");

		saveBtn.setText("Save Data");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				saveBtnActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
										.addGap(23, 23, 23)
										.addComponent(jLabel1)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(labelBalance1)
										.addGap(34, 34, 34)
										.addComponent(labelBalance, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGap(35, 35, 35)
										.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(withdrawBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(depositBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(withdrawAmountLabel)
												.addComponent(depositAmountLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(transactionHistoryBtn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
						.addGap(23, 23, 23))
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(0, 0, Short.MAX_VALUE)
						.addComponent(saveBtn)
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(40, 40, 40)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(labelBalance)
										.addComponent(labelBalance1))
								.addComponent(jLabel1))
						.addGap(89, 89, 89)
						.addComponent(withdrawBtn)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(withdrawAmountLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
										.addComponent(depositBtn)
										.addGap(11, 11, 11)
										.addComponent(depositAmountLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(39, 39, 39))
								.addGroup(layout.createSequentialGroup()
										.addGap(6, 6, 6)
										.addComponent(transactionHistoryBtn)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(saveBtn)
										.addContainerGap())))
				);

		pack();
	}

	private void transactionHistoryBtnActionPerformed(ActionEvent evt) {
		new HistoryView().setVisible(true);

	}

	private void withdrawBtnActionPerformed(ActionEvent evt) {
		String amount=withdrawAmountLabel.getText();
		if (MyController.checkIfCorrectValue(amount))
		{
			try {
				currentUser.withdraw(Double.parseDouble(withdrawAmountLabel.getText()));
				//System.out.println(Double.parseDouble(withdrawAmountLabel.getText()));
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			labelBalance.setText(String.valueOf(currentUser.getBalance()));
		}
		withdrawAmountLabel.setText("");
	}

	private void withdrawAmountLabelActionPerformed(ActionEvent evt) {
		withdrawAmountLabel.setText("");
	}

	private void withdrawAmountLabelFocusGained(FocusEvent evt) {
		withdrawAmountLabel.setText("");
	}

	private void depositAmountLabelFocusGained(FocusEvent evt) {
		depositAmountLabel.setText("");
	}

	private void depositBtnActionPerformed(ActionEvent evt) {
		String amount=depositAmountLabel.getText();
		if (MyController.checkIfCorrectValue(amount))
		{
			try {
				currentUser.deposit(Double.parseDouble(depositAmountLabel.getText()));
				//System.out.println(Double.parseDouble(depositAmountLabel.getText()));
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			depositAmountLabel.setText("");
			labelBalance.setText(String.valueOf(currentUser.getBalance()));
		}
	}

	private void saveBtnActionPerformed(ActionEvent evt) {
		for(User tempUsr : usersLoaded){
			if (tempUsr.getPassWord().equals(currentUser.getPassWord())&& 
					tempUsr.getUserName().equals(currentUser.getUserName())){
				tempUsr.updateUser(currentUser);
			}
			StorageEngine.StoreDataToFile(usersLoaded);

		}

	}
	private JTextField depositAmountLabel;
	private JButton depositBtn;
	private JLabel jLabel1;
	private JLabel labelBalance;
	private JLabel labelBalance1;
	private JButton saveBtn;
	private JButton transactionHistoryBtn;
	private JTextField withdrawAmountLabel;
	private JButton withdrawBtn;

}
