package co.com.delibolis.accountancy.infrastructure.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;

//@Configuration
//@EnableTransactionManagement
//@MapperScan(value="co.com.delibolis.accountancy.infrastructure.repository.mybatis.mappers")
public class MybatisContextConfig {
	
	//@Value("${spring.datasource.driver-class-name}")
	private String className;
	
	//@Value("${spring.datasource.url}")
	private String url;
	
	//@Value("${spring.datasource.username}")
	private String userName;
	
	//@Value("${spring.datasource.password}")
	private String passWord;
	
	//@Value("${mybatis.mapperLocations}")
	private String relativePath;
	
	//@Value("${mybatis.typeAliasesPackage}")
	private String typeAliasesPackage;
	
	//@Value("${mybatis.typeHandlersPackage}")
	private String typeHandlersPackage;
	
	//@Bean
	public DriverManagerDataSource dataSource() throws IllegalArgumentException, NamingException{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(this.className);
		driverManagerDataSource.setUrl(this.url);
		driverManagerDataSource.setUsername(this.userName);
		driverManagerDataSource.setPassword(this.passWord);
		return driverManagerDataSource;
		
	}
	
	//@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	    Resource[] mapperLocations = resolver.getResources(this.relativePath);
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(this.dataSource());
		sqlSessionFactory.setTypeAliasesPackage(this.typeAliasesPackage);
		sqlSessionFactory.setTypeHandlersPackage(this.typeHandlersPackage);
		sqlSessionFactory.setMapperLocations(mapperLocations);
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
	
	//@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		SqlSessionTemplate sqlSessionTemplate= new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate;
	}
}
