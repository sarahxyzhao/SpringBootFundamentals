package ttl.larku.dao;

import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.dao.jpa.JpaStudentDAO;

import java.util.ResourceBundle;

public class DaoFactory {

    public static BaseDAO getDAO() {
        ResourceBundle bundle = ResourceBundle.getBundle("larkUContext");
        String profile = bundle.getString("larku.profile.active");
        switch(profile) {
            case "dev":
                return new InMemoryStudentDAO();
            case "prod":
                return new JpaStudentDAO();
            default:
                throw new RuntimeException("unknown profile: " + profile);
        }
    }
}
