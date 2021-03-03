/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectbank.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
<<<<<<< HEAD
import org.springframework.format.annotation.DateTimeFormat;
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15


/**
 *
 * @author desarrolladorweb6
 */
@Entity
@Table(name = "movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findById", query = "SELECT m FROM Movimiento m WHERE m.movimientoPK.id = :id"),
    @NamedQuery(name = "Movimiento.findByCedulaCli", query = "SELECT m FROM Movimiento m WHERE m.movimientoPK.cedulaCli = :cedulaCli"),
    @NamedQuery(name = "Movimiento.findByCodigoCta", query = "SELECT m FROM Movimiento m WHERE m.movimientoPK.codigoCta = :codigoCta"),
    @NamedQuery(name = "Movimiento.findByFechaMov", query = "SELECT m FROM Movimiento m WHERE m.fechaMov = :fechaMov"),
<<<<<<< HEAD
    @NamedQuery(name = "Movimiento.findBySaldo", query = "SELECT m FROM Movimiento m WHERE m.saldo = :saldo"),
    @NamedQuery(name = "Movimiento.sumSaldo", query = "SELECT SUM(m.saldo) FROM Movimiento m INNER JOIN Cuenta c ON m.movimientoPK.codigoCta = c.codigo  WHERE c.codigo ='12341'")})
=======
    @NamedQuery(name = "Movimiento.findBySaldo", query = "SELECT m FROM Movimiento m WHERE m.saldo = :saldo")})
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovimientoPK movimientoPK;
    @Column(name = "fecha_mov")
    @CreationTimestamp
<<<<<<< HEAD
    @DateTimeFormat()
=======
>>>>>>> 9207b3e346122fcdfbfa20625319540756c03a15
    private Date fechaMov;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tipoMovimiento")
    private String tipoMovimiento;
    @Column(name = "saldo")
    private Double saldo;
    @JoinColumn(name = "cedula_cli", referencedColumnName = "cedula", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "codigo_cta", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(MovimientoPK movimientoPK) {
        this.movimientoPK = movimientoPK;
    }

    public Movimiento(int id, String cedulaCli, String codigoCta) {
        this.movimientoPK = new MovimientoPK(id, cedulaCli, codigoCta);
    }

    public MovimientoPK getMovimientoPK() {
        return movimientoPK;
    }

    public void setMovimientoPK(MovimientoPK movimientoPK) {
        this.movimientoPK = movimientoPK;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        hash += (movimientoPK != null ? movimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.movimientoPK == null && other.movimientoPK != null) || (this.movimientoPK != null && !this.movimientoPK.equals(other.movimientoPK))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Movimiento [movimientoPK=" + movimientoPK + ", fechaMov=" + fechaMov + ", tipoMovimiento="
				+ tipoMovimiento + ", saldo=" + saldo + ", cliente=" + cliente + ", cuenta=" + cuenta + "]";
	}


}
