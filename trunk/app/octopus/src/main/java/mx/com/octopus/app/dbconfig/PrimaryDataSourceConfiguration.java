package mx.com.octopus.app.dbconfig;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
		entityManagerFactoryRef = "primaryEntityManagerFactory", 
		transactionManagerRef = "primaryTransactionManager", 
		basePackages = {"mx.com.octopus.app.models.user.dao"})
public class PrimaryDataSourceConfiguration {

	@Autowired
	private Environment env;
	
	@Bean(name="primaryDataSource")
	@Primary
	public DataSource primaryDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource-primary.url"));
		dataSource.setUsername(env.getProperty("spring.datasource-primary.username"));
		dataSource.setPassword(env.getProperty("spring.datasource-primary.password"));
		dataSource.setDriverClassName(env.getProperty("spring.datasource-primary.driver-class-name"));
		
		return dataSource;
	}

	@Bean(name="primaryEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(primaryDataSource() );
		em.setPackagesToScan("mx.com.octopus.app.models.user.entity");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String,Object> properties = new HashMap<String,Object>();
		properties.put("hibernate.hbm2dll.auto", env.getProperty("spring.datasource-primary.hbm2ddl.auto"));
		properties.put("hibernate.show-sql", env.getProperty("spring.datasource-primary.show-sql"));
		properties.put("hibernate.dialect",env.getProperty("spring.datasource-primary.jpa.database-platform"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
	}


	@Bean(name="primaryTransactionManager")
	@Primary
	public PlatformTransactionManager primaryTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(primaryEntityManagerFactory().getObject());
		
		return transactionManager;
	}
}