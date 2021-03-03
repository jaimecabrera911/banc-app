/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectbank.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
<<<<<<< HEAD
import javax.persistence.CascadeType;
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author desarrolladorweb6
 */
@Entity
@Table(name = "adm_cuentas")
@XmlRootElement
<<<<<<< HEAD
@NamedQueries({ @NamedQuery(name = "AdmCuenta.findAll", query = "SELECT a FROM AdmCuenta a"),
		@NamedQuery(name = "AdmCuenta.findByCodigoCuenta", query = "SELECT a FROM AdmCuenta a WHERE a.codigoCuenta = :codigoCuenta"),
		@NamedQuery(name = "AdmCuenta.findByFechaCreacion", query = "SELECT a FROM AdmCuenta a WHERE a.fechaCreacion = :fechaCreacion") })
public class AdmCuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 10)
	@Column(name = "codigo_cuenta")
	private String codigoCuenta;
	@Column(name = "fecha_creacion")
	@CreationTimestamp
	private Date fechaCreacion;
	@JoinColumn(name = "cedula_cliente", referencedColumnName = "cedula")
	@ManyToOne
	private Cliente cedulaCliente;
	@JoinColumn(name = "codigo_cuenta", referencedColumnName = "codigo", insertable = true, updatable = true)
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Cuenta cuenta;

	public AdmCuenta() {
	}

	public AdmCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public String getCodigoCuenta() {
		return codigoCuenta;
	}

	public void setCodigoCuenta(String codigoCuenta) {
		this.codigoCuenta = codigoCuenta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Cliente getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(Cliente cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (codigoCuenta != null ? codigoCuenta.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AdmCuenta)) {
			return false;
		}
		AdmCuenta other = (AdmCuenta) object;
		if ((this.codigoCuenta == null && other.codigoCuenta != null)
				|| (this.codigoCuenta != null && !this.codigoCuenta.equals(other.codigoCuenta))) {
			return false;
		}
		return true;
	}
=======
@NamedQueries({
    @NamedQuery(name = "AdmCuenta.findAll", query = "SELECT a FROM AdmCuenta a"),
    @NamedQuery(name = "AdmCuenta.findByCodigoCuenta", query = "SELECT a FROM AdmCuenta a WHERE a.codigoCuenta = :codigoCuenta"),
    @NamedQuery(name = "AdmCuenta.findByFechaCreacion", query = "SELECT a FROM AdmCuenta a WHERE a.fechaCreacion = :fechaCreacion")})
public class AdmCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_cuenta")
    private String codigoCuenta;
    @Column(name = "fecha_creacion")
    @CreationTimestamp
    private Date fechaCreacion;
    @JoinColumn(name = "cedula_cliente", referencedColumnName = "cedula")
    @ManyToOne
    private Cliente cedulaCliente;
    @JoinColumn(name = "codigo_cuenta", referencedColumnName = "codigo", insertable = true, updatable = true)
    @OneToOne(optional = false)
    private Cuenta cuenta;

    public AdmCuenta() {
    }

    public AdmCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(String codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Cliente getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Cliente cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCuenta != null ? codigoCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdmCuenta)) {
            return false;
        }
        AdmCuenta other = (AdmCuenta) object;
        if ((this.codigoCuenta == null && other.codigoCuenta != null) || (this.codigoCuenta != null && !this.codigoCuenta.equals(other.codigoCuenta))) {
            return false;
        }
        return true;
    }
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15

	@Override
	public String toString() {
		return "AdmCuenta [codigoCuenta=" + codigoCuenta + ", fechaCreacion=" + fechaCreacion + ", cedulaCliente="
<<<<<<< HEAD
				+ cedulaCliente + "]";
	}

=======
				+ cedulaCliente +"]";
	}

    
    
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
}
