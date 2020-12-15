package ttl.larku.jconfig;

import org.springframework.context.annotation.*;
import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

@Configuration
@ComponentScan({"ttl.larku.service", "ttl.larku.dao"})
public class LarkUConfig {

    //    <bean id="inMemoryDAO" class="ttl.larku.dao.inmemory.InMemoryStudentDAO"/>
    @Bean
    public BaseDAO<Student> studentDAO() {
        return new InMemoryStudentDAO();
    }

    //
//    <bean id="studentService" class="ttl.larku.service.StudentService" >
//        <property name="studentDAO" ref="inMemoryDAO"/>
//    </bean>
    @Bean
    public StudentService studentService() {
        StudentService ss = new StudentService();
        ss.setStudentDAO(studentDAO());

        return ss;
    }
}