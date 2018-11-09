/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo2.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author indiana
 */
@Entity
@Table(name = "ranking_repositorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RankingRepositorio.findAll", query = "SELECT r FROM RankingRepositorio r")
    , @NamedQuery(name = "RankingRepositorio.findByRepositorioId", query = "SELECT r FROM RankingRepositorio r WHERE r.rankingRepositorioPK.repositorioId = :repositorioId")
    , @NamedQuery(name = "RankingRepositorio.findByUsuarioId", query = "SELECT r FROM RankingRepositorio r WHERE r.rankingRepositorioPK.usuarioId = :usuarioId")
    , @NamedQuery(name = "RankingRepositorio.findByRanking", query = "SELECT r FROM RankingRepositorio r WHERE r.ranking = :ranking")})
public class RankingRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RankingRepositorioPK rankingRepositorioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ranking")
    private short ranking;
    @JoinColumn(name = "repositorio_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Repositorios repositorios;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public RankingRepositorio() {
    }

    public RankingRepositorio(RankingRepositorioPK rankingRepositorioPK) {
        this.rankingRepositorioPK = rankingRepositorioPK;
    }

    public RankingRepositorio(RankingRepositorioPK rankingRepositorioPK, short ranking) {
        this.rankingRepositorioPK = rankingRepositorioPK;
        this.ranking = ranking;
    }

    public RankingRepositorio(int repositorioId, int usuarioId) {
        this.rankingRepositorioPK = new RankingRepositorioPK(repositorioId, usuarioId);
    }

    public RankingRepositorioPK getRankingRepositorioPK() {
        return rankingRepositorioPK;
    }

    public void setRankingRepositorioPK(RankingRepositorioPK rankingRepositorioPK) {
        this.rankingRepositorioPK = rankingRepositorioPK;
    }

    public short getRanking() {
        return ranking;
    }

    public void setRanking(short ranking) {
        this.ranking = ranking;
    }

    public Repositorios getRepositorios() {
        return repositorios;
    }

    public void setRepositorios(Repositorios repositorios) {
        this.repositorios = repositorios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rankingRepositorioPK != null ? rankingRepositorioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RankingRepositorio)) {
            return false;
        }
        RankingRepositorio other = (RankingRepositorio) object;
        if ((this.rankingRepositorioPK == null && other.rankingRepositorioPK != null) || (this.rankingRepositorioPK != null && !this.rankingRepositorioPK.equals(other.rankingRepositorioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "equipo2.models.RankingRepositorio[ rankingRepositorioPK=" + rankingRepositorioPK + " ]";
    }
    
}
