package practica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio104 {

    public static void main(String[] args){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_empresa","root","");
            CallableStatement cs=conn.prepareCall("{call sp_update_fecha_inicio(?,?)}");

            cs.setString(1,"2021-05-22");
            cs.setInt(2,3);
            int filas=cs.executeUpdate();
            System.out.println("Filas afectadas: "+filas);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//cierra main

}//cierra class
