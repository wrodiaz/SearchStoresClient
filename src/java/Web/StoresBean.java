/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.xml.ws.WebServiceRef;
import searchgroceries.SearchWebService_Service;

/**
 *
 * @author TRABAJO
 */
@Named(value = "storesBean")
@SessionScoped
public class StoresBean implements Serializable {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/SearchStores/SearchWebService.wsdl")
    private SearchWebService_Service service;

    private List<String> listaProductos;
    private String store;
    /**
     * Creates a new instance of StoresBean
     */
    public StoresBean() {
    }
    
    public void buscar(){
    listaProductos = search(store);
    
    }

    private java.util.List<java.lang.String> search(java.lang.String search) {
        searchgroceries.SearchWebService port = service.getSearchWebServicePort();
        return port.search(search);
    }
    
    public List<String> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<String> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getEstado() {
        return store;
    }

    public void setEstado(String store) {
        this.store = store;
    }
}
