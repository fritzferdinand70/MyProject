package in.nit.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement//enable tx management
@EnableWebMvc//enables webmvc
//load properties into spring container
@PropertySource("classpath:app.properties")
//all layered classes common package name
@ComponentScan("in.nit")
public class AppConfig {

	@Autowired
	private Environment env;
	
	//1) DataSource
	@Bean
	public DataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("db.driver"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.user"));
		ds.setPassword(env.getProperty("db.pwd"));
		return ds;
	}
	//2)SessionFactory
	@Bean
	public SessionFactory sf() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(ds());
		sf.setHibernateProperties(props());
		sf.setPackagesToScan("in.nit.model");
		return  sf.getObject();
	}
	//3)HibernateProperties
	public Properties props() {
		Properties p = new Properties();
		p.put("hibernate.dialect", env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql", env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql",env.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto", env.getProperty("orm.hbm2ddl.auto"));
		return p;
	}
	//4)HibernateTemplate
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate  ht = new HibernateTemplate();
		ht.setSessionFactory(sf());
		return ht;
	}
	//5)HibernateTx Manager
	@Bean
	public HibernateTransactionManager htx() {
		HibernateTransactionManager htx = new HibernateTransactionManager();
		htx.setSessionFactory(sf());
		return htx;
	}
	//6)ViewResolver
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver ivr = new InternalResourceViewResolver();
		ivr.setPrefix(env.getProperty("mvc.prefix"));
		ivr.setSuffix(env.getProperty("mvc.suffix"));
		return ivr;
	}
}
