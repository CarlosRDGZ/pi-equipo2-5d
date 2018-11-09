/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo2.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author indiana
 */
@Embeddable
public class RankingRepositorioPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "repositorio_id")
    private int repositorioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private int usuarioId;

    public RankingRepositorioPK() {
    }

    public RankingRepositorioPK(int repositorioId, int usuarioId) {
        this.repositorioId = repositorioId;
        this.usuarioId = usuarioId;
    }

    public int getRepositorioId() {
        return repositorioId;
    }

    public void setRepositorioId(int repositorioId) {
        this.repositorioId = repositorioId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) repositorioId;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RankingRepositorioPK)) {
            return false;
        }
        RankingRepositorioPK other = (RankingRepositorioPK) object;
        if (this.repositorioId != other.repositorioId) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "equipo2.models.RankingRepositorioPK[ repositorioId=" + repositorioId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
