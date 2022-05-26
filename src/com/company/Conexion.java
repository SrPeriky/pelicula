package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {

    private final String url = "jdbc:mysql://localhost/pelicula";
    PreparedStatement psPrepararSentencia;
    Connection con = null;



    public Conexion() {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","root");
            if (con!=null){
                System.out.println("Conexión a base de datos Pelicula. listo");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
    }
    /**
     *
     * @return
     */
    public Connection conectado(){
        return con;
    }

    public void desconectar(){
        con = null;
        System.out.println("La conexion a la  base de datos a terminado");

    }


}
