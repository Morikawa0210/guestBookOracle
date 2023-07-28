package com.ipsgholdings.guestBookOracle;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
public class GuestBookOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuestBookOracleApplication.class, args);
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
//		XMLで管理するsqlクエリをリターンする処理
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		
//		どこにSQL用のXMLファイルがあるかを指定し、リソースを配列に格納する
		Resource[] res = 
				new PathMatchingResourcePatternResolver()
					.getResources("classpath:mappers/*.xml");
		bean.setMapperLocations(res);
		return bean.getObject();
		
	}
	
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}
}
