package server;

import gui.GameScreen;
import java.io.*;
import java.net.*;

public class Cliente implements Runnable {
    
    private String serverAddress;
    private int serverPort;
    private String playerName;

    private String receivedPlayerName;
    private String receivedRounds;
    private String receivedTimeWord;
    private String receivedWordsCant;

    public Cliente(String serverAddress, int serverPort, String playerName) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.playerName = playerName;
    }
    
    @Override
    public void run() {
        try (Socket socket = new Socket(serverAddress, serverPort)) {
            System.out.println("Conectado al servidor");

            // Enviar mensaje al servidor
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hola desde el cliente ---> " + playerName);

            // Recibir datos del servidor
            DataInputStream input = new DataInputStream(socket.getInputStream());
            receivedPlayerName = input.readUTF();
            receivedRounds = input.readUTF();
            receivedTimeWord = input.readUTF();
            receivedWordsCant = input.readUTF();

            
            System.out.println("Datos recibidos del servidor:");
            System.out.println("Nombre del jugador: " + receivedPlayerName);
            System.out.println("Rondas: " + receivedRounds);
            System.out.println("Tiempo por palabra: " + receivedTimeWord);
            System.out.println("Cantidad de palabras: " + receivedWordsCant);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

