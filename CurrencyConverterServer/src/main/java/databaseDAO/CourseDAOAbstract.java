package databaseDAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ilua on 15.12.2016.
 */
public abstract class CourseDAOAbstract implements CourseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public CourseDAOAbstract() {
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
