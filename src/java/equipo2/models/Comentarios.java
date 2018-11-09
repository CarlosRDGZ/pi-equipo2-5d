/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo2.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author indiana
 */
@Entity
@Table(name = "comentarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentarios.findAll", query = "SELECT c FROM Comentarios c")
    , @NamedQuery(name = "Comentarios.findById", query = "SELECT c FROM Comentarios c WHERE c.id = :id")
    , @NamedQuery(name = "Comentarios.findByContenido", query = "SELECT c FROM Comentarios c WHERE c.contenido = :contenido")
    , @NamedQuery(name = "Comentarios.findByFechaEdicion", query = "SELECT c FROM Comentarios c WHERE c.fechaEdicion = :fechaEdicion")
    , @NamedQuery(name = "Comentarios.findByReportado", query = "SELECT c FROM Comentarios c WHERE c.reportado = :reportado")
    , @NamedQuery(name = "Comentarios.findByVisible", query = "SELECT c FROM Comentarios c WHERE c.visible = :visible")})
public class Comentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "contenido")
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_edicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEdicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reportado")
    private boolean reportado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visible")
    private boolean visible;
    @JoinColumn(name = "recurso_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Recursos recursoId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuarioId;

    public Comentarios() {
    }

    public Comentarios(Integer id) {
        this.id = id;
    }

    public Comentarios(Integer id, String contenido, Date fechaEdicion, boolean reportado, boolean visible) {
        this.id = id;
        this.contenido = contenido;
        this.fechaEdicion = fechaEdicion;
        this.reportado = reportado;
        this.visible = visible;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public boolean getReportado() {
        return reportado;
    }

    public void setReportado(boolean reportado) {
        this.reportado = reportado;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Recursos getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(Recursos recursoId) {
        this.recursoId = recursoId;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "equipo2.models.Comentarios[ id=" + id + " ]";
    }
    
}
