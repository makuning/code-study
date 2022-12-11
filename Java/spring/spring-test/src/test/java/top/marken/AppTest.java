package top.marken;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.marken.config.SpringConfig;
import top.marken.domain.User;
import top.marken.service.MyService;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AppTest {
    //支持自动装配注入bean
    @Autowired
    private MyService service;

    @Test
    public void test() {
        List<User> all = service.findAll();
        System.out.println(all);
    }
}
