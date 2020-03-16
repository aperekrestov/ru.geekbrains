package lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClient extends JFrame {

    private JTextField msgInputField;
    private JTextArea chatArea;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public EchoClient() {
        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        prepareGUI();
    }

    private void openConnection() throws IOException {
        String SERVER_ADDR = "localhost";
        int SERVER_PORT = 8188;

        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        chatArea.append(strFromServer);
                        chatArea.append("\n");
                    }
                } catch (Exception e) {
                    System.out.println("Connection has been closed!");
                }
            }
        }).start();
    }



    public void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        if (!msgInputField.getText().trim().isEmpty()) {
            try {
                out.writeUTF(msgInputField.getText());
                msgInputField.setText("");
                msgInputField.grabFocus();
                getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ошибка отправки сообщения");
            }
        }
    }

    private void getMessage(){
        try {
            String messageFromServer = in.readUTF((DataInput) socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepareGUI() {
        // Параметры окна
        setBounds(600, 300, 500, 500);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Текстовое поле для вывода сообщений
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Нижняя панель с полем для ввода сообщений и кнопкой отправки сообщений
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);
        btnSendMsg.addActionListener(e -> sendMessage());
        msgInputField.addActionListener(e -> sendMessage());

        // Настраиваем действие на закрытие окна
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF("/end");
                    closeConnection();
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EchoClient();
            }
        });
    }
}