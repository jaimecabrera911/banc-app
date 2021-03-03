/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectbank.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author desarrolladorweb6
 */
@Entity
@Table(name = "cuentas")
@XmlRootElement
<<<<<<< HEAD
@NamedQueries({ @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
		@NamedQuery(name = "Cuenta.findByCodigo", query = "SELECT c FROM Cuenta c WHERE c.codigo = :codigo"),
		@NamedQuery(name = "Cuenta.findByEstado", query = "SELECT c FROM Cuenta c WHERE c.estado = :estado"),
		@NamedQuery(name = "Cuenta.findByNombreCta", query = "SELECT c FROM Cuenta c WHERE c.nombreCta = :nombreCta"),
		@NamedQuery(name = "Cuenta.findByCedula", query = "SELECT c FROM Cuenta c INNER JOIN AdmCuenta a ON c.codigo = a.codigoCuenta WHERE a.cedulaCliente=:cedulaCliente") })
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "codigo")
	private String codigo;
	@Column(name = "estado")
	private Boolean estado;
	@Size(max = 25)
	@Column(name = "nombre_cta")
	private String nombreCta;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
	@JsonIgnore
	private List<Movimiento> movimientoList;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cuenta")
	private AdmCuenta admCuenta;

	public Cuenta() {
	}

	public Cuenta(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombreCta() {
		return nombreCta;
	}

	public void setNombreCta(String nombreCta) {
		this.nombreCta = nombreCta;
	}

	@XmlTransient
	public List<Movimiento> getMovimientoList() {
		return movimientoList;
	}

	public void setMovimientoList(List<Movimiento> movimientoList) {
		this.movimientoList = movimientoList;
	}

	public AdmCuenta getAdmCuenta() {
		return admCuenta;
	}

	public void setAdmCuenta(AdmCuenta admCuenta) {
		this.admCuenta = admCuenta;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (codigo != null ? codigo.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Cuenta)) {
			return false;
		}
		Cuenta other = (Cuenta) object;
		if ((this.codigo == null && other.codigo != null)
				|| (this.codigo != null && !this.codigo.equals(other.codigo))) {
			return false;
		}
		return true;
	}
=======
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByCodigo", query = "SELECT c FROM Cuenta c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Cuenta.findByEstado", query = "SELECT c FROM Cuenta c WHERE c.estado = :estado"),
    @NamedQuery(name = "Cuenta.findByNombreCta", query = "SELECT c FROM Cuenta c WHERE c.nombreCta = :nombreCta")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "estado")
    private Boolean estado;
    @Size(max = 25)
    @Column(name = "nombre_cta")
    private String nombreCta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenta")
    @JsonIgnore
    private List<Movimiento> movimientoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cuenta")
    private AdmCuenta admCuenta;

    public Cuenta() {
    }

    public Cuenta(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getNombreCta() {
        return nombreCta;
    }

    public void setNombreCta(String nombreCta) {
        this.nombreCta = nombreCta;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public AdmCuenta getAdmCuenta() {
        return admCuenta;
    }

    public void setAdmCuenta(AdmCuenta admCuenta) {
        this.admCuenta = admCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15

	@Override
	public String toString() {
		return "Cuenta [codigo=" + codigo + ", estado=" + estado + ", nombreCta=" + nombreCta + ", admCuenta="
				+ admCuenta + "]";
	}

<<<<<<< HEAD
=======
    
    
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
}
