/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectbank.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author desarrolladorweb6
 */
@Embeddable
public class MovimientoPK implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cedula_cli")
    private String cedulaCli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo_cta")
    private String codigoCta;

    public MovimientoPK() {
    }

    public MovimientoPK(int id, String cedulaCli, String codigoCta) {
        this.id = id;
        this.cedulaCli = cedulaCli;
        this.codigoCta = codigoCta;
    }
   
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getCedulaCli() {
        return cedulaCli;
    }

    public void setCedulaCli(String cedulaCli) {
        this.cedulaCli = cedulaCli;
    }

    public String getCodigoCta() {
        return codigoCta;
    }

    public void setCodigoCta(String codigoCta) {
        this.codigoCta = codigoCta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (cedulaCli != null ? cedulaCli.hashCode() : 0);
        hash += (codigoCta != null ? codigoCta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoPK)) {
            return false;
        }
        MovimientoPK other = (MovimientoPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.cedulaCli == null && other.cedulaCli != null) || (this.cedulaCli != null && !this.cedulaCli.equals(other.cedulaCli))) {
            return false;
        }
        if ((this.codigoCta == null && other.codigoCta != null) || (this.codigoCta != null && !this.codigoCta.equals(other.codigoCta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.projectbank.model.MovimientoPK[ id=" + id + ", cedulaCli=" + cedulaCli + ", codigoCta=" + codigoCta + " ]";
    }

}
