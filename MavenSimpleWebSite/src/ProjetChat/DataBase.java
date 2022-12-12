import java.sql.*;

public class DataBase {

public static void createNewDataBase(String fileName){
    String url = "jdbc:sqlite:" + fileName;
    
    try {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(url);
        if (conn != null) {
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("A new database has been created.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void connect(){
    Connection conn = null;
    try{
        String url = "jdbc:sqlite:" + "test.bd";
        conn = DriverManager.getConnection(url, "root", "7nains");
        System.out.println("Connection to SQLite haz been established."); 
    } catch (Exception e){
        e.printStackTrace();
    } finally {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public static void createNewTable(){

    String url = "jdbc:sqlite:" + "test.bd";
    String resquest = "CREATE TABLE userMessages (\n"
                    + " idMessage integer NOT NULL PRIMARY KEY,\n"
                    + "idSender integer NOT NULL,\n"
                    +"message text,\n"
                    +"time date,\n"
                    +" );";
    try {
        
    } catch (Exception e) {
        // TODO: handle exception
    }
}

public static void main(String[] args) {
    createNewDataBase("test.db");
}
    
}

