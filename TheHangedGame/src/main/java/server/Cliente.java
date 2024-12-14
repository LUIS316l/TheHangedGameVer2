package server;

import java.io.*;
import java.net.*;

public class Cliente implements Runnable {
    
    private String serverAddress;  // Dirección del servidor
    private int serverPort;        // Puerto del servidor
    private String playerName;     // Nombre del jugador

    private String receivedPlayerName;  // Nombre del jugador recibido del servidor
    private String receivedRounds;      // Número de rondas recibido del servidor
    private String receivedTimeWord;    // Tiempo por palabra recibido del servidor
    private String receivedWordsCant;   // Cantidad de palabras recibido del servidor

    // Constructor que inicializa la dirección del servidor, el puerto y el nombre del jugador
    public Cliente(String serverAddress, int serverPort, String playerName) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.playerName = playerName;
    }
    
    // Método run que se ejecuta cuando el hilo comienza
    @Override
    public void run() {
        try (Socket socket = new Socket(serverAddress, serverPort)) {  // Crea un socket para conectar al servidor
            System.out.println("Conectado al servidor");

            // Enviar mensaje al servidor
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hola desde el cliente ---> " + playerName);  // Enviar el nombre del jugador al servidor

            // Recibir datos del servidor
            DataInputStream input = new DataInputStream(socket.getInputStream());
            receivedPlayerName = input.readUTF();  // Leer el nombre del jugador recibido
            receivedRounds = input.readUTF();      // Leer las rondas recibidas
            receivedTimeWord = input.readUTF();    // Leer el tiempo por palabra recibido
            receivedWordsCant = input.readUTF();   // Leer la cantidad de palabras recibida

            // Mostrar los datos recibidos
            System.out.println("Datos recibidos del servidor:");
            System.out.println("Nombre del jugador: " + receivedPlayerName);
            System.out.println("Rondas: " + receivedRounds);
            System.out.println("Tiempo por palabra: " + receivedTimeWord);
            System.out.println("Cantidad de palabras: " + receivedWordsCant);

        } catch (IOException e) {
            e.printStackTrace();  // Si ocurre un error, imprimir la traza del error
        }
    }
}
