import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFormDemo extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton loginButton;
    private JPanel main;

    public LoginFormDemo() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String email = textField2.getText();
                String address = textArea1.getText();
                File formDetail = new File("D:\\LoginForm.txt");
                try{
                    FileWriter fw = new FileWriter(formDetail);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.print(name + " " + email + " " + address);
                    pw.close();
                    fw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                textField1.setText("");
                textField2.setText("");
                textArea1.setText("");
                JOptionPane.showMessageDialog(loginButton,"Data Saved");
            }
        });
    }

    public static void main(String[] args) {
        LoginFormDemo obj = new LoginFormDemo();
        obj.setContentPane(obj.main);
        obj.setSize(300,200);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
