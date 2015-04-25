package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.contato.Contato;
import br.com.magmadoctor.modelo.contato.ContatoRN;
import br.com.magmadoctor.modelo.convenio.Convenio;
import br.com.magmadoctor.modelo.convenio.ConvenioRN;
import br.com.magmadoctor.modelo.email.Email;
import br.com.magmadoctor.modelo.email.EmailRN;
import br.com.magmadoctor.modelo.endereco.Endereco;
import br.com.magmadoctor.modelo.endereco.EnderecoRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class ConvenioMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Convenio convenio;
    private Endereco endereco;
    private Contato contato;
    private Email email;

    private List<Convenio> listarPorNome;
    private List<Convenio> listarTodos;

    private String pagina;

    private List<Endereco> enderecos = new ArrayList<>();
    private List<Contato> contatos = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();

    public ConvenioMB() {
        this.pagina = "convenio";
        this.convenio = new Convenio();
        this.contato = new Contato();
        this.endereco = new Endereco();
        this.email = new Email();
    }

    public String inserir() {
        ConvenioRN cRN = new ConvenioRN();
        if (this.convenio.getId() != null && this.convenio.getId() != 0) {
            prepararConvenio();
            cRN.atualizar(getConvenio());
            FacesMessage msg = new FacesMessage("CONVENIO ATUALIZADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            prepararConvenio();
            cRN.salvar(getConvenio());
            FacesMessage msg = new FacesMessage("CONVENIO CADASTRADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        novo();
        return getPagina();
    }

    public void atualizaRelacionamentos() {
        ConvenioRN cRN = new ConvenioRN();
        prepararConvenio();
        cRN.atualizar(getConvenio());
        FacesMessage msg = new FacesMessage("CONVENIO ATUALIZADO COM SUCESSO!!!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void prepararConvenio() {
        convenio.setEnderecos(enderecos);
        convenio.setContatos(contatos);
        convenio.setEmails(emails);
    }

    public String novo() {
        this.convenio = new Convenio();
        this.endereco = new Endereco();
        this.contato = new Contato();
        this.email = new Email();
        return getPagina();
    }

    public void limparListas() {
        this.contatos.clear();
        this.enderecos.clear();
        this.emails.clear();
    }

    public void editar() {
        ConvenioRN cRN = new ConvenioRN();
        convenio = cRN.porId(convenio.getId());
        contatos = convenio.getContatos();
        enderecos = convenio.getEnderecos();
        emails = convenio.getEmails();
    }

    public void excluir() {
        ConvenioRN cRN = new ConvenioRN();
        if (this.convenio.getId() != null && this.convenio.getId() != 0) {
            cRN.excluir(getConvenio());
            FacesMessage msg = new FacesMessage("CONVENIO EXCLUIDO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("FAVOR SELECIONAR CONVENIO PARA EXCLUSÃO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        novo();
    }

    //--------------------------------------------------------------- bloco referente aos emails 
    public void novoEmail() {
        email = new Email();
    }

    public void addEmail() {
        EmailRN eRN = new EmailRN();
        if (email.getId() == null) {
            eRN.salvar(email);
            emails.add(email);
        } else {
            for (Iterator iterator = emails.iterator(); iterator.hasNext();) {
                Email e = (Email) iterator.next();
                if (Objects.equals(e.getId(), email.getId())) {
                    emails.set(emails.indexOf(e), email);
                    eRN.atualizar(email);
                }
            }
        }
        novoEmail();
    }

    public void removeEmail() {
        EmailRN eRN = new EmailRN();
        Email emailRemovido;
        if (this.convenio.getId() != null && this.convenio.getId() != 0) {
            emails.remove(email);
            emailRemovido = email;
            atualizaRelacionamentos();
            eRN.excluir(emailRemovido);
        } else {
            emails.remove(email);
            eRN.excluir(email);
        }
        novoEmail();
    }
    //-------------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------- bloco referente aos contatos 
    public void novoContato() {
        contato = new Contato();
    }

    public void addContato() {
        ContatoRN cRN = new ContatoRN();
        if (contato.getId() == null) {
            cRN.salvar(contato);
            contatos.add(contato);
        } else {
            for (Iterator iterator = contatos.iterator(); iterator.hasNext();) {
                Contato c = (Contato) iterator.next();
                if (Objects.equals(c.getId(), contato.getId())) {
                    contatos.set(contatos.indexOf(c), contato);
                    cRN.atualizar(contato);
                }
            }
        }
        novoContato();
    }

    public void removeContato() {
        ContatoRN cRN = new ContatoRN();
        Contato contatoRemovido;
        if (this.convenio.getId() != null && this.convenio.getId() != 0) {
            contatos.remove(contato);
            contatoRemovido = contato;
            atualizaRelacionamentos();
            cRN.excluir(contatoRemovido);
        } else {
            contatos.remove(contato);
            cRN.excluir(contato);
        }
        novoContato();
    }

    //-------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------ bloco referente aos enderecos 
    public void novoEndereco() {
        endereco = new Endereco();
    }

    public void addEndereco() {
        EnderecoRN eRN = new EnderecoRN();
        if (endereco.getId() == null) {
            eRN.salvar(endereco);
            enderecos.add(endereco);
        } else {
            for (Iterator iterator = enderecos.iterator(); iterator.hasNext();) {
                Endereco e = (Endereco) iterator.next();
                if (Objects.equals(e.getId(), endereco.getId())) {
                    enderecos.set(enderecos.indexOf(e), endereco);
                    eRN.atualizar(endereco);
                }
            }
        }
        novoEndereco();
    }

    public void removeEndereco() {
        EnderecoRN eRN = new EnderecoRN();
        Endereco enderecoRemovido;
        if (this.convenio.getId() != null && this.convenio.getId() != 0) {
            enderecos.remove(endereco);
            enderecoRemovido = endereco;
            atualizaRelacionamentos();
            eRN.excluir(enderecoRemovido);
        } else {
            enderecos.remove(endereco);
            eRN.excluir(endereco);
        }
        novoEndereco();
    }
    //-------------------------------------------------------------------------------------------------------

    public List<Convenio> getListarPorNome() {
        if ((convenio.getNomeFantasia() != null) && (!convenio.getNomeFantasia().equals(""))) {
            ConvenioRN cRN = new ConvenioRN();
            listarPorNome = cRN.listar(convenio.getNomeFantasia());
        } else {
            listarPorNome = null;
        }
        return listarPorNome;
    }

    public List<Convenio> getListarTodos() {
        ConvenioRN cRN = new ConvenioRN();
        return cRN.listarTodos();
    }

    public void setListarTodos(List<Convenio> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

}
