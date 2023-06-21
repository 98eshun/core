package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PortotypeTest {

    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBena.class);
        System.out.println("find prototypeBean1");
        PrototypeBena prototypeBena1 = ac.getBean(PrototypeBena.class);
        System.out.println("find prototypeBean2");
        PrototypeBena prototypeBena2 = ac.getBean(PrototypeBena.class);
        System.out.println("prototypeBena1 = " + prototypeBena1);
        System.out.println("prototypeBena2 = " + prototypeBena2);
        Assertions.assertThat(prototypeBena1).isNotSameAs(prototypeBena2);

        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBena {
        @PostConstruct
        public void init(){
            System.out.println("SingletonBena.init");
        }

        @PreDestroy
        public void destory(){
            System.out.println("SingletonBena.destory");
        }
    }

}
