package teoria;

import java.sql.*;

public class ProcedimientosAlmacenados {
    public static void main(String[] args){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_sp","root","");
            CallableStatement cs = conn.prepareCall("{call sp_consultar()}");
            ResultSet rs =cs.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("nombre")+" "+rs.getString("apellido"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }//cierra main
}//cierra class
