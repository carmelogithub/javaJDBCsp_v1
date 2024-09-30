package practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio103 {
    public static void main(String[] args){
        //insertar clientes con una consulta paramétrica. PreparedStatement
        Connection conn=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_empresa","root","");
            String insertar="INSERT INTO clientes (nombre, ciudad, fecha_inicio) VALUES (?,?,?)";
            PreparedStatement ps=conn.prepareStatement(insertar);
            Scanner sc=new Scanner(System.in);
            System.out.println("Introduce el nombre del cliente: ");
            ps.setString(1,sc.next());
            System.out.println("Introduce la ciudad del cliente: ");
            ps.setString(2,sc.next());
            System.out.println("Introduce la fecha de inicio del cliente: (yyyy-MM-DD)");
            ps.setString(3,sc.next());//añadir la fecha como String
            int filas=ps.executeUpdate();
            System.out.println("Filas afectadas: "+filas);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//cierra main
}//cierra class
