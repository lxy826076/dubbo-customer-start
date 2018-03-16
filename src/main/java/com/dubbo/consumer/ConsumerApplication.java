package com.dubbo.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.provider.DemoService;

public class ConsumerApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath:dubbo-consumer.xml"});
        context.start();
        // obtain proxy object for remote invocation   test
        DemoService demoService = (DemoService) context.getBean("demoService");
        // execute remote invocation
        int i = 0;
        while (true) {
			String hello = demoService.sayHello("world");
			System.out.println(hello);
			System.out.println("---------------");;
			i++;
			if (i>5) {
				break;
			}
		}
        
        Thread.sleep(1000*60*3);
    }
}