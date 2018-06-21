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

    public ResultSet ObtenerNombreImagen() {
        return cn.getValores("SELECT Nombre_Pelicula,portada FROM Peliculas ;");
    }

    public ResultSet ObtenerDatos(String nom) {
        return cn.getValores("SELECT Peliculas.Nombre_Pelicula, Peliculas.Sinopsis, Peliculas.Duracion, Peliculas.Año, Peliculas.portada, Directores.Nombre_Director,Directores.Apellido_Director,Generos.Nombre_Genero FROM Peliculas inner join Directores on Directores.Cod_Director=Peliculas.Cod_Director inner join Generos on Generos.Cod_Genero=Peliculas.Cod_Genero where Nombre_Pelicula='" + nom + "';");
    }

    public ResultSet ObtenerConteo() {
        return cn.getValores("SELECT count(portada) as cont from Peliculas;");
    }

    public ResultSet obtenerMaxPelicula() {
        return cn.getValores("select max(Cod_Pelicula) as maximo from Peliculas;");
    }

    public ResultSet obtenerNombres() {
        return cn.getValores("select Nombre_Pelicula as Nombre from Peliculas;");
    }

    public ResultSet ObtenerNombreImagenOrdenado(String param) {
        return cn.getValores("SELECT Nombre_Pelicula,portada FROM Peliculas order by " + param + " ;");
    }

    public ResultSet ObtenerCodigo(String param) {
        return cn.getValores("SELECT Cod_Pelicula FROM Peliculas where Nombre_Pelicula='" + param + "' ;");
    }
    
    public ResultSet ObtenerNombre(String param) {
        return cn.getValores("SELECT Nombre_Pelicula FROM Peliculas where Cod_Pelicula=" + param + " ;");
    }
}
