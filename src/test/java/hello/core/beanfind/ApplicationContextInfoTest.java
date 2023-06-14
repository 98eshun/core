package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String beanDefivitionName : beanDefinitionName) {
            Object bean = ac.getBean(beanDefivitionName);
            System.out.println("name = " + beanDefivitionName + "object" + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();
        for (String beanDefivitionName : beanDefinitionName) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefivitionName);

//            ROLE_APPLICATION : 일반적으로 사용자가 정의한 빈
//            ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefivitionName);
                System.out.println("name = " + beanDefivitionName + "object" + bean);
            }
        }
    }
}
