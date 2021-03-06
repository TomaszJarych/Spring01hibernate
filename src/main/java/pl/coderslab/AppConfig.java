package pl.coderslab;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.coderslab.converter.AuthorConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.coderslab.Repository")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
	LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
	emfb.setPersistenceUnitName("Spring01hibernate");
	return emfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	JpaTransactionManager tm = new JpaTransactionManager(emf);
	return tm;
    }

    @Bean
    public ViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/views/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	final ObjectMapper objectMapper = new ObjectMapper();
	objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	converter.setObjectMapper(objectMapper);
	converters.add(converter);
	super.configureMessageConverters(converters);
    }

    // konwerter z zadania Dzień 2 - zadanie 4

    @Override
    public void addFormatters(FormatterRegistry registry) {
	registry.addConverter(getAuthorConverter());
    }

    @Bean
    public AuthorConverter getAuthorConverter() {
	return new AuthorConverter();
    }

    // dodanie validatora

    @Bean
    public Validator validator() {
	return new LocalValidatorFactoryBean();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
