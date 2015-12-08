package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Articulos;
import com.fpuna.sigeres.modelo.Departamentos;
import com.fpuna.util.Messages;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.UploadedFile;

@ManagedBean(name = "articulobean")
@ViewScoped
public class ArticuloBean implements Serializable {

    private Articulos articulo;
    private List<Articulos> lista;
    private List<Articulos> listafiltro;
    private Articulos articuloSelected;
    private UploadedFile imagen;
    private String baseUrl;

    //metodos
    public void guardar() {
        try {
            articulo.setCodigo(articulo.getCodigo().toUpperCase());
            if (articulo.getId() == null) {
                DaoFactory.getArticuloDAO().add(articulo);
            } else {
                DaoFactory.getArticuloDAO().edit(articulo);
            }
            Messages.infoMessage("Exito");
            resetFields();

        } catch (Exception e) {
            Messages.errorMessage("error");
        }
    }

    public void eliminar() {
        try {
            DaoFactory.getArticuloDAO().delete(articulo);
        } catch (Exception e) {

        }
    }

    public void writeImageInDisk() throws IOException {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {

            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

            String dirImageArticulo = (String) servletContext.getRealPath("/imagens");
            System.out.println(" valor del directorio ---> " + dirImageArticulo);

            outputStream = new FileOutputStream(new File("C://dir//"
                    + this.articulo.getCodigo() + ".png"));

            inputStream = imagen.getInputstream();

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {

                outputStream.write(bytes, 0, read);

            }
            Messages.infoMessage("Correcto.");
        } catch (Exception e) {
            e.printStackTrace();
            Messages.errorMessage("Error.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }

    public void contextPath() {
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

        String directorio = (String) servletContext.getRealPath("/imagens");
     
        this.baseUrl = "C:/dir/";
    }

    private void resetFields() {
        this.articulo = new Articulos();
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public boolean isEditando() {
        return articulo.getId() != null;
    }

    public void listarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getArticuloDAO().getAll("ACTIVO");
                }
            } else {
                lista = DaoFactory.getArticuloDAO().getAll("ACTIVO");
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void listarTabla(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    lista = DaoFactory.getArticuloDAO().getAll();
                }
            } else {
                lista = DaoFactory.getArticuloDAO().getAll();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void listarComboById(Departamentos id) {
        try {
            if (id != null) {
                lista = DaoFactory.getArticuloDAO().getAll(id);
            } else {
                //lista = DaoFactory.getArticuloDAO().getAll("ACTIVO");
                lista = null;
            }
        } catch (Exception e) {

        }
    }
 
    //constructor
    public ArticuloBean() {
        this.articulo = new Articulos();
        this.lista = new ArrayList();
    }

    @PostConstruct
    public void init(){
        contextPath();
    }
    //Setter,getters
    public Articulos getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulos articulo) {
        this.articulo = articulo;
    }

    public List<Articulos> getLista() {
        return lista;
    }

    public void setLista(List<Articulos> lista) {
        this.lista = lista;
    }

    public List<Articulos> getListafiltro() {
        return listafiltro;
    }

    public void setListafiltro(List<Articulos> listafiltro) {
        this.listafiltro = listafiltro;
    }

    public Articulos getArticuloSelected() {
        return articuloSelected;
    }

    public void setArticuloSelected(Articulos articuloSelected) {
        this.articuloSelected = articuloSelected;
    }

    public UploadedFile getImagen() {
        return imagen;
    }

    public void setImagen(UploadedFile imagen) {
        this.imagen = imagen;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

}
