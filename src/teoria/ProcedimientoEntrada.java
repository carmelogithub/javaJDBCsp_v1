package teoria;

import java.sql.*;

public class ProcedimientoEntrada {

    public static void main(String[] args){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_sp","root","");
            CallableStatement cs = conn.prepareCall("{call sp_add_alumnos(?,?,?,?)}");
            conn.prepareCall("{call sp_add_alumnos(?,?,?,?)}");
            cs.setString(1, "nombre prueba");
            cs.setString(2, "apellido prueba");
            cs.setString(3, "correo prueba");
            cs.setString(4, "telefono prueba");
            int filas=cs.executeUpdate();
            System.out.println("Se insertaron "+filas+" registros");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}//cierra class
