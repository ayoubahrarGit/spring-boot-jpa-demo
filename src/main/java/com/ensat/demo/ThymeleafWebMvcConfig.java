package com.ensat.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafWebMvcConfig implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewRes = new ThymeleafViewResolver();
		viewRes.setTemplateEngine(templateEngine());
		return viewRes;
	}

	@Bean
	public ISpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setDialect(new LayoutDialect());
		return templateEngine;
	}

	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setCacheable(false);
		templateResolver.setPrefix("classpath:/templates");
		templateResolver.setSuffix(".html");
		return templateResolver;
	}

}
