package repository;

import manager.HibernateController;
import model.Departamento;

import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

public class DepartamentoRepositoryJPA implements CrudRepository<Departamento, Long> {
    @Override
    public List<Departamento> findAll() {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        TypedQuery<Departamento> query = hc.getManager().createNamedQuery("Departamento.findAll", Departamento.class);
        List<Departamento> list = query.getResultList();
        hc.close();
        return list;
    }

    @Override
    public Departamento getById(Long ID) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        Departamento post = hc.getManager().find(Departamento.class, ID);
        hc.close();
        if (post != null)
            return post;
        throw new SQLException("Error PostRepository no existe post con ID: " + ID);
    }

    @Override
    public Departamento save(Departamento post) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().persist(post);
            hc.getTransaction().commit();
            hc.close();
            return post;
        } catch (Exception e) {
            throw new SQLException("Error PostRepository al insertar post en BD");
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    @Override
    public Departamento update(Departamento post) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            hc.getManager().merge(post);
            hc.getTransaction().commit();
            hc.close();
            return post;
        } catch (Exception e) {
            throw new SQLException("Error PostRepository al actualizar post con id: " + post.getId());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }

    }

    @Override
    public Departamento delete(Departamento post) throws SQLException {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        try {
            hc.getTransaction().begin();
            // Ojo que borrar implica que estemos en la misma sesión y nos puede dar problemas, por eso lo recuperamos otra vez
            post = hc.getManager().find(Departamento.class, post.getId());
            hc.getManager().remove(post);
            hc.getTransaction().commit();
            hc.close();
            return post;
        } catch (Exception e) {
            throw new SQLException("Error PostRepository al eliminar post con id: " + post.getId());
        } finally {
            if (hc.getTransaction().isActive()) {
                hc.getTransaction().rollback();
            }
            hc.close();
        }
    }

    public List<Departamento> getByUserId(Long userId) {
        HibernateController hc = HibernateController.getInstance();
        hc.open();
        List<Departamento> list = hc.getManager().createNamedQuery("Departamento.getByUserId", Departamento.class)
                .setParameter(1, userId).getResultList();
        hc.close();
        return list;
    }
}
