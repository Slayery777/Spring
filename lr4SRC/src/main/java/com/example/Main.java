package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Main {

    @Autowired
    private BeanARepository beanARepository;

    @Autowired
    private BeanDRepository beanDRepository; // new

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);

        Main main = context.getBean(Main.class);
        main.test(context);
    }

    @Transactional
    public void test(ApplicationContext context) {
        // Read
        List<BeanA> beanAList = beanARepository.findAll();

        // Create and Delete
        BeanCRepository beanCRepository = context.getBean(BeanCRepository.class);
        BeanC firstBeanC = beanAList.get(0).getBeanBs().get(0).getBeanCs().get(0);
        beanCRepository.delete(firstBeanC);
        System.out.println("Deleted BeanC with id: " + firstBeanC.getId());

        BeanC newBeanC = new BeanC();
        newBeanC.setCode("New Code");
        newBeanC.setBeanB(beanAList.get(0).getBeanBs().get(0));
        beanCRepository.save(newBeanC);
        System.out.println("Created new BeanC with id: " + newBeanC.getId());

        // Update
        BeanA firstBeanA = beanAList.get(0);
        firstBeanA.setName("Updated BeanA");
        beanARepository.save(firstBeanA);
        System.out.println("Updated BeanA: " + firstBeanA.getName());

        // Виведення даних
        System.out.println("----beanAList----");
        beanAList.forEach(beanA -> {
            System.out.println("BeanA Name: " + beanA.getName());

            beanA.getBeanBs().forEach(beanB -> {
                System.out.println("BeanB Age: " + beanB.getAge());

                beanB.getBeanCs().forEach(beanC -> {
                    System.out.println("BeanC Code: " + beanC.getCode());
                });
            });
        });

        List<BeanD> beanDList = beanDRepository.findAll();
        System.out.println("----beanDList----");
        beanDList.forEach(beanD -> {
            System.out.println("BeanD id: " + beanD.getId());
            System.out.println("Associated BeanA id: " + beanD.getBeanA().getId());
        });
    }
}

