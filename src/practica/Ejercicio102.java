package practica;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Ejercicio102 {

    public static void main(String[] args){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/a_sp","root","");
            //DatabaseMetaData.getTables(null,null,null,new String[]{"VIEW"});

            String consulta="select * from v_resumen";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(consulta);
            while (rs.next()){
                System.out.println(rs.getString("nombre")+"--"+rs.getString("titulo")+"--"+rs.getDate("fecha"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//cierra main

}//cierra class
