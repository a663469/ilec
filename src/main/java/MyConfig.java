import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop")
@ComponentScan("entity")
@ComponentScan("hibernate")
@EnableAspectJAutoProxy
public class MyConfig {
}
