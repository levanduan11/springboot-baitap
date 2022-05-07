package com.jobhunt;

import com.jobhunt.service.Impl.EmployerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JobhuntApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(JobhuntApplication.class, args);
		EmployerService service=context.getBean(EmployerService.class);
		System.out.println(service.listAll());
	}

}
