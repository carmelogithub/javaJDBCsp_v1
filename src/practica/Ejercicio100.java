package practica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio100 {

    public static void main(String[] args) {
        /*inserta registros en la tabla productos con id, nmbre, precio y stock
        con un proceimiento almacenado / rutina... ejecuta una consulta para actulizar datos de la tabla productos
         */
        Connection conn=null;
        try {
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/a_sp","root","");
            CallableStatement cs = conn.prepareCall("{call sp_update_productos(?)}");
            cs.setInt(1, 1);
            int filas_actualizadas=cs.executeUpdate();
            System.out.println("Se actualizaron "+filas_actualizadas+" registros");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }//cierra método main

}//cierra class
