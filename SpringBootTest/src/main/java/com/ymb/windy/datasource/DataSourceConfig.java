package com.ymb.windy.datasource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.ymb.windy.datasource1.mapper,com.ymb.windy.datasource2.mapper", sqlSessionFactoryRef = "SqlSessionFactory")
public class DataSourceConfig {

	@Autowired
	private Environment env;

	/**
	 * 创建数据源1
	*/
	@Bean(name = "dataSource1")
	public DataSource getDateSource1() throws  Exception{
		Properties props = new Properties();
		props.put("driverClassName",env.getProperty("spring.dataSource1.driverName"));
		props.put("url", env.getProperty("spring.dataSource1.url"));
		props.put("username", env.getProperty("spring.dataSource1.username"));
		props.put("password", env.getProperty("spring.dataSource1.password"));
		return DruidDataSourceFactory.createDataSource(props);
	}

	/**
	 * 创建数据源2
	 */
	@Bean(name = "dataSource2")
	public DataSource getDateSource2() throws  Exception{
		Properties props = new Properties();
		props.put("driverClassName",env.getProperty("spring.dataSource2.driverName"));
		props.put("url", env.getProperty("spring.dataSource2.url"));
		props.put("username", env.getProperty("spring.dataSource2.username"));
		props.put("password", env.getProperty("spring.dataSource2.password"));
		return DruidDataSourceFactory.createDataSource(props);
	}

	@Bean(name = "dynamicDataSource")
	public DynamicDataSource DataSource(@Qualifier("dataSource1") DataSource dataSource1,@Qualifier("dataSource2") DataSource dataSource2) {
		Map<Object, Object> targetDataSource = new HashMap<>();
		targetDataSource.put(DataSourceType.DataBaseType.DATA_SOURCE_TYPE_1, dataSource1);
		targetDataSource.put(DataSourceType.DataBaseType.DATA_SOURCE_TYPE_2, dataSource2);
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSource);
		dataSource.setDefaultTargetDataSource(dataSource1);
		return dataSource;
	}

	@Bean(name = "SqlSessionFactory")
	public SqlSessionFactory test1SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dynamicDataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*.xml"));
		return bean.getObject();
	}

}
