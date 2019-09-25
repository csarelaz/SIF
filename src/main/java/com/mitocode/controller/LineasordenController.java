
package com.mitocode.controller;

import com.mitocode.ejb.ArticulosFacadeLocal;
import com.mitocode.ejb.LineasordenFacadeLocal;
import com.mitocode.ejb.OrdenFacadeLocal;
import com.mitocode.model.Articulos;
import com.mitocode.model.Lineasorden;
import com.mitocode.model.Orden;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@Named
@ViewScoped
public class LineasordenController implements Serializable{
    
    @EJB
    private LineasordenFacadeLocal lineasordenEJB;
    @EJB
    private ArticulosFacadeLocal articulosEJB;
    @EJB
    private OrdenFacadeLocal ordenEJB; 
    
    @Inject
    private Lineasorden lineasorden;
    

    @Inject
    private Articulos articulos;
    
    @Inject
    private OrdenController ordencontroller;
   
    @Inject
    private Orden orden;
    
    
    private List<Articulos> lstarticulos;
    
    private List<Lineasorden> lstlineasorden;
    
    private String accion;
    
    private Double totalcosto;
        
    private Integer idArticuloSeleccionado;
    
    private double precioArticulo;

    
    public Double getTotalcosto() {
        return totalcosto;
    }

    public void setTotalcosto(Double totalcosto) {
        this.totalcosto = totalcosto;
    }
    
    

    public Integer getIdArticuloSeleccionado() {
        return idArticuloSeleccionado;
    }

    public void setIdArticuloSeleccionado(Integer idArticuloSeleccionado) {
        this.idArticuloSeleccionado = idArticuloSeleccionado;
    }
    
    
 
    public double getPrecioArticulo() {
        return precioArticulo;
    }

    public void setPrecioArticulo(double precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

    
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Lineasorden> getLstlineasorden() {
        return lstlineasorden;
    }

    public void setLstlineasorden(List<Lineasorden> lstlineasorden) {
        this.lstlineasorden = lstlineasorden;
    }
    
    

    public Lineasorden getLineasorden() {
        return lineasorden;
    }

    public void setLineasorden(Lineasorden lineasorden) {
        this.lineasorden = lineasorden;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

      
    public Articulos getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }

    public List<Articulos> getLstarticulos() {
        return lstarticulos;
    }

    public void setLstarticulos(List<Articulos> lstarticulos) {
        this.lstarticulos = lstarticulos;
    }
   
    @PostConstruct
    public void init() {
       this.orden = ordencontroller.getOrden();
       this.lstlineasorden =  lineasordenEJB.findListByOrden(orden.getIdOrdenes());
       this.lstarticulos = articulosEJB.findListByDepa(orden.getDepartamento().getIdDepartamento());//Metodo para Mostrar Articulos Segun el Departamento
    }
    
       public void seleccionarArticulo(){
       
        for (Articulos lstarticulo : lstarticulos) {
            if(idArticuloSeleccionado.equals(lstarticulo.getIdArticulos())){
                precioArticulo = lstarticulo.getCosto_Art();
            }
        }
    }
    
    public void stateChangeListener(ValueChangeEvent event) {
        if(event.getNewValue()!=null){
       idArticuloSeleccionado = (Integer)event.getNewValue();
        for (Articulos lstarticulo : lstarticulos) {
            if(idArticuloSeleccionado.equals(lstarticulo.getIdArticulos())){
                precioArticulo = lstarticulo.getCosto_Art();
                //idArticuloSeleccionado = null;//csar.nl
               // articulos.setIdArticulos(idArticuloSeleccionado);
                break;
            }
        }
        }
    }
    
    public void calculacosto(ValueChangeEvent event){
        if(event.getNewValue() instanceof Double){
        lineasorden.setTotal(precioArticulo * (Double)event.getNewValue()) ;
    }
    }
    
    public void registrar(){
    try{
    //articulos.setIdArticulos(idArticuloSeleccionado);
    //articulos.setDescripcion_Art(lstarticulo.);
    this.lineasorden.setIdorden(orden);//poner el valor del codOrden
    this.lineasorden.setArticulos(articulos);//Cod Articulo que seleccionaste
    lineasordenEJB.create(lineasorden);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));    
    //this.init();//Se borra todas las lineas
    this.lstlineasorden =  lineasordenEJB.findListByOrden(orden.getIdOrdenes());
    precioArticulo = 0;
    idArticuloSeleccionado = 0;
    

    }
    catch (Exception e){
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));    
    }
    }
    
     public void mostrarDialogo() throws Exception{
        //logica
        RequestContext req = RequestContext.getCurrentInstance();
        req.reset(":frmDialogo");
        this.lstarticulos = articulosEJB.findListByDepa(orden.getDepartamento().getIdDepartamento());//Metodo para Mostrar Articulos Segun el Departamento
        this.setAccion("R");  
        req.execute("PF('wdialogo').show();");
    }
     
     public void leer(Lineasorden LineaSeleccion) {
        lineasorden = LineaSeleccion;
        this.setAccion("M");
    }
    
     public void reset() {
        RequestContext.getCurrentInstance().reset(":frmDialogo:txtArticulo");
    }
     
     
    public void modificar(Lineasorden lin){
    lineasordenEJB.edit(lin);
    lstlineasorden = lineasordenEJB.findListByOrden(orden.getIdOrdenes());
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro modificado"));
    }
    public void eliminar(Lineasorden lin){
 
    lineasordenEJB.remove(lin);
    lstlineasorden = lineasordenEJB.findListByOrden(orden.getIdOrdenes());
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro eliminado"));
    }

    public void addarticulo(Lineasorden lin){
       
    this.lineasorden.setIdorden(orden);//poner el valor del codOrden
    lineasorden.setArticulos(articulos);//Cod Articulo que seleccionaste   
     lstlineasorden.add(lineasorden);
     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Agregó el Registro"));
     lstlineasorden = lineasordenEJB.findListByOrden(orden.getIdOrdenes());
    }
    
}
