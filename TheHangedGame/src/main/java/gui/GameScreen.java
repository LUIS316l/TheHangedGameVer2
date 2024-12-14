package gui;


import customeComponents.CustomeList;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import server.Cliente;
import server.Servidor;
import server.dbConnection;
import utils.ThreadTimer;


public class GameScreen extends JFrame {
    
    // VARIABLES 
   
    // DECLARACIÓN DE VARIABLES
    private int roundsToInt;  // Número de rondas en formato entero
    private int timeToInt;    // Tiempo por ronda en formato entero
    private int wordsToInt;   // Cantidad de palabras en formato entero

    private String playerName;   // Nombre del jugador
    private String rounds;       // Número de rondas como cadena
    private String timeWords;    // Tiempo como cadena
    private String wordsCant;    // Cantidad de palabras como cadena

    private String ip;   // Dirección IP para conexión

    private int lives = 6;      // Número de vidas iniciales
    private int points = 0;     // Puntos iniciales
    private int round = 1;      // Ronda actual
    private int timeInitial;    // Tiempo inicial guardado
    private String word;        // Palabra actual
    private boolean isWordComplete = false;   // Verifica si la palabra está completa
    private boolean isUpdatingRound = false;  // Controla la actualización de la ronda

    // Etiquetas para mostrar información
    private JLabel lblPlayerName;
    private JLabel lblRound;
    private JLabel lblPoints;

    private Timer timer = null;  // Temporizador del juego  
    
    // -------------------------------- CONSTRUCTOR
    public GameScreen(String playerName, String rounds, String timeWords, String wordsCant, String screen, String ip) {
       //asignacion de valores iniciales 
        this.playerName = playerName;
        this.rounds = rounds;
        this.timeWords = timeWords;
        this.wordsCant = wordsCant;
        this.ip = ip;
        
        //conversion de cadenas a enteros 
        roundsToInt = Integer.parseInt(rounds);
        timeToInt = Integer.parseInt(timeWords);
        wordsToInt = Integer.parseInt(wordsCant);
           // Configuración inicial
        timeInitial = timeToInt;
        initComponents();      // Inicializa los componentes gráficos
        addComponents();       // Agrega componentes personalizados
        updateLabels();        // Actualiza las etiquetas informativas
        getWord();             // Obtiene la primera palabra
        startTimer();          // Inicia el temporizador
        controlador(screen);   // Configura servidor o cliente según el modo seleccionado
        panelMonito.repaint(); // Dibuja la horca
    }
        
