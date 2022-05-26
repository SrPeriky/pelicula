package com.company;

public class Pelicula {

    SqlC Con;

    public Pelicula(){

        Con= new SqlC();
    }

    public boolean IngresarCliente(String Nom, String Des, String Fec){

        String datos[]={Nom, Des, Fec};

        return Con.insertar(datos, "INSERT INTO pelicula(nombre,descripcion,fecha) VALUES(?,?,?)");
    }

    public Object[][] ConsulMovie(){

        String[] Columnas={"id", "nombre","descripcion","fecha"};

        Object[][] Resultado= Con.datosTabla(Columnas, "pelicula", ""
                + "SELECT pelicula.id, pelicula.nombre, pelicula.descripcion, pelicula.fecha FROM pelicula");
        return Resultado;
    }
}
