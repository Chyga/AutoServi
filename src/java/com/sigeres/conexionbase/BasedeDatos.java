
package com.sigeres.conexionbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasedeDatos {
   private Connection conexion;

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Connection getConexion() {
        return conexion;
    }
    public void Conectar() throws Exception{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sigeresbdd?user=root&password=123");
        } catch (SQLException e){
            throw e;
        }
    }
    public void Cerrar() throws SQLException{
        try{
            if(conexion !=null){
                if (conexion.isClosed() == false) {
                    conexion.close();
                }
            }
        } catch(SQLException e){
            throw e;
        }
    }
}
