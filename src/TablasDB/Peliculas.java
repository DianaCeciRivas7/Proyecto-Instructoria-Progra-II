package TablasDB;

import java.sql.ResultSet;

public class Peliculas {
    
    Conexion cn = new Conexion();

    public void AgregarPelicula(Object p[]) throws Exception {

        try {
            cn.conectar();
            cn.UID("INSERT into Peliculas(Cod_Pelicula,Nombre_Pelicula,Sinopsis,Duracion,Año,Cod_Genero,Cod_Director,portada) values(\"" + p[0] + "\",\"" + p[1] + "\",\"" + p[2] + "\",\"" + p[3] + "\",\"" + p[4] + "\",\"" + p[5] + "\",\"" + p[6] + "\",\"" + p[7] + "\");");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No logra ingresar");
        } finally {
            cn.desconectar();
        }

    }

    public void EliminarPelicula(int p) throws Exception {
        try {
            cn.conectar();
            cn.UID("DELETE FROM Peliculas WHERE Cod_Pelicula='" + p + "'");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No logra eliminar");
        } finally {
            cn.desconectar();
        }
    }

    public ResultSet ObtenerNombreImagen(int cod) {
        return cn.getValores("SELECT Nombre_Pelicula,portada FROM Peliculas where Cod_Pelicula=" + cod + ";");
    }

    public ResultSet ObtenerConteo() {
        return cn.getValores("SELECT count(portada) as cont from Peliculas;");
    }

    public ResultSet obtenerMaxPelicula() {
        return cn.getValores("select max(Cod_Pelicula) as maximo from Peliculas;");
    }

    public ResultSet obtenerDatosTabla() {
        return cn.getValores("select Peliculas.Cod_Pelicula,Peliculas.Nombre_Pelicula,Generos.Nombre_Genero,Directores.Nombre_Director,Directores.Apellido_Director,Peliculas.Año from Peliculas inner join Generos on Generos.Cod_Genero=Peliculas.Cod_Genero inner join Directores on Directores.Cod_Director=Peliculas.Cod_Director;");
    }
    
}
