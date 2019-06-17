/*

 */
package katasg_bank.View;
import katasg_bank.Models.SimpleUser;
import katasg_bank.Utils.MyController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author Nad
 */
public class LoginForm extends JFrame {

	private static final long serialVersionUID = -1668662558934186979L;
	/**
     * Creates new form MainApp
     */
    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
       
    }

   
   
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        loginTextField = new JTextField();
        passwordTextField = new JTextField();
        loginBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        jLabel1.setText("Login");

        jLabel2.setText("Password");

        loginTextField.setText("Nadir47");
        loginTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginTextFieldActionPerformed(evt);
            }
        });

        passwordTextField.setText("password");
        passwordTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(loginTextField, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(passwordTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(loginTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(loginBtn)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }

    private void loginTextFieldActionPerformed(ActionEvent evt) {
       
    }

    private void passwordTextFieldActionPerformed(ActionEvent evt) {
       
    }

    private void loginBtnActionPerformed(ActionEvent evt) {
        SimpleUser tempUser =(SimpleUser) MyController.checkUserPswd(loginTextField.getText(),passwordTextField.getText());
        if (tempUser!=null)
            {
                new DashBoard(tempUser).setVisible(true);
                this.dispose();
            }
    }
    

   
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton loginBtn;
    private JTextField loginTextField;
    private JTextField passwordTextField;
   
}
