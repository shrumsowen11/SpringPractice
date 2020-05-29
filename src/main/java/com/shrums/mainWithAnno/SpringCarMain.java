package com.shrums.mainWithAnno;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shrums.Car;

public class SpringCarMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cars.xml");
		// "new ClassPathXmlApplicationContext" --> making the Spring Container(making a
		// bean file), where we have to give the .xml files as input

		// ApplicationContext --> it is a interface reference through which we can
		// access the spring(xml) container

		BeanFactory beanFactory = new ClassPathXmlApplicationContext("cars.xml");

		System.out.println("**************** ApplicationContext ******************");
		Car honda = (Car) applicationContext.getBean("honda"); 
		//("honda") --> this is the "id" part written in the .xml bean tags
		// "applicationContext.getBean("honda");" this just creates the object files(address)
		honda.run();
		System.out.println(honda);

		Car toyota = (Car) applicationContext.getBean("toyota");
		toyota.run();
		System.out.println(toyota);

		System.out.println("************************ End **************************\n\n\n");

		
		
		System.out.println("**************** BeanFactory ******************");

		Car hondb = (Car) beanFactory.getBean("honda");
		hondb.run();
		System.out.println(hondb);

		Car toyotb = (Car) beanFactory.getBean("toyota");
		toyotb.run();
		System.out.println(toyotb);

		System.out.println("**************** Rerunning the honda with \"a\" but printing the toyota values ******************");

		honda = (Car) applicationContext.getBean("toyota");
		honda.run();
		System.out.println(honda);

	}
}
