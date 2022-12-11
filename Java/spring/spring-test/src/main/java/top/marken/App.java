package top.marken;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.marken.config.SpringConfig;
import top.marken.domain.User;
import top.marken.service.MyService;
import java.util.List;

/**
 * Hello world!
 *
 */

public class App {
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        MyService service = context.getBean(MyService.class);
        User byId = service.findById(1);
        System.out.println(byId);
        List<User> all = service.findAll();
        System.out.println(all);
    }
}
