package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.empresa.Empresa;
import br.com.magmadoctor.modelo.empresa.EmpresaRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aguinaldo
 */
@ManagedBean
@ViewScoped
public class EmpresaMB {

    private Empresa empresa = new Empresa();
    private List<Empresa> listarPorNome;
    private List<Empresa> listarTodos;
    private String pagina;

    public EmpresaMB() {
        this.pagina = "empresa";
        empresa = new Empresa();
    }

    public void setListarPorNome(List<Empresa> listarPorNome) {
        this.listarPorNome = listarPorNome;
    }

    public String inserir() {
        EmpresaRN cRN = new EmpresaRN();
        if (this.empresa.getCodigo() != null && this.empresa.getCodigo() != 0) {
            cRN.atualizar(getEmpresa());
            FacesMessage msg = new FacesMessage("EMPRESA ATUALIZADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            cRN.salvar(getEmpresa());
            novo();

            FacesMessage msg = new FacesMessage("EMPRESA CADASTRADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return pagina;
    }

    public String excluir() {
        EmpresaRN cRN = new EmpresaRN();
        if (this.empresa.getCodigo() != null && this.empresa.getCodigo() != 0) {
            cRN.excluir(getEmpresa());
            FacesMessage msg = new FacesMessage("EMPRESA EXCLUIDO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("FAVOR SELECIONAR EMPRESA PARA EXCLUSÃO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return pagina;
    }

    public List<Empresa> getListarPorNome() {
        EmpresaRN cRN = new EmpresaRN();
        listarPorNome = cRN.listar(empresa.getNomeFantasia());
        return listarPorNome;
    }

    public List<Empresa> getListarTodos() {
        EmpresaRN cRN = new EmpresaRN();
        return cRN.listarTodos();
    }

    public void setListarTodos(List<Empresa> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public String novo() {
        this.empresa = new Empresa();
        return pagina;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

}
