/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "CATALOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalog.findAll", query = "SELECT c FROM Catalog c"),
    @NamedQuery(name = "Catalog.findByDvdnames", query = "SELECT c FROM Catalog c WHERE c.dvdnames = :dvdnames"),
    @NamedQuery(name = "Catalog.findByRate", query = "SELECT c FROM Catalog c WHERE c.rate = :rate"),
    @NamedQuery(name = "Catalog.findByPrice", query = "SELECT c FROM Catalog c WHERE c.price = :price"),
    @NamedQuery(name = "Catalog.findByQuantity", query = "SELECT c FROM Catalog c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "Catalog.findByYearr", query = "SELECT c FROM Catalog c WHERE c.yearr = :yearr")})
public class Catalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DVDNAMES")
    private String dvdnames;
    @Size(max = 100)
    @Column(name = "RATE")
    private String rate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Size(max = 10)
    @Column(name = "YEARR")
    private String yearr;

    public Catalog() {
    }

    public Catalog(String dvdnames) {
        this.dvdnames = dvdnames;
    }

    public Catalog(String name, String rate, String year, double price, int quantity) {
        dvdnames = name ;
        this.rate = rate;
        yearr = year;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDvdnames() {
        return dvdnames;
    }

    public void setDvdnames(String dvdnames) {
        this.dvdnames = dvdnames;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getYearr() {
        return yearr;
    }

    public void setYearr(String yearr) {
        this.yearr = yearr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dvdnames != null ? dvdnames.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalog)) {
            return false;
        }
        Catalog other = (Catalog) object;
        if ((this.dvdnames == null && other.dvdnames != null) || (this.dvdnames != null && !this.dvdnames.equals(other.dvdnames))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Catalog[ dvdnames=" + dvdnames + " ]";
    }
    
}
