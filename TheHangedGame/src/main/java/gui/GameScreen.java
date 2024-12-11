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
import server.dbConnection;
import utils.ThreadTimer;


public class GameScreen extends JFrame {
    
    // VARIABLES 
    private int roundsToInt;
    private int timeToInt;
    private int wordsToInt;
    
    private String playerName;
    private String rounds;
    private String timeWords;
    private String wordsCant;
    
    private int lives = 6;  
    private int points = 0;
    private int round = 1;
    private int timeInitial;
    private String word;
    private boolean isWordComplete = false;
    private boolean isUpdatingRound = false;   
    
    private JLabel lblPlayerName;
    private JLabel lblRound;
    private JLabel lblPoints;
    
    private Timer timer = null;    
    
    // -------------------------------- CONSTRUCTOR
    public GameScreen(String playerName, String rounds, String timeWords, String wordsCant) {
        this.playerName = playerName;
        this.rounds = rounds;
        this.timeWords = timeWords;
        this.wordsCant = wordsCant;
        
        roundsToInt = Integer.parseInt(rounds);
        timeToInt = Integer.parseInt(timeWords);
        wordsToInt = Integer.parseInt(wordsCant);
        
        timeInitial = timeToInt;
               
        initComponents();
        addComponents();
        
        updateLabels();  
        getWord(); 
        startTimer();
        panelMonito.repaint();
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
    private void addComponents(){
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Player 1");
        model.addElement("Player 2");

        Font labelFont = new Font("Doto", Font.BOLD, 20);
        Color textColorLabel = Color.WHITE;

        Dimension listSize = new Dimension(300, 200); 
        Color defaultColor = new Color(255, 255, 255);
        Color textColor = Color.BLACK;
        
        int borderRadius = 10;
        
        lblPlayerName = new JLabel(" ");
        lblPlayerName.setFont(labelFont);
        lblPlayerName.setForeground(textColorLabel);
        
        lblRound = new JLabel("Ronda --> ");
        lblRound.setFont(labelFont);
        lblRound.setForeground(textColorLabel);
        
        lblPoints = new JLabel("Puntos --> ");
        lblPoints.setFont(labelFont);
        lblPoints.setForeground(textColorLabel);
                
        JLabel label5 = new JLabel(" ");
        JLabel label6 = new JLabel(" ");

        CustomeList<String> customeList = new CustomeList<>(model, listSize, defaultColor, textColor, borderRadius);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 15, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridy = 1;
        panelInfo.add(lblPlayerName, gbc);
        gbc.gridy = 2;
        panelInfo.add(lblRound, gbc);
        gbc.gridy = 3;
        panelInfo.add(lblPoints, gbc);
        gbc.gridy = 5;
        panelInfo.add(label5, gbc);
        gbc.gridy = 6;
        panelInfo.add(label6, gbc);
        gbc.gridy = 7;
        panelInfo.add(customeList, gbc); 

        panelInfo.revalidate();
        panelInfo.repaint();
    }
    
    // -------------------------------- METODO QUE MUESTRA LA PANTALLA DE PERDEDOR O GANADOR
    private void mainMenu() {
        stopTimer();
        
        ThreadTimer.execute(1000, () -> {
            String message = "";
        
            dbConnection.resetWords();           
                        
            this.dispose(); 

            if (lives > 1) {
                message = "HAS GANADO";
            } else {
                message = "HAS PERDIDO";
            }
            
            WinnerScreen winnerScreen = new WinnerScreen(message, playerName);
            winnerScreen.setVisible(true);
            winnerScreen.setLocationRelativeTo(null);
        });
    }
    
    // -------------------------------- METODO PARA OBTENER LA PALABRA DE LA CONEXION A LA BASE DE DATOS
    private void getWord() {
        try {
            word = dbConnection.getRandomWord();

            if (word == null || word.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se pudo obtener la palabra de la Base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            word = word.toUpperCase();
            System.out.println("La palabra es: " + word);

            panelLetters.removeAll();
            for (int i = 0; i < word.length(); i++) {
                JLabel lblLetter = new JLabel("_");
                lblLetter.setFont(new Font("Arial", Font.BOLD, 30));
                lblLetter.setHorizontalAlignment(SwingConstants.CENTER);
                lblLetter.setPreferredSize(new Dimension(40, 40));

                panelLetters.add(lblLetter);
            }

            panelLetters.setFocusable(true);
            panelLetters.requestFocusInWindow();
            panelLetters.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char guessedLetter = Character.toUpperCase(e.getKeyChar());
                    if (Character.isLetter(guessedLetter)) {
                        checkGuess(guessedLetter, word);
                    }
                }
            });

            panelLetters.revalidate();
            panelLetters.repaint();
        } catch (Exception e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Error al obtener la palabra: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // -------------------------------- METODO PARA VERIFICAR LAS LETRAS, RONDAS, PUNTOS
    private void checkGuess(char guessedLetter, String word) {
        // VARIABLE PARA LAS VIDAS
        boolean found = false;
        boolean wordComplete = true;
        
        for (int i = 0; i < word.length(); i++) {
            JLabel lblLetter = (JLabel) panelLetters.getComponent(i);
            if (word.charAt(i) == guessedLetter) {
                lblLetter.setText(String.valueOf(guessedLetter));
                // SI LA LETRA EXISTE LA VARIABLE SE VUELVE TRUE
                found = true;
            }
            if (lblLetter.getText().equals("_")) {
                wordComplete = false;
            }
        }      
        
        if (!found) {
            verificarVidas(found);
        }
        
        if(points >= wordsToInt && !isUpdatingRound) {
            isUpdatingRound = true; 
            
            if (round < roundsToInt) {
                round ++;
                lblRound.setText("Rondas --> " + round);   
            } else {
                mainMenu();
                return;
            }
            
            ThreadTimer.execute(500, () -> {
                points = 0;
                lblPoints.setText("Puntos --> " + points);
                isUpdatingRound = false;
            });
        }

        if (wordComplete && !isWordComplete) {
            isWordComplete = true;  
            points ++;
            lblPoints.setText("Puntos --> " + points);

            ThreadTimer.execute(700, () -> {
                timeToInt = timeInitial;
                lblTimer.setText("TIEMPO: " + timeToInt);
            });
            
            ThreadTimer.execute(500, () -> {
                getWord();
                isWordComplete = false;
            });
        }
    }
    
    // -------------------------------- METODO PARA VERIFICAR LAS VIDAS Y DIBUJAR EL MONITO
    private void verificarVidas(boolean found) {
        
        Graphics g;
        if (!found && lives > 0) {
                                   
            if (lives != 0) {
                g = panelMonito.getGraphics();
            
                Graphics2D g2d = (Graphics2D) g;

                g2d.setStroke(new BasicStroke(5));

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
                        g.drawOval(180, 80, 40, 40); // CABEZA
                        break;                
                }
                lives --;
                lblLives.setText("VIDAS: " + lives);         
            } else {
                dbConnection.resetWords();
                mainMenu();
                panelLetters.removeKeyListener(panelLetters.getKeyListeners()[0]);
                return;
            }
        }
    }
    
