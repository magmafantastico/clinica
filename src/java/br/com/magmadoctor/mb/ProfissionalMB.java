package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.contato.Contato;
import br.com.magmadoctor.modelo.contato.ContatoRN;
import br.com.magmadoctor.modelo.documento.Documento;
import br.com.magmadoctor.modelo.documento.DocumentoRN;
import br.com.magmadoctor.modelo.email.Email;
import br.com.magmadoctor.modelo.email.EmailRN;
import br.com.magmadoctor.modelo.endereco.Endereco;
import br.com.magmadoctor.modelo.endereco.EnderecoRN;
import br.com.magmadoctor.modelo.especialidade.Especialidade;
import br.com.magmadoctor.modelo.especialidade.EspecialidadeRN;
import br.com.magmadoctor.modelo.profissional.Profissional;
import br.com.magmadoctor.modelo.profissional.ProfissionalRN;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class ProfissionalMB {

    private static final long serialVersionUID = 1L;

    private Profissional profissional;
    private Especialidade especialidade;
    private Endereco endereco;
    private Contato contato;
    private Email email;
    private Documento documento;

    private List<Profissional> listarPorNome;
    private List<Profissional> listarPorEspecializacao;

    private List<String> cbEspecialidades;

    private List<Profissional> profissionais = new ArrayList<>();
    private List<Especialidade> especialidades = new ArrayList<>();
    private List<Especialidade> especialidadesComplete = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Contato> contatos = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();
    private List<Documento> documentos = new ArrayList<>();

    private String pagina;

    private int controleDocumento;

    public ProfissionalMB() {
        this.pagina = "profissional";
        this.controleDocumento = 0;
        this.profissional = new Profissional();
        this.especialidade = new Especialidade();
        this.endereco = new Endereco();
        this.contato = new Contato();
        this.email = new Email();
        this.documento = new Documento();
    }

    public String inserir() {
        ProfissionalRN pRN = new ProfissionalRN();
        if (this.profissional.getId() != null && this.profissional.getId() != 0) {
            preparaProfissional();
            pRN.atualizar(getProfissional());
            FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            preparaProfissional();
            pRN.salvar(getProfissional());
            FacesMessage msg = new FacesMessage("CADASTRADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        novo();
        return getPagina();
    }

    public void atualizaRelacionamentos() {
        ProfissionalRN pRN = new ProfissionalRN();
        preparaProfissional();
        pRN.atualizar(getProfissional());
        FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void preparaProfissional() {
        profissional.setEspecialidades(especialidades);
        profissional.setEnderecos(enderecos);
        profissional.setContatos(contatos);
        profissional.setEmails(emails);
        if (controleDocumento == 1) {
            if (this.documento != null) {
                profissional.setDocumento(documento);
            }
        } else {
            if (this.documento.getId() != null) {
                profissional.setDocumento(documento);
            }
        }
    }

    public void excluir() {
        ProfissionalRN pRN = new ProfissionalRN();
        if (this.profissional.getId() != null && this.profissional.getId() != 0) {
            pRN.excluir(getProfissional());
            FacesMessage msg = new FacesMessage("PROFISSIONAL EXCLUIDO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("FAVOR SELECIONAR PROFISSIONAL PARA EXCLUSÃO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        novo();
    }

    public String novo() {
        this.profissional = new Profissional();
        this.especialidade = new Especialidade();
        this.endereco = new Endereco();
        this.contato = new Contato();
        this.email = new Email();
        this.documento = new Documento();
        return getPagina();
    }

    public void limparListas() {
        this.profissionais.clear();
        this.contatos.clear();
        this.enderecos.clear();
        this.emails.clear();
        this.documentos.clear();
    }

    public void editar() {
        controleDocumento = 1;
        ProfissionalRN pRN = new ProfissionalRN();
        profissional = pRN.porId(profissional.getId());
        especialidades = profissional.getEspecialidades();
        especialidadesComplete = profissional.getEspecialidades();
        contatos = profissional.getContatos();
        enderecos = profissional.getEnderecos();
        emails = profissional.getEmails();
        documento = profissional.getDocumento();
        if (this.documento != null) {
            documentos.add(documento);
        }
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
        if (this.profissional.getId() != null && this.profissional.getId() != 0) {
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
        if (this.profissional.getId() != null && this.profissional.getId() != 0) {
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
        if (this.profissional.getId() != null && this.profissional.getId() != 0) {
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

    //--------------------------------------------------------------- bloco referente aos documentos
    public void novoDocumento() {
        if (documento == null) {
            documento = new Documento();
        } else if (documento.getId() == null) {
            documento = new Documento();
        }
    }

    public void addDocumento() {
        DocumentoRN dRN = new DocumentoRN();
        if (documento.getId() == null) {
            dRN.salvar(documento);
            documentos.add(documento);
        } else {
            dRN.atualizar(documento);
        }
    }

    //-------------------------------------------------------------------------------------------------------
    public List<Profissional> getListarPorNome() {
        if ((profissional.getNome() != null) && (!profissional.getNome().equals(""))) {
            ProfissionalRN pRN = new ProfissionalRN();
            listarPorNome = pRN.listarPorNome(profissional.getNome());
        } else {
            listarPorNome = null;
        }
        return listarPorNome;
    }

    public List<Profissional> getListarTodos() {
        ProfissionalRN pRN = new ProfissionalRN();
        return pRN.listarTodos();
    }

    public void adicionaEspecialidade(ValueChangeEvent event) {
        int valor = Integer.parseInt(event.getNewValue().toString());
        boolean controle = true;
        for (Iterator iterator = especialidades.iterator(); iterator.hasNext();) {
            Especialidade e = (Especialidade) iterator.next();
            if (e.getId() == valor) {
                controle = false;
            }
        }
        if (valor == 0) {
        } else if ((controle)) {
            EspecialidadeRN eRN = new EspecialidadeRN();
            especialidades.add(eRN.porId(Integer.parseInt(event.getNewValue().toString())));
        } else {
            FacesMessage msg = new FacesMessage("ESPECIALIDADE JÁ SELECIONADA!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void selecionarEspecialidades(SelectEvent event) {
        boolean controle = true;
        Especialidade esp = (Especialidade) event.getObject();
        for (Iterator iterator = especialidadesComplete.iterator(); iterator.hasNext();) {
            Especialidade e = (Especialidade) iterator.next();
            if (Objects.equals(e.getId(), esp.getId())) {
                controle = false;
            }
        }
        if ((controle)) {
            EspecialidadeRN eRN = new EspecialidadeRN();
            especialidadesComplete.add((Especialidade) event.getObject());
        } else {
            FacesMessage msg = new FacesMessage("ESPECIALIDADE JÁ SELECIONADA!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

    }

    public void removerEspecialidades(UnselectEvent event) {
        Especialidade esp = (Especialidade) event.getObject();
        for (Iterator iterator = especialidadesComplete.iterator(); iterator.hasNext();) {
            Especialidade e = (Especialidade) iterator.next();
            if (Objects.equals(e.getId(), esp.getId())) {
                especialidadesComplete.remove(e);
                break;
            }
        }
    }

    public List<Especialidade> completeEspecialidade(String query) {
        EspecialidadeRN eRN = new EspecialidadeRN();
        especialidades = eRN.listarTodos();
        for (Especialidade e1 : especialidadesComplete) {
            for (Especialidade e2 : especialidades) {
                if (Objects.equals(e1.getId(), e2.getId())) {
                    especialidades.remove(e2);
                    break;
                }
            }
        }
        List<Especialidade> sugestoes = new ArrayList<>();
        for (Especialidade j : this.especialidades) {
            if (j.getNome().contains(query)) {
                sugestoes.add(j);
            }
        }
        return sugestoes;
    }

    public List<Profissional> completeNome(String query) {
        ProfissionalRN pRN = new ProfissionalRN();
        this.profissionais = pRN.listarTodos();
        List<Profissional> sugestoes = new ArrayList<>();
        for (Profissional j : this.profissionais) {
            if (j.getNome().startsWith(query)) {
                sugestoes.add(j);
            }
        }
        return sugestoes;
    }

    public void removeEspecialidade() {
        especialidades.remove(especialidade);
        especialidade = new Especialidade();
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<Profissional> getListarPorEspecializacao() {
        return listarPorEspecializacao;
    }

    public void setListarPorEspecializacao(List<Profissional> listarPorEspecializacao) {
        this.listarPorEspecializacao = listarPorEspecializacao;
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Profissional> profissionais) {
        this.profissionais = profissionais;
    }

    public List<String> getCbEspecialidades() {
        return cbEspecialidades;
    }

    public void setCbEspecialidades(List<String> cbEspecialidades) {
        this.cbEspecialidades = cbEspecialidades;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
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

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Especialidade> getEspecialidadesComplete() {
        return especialidadesComplete;
    }

    public void setEspecialidadesComplete(List<Especialidade> especialidadesComplete) {
        this.especialidadesComplete = especialidadesComplete;
    }

    public int getControleDocumento() {
        return controleDocumento;
    }

    public void setControleDocumento(int controleDocumento) {
        this.controleDocumento = controleDocumento;
    }

}
