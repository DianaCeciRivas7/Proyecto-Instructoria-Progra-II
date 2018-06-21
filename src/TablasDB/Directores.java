package TablasDB;

import java.sql.ResultSet;

public class Directores {

    Conexion cn = new Conexion();

    public void AgregarDirectores(Object p[]) throws Exception {

        try {
            cn.conectar();
            cn.UID("INSERT into Directores(Cod_Director,Nombre_Director,Apellido_Director) values(\"" + p[0] + "\",\"" + p[1] + "\",\"" + p[2] + "\");");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No logra ingresar");
        } finally {
            cn.desconectar();
        }

    }

    public void EliminarDirectores(int p) throws Exception {
        try {
            cn.conectar();
            cn.UID("DELETE FROM Directores WHERE Cod_Director='" + p + "'");
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
            cn.UID("UPDATE Directores set Nombre_Director=\"" + t[1] + "\", Apellido_Director=\"" + t[2] + "\" where Cod_Director=" + t[0] + "; ");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("No logra modificar");

        } finally {
            cn.desconectar();
        }
    }

    public ResultSet obtenerCodDeDirector(String nom, String ape) {
        return cn.getValores("select (Cod_Director)  from Directores where Nombre_Director='" + nom + "' and Apellido_Director='" + ape + "';");
    }

    public ResultSet obtenerMaxDirectores() {
        return cn.getValores("select max(Cod_Director) as maximo from Directores;");
    }

    public ResultSet obtenerNombreApellidoDirectores() {
        return cn.getValores("select Nombre_Director,Apellido_Director from Directores;");
    }

}
