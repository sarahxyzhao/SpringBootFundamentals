package ttl.larku.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ttl.larku.domain.Course;
import ttl.larku.domain.Student;
import ttl.larku.jconfig.LarkUConfig;
import ttl.larku.service.CourseService;
import ttl.larku.service.StudentService;

import java.util.List;

public class SpringDemo {

    public static void main(String[] args) {
        SpringDemo sd = new SpringDemo();
        sd.go();
    }

    public void go() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(LarkUConfig.class);

//        StudentService ss = context.getBean("studentService", StudentService.class);
//
////        StudentService ss2 = context.getBean("studentService", StudentService.class);
//
//
//        List<Student> students = ss.getAllStudents();
//        System.out.println("Students:");
//        System.out.println(students);

        CourseService courseService = context.getBean("courseService", CourseService.class);
        List<Course> courses = courseService.getAllCourses();
        System.out.println(courses);
    }
}
