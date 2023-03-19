import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@ComponentScan("aop")
//@ComponentScan("entity")
@ComponentScan("ilecDB")
@ComponentScan("spobreo")
@EnableAspectJAutoProxy
public class MyConfig {
}
