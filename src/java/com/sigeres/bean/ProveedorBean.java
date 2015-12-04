package com.sigeres.bean;

import com.sigeres.conexionbase.ABMGenerico;
import com.sigeres.entidades.Proveedor;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProveedorBean {
    private Proveedor proveedor = new Proveedor();

    
    
    public void registrar(){
       ABMGenerico abmProveedor = new ABMGenerico();
       Map<Integer, Proveedor > map = new HashMap<Integer, Proveedor>();
       map.put(1, this.proveedor);
       String preparedStatement = "INSERT INTO (nombre,telefono)"
                                + "INTO proveedores VALUES(?,?)";
       
    }
    // setters y getters
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
}
