package TablasDB;

import java.sql.ResultSet;

public class PeliculasPorBiblioteca {
    
    Conexion cn = new Conexion();

    public void AgregarPeliculasXBiblioteca(Object p[]) throws Exception {

        try {
            cn.conectar();  
            cn.UID("INSERT INTO peliculasporbiblioteca(Cod_Biblioteca, Cod_Pelicula) values(\"" + p[0] + "\",\"" + p[1] + "\");");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No se pudo almacenar la pelicula en la biblioteca.");
        } finally {
            cn.desconectar();
        }

    }

    public ResultSet BuscarPeliculaXBiblioteca(int cod) throws Exception {
        ResultSet d = null;
        try {
            cn.conectar();
            d = cn.getValores("SELECT * FROM peliculasporbiblioteca WHERE Cod_Biblioteca='" + cod + "'");
        } catch (Exception e) {
            cn.desconectar();
            System.out.println("No logra obtener");
        } finally {
        }
        return d;
    }

    public ResultSet BuscarPeliculasXBilioteca() throws Exception {
        ResultSet d = null;
        try {
            cn.conectar();
            d = cn.getValores("SELECT Cod_Pelicula FROM peliculasporbibliotecas;");
        } catch (Exception e) {
            cn.desconectar();
            System.out.println("No logra obtener");
        } finally {
        }
        return d;
    }

    
}
