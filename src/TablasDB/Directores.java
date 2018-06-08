
package TablasDB;

import java.sql.ResultSet;

public class Directores {
    
    Conexion cn = new Conexion();

    public void AgregarDirectores(Object p[]) throws Exception {

        try {
            cn.conectar();
            cn.UID("INSERT into Directores(Cod_Director,Nombre_Director,Apellido_Director) values(\"" + p[0] + "\",\"" + p[1] + "\",\"" + p[3] + "\");");
            cn.desconectar();
        } catch (Exception e) {                
            System.out.println("No logra ingresar");
        } finally {
            cn.desconectar();
        }

    }

    public ResultSet BuscarDirector(String Nombre) throws Exception {
        ResultSet d = null;
        try {
            cn.conectar();
            d = cn.getValores("SELECT (Cod_Director) FROM Directores);");
        } catch (Exception e) {
            cn.desconectar();
            System.out.println("No logra obtener");
        } finally {
        }
        return d; //Aqui no se que hacer
    }

    public void EliminarDirectores() throws Exception {
        // ResultSet d = null;
        try {
            cn.conectar();
            cn.desconectar();cn.UID("TRUNCATE TABLE Directores;");
            cn.desconectar();
        } catch (Exception e) {
            
            System.out.println("No logra eliminar");
        } finally {
            cn.desconectar();
        }
        //}
        //return d;  //Aqui no se que hacer x2
    }
    
    public void CambiarDirectores(Object p[]) throws Exception {

        try {
            cn.conectar();
            cn.UID("UPDATE Directores;");
            //No se como se haria el cambio xD
            cn.desconectar();
        } catch (Exception e) {                
            System.out.println("No logra ingresar");
        } finally {
            cn.desconectar();
        }

    }
    
}
