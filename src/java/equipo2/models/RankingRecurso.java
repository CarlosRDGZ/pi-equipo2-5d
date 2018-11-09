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
@Table(name = "ranking_recurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RankingRecurso.findAll", query = "SELECT r FROM RankingRecurso r")
    , @NamedQuery(name = "RankingRecurso.findByRecursoId", query = "SELECT r FROM RankingRecurso r WHERE r.rankingRecursoPK.recursoId = :recursoId")
    , @NamedQuery(name = "RankingRecurso.findByUsuarioId", query = "SELECT r FROM RankingRecurso r WHERE r.rankingRecursoPK.usuarioId = :usuarioId")
    , @NamedQuery(name = "RankingRecurso.findByRanking", query = "SELECT r FROM RankingRecurso r WHERE r.ranking = :ranking")})
public class RankingRecurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RankingRecursoPK rankingRecursoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ranking")
    private short ranking;
    @JoinColumn(name = "recurso_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recursos recursos;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public RankingRecurso() {
    }

    public RankingRecurso(RankingRecursoPK rankingRecursoPK) {
        this.rankingRecursoPK = rankingRecursoPK;
    }

    public RankingRecurso(RankingRecursoPK rankingRecursoPK, short ranking) {
        this.rankingRecursoPK = rankingRecursoPK;
        this.ranking = ranking;
    }

    public RankingRecurso(int recursoId, int usuarioId) {
        this.rankingRecursoPK = new RankingRecursoPK(recursoId, usuarioId);
    }

    public RankingRecursoPK getRankingRecursoPK() {
        return rankingRecursoPK;
    }

    public void setRankingRecursoPK(RankingRecursoPK rankingRecursoPK) {
        this.rankingRecursoPK = rankingRecursoPK;
    }

    public short getRanking() {
        return ranking;
    }

    public void setRanking(short ranking) {
        this.ranking = ranking;
    }

    public Recursos getRecursos() {
        return recursos;
    }

    public void setRecursos(Recursos recursos) {
        this.recursos = recursos;
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
        hash += (rankingRecursoPK != null ? rankingRecursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RankingRecurso)) {
            return false;
        }
        RankingRecurso other = (RankingRecurso) object;
        if ((this.rankingRecursoPK == null && other.rankingRecursoPK != null) || (this.rankingRecursoPK != null && !this.rankingRecursoPK.equals(other.rankingRecursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "equipo2.models.RankingRecurso[ rankingRecursoPK=" + rankingRecursoPK + " ]";
    }
    
}
