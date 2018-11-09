/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo2.models;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author indiana
 */
@Entity
@Table(name = "repositorios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repositorios.findAll", query = "SELECT r FROM Repositorios r")
    , @NamedQuery(name = "Repositorios.findById", query = "SELECT r FROM Repositorios r WHERE r.id = :id")
    , @NamedQuery(name = "Repositorios.findByNombre", query = "SELECT r FROM Repositorios r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Repositorios.findByDescripcion", query = "SELECT r FROM Repositorios r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Repositorios.findByAprobado", query = "SELECT r FROM Repositorios r WHERE r.aprobado = :aprobado")
    , @NamedQuery(name = "Repositorios.findByUrl", query = "SELECT r FROM Repositorios r WHERE r.url = :url")})
public class Repositorios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aprobado")
    private short aprobado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "url")
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repositorios")
    private Collection<RankingRepositorio> rankingRepositorioCollection;
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categorias categoriaId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repositorioId")
    private Collection<Recursos> recursosCollection;

    public Repositorios() {
    }

    public Repositorios(Integer id) {
        this.id = id;
    }

    public Repositorios(Integer id, String nombre, String descripcion, short aprobado, String url) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aprobado = aprobado;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getAprobado() {
        return aprobado;
    }

    public void setAprobado(short aprobado) {
        this.aprobado = aprobado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public Collection<RankingRepositorio> getRankingRepositorioCollection() {
        return rankingRepositorioCollection;
    }

    public void setRankingRepositorioCollection(Collection<RankingRepositorio> rankingRepositorioCollection) {
        this.rankingRepositorioCollection = rankingRepositorioCollection;
    }

    public Categorias getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categorias categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @XmlTransient
    public Collection<Recursos> getRecursosCollection() {
        return recursosCollection;
    }

    public void setRecursosCollection(Collection<Recursos> recursosCollection) {
        this.recursosCollection = recursosCollection;
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
        if (!(object instanceof Repositorios)) {
            return false;
        }
        Repositorios other = (Repositorios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "equipo2.models.Repositorios[ id=" + id + " ]";
    }
    
}
