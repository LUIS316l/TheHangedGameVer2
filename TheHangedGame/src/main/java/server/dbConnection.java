package server;

import java.sql.*;

public class dbConnection {

    static String url = "jdbc:mysql://127.0.0.1:3306/game";
    static String user = "luis";
    static String password = "1583497620";
    
    public static Connection conectar() {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(url, user, password);
            System.out.println("CONEXION ESTABLECIDA CON LA BASE DE DATOS");
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR AL CONECTARSE A LA BASE DE DATOS");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR: No se encontró el controlador JDBC.");
        }
        
        return con;
    }

    // Método para obtener una palabra aleatoria y actualizar el campo used a true
    public static String getRandomWord() {
        String word = null;
        Connection con = conectar();
        
        if (con != null) {
            String querySelect = "SELECT word FROM words WHERE used = FALSE ORDER BY RAND() LIMIT 1";
            String queryUpdate = "UPDATE words SET used = TRUE WHERE word = ?";
            try (PreparedStatement stmtSelect = con.prepareStatement(querySelect);
                PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate);
                ResultSet rs = stmtSelect.executeQuery()) {
                
                if (rs.next()) {
                    word = rs.getString("word");
                    stmtUpdate.setString(1, word);
                    stmtUpdate.executeUpdate();

                    // Reemplazar letras especiales
                    word = word.replace("é", "e")
                        .replace("á", "a")
                        .replace("í", "i")
                        .replace("ó", "o")
                        .replace("ú", "u")
                        .replace("ñ", "n")
                        .replace("Ñ", "N")
                        .replace("Á", "A")
                        .replace("Í", "I")
                        .replace("Ó", "O")
                        .replace("Ú", "U")
                        .replace("ü", "u");
                } else {
                    // Si no se encuentran palabras, reiniciar todas las palabras a used = FALSE
                    resetWords();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERROR AL OBTENER LA PALABRA ALEATORIA");
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("ERROR AL CERRAR LA CONEXIÓN");
                }
            }
        }
        
        return word;
    }
    
    public ResultSet loadWords() {
        String query = "SELECT * FROM words";
        Connection con = conectar();

        try {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
        }
        return null;
    }

    // Método para reiniciar el campo used a false para todas las palabras
    public static void resetWords() {
        Connection con = conectar();
        
        if (con != null) {
            String query = "UPDATE words SET used = FALSE";
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.executeUpdate();
                System.out.println("TODAS LAS PALABRAS HAN SIDO REINICIADAS A FALSE");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERROR AL REINICIAR LAS PALABRAS");
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("ERROR AL CERRAR LA CONEXIÓN");
                }
            }
        }
    }
}
