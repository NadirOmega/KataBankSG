/*

 */
package katasg_bank.View;

import katasg_bank.Models.Transaction;
import javax.swing.table.DefaultTableModel;
import katasg_bank.Utils.DateUtil;

import javax.swing.*;

/**
 *
 * @author Nad
 */
public class HistoryView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates new form HistoryView
	 */
	public HistoryView() {
		initComponents();
		addRowToJtable();
		this.setLocationRelativeTo(null);
	}
	public void addRowToJtable(){

		DefaultTableModel model = (DefaultTableModel) historyTable.getModel();
		Object rowData[] = new Object[4];
		int i=1;
		for(Transaction transactionCurrentUser :DashBoard.currentUser.getTransactions()){

			rowData[0] = i;
			rowData[1] = transactionCurrentUser.getTypeAsString();
			rowData[2] = transactionCurrentUser.getAmount();
			rowData[3] = DateUtil.getStringFromDate(transactionCurrentUser.getDateTime());
			model.addRow(rowData);
			i++;
		}

	}


	private void initComponents() {

		jScrollPane1 = new JScrollPane();
		historyTable = new JTable();

		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		historyTable.setModel(new DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"Number", "Type", "Amount", "Date"
				}
				));
		jScrollPane1.setViewportView(historyTable);
		if (historyTable.getColumnModel().getColumnCount() > 0) {
			historyTable.getColumnModel().getColumn(3).setPreferredWidth(50);
		}

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
						.addContainerGap())
				);

		pack();
	}
	private JTable historyTable;
	private JScrollPane jScrollPane1;

}
