package TablasDB;

import java.sql.ResultSet;

public class PeliculasPorBiblioteca {

    Conexion cn = new Conexion();

    public void AgregarPelicula(Object p[]) throws Exception {

        try {
            cn.conectar();
            cn.UID("INSERT into PeliculasPorBiblioteca(Cod_Biblioteca,Cod_Pelicula) values(\"" + p[0] + "\",\"" + p[1] + "\");");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("no logra ingresar");
        } finally {
            cn.desconectar();
        }

    }

    public ResultSet obtenerBibliotecas(String param) {
        return cn.getValores("select Peliculas.Nombre_Pelicula as nombre, Peliculas.portada from PeliculasPorBiblioteca inner join Peliculas on PeliculasPorBiblioteca.Cod_Pelicula=Peliculas.Cod_Pelicula where PeliculasPorBiblioteca.Cod_Biblioteca=" + param + " ;");
    }

}
