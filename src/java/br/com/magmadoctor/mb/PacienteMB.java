package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.contato.Contato;
import br.com.magmadoctor.modelo.contato.ContatoRN;
import br.com.magmadoctor.modelo.convenio.Convenio;
import br.com.magmadoctor.modelo.convenio.ConvenioRN;
import br.com.magmadoctor.modelo.documento.Documento;
import br.com.magmadoctor.modelo.documento.DocumentoRN;
import br.com.magmadoctor.modelo.email.Email;
import br.com.magmadoctor.modelo.email.EmailRN;
import br.com.magmadoctor.modelo.endereco.Endereco;
import br.com.magmadoctor.modelo.endereco.EnderecoRN;
import br.com.magmadoctor.modelo.paciente.Paciente;
import br.com.magmadoctor.modelo.paciente.PacienteRN;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class PacienteMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Paciente paciente;
    private Convenio convenio;
    private Endereco endereco;
    private Contato contato;
    private Email email;
    private Documento documento;

    private List<Paciente> listarTodos;
    private List<Paciente> listarPorNome;

    private String pagina;

    private int controleDocumento;

    private List<Paciente> pacientes = new ArrayList<>();
    private List<Convenio> convenios = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Contato> contatos = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();
    private List<Documento> documentos = new ArrayList<>();

    private StreamedContent arquivoRetorno;
    private int tipoRelatorio;

    public PacienteMB() {
        this.pagina = "paciente";
        this.controleDocumento = 0;
        this.paciente = new Paciente();
        this.convenio = new Convenio();
        this.endereco = new Endereco();
        this.contato = new Contato();
        this.email = new Email();
        this.documento = new Documento();
    }

    public String inserir() {
        PacienteRN pRN = new PacienteRN();
        if (this.paciente.getId() != null && this.paciente.getId() != 0) {
            prepararPaciente();
            pRN.atualizar(getPaciente());
            FacesMessage msg = new FacesMessage("PACIENTE ATUALIZADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            prepararPaciente();
            pRN.salvar(getPaciente());
            FacesMessage msg = new FacesMessage("PACIENTE CADASTRADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        novo();
        return getPagina();
    }

    public void atualizaRelacionamentos() {
        PacienteRN pRN = new PacienteRN();
        prepararPaciente();
        pRN.atualizar(getPaciente());
        FacesMessage msg = new FacesMessage("PACIENTE ATUALIZADO COM SUCESSO!!!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void prepararPaciente() {
        paciente.setConvenios(convenios);
        paciente.setEnderecos(enderecos);
        paciente.setContatos(contatos);
        paciente.setEmails(emails);
        paciente.setAtivo(1);
        if (controleDocumento == 1) {
            if (this.documento != null) {
                paciente.setDocumento(documento);
            }
        } else {
            if (this.documento.getId() != null) {
                paciente.setDocumento(documento);
            }
        }
    }

    public void excluir() {
        PacienteRN pRN = new PacienteRN();
        if (this.paciente.getId() != null && this.paciente.getId() != 0) {
            pRN.excluir(getPaciente());
            FacesMessage msg = new FacesMessage("PACIENTE EXCLUIDO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("FAVOR SELECIONAR PACIENTE PARA EXCLUSÃO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        novo();
    }

    public String novo() {
        this.paciente = new Paciente();
        this.convenio = new Convenio();
        this.endereco = new Endereco();
        this.contato = new Contato();
        this.email = new Email();
        this.documento = new Documento();
        return getPagina();
    }

    public void limparListas() {
        this.pacientes.clear();
        this.contatos.clear();
        this.enderecos.clear();
        this.emails.clear();
        this.documentos.clear();
    }

    public void editar() {
        controleDocumento = 1;
        PacienteRN pRN = new PacienteRN();
        paciente = pRN.porId(paciente.getId());
        convenios = paciente.getConvenios();
        contatos = paciente.getContatos();
        enderecos = paciente.getEnderecos();
        emails = paciente.getEmails();
        documento = paciente.getDocumento();
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
        if (this.paciente.getId() != null && this.paciente.getId() != 0) {
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
        if (this.paciente.getId() != null && this.paciente.getId() != 0) {
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
        if (this.paciente.getId() != null && this.paciente.getId() != 0) {
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

    //--------------------------------------------------------------------------------------------
    public List<Paciente> getListarTodos() {
        PacienteRN pRN = new PacienteRN();
        listarTodos = pRN.listarTodos();
        return listarTodos;
    }

    public List<Paciente> getListarPorNome() {
        if ((paciente.getNome() != null) && (!paciente.getNome().equals(""))) {
            PacienteRN pRN = new PacienteRN();
            listarPorNome = pRN.listarPorNome(paciente.getNome());
        } else {
            listarPorNome = null;
        }
        return listarPorNome;
    }

    public List<Paciente> getListarPorNomeSimples() {
        if ((paciente.getNome() != null) && (!paciente.getNome().equals(""))) {
            PacienteRN pRN = new PacienteRN();
            listarPorNome = pRN.porNomeSimples(paciente.getNome());
        } else {
            listarPorNome = null;
        }
        return listarPorNome;
    }

    public List<Paciente> completaNome(String query) {
        PacienteRN pRN = new PacienteRN();
        this.pacientes = pRN.listarTodos();
        List<Paciente> sugestoes = new ArrayList<>();
        for (Paciente j : this.pacientes) {
            if (j.getNome().startsWith(query)) {
                sugestoes.add(j);
            }
        }
        return sugestoes;
    }

    public void adicionaConvenio(ValueChangeEvent event) {
        int valor = Integer.parseInt(event.getNewValue().toString());
        boolean controle = true;
        for (Iterator iterator = convenios.iterator(); iterator.hasNext();) {
            Convenio c = (Convenio) iterator.next();
            if (c.getId() == valor) {
                controle = false;
            }
        }
        if (valor == 0) {
        } else if ((controle)) {
            ConvenioRN cRN = new ConvenioRN();
            convenios.add(cRN.porId(Integer.parseInt(event.getNewValue().toString())));
        } else {
            FacesMessage msg = new FacesMessage("CONVÊNIO JÁ SELECIONADO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void removeConvenio() {
        convenios.remove(convenio);
        convenio = new Convenio();
    }

    public void conveniosPorPaciente(SelectEvent event) {
        convenios.clear();
        paciente = (Paciente) event.getObject();
        convenios.addAll(paciente.getConvenios());
    }

    public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException {
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/relatorios/Paciente.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, new JRBeanCollectionDataSource(this.getPacientes()));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
        stream.flush();
        stream.close();

        FacesContext.getCurrentInstance().responseComplete();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
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

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public int getControleDocumento() {
        return controleDocumento;
    }

    public void setControleDocumento(int controleDocumento) {
        this.controleDocumento = controleDocumento;
    }

    public StreamedContent getArquivoRetorno() {
//        //FacesContext context = FacesContext.getCurrentInstance();
//        //ContextoBean contextoBean = ContextoUtil.getContextoBean();
//        //String usuario = contextoBean.getUsuarioLogado().getLogin();
//        String nomeRelatorioJasper = "Paciente";
//        String nomeRelatorioSaida = Calendar.getInstance().getTime() + "_todosPacientes";
//        RelatorioUtil relatorioUtil = new RelatorioUtil();
//        HashMap parametrosRelatorio = new HashMap();
//        //parametrosRelatorio.put("codigoUsuario", contextoBean.getUsuarioLogado().getCodigo());
//        try {
//            this.arquivoRetorno = relatorioUtil.geraRelatorio(parametrosRelatorio, nomeRelatorioJasper, nomeRelatorioSaida, this.tipoRelatorio);
//        } catch (UtilException e) {
//            //context.addMessage(null, new FacesMessage(e.getMessage()));
//            return null;
//        }
//        return this.arquivoRetorno;
        return null;
    }

    public void setArquivoRetorno(StreamedContent arquivoRetorno) {
        this.arquivoRetorno = arquivoRetorno;
    }

    public int getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(int tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }

}
