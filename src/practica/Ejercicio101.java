package practica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio101 {

    public static void main(String[] args){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_sp","root","");
            CallableStatement cs=conn.prepareCall("{call sp_delete_productos(?)}");
            Scanner sc=new Scanner(System.in);
            System.out.println("Ingrese el id del producto a eliminar");
            cs.setInt(1, sc.nextInt());
            int filas=cs.executeUpdate();
            System.out.println("Se eliminaron "+filas+" registros");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }//cierra main

}//cierra class