   private void controlador(String screen) {
    // Comienza a ejecutar el servidor o cliente según la pantalla ("Create" o "Join")
    if(screen.equals("Create")) {
        // Si la pantalla es "Create", se inicia el servidor.
        
        int port = 12345; // Define el puerto en el que el servidor escuchará las conexiones
        
        // Crea una nueva instancia de 'Servidor' pasando el puerto, el nombre del jugador, las rondas, el tiempo por palabra, y la cantidad de palabras
        Servidor servidor = new Servidor(port, playerName, rounds, timeWords, wordsCant);
        
        // Crea un hilo para ejecutar el servidor de manera asincrónica (en segundo plano)
        Thread servidorThread = new Thread(servidor);    
        servidorThread.start(); // Inicia el hilo que ejecuta el servidor
        
        // Muestra un mensaje en la consola indicando que el servidor ha iniciado en el puerto especificado
        System.out.println("SERVIDOR INICIADO EN EL PUERTO ---- " + port);
    } 
    
    // Si la pantalla es "Join", se conecta a un servidor como cliente
    if(screen.equals("Join")) {
        String serverAddress = ip; // La dirección IP del servidor al que se quiere conectar
        int port = 12345; // El puerto al que el cliente se conectará
        
        // Crea una nueva instancia de 'Cliente' pasando la dirección IP del servidor, el puerto y el nombre del jugador
        Cliente cliente = new Cliente(serverAddress, port, playerName);
        
        // Crea un hilo para ejecutar el cliente de manera asincrónica
        Thread clienteThread = new Thread(cliente); 
        clienteThread.start(); // Inicia el hilo que ejecuta el cliente
        
        // Muestra un mensaje en la consola indicando que el cliente se está conectando al servidor
        System.out.println("CLIENTE CONECTANDOSE AL SERVIDOR " + serverAddress + ":" + port);
        }        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInfo = new javax.swing.JPanel();
        panelGame = new javax.swing.JPanel();
        panelMonito = new javax.swing.JPanel();
        lblTimer = new javax.swing.JLabel();
        lblLives = new javax.swing.JLabel();
        lblRounds = new javax.swing.JLabel();
        panelLetters = new javax.swing.JPanel();
        lblLetters = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelInfo.setBackground(new java.awt.Color(47, 89, 114));
        panelInfo.setPreferredSize(new java.awt.Dimension(350, 650));
        panelInfo.setLayout(new java.awt.GridBagLayout());

        panelGame.setBackground(new java.awt.Color(66, 130, 170));
        panelGame.setPreferredSize(new java.awt.Dimension(900, 650));

        panelMonito.setBackground(new java.awt.Color(66, 130, 170));
        panelMonito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout panelMonitoLayout = new javax.swing.GroupLayout(panelMonito);
        panelMonito.setLayout(panelMonitoLayout);
        panelMonitoLayout.setHorizontalGroup(
            panelMonitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
        );
        panelMonitoLayout.setVerticalGroup(
            panelMonitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        lblTimer.setFont(new java.awt.Font("Doto", 1, 20)); // NOI18N
        lblTimer.setForeground(new java.awt.Color(255, 255, 255));
        lblTimer.setText("TIEMPO -->");

        lblLives.setFont(new java.awt.Font("Doto", 1, 20)); // NOI18N
        lblLives.setForeground(new java.awt.Color(255, 255, 255));
        lblLives.setText("VIDAS -->");

        lblRounds.setFont(new java.awt.Font("Doto", 1, 20)); // NOI18N
        lblRounds.setForeground(new java.awt.Color(255, 255, 255));
        lblRounds.setText("RONDAS -->");

        panelLetters.setBackground(new java.awt.Color(66, 130, 170));

        lblLetters.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblLetters.setForeground(new java.awt.Color(0, 0, 0));
        lblLetters.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLetters.setPreferredSize(new java.awt.Dimension(40, 40));
        panelLetters.add(lblLetters);

        javax.swing.GroupLayout panelGameLayout = new javax.swing.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGameLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGameLayout.createSequentialGroup()
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblLives, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblRounds, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelMonito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLetters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGameLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLives)
                    .addComponent(lblRounds)
                    .addComponent(lblTimer))
                .addGap(18, 18, 18)
                .addComponent(panelMonito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelLetters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    // -------------------------------- COMPONENTES PERSONALIZADOS 
    //inicializacion y confiiguracion de paneles y etiquetas
   private void addComponents() {
    // Crear un modelo de lista con algunos jugadores de ejemplo
    DefaultListModel<String> model = new DefaultListModel<>();
    model.addElement("Player 1");
    model.addElement("Player 2");

    // Configuración de la fuente y color de los textos de las etiquetas
    Font labelFont = new Font("Doto", Font.BOLD, 20);
    Color textColorLabel = Color.WHITE;

    // Configuración de la lista personalizada
    Dimension listSize = new Dimension(300, 200); 
    Color defaultColor = new Color(255, 255, 255); // Color de fondo de la lista
    Color textColor = Color.BLACK; // Color del texto en la lista
    int borderRadius = 10; // Radio del borde de la lista

    // Crear etiquetas que mostrarán información como el nombre del jugador, ronda y puntos
    lblPlayerName = new JLabel(" ");
    lblPlayerName.setFont(labelFont);
    lblPlayerName.setForeground(textColorLabel);
    
    lblRound = new JLabel("Ronda --> ");
    lblRound.setFont(labelFont);
    lblRound.setForeground(textColorLabel);
    
    lblPoints = new JLabel("Puntos --> ");
    lblPoints.setFont(labelFont);
    lblPoints.setForeground(textColorLabel);
    
    // Etiquetas vacías para el espaciado
    JLabel label5 = new JLabel(" ");
    JLabel label6 = new JLabel(" ");

    // Crear una lista personalizada con el modelo de datos
    CustomeList<String> customeList = new CustomeList<>(model, listSize, defaultColor, textColor, borderRadius);

    // Crear un GridBagConstraints para especificar la posición y las restricciones de los componentes
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.insets = new Insets(10, 15, 10, 10); // Espaciado de los componentes
    gbc.anchor = GridBagConstraints.WEST; // Alinear los componentes a la izquierda
    
    // Añadir los componentes al panel utilizando las restricciones de GridBag
    gbc.gridy = 1;
    panelInfo.add(lblPlayerName, gbc); // Añadir la etiqueta de nombre del jugador
    gbc.gridy = 2;
    panelInfo.add(lblRound, gbc); // Añadir la etiqueta de ronda
    gbc.gridy = 3;
    panelInfo.add(lblPoints, gbc); // Añadir la etiqueta de puntos
    gbc.gridy = 5;
    panelInfo.add(label5, gbc); // Etiqueta vacía para espaciado
    gbc.gridy = 6;
    panelInfo.add(label6, gbc); // Otra etiqueta vacía para espaciado
    gbc.gridy = 7;
    panelInfo.add(customeList, gbc); // Añadir la lista personalizada
    
    // Revalidar y repintar el panel para aplicar los cambios
    panelInfo.revalidate();
    panelInfo.repaint();
    }
    
    // -------------------------------- METODO QUE MUESTRA LA PANTALLA DE PERDEDOR O GANADOR
   private void mainMenu() {
    // Detener el temporizador que puede estar corriendo en el juego
    stopTimer();
    
    // Ejecutar una tarea después de 1000 milisegundos (1 segundo)
    ThreadTimer.execute(1000, () -> {
        // Variable que contendrá el mensaje a mostrar al final del juego
        String message = "";
        
        // Restablecer las palabras en la base de datos o el almacenamiento (probablemente para reiniciar el juego o limpiar los datos previos)
        dbConnection.resetWords();           

        // Cerrar la ventana actual (probablemente la pantalla de juego)
        this.dispose(); 

        // Dependiendo de cuántas vidas le queden al jugador, se decide el mensaje a mostrar
        if (lives > 1) {
            // Si el jugador tiene más de 1 vida, significa que ganó
            message = "HAS GANADO";
        } else {
            // Si el jugador tiene 1 o menos vidas, significa que perdió
            message = "HAS PERDIDO";
        }
        
        // Crear una nueva instancia de la pantalla de ganador, pasando el mensaje y el nombre del jugador
        WinnerScreen winnerScreen = new WinnerScreen(message, playerName);
        
        // Hacer visible la pantalla de ganador
        winnerScreen.setVisible(true);
        
        // Centrar la ventana de la pantalla de ganador en la pantalla
        winnerScreen.setLocationRelativeTo(null);
        });
    }
    
    // -------------------------------- METODO PARA OBTENER LA PALABRA DE LA CONEXION A LA BASE DE DATOS
   private void getWord() {
    try {
        // Obtener una palabra aleatoria de la base de datos a través de la conexión
        word = dbConnection.getRandomWord();

        // Verificar si la palabra obtenida es nula o está vacía
        if (word == null || word.isEmpty()) {
            // Si no se pudo obtener una palabra, mostrar un mensaje de error
            JOptionPane.showMessageDialog(null, "No se pudo obtener la palabra de la Base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convertir la palabra a mayúsculas
        word = word.toUpperCase();
        // Imprimir la palabra en la consola (útil para depuración)
        System.out.println("La palabra es: " + word);

        // Limpiar el panel que mostrará las letras
        panelLetters.removeAll();
        
        // Crear una etiqueta para cada letra de la palabra
        for (int i = 0; i < word.length(); i++) {
            JLabel lblLetter = new JLabel("_"); // Inicialmente, mostrar un guion bajo por cada letra
            lblLetter.setFont(new Font("Arial", Font.BOLD, 30)); // Establecer fuente y tamaño de letra
            lblLetter.setHorizontalAlignment(SwingConstants.CENTER); // Centrar el texto
            lblLetter.setPreferredSize(new Dimension(40, 40)); // Establecer el tamaño preferido de cada etiqueta

            // Agregar la etiqueta al panel de letras
            panelLetters.add(lblLetter);
        }

        // Hacer que el panel de letras sea enfocable, para que pueda recibir eventos de teclado
        panelLetters.setFocusable(true);
        panelLetters.requestFocusInWindow(); // Solicitar el enfoque en el panel

        // Agregar un KeyListener al panel para detectar las teclas presionadas
        panelLetters.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Obtener la letra presionada y convertirla a mayúscula
                char guessedLetter = Character.toUpperCase(e.getKeyChar());
                
                // Verificar si la tecla presionada es una letra
                if (Character.isLetter(guessedLetter)) {
                    // Llamar al método que verifica si la letra es correcta
                    checkGuess(guessedLetter, word);
                }
            }
        });

        // Volver a validar el panel para reflejar los cambios
        panelLetters.revalidate();
        // Volver a pintar el panel para actualizar la interfaz
        panelLetters.repaint();
    } catch (Exception e) {
        // Si ocurre algún error, imprimir el stack trace y mostrar un mensaje de error
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener la palabra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // -------------------------------- METODO PARA VERIFICAR LAS LETRAS, RONDAS, PUNTOS
    private void checkGuess(char guessedLetter, String word) {
    // VARIABLES PARA LAS VIDAS Y EL ESTADO DE LA PALABRA
    boolean found = false; // Indica si la letra adivinada fue correcta
    boolean wordComplete = true; // Indica si toda la palabra ha sido completada

    // Recorrer cada letra de la palabra
    for (int i = 0; i < word.length(); i++) {
        // Obtener el componente JLabel correspondiente a cada letra en el panel
        JLabel lblLetter = (JLabel) panelLetters.getComponent(i);

        // Si la letra adivinada coincide con la letra en la palabra
        if (word.charAt(i) == guessedLetter) {
            // Actualizar la etiqueta para mostrar la letra adivinada
            lblLetter.setText(String.valueOf(guessedLetter));
            // Si la letra existe, cambiar la variable 'found' a true
            found = true;
        }

        // Si alguna letra en el panel aún no ha sido adivinada (es un guion bajo), la palabra no está completa
        if (lblLetter.getText().equals("_")) {
            wordComplete = false;
        }
    }

    // Si la letra no fue encontrada en la palabra, se verifica las vidas restantes
    if (!found) {
        verificarVidas(found); // Llamar al método que verifica las vidas
    }

    // Si el jugador ha alcanzado la cantidad de puntos necesaria para completar una ronda
    if (points >= wordsToInt && !isUpdatingRound) {
        isUpdatingRound = true;  // Bloquear la actualización de la ronda mientras se procesa

        // Si no se han alcanzado el número máximo de rondas, aumentar la ronda
        if (round < roundsToInt) {
            round++; // Incrementar la ronda
            lblRound.setText("Rondas --> " + round); // Actualizar la etiqueta de la ronda
        } else {
            // Si se alcanzó el número máximo de rondas, finalizar el juego
            mainMenu();
            return;
        }

        // Reiniciar los puntos al finalizar la ronda
        ThreadTimer.execute(500, () -> {
            points = 0;
            lblPoints.setText("Puntos --> " + points); // Mostrar los puntos actualizados
            isUpdatingRound = false; // Permitir la actualización de la siguiente ronda
        });
    }

    // Si toda la palabra ha sido completada correctamente
    if (wordComplete && !isWordComplete) {
        isWordComplete = true;  // Marcar que la palabra está completa
        points++;  // Incrementar los puntos
        lblPoints.setText("Puntos --> " + points); // Actualizar los puntos en la interfaz

        // Reiniciar el temporizador
        ThreadTimer.execute(700, () -> {
            timeToInt = timeInitial;  // Reiniciar el tiempo al valor inicial
            lblTimer.setText("TIEMPO: " + timeToInt); // Actualizar el temporizador
        });

        // Obtener una nueva palabra después de completar la palabra actual
        ThreadTimer.execute(500, () -> {
            getWord();  // Llamar al método para obtener una nueva palabra
            isWordComplete = false; // Marcar que la palabra ya no está completa
            });
        }
    }
    
    // -------------------------------- METODO PARA VERIFICAR LAS VIDAS Y DIBUJAR EL MONITO
   private void verificarVidas(boolean found) {
    // Variable para manejar el gráfico de dibujo del monito
    Graphics g;

    // Si la letra no fue encontrada y el jugador aún tiene vidas
    if (!found && lives > 0) {

        // Si aún tiene vidas para restar
        if (lives != 0) {
            g = panelMonito.getGraphics(); // Obtener el objeto Graphics del panel donde se dibuja el monito
            
            Graphics2D g2d = (Graphics2D) g; // Convertirlo a Graphics2D para tener más control sobre el dibujo (líneas, formas)

            g2d.setStroke(new BasicStroke(5)); // Establecer el grosor de las líneas a 5 píxeles (para dibujar el monito con mayor grosor)

            // Según la cantidad de vidas restantes, se dibuja una parte del monito
            switch (lives - 1) {
                case 0:
                    g.drawLine(200, 180, 230, 220); // PIERNA DERECHA
                    break;
                case 1:
                    g.drawLine(200, 180, 170, 220); // PIERNA IZQUIERDA
                    break;
                case 2:
                    g.drawLine(200, 140, 230, 160); // BRAZO DERECHO
                    break;
                case 3:
                    g.drawLine(200, 140, 170, 160); // BRAZO IZQUIERDO
                    break;
                case 4:
                    g.drawLine(200, 120, 200, 180); // CUERPO
                    break;
                case 5:
                    g.drawOval(180, 80, 40, 40); // CABEZA (Dibuja una cabeza con un óvalo)
                    break;
            }

            // Disminuir el número de vidas restantes
            lives--;

            // Actualizar la etiqueta de vidas en la interfaz
            lblLives.setText("VIDAS: " + lives);
        } else {
            // Si ya no hay vidas, reiniciar las palabras en la base de datos
            dbConnection.resetWords();
            // Llamar al menú principal para finalizar el juego
            mainMenu();
            // Remover el listener de teclas para que no se sigan procesando entradas
            panelLetters.removeKeyListener(panelLetters.getKeyListeners()[0]);
            return; // Salir del método porque ya no se debe seguir ejecutando
            }
        }
    }
    
    // -------------------------------- METODO QUE DECREMENTA EL TIMEPO DEL TIMER
    private void startTimer() {
    // Se crea un Timer que se ejecutará cada 1000 milisegundos (1 segundo)
    timer = new Timer(1000, (ActionEvent e) -> {
        
        // Si aún queda tiempo
        if (timeToInt > 0) {
            timeToInt--; // Decrementa el tiempo
            lblTimer.setText("TIEMPO: " + timeToInt); // Actualiza la etiqueta del temporizador con el nuevo valor
        } 
        
        // Si el tiempo se agotó y el jugador tiene puntos
        else if (points > 0) {
            points--;  // Decrementa los puntos
            lblPoints.setText("Puntos --> " + points); // Actualiza la etiqueta de puntos

            // Restablece el temporizador al valor inicial
            timeToInt = timeInitial;
            lblTimer.setText("TIEMPO: " + timeToInt); // Actualiza el temporizador

            // Llama a la función para obtener una nueva palabra
            getWord();
        } 
        
        // Si los puntos llegaron a cero y la ronda es mayor que 1
        else if (points == 0 && round > 1) {
            round--; // Decrementa la ronda
            lblRound.setText("Rondas --> " + round); // Actualiza la etiqueta de ronda

            // Restablece el temporizador al valor inicial
            timeToInt = timeInitial;
            lblTimer.setText("TIEMPO: " + timeToInt); // Actualiza el temporizador

            // Llama a la función para obtener una nueva palabra
            getWord();
        } 
        
        // Si no se cumplen las condiciones anteriores, se resetea el temporizador y se obtiene una nueva palabra
        else {
            timeToInt = timeInitial; // Restablece el tiempo al valor inicial
            lblTimer.setText("TIEMPO: " + timeToInt); // Actualiza la etiqueta de temporizador

            // Llama a la función para obtener una nueva palabra
            getWord();
        }
    });

    // Inicia el temporizador
    timer.start();
    }
    
    // -------------------------------- METODO QUE DETIENE EL TIMER
    private void stopTimer() {
    // Verifica si el temporizador ya fue inicializado (no es nulo)
    if (timer != null) {
        timer.stop(); // Detiene el temporizador
        }
    }

   // -------------------------------- METODO PARA REINICIAR LOS CAMPOS AL INICIAR EL JUEGO
private void updateLabels() {
    // Actualiza la etiqueta del nombre del jugador con el valor de playerName
    lblPlayerName.setText(playerName);
    
    // Actualiza la etiqueta del temporizador con el valor actual de timeToInt
    lblTimer.setText("TIEMPO: " + timeToInt);
    
    // Actualiza la etiqueta de vidas con el valor actual de lives
    lblLives.setText("VIDAS: " + lives);
    
    // Actualiza la etiqueta de rondas con el valor actual de rounds
    lblRounds.setText("RONDAS: " + rounds);
    
    // Actualiza la etiqueta de la ronda actual con el valor de round
    lblRound.setText("Ronda --> " + round);
    
    // Actualiza la etiqueta de puntos con el valor de points
    lblPoints.setText("Puntos --> " + points);
    }  
    
    // -------------------------------- METODO QUE DINUJA LA HORCA
    @Override
   public void paint(Graphics g) {
    super.paint(g); // Llama al método de la clase padre para asegurarse de que la parte estándar de la pintura se realice.
    
    // Obtiene los gráficos del panelMonito (probablemente un JPanel donde se dibuja la horca)
    g = panelMonito.getGraphics();
    
    // Convierte el objeto Graphics en un Graphics2D para un mayor control y mayor capacidad de dibujo
    Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5)); // Grosor de las lineas

        g.drawLine(50, 250, 150, 250); // Base de la horca
        g.drawLine(100, 250, 100, 50); // Poste vertical
        g.drawLine(100, 50, 200, 50);  // Poste horizontal
        g.drawLine(200, 50, 200, 80);  // Cuerda 
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblLetters;
    private javax.swing.JLabel lblLives;
    private javax.swing.JLabel lblRounds;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JPanel panelGame;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelLetters;
    private javax.swing.JPanel panelMonito;
    // End of variables declaration//GEN-END:variables
}
