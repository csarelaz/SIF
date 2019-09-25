
package com.mitocode.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "activo")
public class Activo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivos;

    @ManyToOne
    @JoinColumn(name = "CodTipoBien", nullable = false)
    private TipoBien idCodTipoBien;
    
    @Column(name = "Entidad")
    private String Entidad;
    
    @Column(name = "UnidadEjecutora")
    private String UnidadEjecutora;
    
    @Column(name = "UnidadDesconcentrada")
    private String UnidadDesconcentrada;
    
    @Column(name = "NumBodega")
    private Integer NumBodega;
    
    @Column(name = "ActFijoContAdmin")
    private String ActFijoContAdmin;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha_Ingreso")
    private Date Fecha_Ingreso;
    
    @Column(name = "Formaingreso")
    private String Formaingreso;
    
    @ManyToOne
    @JoinColumn(name = "idACTIVOAdj")
    private Activo idACTIVOAdj; 
    
    @Column(name = "CatBienes")
    private String CatBienes;
    
    @Column(name = "Identificador")
    private String Identificador;
    
    @Column(name = "Descripcion")
    private String Descripcion;
    
    @Column(name = "OrigenIngreso")
    private String OrigenIngreso;
    
    @Column(name = "TipoDocResp")
    private String TipoDocResp;
    
    @Column(name = "ClasesDocResp")
    private String ClasesDocResp;
    
    @Column(name = "TipoComp")
    private String TipoComp;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaComp")
    private Date FechaComp;
    
    @Column(name = "Cod_Actual")
    private String Cod_Actual;
    
    @Column(name = "EstadoFisico")
    private String EstadoFisico;
    
    @Column(name = "Costo")
    private Double Costo;
    
    @Column(name = "Depreciacion")
    private String Depreciacion;
    
    @ManyToOne
    @JoinColumn(name = "NOMINA_idNomina", nullable = false)
    private Nomina idNomina;

    @ManyToOne
    @JoinColumn(name = "DEPENDENCIA_idDependencia", nullable = false)
    private Dependencia idDependencia;
    
    @Column(name = "Serie")
    private String Serie;
    
    @Column(name = "Modelo")
    private String Modelo;
    
    @Column(name = "Marca")
    private String Marca;
    
    @Column(name = "PartPresup")
    private String PartPresup;
    
    @Column(name = "ItemPresup")
    private Integer ItemPresup;
    
    @Column(name = "CodTipoProy")
    private Integer CodTipoProy;  
    
    @Column(name = "CodCuentaCont")
    private String CodCuentaCont;
    
    @Column(name = "ValContable")
    private Double ValContable;
        
    @Column(name = "ValResidual")
    private Double ValResidual;
    
    @Column(name = "ValLibros")
    private Double ValLibros;    
        
    @Column(name = "ValDepAcum")
    private Double ValDepAcum;

    @Temporal(TemporalType.DATE)
    @Column(name = "FechaDep")
    private Date FechaDep;

    @Column(name = "VidaUtil")
    private Integer VidaUtil;
    
    @Column(name = "Observaciones")
    private String Observaciones;
    
    @Column(name = "Num_Acta")
    private String Num_Acta;

    @Column(name = "ActaPdf")
    private String ActaPdf;   
    
    @Column(name = "Estado")
    private String Estado;
    
    @Column(name = "idEmp")
    private String IdEmp;
    

    


    public int getIdActivos() {
        return idActivos;
    }

    public void setIdActivos(int idActivos) {
        this.idActivos = idActivos;
    }

    public TipoBien getIdCodTipoBien() {
        return idCodTipoBien;
    }

    public void setIdCodTipoBien(TipoBien idCodTipoBien) {
        this.idCodTipoBien = idCodTipoBien;
    }

    public String getEntidad() {
        return Entidad;
    }

    public void setEntidad(String Entidad) {
        this.Entidad = Entidad;
    }

    public String getUnidadEjecutora() {
        return UnidadEjecutora;
    }

    public void setUnidadEjecutora(String UnidadEjecutora) {
        this.UnidadEjecutora = UnidadEjecutora;
    }

    public String getUnidadDesconcentrada() {
        return UnidadDesconcentrada;
    }

    public void setUnidadDesconcentrada(String UnidadDesconcentrada) {
        this.UnidadDesconcentrada = UnidadDesconcentrada;
    }

    public Integer getNumBodega() {
        return NumBodega;
    }

    public void setNumBodega(Integer NumBodega) {
        this.NumBodega = NumBodega;
    }

    public String getActFijoContAdmin() {
        return ActFijoContAdmin;
    }

    public void setActFijoContAdmin(String ActFijoContAdmin) {
        this.ActFijoContAdmin = ActFijoContAdmin;
    }

    public String getFormaingreso() {
        return Formaingreso;
    }

    public void setFormaingreso(String Formaingreso) {
        this.Formaingreso = Formaingreso;
    }

    public String getCatBienes() {
        return CatBienes;
    }

    public void setCatBienes(String CatBienes) {
        this.CatBienes = CatBienes;
    }

    public String getIdentificador() {
        return Identificador;
    }

    public void setIdentificador(String Identificador) {
        this.Identificador = Identificador;
    }

    public String getOrigenIngreso() {
        return OrigenIngreso;
    }

    public void setOrigenIngreso(String OrigenIngreso) {
        this.OrigenIngreso = OrigenIngreso;
    }

    public String getTipoDocResp() {
        return TipoDocResp;
    }

    public void setTipoDocResp(String TipoDocResp) {
        this.TipoDocResp = TipoDocResp;
    }

    public String getClasesDocResp() {
        return ClasesDocResp;
    }

    public void setClasesDocResp(String ClasesDocResp) {
        this.ClasesDocResp = ClasesDocResp;
    }

    public String getTipoComp() {
        return TipoComp;
    }

    public void setTipoComp(String TipoComp) {
        this.TipoComp = TipoComp;
    }

    public Date getFechaComp() {
        return FechaComp;
    }

    public void setFechaComp(Date FechaComp) {
        this.FechaComp = FechaComp;
    }

    public String getCod_Actual() {
        return Cod_Actual;
    }

    public void setCod_Actual(String Cod_Actual) {
        this.Cod_Actual = Cod_Actual;
    }

    public String getDepreciacion() {
        return Depreciacion;
    }

    public void setDepreciacion(String Depreciacion) {
        this.Depreciacion = Depreciacion;
    }

    public String getPartPresup() {
        return PartPresup;
    }

    public void setPartPresup(String PartPresup) {
        this.PartPresup = PartPresup;
    }

    public Integer getItemPresup() {
        return ItemPresup;
    }

    public void setItemPresup(Integer ItemPresup) {
        this.ItemPresup = ItemPresup;
    }

    public Integer getCodTipoProy() {
        return CodTipoProy;
    }

    public void setCodTipoProy(Integer CodTipoProy) {
        this.CodTipoProy = CodTipoProy;
    }

    public String getCodCuentaCont() {
        return CodCuentaCont;
    }

    public void setCodCuentaCont(String CodCuentaCont) {
        this.CodCuentaCont = CodCuentaCont;
    }

    public Double getValContable() {
        return ValContable;
    }

    public void setValContable(Double ValContable) {
        this.ValContable = ValContable;
    }

    public Double getValResidual() {
        return ValResidual;
    }

    public void setValResidual(Double ValResidual) {
        this.ValResidual = ValResidual;
    }

    public Double getValLibros() {
        return ValLibros;
    }

    public void setValLibros(Double ValLibros) {
        this.ValLibros = ValLibros;
    }

    public Double getValDepAcum() {
        return ValDepAcum;
    }

    public void setValDepAcum(Double ValDepAcum) {
        this.ValDepAcum = ValDepAcum;
    }

    public Date getFechaDep() {
        return FechaDep;
    }

    public void setFechaDep(Date FechaDep) {
        this.FechaDep = FechaDep;
    }

    public Integer getVidaUtil() {
        return VidaUtil;
    }

    public void setVidaUtil(Integer VidaUtil) {
        this.VidaUtil = VidaUtil;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }
    
    

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getNum_Acta() {
        return Num_Acta;
    }

    public void setNum_Acta(String Num_Acta) {
        this.Num_Acta = Num_Acta;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double Costo) {
        this.Costo = Costo;
    }

    public String getEstadoFisico() {
        return EstadoFisico;
    }

    public void setEstadoFisico(String EstadoFisico) {
        this.EstadoFisico = EstadoFisico;
    }

    public Date getFecha_Ingreso() {
        return Fecha_Ingreso;
    }

    public void setFecha_Ingreso(Date Fecha_Ingreso) {
        this.Fecha_Ingreso = Fecha_Ingreso;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getActaPdf() {
        return ActaPdf;
    }

    public void setActaPdf(String ActaPdf) {
        this.ActaPdf = ActaPdf;
    }

    public String getIdEmp() {
        return IdEmp;
    }

    public void setIdEmp(String IdEmp) {
        this.IdEmp = IdEmp;
    }


    public Activo getIdACTIVOAdj() {
        return idACTIVOAdj;
    }

    public void setIdACTIVOAdj(Activo idACTIVOAdj) {
        this.idACTIVOAdj = idACTIVOAdj;
    }

    public Nomina getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(Nomina idNomina) {
        this.idNomina = idNomina;
    }

    public Dependencia getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(Dependencia idDependencia) {
        this.idDependencia = idDependencia;
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idActivos;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Activo other = (Activo) obj;
        if (this.idActivos != other.idActivos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Activo{" + "idActivos=" + idActivos + '}';
    }
    
    
    
}
