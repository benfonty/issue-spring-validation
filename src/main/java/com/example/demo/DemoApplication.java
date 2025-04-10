package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
@EnableConfigurationProperties(MyProperties.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();

		// replace by the following to apply the workaround
		/*return new MethodValidationPostProcessor() {
			@Override
			public boolean isEligible(Object bean, String beanName) {
				if (bean.getClass().isRecord()) {
					return false;
				}
				return super.isEligible(bean, beanName);
			}
		};*/
	}

}
