package myapp;

import java.util.Properties;
import javax.activation.DataSource;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class SpringConfiguration {

	/*
	 * Définition de la source de données
	 */
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setUrl("jdbc:mariadb://localhost:3306/biblio");
		return (DataSource) dataSource;
	}

	/*
	 * Construction de l’EMF `a partir de la source de donn ́ees et du choix
	 * d’hibernate. Cette configuration remplace le fichier persistence.xml
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource((javax.sql.DataSource) dataSource());
		em.setPackagesToScan(new String[] { "myapp.entities" });
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		// Configuration d’hibernate
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		// properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		em.setJpaProperties(properties);
		return em;
	}

	/*
	 * Construction d’un gestionnaire de transaction en liaison avec l’usine `a EM.
	 */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {

		JpaTransactionManager transactionManager = new

		JpaTransactionManager();

		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
}
