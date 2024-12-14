package server;

import java.io.*;
import java.net.*;

public class Servidor implements Runnable {
    private int port;             // Puerto en el que el servidor escuchará las conexiones
    private String playerName;    // Nombre del jugador
    private String rounds;        // Número de rondas
    private String timeWord;      // Tiempo por palabra
    private String wordsCant;     // Cantidad de palabras

    // Constructor que recibe los parámetros del servidor (puerto, nombre del jugador, rondas, tiempo por palabra, cantidad de palabras)
    public Servidor(int port, String playerName, String rounds, String timeWord, String wordsCant) {
        this.port = port;
        this.playerName = playerName;
        this.rounds = rounds;
        this.timeWord = timeWord;
        this.wordsCant = wordsCant;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {  // Crea un servidor que escucha en el puerto indicado
            System.out.println("Servidor esperando conexiones...");

            while (true) {
                // Acepta la conexión de un cliente
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado");

                // Envía datos al cliente (nombre del jugador, rondas, tiempo por palabra, cantidad de palabras)
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(playerName);     // Enviar el nombre del jugador
                out.writeUTF(rounds);         // Enviar las rondas
                out.writeUTF(timeWord);       // Enviar el tiempo por palabra
                out.writeUTF(wordsCant);      // Enviar la cantidad de palabras
                out.writeUTF("StartGame");    // Enviar mensaje para comenzar el juego

                // Leer mensaje enviado por el cliente
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String receivedMessage = input.readLine();  // Leer el mensaje recibido del cliente
                System.out.println("Mensaje recibido del cliente: " + receivedMessage);

                // Confirmar que los datos fueron enviados correctamente
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                output.println("Datos enviados correctamente desde el servidor");

                socket.close();  // Cierra la conexión con el cliente
            }
        } catch (IOException e) {
            e.printStackTrace();  // Si ocurre un error, imprime la traza del error
        }
    }
}
