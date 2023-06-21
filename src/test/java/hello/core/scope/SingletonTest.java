package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonTest {

    @Test
    void singletonBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBena.class);

        SingletonBena singletonBena1 = ac.getBean(SingletonBena.class);
        SingletonBena singletonBena2 = ac.getBean(SingletonBena.class);
        System.out.println("singletonBena1 = " + singletonBena1);
        System.out.println("singletonBena2 = " + singletonBena2);
        Assertions.assertThat(singletonBena1).isSameAs(singletonBena2);


    }

    @Scope("singleton")
    static class SingletonBena {
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