    // -------------------------------- METODO QUE DECREMENTA EL TIMEPO DEL TIMER
    private void startTimer() {
        timer = new Timer(1000, (ActionEvent e) -> {
            if (timeToInt > 0) {
                timeToInt --;
                lblTimer.setText("TIEMPO: " + timeToInt);
            } else if (points > 0) {
                points --   ;
                lblPoints.setText("Puntos --> " + points);
                
                timeToInt = timeInitial;
                lblTimer.setText("TIEMPO: " + timeToInt);
                
                getWord();
            } else if (points == 0 && round > 1) {
                round --;
                lblRound.setText("Rondas --> " + round);   

                timeToInt = timeInitial;
                lblTimer.setText("TIEMPO: " + timeToInt);
                
                getWord();
            } else {
                timeToInt = timeInitial;
                lblTimer.setText("TIEMPO: " + timeToInt);
                
                getWord();
            }
        });
        
        timer.start();
    }
    
    // -------------------------------- METODO QUE DETIENE EL TIMER
    private void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    // -------------------------------- METODO PARA REINICIAR LOS CAMPOS AL INICIAR EL JUEGO
    private void updateLabels() {
        lblPlayerName.setText(playerName);
        lblTimer.setText("TIEMPO: " + timeToInt);
        lblLives.setText("VIDAS: " + lives);
        lblRounds.setText("RONDAS: " + rounds);
        lblRound.setText("Ronda --> " + round);
        lblPoints.setText("Puntos --> " + points);
    }  
    
    // -------------------------------- METODO QUE DINUJA LA HORCA
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g = panelMonito.getGraphics();

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
