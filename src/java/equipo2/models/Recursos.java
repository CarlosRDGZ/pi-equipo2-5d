/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo2.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author indiana
 */
@Entity
@Table(name = "recursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recursos.findAll", query = "SELECT r FROM Recursos r")
    , @NamedQuery(name = "Recursos.findById", query = "SELECT r FROM Recursos r WHERE r.id = :id")
    , @NamedQuery(name = "Recursos.findByTitulo", query = "SELECT r FROM Recursos r WHERE r.titulo = :titulo")
    , @NamedQuery(name = "Recursos.findByFechaEdicion", query = "SELECT r FROM Recursos r WHERE r.fechaEdicion = :fechaEdicion")
    , @NamedQuery(name = "Recursos.findByNoEdicion", query = "SELECT r FROM Recursos r WHERE r.noEdicion = :noEdicion")
    , @NamedQuery(name = "Recursos.findByTags", query = "SELECT r FROM Recursos r WHERE r.tags = :tags")
    , @NamedQuery(name = "Recursos.findByUrl", query = "SELECT r FROM Recursos r WHERE r.url = :url")
    , @NamedQuery(name = "Recursos.findByAutor", query = "SELECT r FROM Recursos r WHERE r.autor = :autor")
    , @NamedQuery(name = "Recursos.findByDescripcion", query = "SELECT r FROM Recursos r WHERE r.descripcion = :descripcion")})
public class Recursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha_edicion")
    @Temporal(TemporalType.DATE)
    private Date fechaEdicion;
    @Column(name = "no_edicion")
    private Short noEdicion;
    @Size(max = 2147483647)
    @Column(name = "tags")
    private String tags;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "url")
    private String url;
    @Size(max = 2147483647)
    @Column(name = "autor")
    private String autor;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recursos")
    private Collection<RankingRecurso> rankingRecursoCollection;
    @JoinColumn(name = "repositorio_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Repositorios repositorioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recursoId")
    private Collection<Comentarios> comentariosCollection;

    public Recursos() {
    }

    public Recursos(Integer id) {
        this.id = id;
    }

    public Recursos(Integer id, String titulo, String url) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    public Short getNoEdicion() {
        return noEdicion;
    }

    public void setNoEdicion(Short noEdicion) {
        this.noEdicion = noEdicion;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<RankingRecurso> getRankingRecursoCollection() {
        return rankingRecursoCollection;
    }

    public void setRankingRecursoCollection(Collection<RankingRecurso> rankingRecursoCollection) {
        this.rankingRecursoCollection = rankingRecursoCollection;
    }

    public Repositorios getRepositorioId() {
        return repositorioId;
    }

    public void setRepositorioId(Repositorios repositorioId) {
        this.repositorioId = repositorioId;
    }

    @XmlTransient
    public Collection<Comentarios> getComentariosCollection() {
        return comentariosCollection;
    }

    public void setComentariosCollection(Collection<Comentarios> comentariosCollection) {
        this.comentariosCollection = comentariosCollection;
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
        if (!(object instanceof Recursos)) {
            return false;
        }
        Recursos other = (Recursos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "equipo2.models.Recursos[ id=" + id + " ]";
    }
    
}
