package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final String END_COMMAND = "/end";
    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;

    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(8188, 1);
            System.out.println("Сервер запущен, ожидаем подключения...");

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("Клиент подключился");
                newClientListener();
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (serverSocket != null) serverSocket.close();
            if (clientSocket != null) clientSocket.close();
        }
    }

    private static void newClientListener() throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Попали в метод ожидания сообщений");
                    DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

                    while (true) {
                        String message = inputStream.readUTF();
                        System.out.println("Клиент: " + message);

                        if (message.equals(END_COMMAND)) {
                            System.out.println("На выход");
                            break;
                        }
                        outputStream.writeUTF("Эхо: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}