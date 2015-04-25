package br.com.magmadoctor.modelo.usuario;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

public class UsuarioRN {

    private UsuarioDAO usuarioDAO;

    public UsuarioRN() {
        this.usuarioDAO = DAOFactory.criarUsuarioDAO();
    }

    public Usuario carregar(Integer codigo) {
        return this.usuarioDAO.carregar(codigo);
    }

    public Usuario buscarPorLogin(String login) {
        return this.usuarioDAO.buscarPorLogin(login);
    }

    public void salvar(Usuario usuario) {

        Integer codigo = usuario.getCodigo();
        if (codigo == null || codigo == 0) {

            usuario.getPermissao().add("ROLE_USUARIO");

            this.usuarioDAO.salvar(usuario);

//            CategoriaRN categoriaRN = new CategoriaRN();
//            categoriaRN.salvaEstruturaPadrao(usuario);

        } else {
            this.usuarioDAO.atualizar(usuario);
        }
    }

    public void excluir(Usuario usuario) {

//        CategoriaRN categoriaRN = new CategoriaRN();
//        categoriaRN.excluir(usuario);

        this.usuarioDAO.excluir(usuario);
    }

    public List<Usuario> listar() {
        return this.usuarioDAO.listar();
    }
//	public void enviarEmailPosCadastramento(Usuario usuario) throws RNException {
//		//Enviando um e-mail conforme o idioma do usu�rio
//		String[] info = usuario.getIdioma().split("_");
//		Locale locale = new Locale(info[0], info[1]);
//			
//		String titulo = MensagemUtil.getMensagem(locale, "email_titulo");
//		String mensagem = MensagemUtil.getMensagem(locale, "email_mensagem", usuario.getNome(), usuario.getLogin(), usuario.getSenha());
//		try {		
//			EmailUtil emailUtil = new EmailUtil();
//			emailUtil.enviarEmail(null, usuario.getEmail(), titulo, mensagem);
//		} catch (UtilException e) {
//			throw new RNException(e);
//		}
//	}
}
