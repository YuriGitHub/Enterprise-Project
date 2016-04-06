package io.khasang.enterprise.dao;

import io.khasang.enterprise.dao.interfaces.ProjectDao;
import io.khasang.enterprise.model.Client;
import io.khasang.enterprise.model.CustomerOrder;
import io.khasang.enterprise.model.Project;
import io.khasang.enterprise.model.enums.ProjectBasis;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository("projectDao")
public class ProjectDaoImpl extends AbstractDao<Project> implements ProjectDao {
    public Project findById(int id) {
        return getSession().get(Project.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Project> findByProjectBasis(ProjectBasis basis) {
        Criteria criteria = getSession().createCriteria(Project.class);
        criteria.add(Restrictions.eq("project_basis", basis)); //todo TESTS TESTS TESTS! project_basis or projectBasis?
        return (List<Project>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Project> findByPrice(BigDecimal price) {
        Criteria criteria = getSession().createCriteria(Project.class);
        criteria.add(Restrictions.eq("price", price));
        return (List<Project>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Project> findUnfinishedProjects() {
        Query query = getSession().createQuery("FROM Project p WHERE p.endDate = null");
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Project> findFinishedProjects() {
        Query query = getSession().createQuery("FROM Project p WHERE p.endDate != null");
        return query.list();
    }
    @SuppressWarnings("unchecked")
    public List<Project> findAllProjects() {
        Criteria criteria = getSession().createCriteria(Project.class);
        return criteria.list();
    }

    public void saveProject(Project project) {
        persist(project);
    }

    public void deleteProjectById(int id) {
        Query query = getSession().createQuery("FROM Project p WHERE p.id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public void deleteAllProjects() {
        Query query = getSession().createQuery("FROM Project");
        query.executeUpdate();
    }
}
