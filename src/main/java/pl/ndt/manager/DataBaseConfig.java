package pl.ndt.manager;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.ndt.manager.model.Document;
import pl.ndt.manager.repository.DocumentRepository;
import pl.ndt.manager.repository.UserRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {UserRepository.class,DocumentRepository.class})

public class DataBaseConfig {

	/**
	 * EntityManagerFactory configuration
	 * 
	 * @param adapter
	 *            information about JPA provider
	 * @param ds
	 *            data source
	 * @return LocalContainerEntityManagerFactory object
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter adapter, DataSource ds) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPersistenceUnitName("myPersistanceUnit");
		Map<String, String> properties = new HashMap<>();
		properties.put("javax.persistence.schema-generation.database.action", "update");
		emf.setJpaPropertyMap(properties);
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(adapter);
		emf.setPackagesToScan("pl.ndt.manager.model");
		return emf;
	}

	/**
	 * Configuration JPA provider and type of database
	 * 
	 * @return JpaVendorAdapter object
	 */

	@Bean
	public JpaVendorAdapter createVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setGenerateDdl(true);
		adapter.setShowSql(true);
		return adapter;
	}

	/**
	 * DataSource configuration
	 * 
	 * @return DriverManagerDataSource object
	 */

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ndt_manager");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("admin");
		return driverManagerDataSource;
	}

	/**
	 * TransactionManager configuration
	 * 
	 * @param emf
	 *            EntityManagerFactoryObject
	 * @return PlatformTransactionManager object
	 */

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager(emf);
		return txManager;
	}

}
