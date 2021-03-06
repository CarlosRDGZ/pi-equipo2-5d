package equipo2.controllers;

import equipo2.models.RankingRecurso;
import equipo2.util.JsfUtil;
import equipo2.util.PaginationHelper;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("rankingRecursoController")
@SessionScoped
public class RankingRecursoController implements Serializable {

    private RankingRecurso current;
    private DataModel items = null;
    @EJB
    private equipo2.controllers.RankingRecursoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public RankingRecursoController() {
    }

    public RankingRecurso getSelected() {
        if (current == null) {
            current = new RankingRecurso();
            current.setRankingRecursoPK(new equipo2.models.RankingRecursoPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private RankingRecursoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (RankingRecurso) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new RankingRecurso();
        current.setRankingRecursoPK(new equipo2.models.RankingRecursoPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getRankingRecursoPK().setUsuarioId(current.getUsuarios().getId());
            current.getRankingRecursoPK().setRecursoId(current.getRecursos().getId());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("RankingRecursoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (RankingRecurso) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getRankingRecursoPK().setUsuarioId(current.getUsuarios().getId());
            current.getRankingRecursoPK().setRecursoId(current.getRecursos().getId());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("RankingRecursoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (RankingRecurso) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("RankingRecursoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public RankingRecurso getRankingRecurso(equipo2.models.RankingRecursoPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = RankingRecurso.class)
    public static class RankingRecursoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            RankingRecursoController controller = (RankingRecursoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "rankingRecursoController");
            return controller.getRankingRecurso(getKey(value));
        }

        equipo2.models.RankingRecursoPK getKey(String value) {
            equipo2.models.RankingRecursoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new equipo2.models.RankingRecursoPK();
            key.setRecursoId(Integer.parseInt(values[0]));
            key.setUsuarioId(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(equipo2.models.RankingRecursoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getRecursoId());
            sb.append(SEPARATOR);
            sb.append(value.getUsuarioId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof RankingRecurso) {
                RankingRecurso o = (RankingRecurso) object;
                return getStringKey(o.getRankingRecursoPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + RankingRecurso.class.getName());
            }
        }

    }

}
