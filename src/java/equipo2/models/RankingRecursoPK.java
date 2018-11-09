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
public class RankingRecursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "recurso_id")
    private int recursoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private int usuarioId;

    public RankingRecursoPK() {
    }

    public RankingRecursoPK(int recursoId, int usuarioId) {
        this.recursoId = recursoId;
        this.usuarioId = usuarioId;
    }

    public int getRecursoId() {
        return recursoId;
    }

    public void setRecursoId(int recursoId) {
        this.recursoId = recursoId;
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
        hash += (int) recursoId;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RankingRecursoPK)) {
            return false;
        }
        RankingRecursoPK other = (RankingRecursoPK) object;
        if (this.recursoId != other.recursoId) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "equipo2.models.RankingRecursoPK[ recursoId=" + recursoId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
