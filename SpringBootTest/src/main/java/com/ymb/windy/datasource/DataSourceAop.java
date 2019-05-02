package com.ymb.windy.datasource;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {
	@Before("execution(* com.ymb.windy.datasource1.service..*.*(..))")
	public void setDataSource1() {

		DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DATA_SOURCE_TYPE_1);
	}
	
	@Before("execution(* com.ymb.windy.datasource2.service..*.*(..))")
	public void setDataSource2() {

		DataSourceType.setDataBaseType(DataSourceType.DataBaseType.DATA_SOURCE_TYPE_2);
	}
}
