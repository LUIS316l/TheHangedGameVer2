package server;

import java.io.*;
import java.net.*;

public class Servidor implements Runnable {
    private int port;
    private String playerName;
    private String rounds;
    private String timeWord;
    private String wordsCant;
    
    public Servidor(int port, String playerName, String rounds, String timeWord, String wordsCant) {
        this.port = port;
        this.playerName = playerName;
        this.rounds = rounds;
        this.timeWord = timeWord;
        this.wordsCant = wordsCant;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor esperando conexiones...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado");

                // Enviar datos al cliente
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(playerName);
                out.writeUTF(rounds);
                out.writeUTF(timeWord);
                out.writeUTF(wordsCant);
                out.writeUTF("StartGame");

                // Leer datos enviados por el cliente (si aplica)
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String receivedMessage = input.readLine();
                System.out.println("Mensaje recibido del cliente: " + receivedMessage);

                // Confirmar recepción al cliente
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                output.println("Datos enviados correctamente desde el servidor");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
