package br.com.magmadoctor.modelo.documento;

import br.com.magmadoctor.util.DAOFactory;

/**
 *
 * @author Dirceu Junior
 */
public class DocumentoRN {

    private final DocumentoDAO documentoDAO;

    public DocumentoRN() {
        this.documentoDAO = DAOFactory.criarDocumentoDAO();
    }

    public void salvar(Documento documento) {
        this.documentoDAO.salvar(documento);
    }

    public void atualizar(Documento documento) {
        this.documentoDAO.atualizar(documento);
    }

    public void excluir(Documento documento) {
        this.documentoDAO.excluir(documento);
    }

    public Documento porId(int id) {
        return this.documentoDAO.porId(id);
    }

}
