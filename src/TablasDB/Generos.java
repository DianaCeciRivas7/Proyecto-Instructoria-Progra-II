package TablasDB;

import java.sql.ResultSet;

public class Generos {

    Conexion cn = new Conexion();

    public void AgregarGeneros(Object p[]) throws Exception {

        try {
            cn.conectar();
            cn.UID("INSERT into Generos(Cod_Genero,Nombre_Genero) values(\"" + p[0] + "\",\"" + p[1] + "\");");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No logra ingresar");
        } finally {
            cn.desconectar();
        }

    }

    public void EliminarGeneros(int p) throws Exception {
        try {
            cn.conectar();
            cn.UID("DELETE FROM Generos WHERE Cod_Genero='" + p + "'");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No logra eliminar");
        } finally {
            cn.desconectar();
        }
    }

    public void ModificarDirectores(Object t[]) throws Exception {
        try {
            cn.conectar();
            cn.UID("UPDATE Generos set Nombre_Genero=\"" + t[1] + "\" where Cod_Genero=" + t[0] + "; ");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No logra modificar");

        } finally {
            cn.desconectar();
        }
    }

    public ResultSet obtenerCodDeGenero(String nom) {
        return cn.getValores("select (Cod_Genero)  from Generos where Nombre_Genero='" + nom + "' ;");
    }

    public ResultSet obtenerMaxGeneros() {
        return cn.getValores("select max(Cod_Genero) as maximo from Generos;");
    }

    public ResultSet obtenerNombreGeneros() {
        return cn.getValores("select (Nombre_Genero) from Generos;");
    }
}
