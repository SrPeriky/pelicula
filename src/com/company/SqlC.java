package com.company;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlC {

    private Conexion con;
    PreparedStatement ps;
    ResultSet res;

    public SqlC() {
        con = new Conexion();
    }

    public boolean insertar(String datos[], String insert){
        boolean estado = false;
        try {
            ps = con.conectado().prepareStatement(insert);
            for(int i=0; i<=datos.length-1;i++){
                ps.setString(i+1, datos[i]);
            }
            ps.execute();
            ps.close();
            estado = true;
        }catch(SQLException e){
            System.out.println(e);
        }
        return estado;
    }


    public Object [][] datosTabla(String nombrecol[], String tabla, String sql){
        int registros = 0;

        try{
            ps = con.conectado().prepareStatement("select count(*) as total from " + tabla);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }

        Object[][] dat = new String[registros][nombrecol.length];
        String col[] = new String[nombrecol.length];

        try{
            ps = con.conectado().prepareStatement(sql);
            res = ps.executeQuery();
            int i = 0;
            while(res.next()){
                for(int j=0; j<=nombrecol.length-1;j++){
                    col[j] = res.getString(nombrecol[j]);
                    dat[i][j] = col[j];
                }
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return dat;
    }

    public String datos_string(String nombre_columna, String sentenciasql){

        String datos ="";
        try{
            ps = con.conectado().prepareStatement(sentenciasql);
            res = ps.executeQuery();
            while(res.next()){
                datos = res.getString(nombre_columna);
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return datos;
    }

    public Object[] poblar_combox(String tabla, String nombrecol, String sql){
        int registros = 0;
        try{
            ps = con.conectado().prepareStatement("SELECT Num_Habitacion FROM " + tabla);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("Num_Habitacion");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }

        Object[] datos = new Object[registros];
        try{
            ps = con.conectado().prepareStatement(sql);
            res = ps.executeQuery();
            int i = 0;
            while(res.next()){
                datos[i] = res.getObject(nombrecol);
                i++;
            }
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return datos;
    }

    public boolean existe(String campo, String from_where){
        int registros = 0;
        try{
            ps = con.conectado().prepareStatement("SELECT count("+campo+") as total  " + from_where);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }catch(SQLException e){
            System.out.println(e);
        }

        if (registros >0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
