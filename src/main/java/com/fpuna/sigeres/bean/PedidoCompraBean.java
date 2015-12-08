package com.fpuna.sigeres.bean;

import com.fpuna.sigeres.dao.DaoFactory;
import com.fpuna.sigeres.modelo.Articulos;
import com.fpuna.sigeres.modelo.PedidoCompraDetalle;
import com.fpuna.sigeres.modelo.PedidosCompras;
import com.fpuna.sigeres.modelo.Usuarios;
import com.fpuna.util.Messages;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;

@ManagedBean(name = "pedidocomprabean")
@ViewScoped
public class PedidoCompraBean implements Serializable {

    private PedidosCompras pedidoCompra;
    private PedidoCompraDetalle pedidoCompraDetalle;
    private List<PedidosCompras> headerOrder;
    private List<PedidoCompraDetalle> itemList;
    private Articulos articuloSelected;
    private long total;

    //Metodo a utilizar en el boton guardar una vez cargado cabecera y detalle
    public void guardar() {
        try {
            if (pedidoCompraDetalle != null) {
                if (pedidoCompra.getId() == null) {
                    pedidoCompra = DaoFactory.getPedidoCompraDAO().add(pedidoCompra);
                    //recupera el objeto de pedido compra que retorna el metodo para poder obtener el id
                } else {
                    DaoFactory.getPedidoCompraDAO().edit(pedidoCompra);
                }
                if (pedidoCompra != null) {
                    guardarDetalle();
                } else {
                    Messages.errorMessage("Pedido no se puede guardar");
                }// siempre se ejecuta sea modificacion o insercion
                //resetear todo para cargar de nuevo
            } else {
                Messages.errorMessage("No ha cargado ningun detalle");
            }
        } catch (Exception ex) {
            Messages.errorMessage("Pedido no se puede guardar");
        }
    }

    public void guardarDetalle() {
        // recorre la headerOrder de detalle para aÃƒÂ±adir el pedido
        for (int i = 0; i < itemList.size(); i++) {
            pedidoCompraDetalle = itemList.get(i);
            try {
                if (pedidoCompraDetalle.getId() == null) {
                    // modifica agregando el id de la cabecera en cada detalle
                    pedidoCompraDetalle.setIdPedido(pedidoCompra);
                    DaoFactory.getPedidoCompraDetalleDAO().add(pedidoCompraDetalle);
                } else {
                    DaoFactory.getPedidoCompraDetalleDAO().edit(pedidoCompraDetalle);
                }
            } catch (Exception ex) {
            }
        }
        itemList.clear();

    }

    public void cargarUsuario(Object id) {
        Usuarios usr;
        usr = (Usuarios) id;
        if (pedidoCompra.getIdUsuario() == null) {
            pedidoCompra.setIdUsuario(usr);
            pedidoCompra.setFecha(new Date());
            pedidoCompra.setFechaEntrega(new Date());
            pedidoCompra.setEstado("PRESUPUESTADO");
        }
    }

    private void eliminarDetalle(int pos) {
        itemList.remove(pos);
        RequestContext.getCurrentInstance().update("editablePedido");
    }

    public void agregarDetalle(boolean fromDlg) {
        /*
         fromDlg, desde el dialogo cantidad
         solo si getCantidad es mayor a 0, se agrega a la lista
         */
        if (!fromDlg || (fromDlg && pedidoCompraDetalle.getCantidad() > 0)) {

            boolean BlnAgregar;
            BlnAgregar = true;
            for (PedidoCompraDetalle objIterator : itemList) {
                if (objIterator.getIdArticulo().equals(pedidoCompraDetalle.getIdArticulo())) {
                    Messages.errorMessage("Ya ha cargado este articulo");
                    BlnAgregar = false;
                    break;
                }
            }
            if (BlnAgregar) {
                if (pedidoCompraDetalle.getCantidad() < 1) {
                    pedidoCompraDetalle.setCantidad(1);
                }

                itemList.add(pedidoCompraDetalle);

                pedidoCompraDetalle = new PedidoCompraDetalle();

                calcularTotal();
            }
        }
    }

