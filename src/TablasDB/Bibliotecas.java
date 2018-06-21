package TablasDB;

import java.sql.ResultSet;

public class Bibliotecas {

    Conexion cn = new Conexion();

    public void AgregarBiblioteca(Object p[]) throws Exception {

        try {
            cn.conectar();
            cn.UID("INSERT into Bibliotecas(Cod_Biblioteca,Nombre_Biblioteca,Nombre_Usuario) values(\"" + p[0] + "\",\"" + p[1] + "\",\"" + p[2] + "\");");
            cn.desconectar();
        } catch (Exception e) {
            System.out.println("no logra ingresar");
        } finally {
            cn.desconectar();
        }

    }

    public ResultSet obtenerBibliotecas(String nom) {
        return cn.getValores("select Nombre_Biblioteca from Bibliotecas where Nombre_Usuario=\"" + nom + "\" ;");
    }

    public ResultSet obtenerMaxBibliotecas(String nom) {
        return cn.getValores("select max(Cod_Biblioteca) as maximo from Bibliotecas where Nombre_Usuario='" + nom + "' ;");
    }

    public ResultSet obtenerNombresBibliotecas() {
        return cn.getValores("select Nombre_Biblioteca from Bibliotecas;");
    }

    public ResultSet obtenerCodigo(String nom, String nomUsuario) {
        return cn.getValores("select Cod_Biblioteca from Bibliotecas where Nombre_Biblioteca='" + nom + "' and Nombre_Usuario='" + nomUsuario + "' ;");
    }
}
