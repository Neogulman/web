package com.neogul.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
//@Lazy
@PropertySource("classpath:/datasource.properties")
@EnableTransactionManagement
public class DataConfig  {
	
	@Autowired
    private ApplicationContext applicationContext;

	/*@Autowired
    private Environment env;*/
	@Value("${jdbc.driverClassName}")
	String driverClassName;
	@Value("${jdbc.url}")
	String url;
	@Value("${jdbc.maxActive}")
	String maxActive;
	
    /**
     * Uses Apache Commons DBCP for connection pooling. See Commons DBCP
     * documentation for the required JAR files. Alternatively you can use
     * another connection pool such as C3P0, similarly configured using Spring.
     */
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource =  new org.apache.tomcat.jdbc.pool.DataSource();
		 // BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        
        
        dataSource.setUsername("root");
        dataSource.setPassword("111111");
        
        dataSource.setMaxActive(Integer.valueOf(maxActive));
       /* dataSource.setMaxIdle(Integer.valueOf(env.getProperty("jdbc.maxIdle")));
        dataSource.setMaxWait(Integer.valueOf(env.getProperty("jdbc.maxWait")));
        dataSource.setInitialSize(Integer.valueOf(env.getProperty("jdbc.initialSize")));
        dataSource.setRemoveAbandoned(Boolean.parseBoolean(env.getProperty("jdbc.removeAbandoned")));
        dataSource.setRemoveAbandonedTimeout(Integer.valueOf(env.getProperty("jdbc.removeAbandonedTimeout")));
        dataSource.setLogAbandoned(Boolean.parseBoolean(env.getProperty("jdbc.logAbandoned")));
        dataSource.setPoolPreparedStatements(Boolean.parseBoolean(env.getProperty("jdbc.poolPreparedStatements")));
        dataSource.setTestOnBorrow(Boolean.parseBoolean(env.getProperty("jdbc.testOnBorrow")));
        dataSource.setValidationQuery(env.getProperty("jdbc.validationQuery"));
        dataSource.setTestOnReturn(Boolean.parseBoolean(env.getProperty("jdbc.testOnReturn")));
        dataSource.setTestWhileIdle(Boolean.parseBoolean(env.getProperty("jdbc.testWhileIdle")));
        dataSource.setTimeBetweenEvictionRunsMillis(Integer.valueOf(env.getProperty("jdbc.timeBetweenEvictionRunsMillis")));
        dataSource.setMinIdle(Integer.valueOf(env.getProperty("jdbc.minIdle")));*/
        
        return dataSource;
    }
	
    @Bean
    public DataSourceTransactionManager transactionManager()
    {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
                
        // 이 부분은 mybatis mapper 위치에 대해서 설정해주는 부분...
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath:/mybatis/*.xml"));
        return sessionFactory.getObject();
    }
   /* @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{
    	return new SqlSessionTemplate(sqlSessionFactory);
    }*/
    

}