    public void deleteItem(int pos) {
        itemList.remove(pos);
        calcularTotal();
    }

    public void eliminar() {
        try {
            // se puede eliminar un pedido en caso de que no tenga factura asignada a el
            //se utiliza el estado APROVADO para diferencia de que tenga factura
            //al eliminar la cabecera se elimina los detalles por el fk en cascada
            if (pedidoCompra.getEstado().compareTo("APROVADO") != 0) {
                DaoFactory.getPedidoCompraDAO().delete(pedidoCompra);
            } else {
                Messages.errorMessage("Pedido no se puede eliminar");
            }
        } catch (Exception e) {

        }
    }

    private boolean isPostBack() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void ListarCombo(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    headerOrder = DaoFactory.getPedidoCompraDAO().getAll("ACTIVO");
                }
            } else {
                headerOrder = DaoFactory.getPedidoCompraDAO().getAll("ACTIVO");
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void ListarTabla(boolean isback) throws Exception {
        try {
            if (isback == false) {
                if (isPostBack() == false) {
                    headerOrder = DaoFactory.getPedidoCompraDAO().getAll();
                }
            } else {
                headerOrder = DaoFactory.getPedidoCompraDAO().getAll();
            }
        } catch (Exception e) {
            throw e;
        } finally {

        }
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        //GetObject linea detalle
        //DataTable dataTable = (DataTable) event.getSource();
        //int pos = dataTable.getRowIndex();
        if (newValue != null && !newValue.equals(oldValue)) {
            calcularTotal();
        }
    }

    public void deleteItemLine(PedidoCompraDetalle item, int linea) {
        if (item.getCantidad() < 1) {
            itemList.remove(linea);
        }
        calcularTotal();
        update();
    }

    private void update() {
        //otro metodo para actualizar componentes
        RequestContext.getCurrentInstance().update("frm-pedido:editablePedido");
    }

    private void calcularTotal() {

        int vTotal = 0;
        for (PedidoCompraDetalle obj : itemList) {
            vTotal += obj.getCantidad() * obj.getIdArticulo().getPreciocompra();
        }
        this.total = vTotal;
    }

    public void onRowSelect() {
        RequestContext.getCurrentInstance().execute("PF('wv-dialog-cantidad').show()");
    }

    //contructor
    public PedidoCompraBean() {
        this.headerOrder = new ArrayList();
        this.itemList = new ArrayList();
        this.pedidoCompra = new PedidosCompras();
        this.pedidoCompraDetalle = new PedidoCompraDetalle();
        System.out.println("contruct");
    }

    @PostConstruct
    public void init() {
        this.pedidoCompra.setEstado("PENDIENTE");

        RequestContext.getCurrentInstance().update("state");
    }
    

    //-------------Setter and Getter---------------------
    public PedidosCompras getPedidoCompra() {
        return pedidoCompra;
    }

    public void setPedidoCompra(PedidosCompras pedidoCompra) {
        this.pedidoCompra = pedidoCompra;
    }

    public PedidoCompraDetalle getPedidoCompraDetalle() {
        return pedidoCompraDetalle;
    }

    public void setPedidoCompraDetalle(PedidoCompraDetalle pedidoCompraDetalle) {
        this.pedidoCompraDetalle = pedidoCompraDetalle;
    }

    public List<PedidosCompras> getHeaderOrder() {
        return headerOrder;
    }

    public void setHeaderOrder(List<PedidosCompras> headerOrder) {
        this.headerOrder = headerOrder;
    }

    public List<PedidoCompraDetalle> getItemList() {
        return itemList;
    }

    public void setItemList(List<PedidoCompraDetalle> itemList) {
        this.itemList = itemList;
    }

    public Articulos getArticuloSelected() {
        return articuloSelected;
    }

    public void setArticuloSelected(Articulos articuloSelected) {
        this.articuloSelected = articuloSelected;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

}
