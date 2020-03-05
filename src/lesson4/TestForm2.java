package lesson4;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestForm2 {
    private JPanel panel1;
    private JList<String> listContacts;
    private JList<String> listMessages;
    private JButton btnSend;
    private JTextField textField1;

    public TestForm2() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listMessages.setModel(listModel);

        DefaultListModel<String> contacts = new DefaultListModel<>();
        listContacts.setModel(contacts);
        contacts.addElement("Маша");
        contacts.addElement("Саша");
        contacts.addElement("Даша");
        contacts.addElement("Паша");

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(textField1.getText());
                textField1.setText("");
            }
        });

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listModel.addElement(textField1.getText());
                textField1.setText("");
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Testing form");
        frame.setContentPane(new TestForm2().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}
