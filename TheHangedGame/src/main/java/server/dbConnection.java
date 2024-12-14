package server;

import java.sql.*;

public class dbConnection {

    // Variables estáticas para la conexión a la base de datos
    static String url = "jdbc:mysql://127.0.0.1:3306/game"; // URL de la base de datos
    static String user = "luis"; // Usuario para la base de datos
    static String password = "1583497620"; // Contraseña de la base de datos
    
    // Método para conectar a la base de datos
    public static Connection conectar() {
        Connection con = null;
        
        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establecer la conexión con la base de datos
            con = DriverManager.getConnection(url, user, password);
            System.out.println("CONEXION ESTABLECIDA CON LA BASE DE DATOS");
        } catch(SQLException e) {
            // Captura errores de conexión
            e.printStackTrace();
            System.out.println("ERROR AL CONECTARSE A LA BASE DE DATOS");
        } catch(ClassNotFoundException e) {
            // Captura errores si no se encuentra el controlador JDBC
            e.printStackTrace();
            System.out.println("ERROR: No se encontró el controlador JDBC.");
        }
        
        return con;
    }

    // Método para obtener una palabra aleatoria de la base de datos y actualizar su estado
    public static String getRandomWord() {
        String word = null;
        Connection con = conectar();
        
        if (con != null) {
            // Consulta para obtener una palabra que no haya sido utilizada
            String querySelect = "SELECT word FROM words WHERE used = FALSE ORDER BY RAND() LIMIT 1";
            // Consulta para marcar la palabra como utilizada
            String queryUpdate = "UPDATE words SET used = TRUE WHERE word = ?";
            try (PreparedStatement stmtSelect = con.prepareStatement(querySelect);
                PreparedStatement stmtUpdate = con.prepareStatement(queryUpdate);
                ResultSet rs = stmtSelect.executeQuery()) {
                
                if (rs.next()) {
                    // Si se encuentra una palabra, se obtiene y se actualiza su estado
                    word = rs.getString("word");
                    stmtUpdate.setString(1, word);
                    stmtUpdate.executeUpdate();

                    // Reemplazar caracteres especiales en la palabra
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
                    // Si no se encuentra ninguna palabra, reiniciar todas las palabras
                    resetWords();
                }
            } catch (SQLException e) {
                // Captura errores durante la obtención de la palabra
                e.printStackTrace();
                System.out.println("ERROR AL OBTENER LA PALABRA ALEATORIA");
            } finally {
                // Asegura el cierre de la conexión con la base de datos
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
    
    // Método para cargar todas las palabras de la base de datos
    public ResultSet loadWords() {
        String query = "SELECT * FROM words"; // Consulta para obtener todas las palabras
        Connection con = conectar();

        try {
            // Crear una sentencia para ejecutar la consulta
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return st.executeQuery(query); // Retorna el conjunto de resultados
        } catch (SQLException ex) {
            // Captura errores durante la ejecución de la consulta
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
        }
        return null;
    }

    // Método para reiniciar el campo 'used' a 'FALSE' para todas las palabras
    public static void resetWords() {
        Connection con = conectar();
        
        if (con != null) {
            String query = "UPDATE words SET used = FALSE"; // Consulta para reiniciar las palabras
            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.executeUpdate(); // Ejecuta la actualización
                System.out.println("TODAS LAS PALABRAS HAN SIDO REINICIADAS A FALSE");
            } catch (SQLException e) {
                // Captura errores al reiniciar las palabras
                e.printStackTrace();
                System.out.println("ERROR AL REINICIAR LAS PALABRAS");
            } finally {
                // Asegura el cierre de la conexión con la base de datos
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
