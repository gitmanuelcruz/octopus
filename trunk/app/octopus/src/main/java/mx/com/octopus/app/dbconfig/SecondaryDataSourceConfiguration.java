package mx.com.octopus.app.dbconfig;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "secondaryEntityManagerFactory", 
		transactionManagerRef = "secondaryTransactionManager", 
		basePackages = {"mx.com.octopus.app.models.hr.dao" })
public class SecondaryDataSourceConfiguration {
	@Autowired
	private Environment env;
	
	@Bean(name="secondaryDataSource")	
	public DataSource thirdDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource-secondary.url"));
		dataSource.setUsername(env.getProperty("spring.datasource-secondary.username"));
		dataSource.setPassword(env.getProperty("spring.datasource-secondary.password"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource-secondary.driver-class-name"));
		
		return dataSource;
	}
	
	@Bean(name="secondaryEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean thirdEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(thirdDataSource() );
		em.setPackagesToScan("mx.com.octopus.app.models.hr.entity");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String,Object> properties = new HashMap<String,Object>();
		properties.put("hibernate.hbm2dll.auto", env.getProperty("spring.datasource-secondary.hbm2ddl.auto"));
		properties.put("hibernate.show-sql", env.getProperty("spring.datasource-secondary.show-sql"));
		properties.put("hibernate.dialect",env.getProperty("spring.datasource-secondary.database-platform"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
	}
	
	@Bean(name="secondaryTransactionManager")
	public PlatformTransactionManager thirdTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(thirdEntityManagerFactory().getObject());
		
		return transactionManager;
	}
}
