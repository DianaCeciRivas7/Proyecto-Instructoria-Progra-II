package TablasDB;

import java.sql.ResultSet;

public class Usuarios {

    Conexion cn = new Conexion();

    public void AgregarUsuario(Object p[]) throws Exception {

        try {
            cn.conectar();
            cn.UID("INSERT into Usuarios(Nombre_Usuario,Contraseña) values(\"" + p[0] + "\",\"" + p[1] + "\");");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("no logra ingresar");
        } finally {
            cn.desconectar();
        }

    }

    public ResultSet BuscarUsuario(String Nombre) throws Exception {
        ResultSet d = null;
        try {
            cn.conectar();
            d = cn.getValores("SELECT (Contraseña) FROM Usuarios WHERE Nombre_Usuario='" + Nombre + "'");
        } catch (Exception e) {
            cn.desconectar();
            System.out.println("No logra obtener");
        } finally {
        }
        return d;
    }

    public ResultSet BuscarUsuarios() throws Exception {
        ResultSet d = null;
        try {
            cn.conectar();
            d = cn.getValores("SELECT (Nombre_Usuario) FROM Usuarios;");
        } catch (Exception e) {
            cn.desconectar();
            System.out.println("No logra obtener");
        } finally {
        }
        return d;
    }

}
