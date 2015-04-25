package br.com.magmadoctor.modelo.usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAOHibernate implements UsuarioDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    public void salvar(Usuario usuario) {
        this.session.save(usuario);
    }

    public void atualizar(Usuario usuario) {

        if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
            Usuario usuarioPermissao = this.carregar(usuario.getCodigo());
            usuario.setPermissao(usuarioPermissao.getPermissao());
            this.session.evict(usuarioPermissao);
        }

        this.session.update(usuario);
    }

    public void excluir(Usuario usuario) {
        this.session.delete(usuario);
    }

    public Usuario carregar(Integer codigo) {
        //TODO o hibernate nao conseguira fazer a carga caso seja passado o Usuario
        // no parametro, tem que ser diretamente a chave (integer)
        return (Usuario) this.session.get(Usuario.class, codigo);
    }

    public Usuario buscarPorLogin(String login) {
        String hql = "select u from Usuario u where u.login = :login";
        Query consulta = this.session.createQuery(hql);
        consulta.setString("login", login);

        //TODO mostrar primeiramente com o list e depois apresentar o uniqueResult
        return (Usuario) consulta.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> listar() {
        return this.session.createCriteria(Usuario.class).list();
    }
}
