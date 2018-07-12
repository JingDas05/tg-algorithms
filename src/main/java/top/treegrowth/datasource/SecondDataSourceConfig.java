package top.treegrowth.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

//@Configuration
//@MapperScan(basePackages = {"com.dianwoba.rider.stalker.riderextradb.mapper"}, sqlSessionFactoryRef = SecondDataSourceConfig.SESSION_FACTORY_NAME)
public class SecondDataSourceConfig {
    
    public static final String DATASOURC_ENAME = "riderextradbDataSource";
    public static final String JDBC_TEMPLATE_ENAME = "riderextradbJdbcTemplate";
    public static final String TRANSACTION_MANAGER_NAME = "riderextradbTransactionManager";
    public static final String SESSION_FACTORY_NAME = "riderextradbSqlSessionFactory";
    
    @Resource
    private Environment env;
    
    private DataSource dataSource = null;
    
    @Bean(name = DATASOURC_ENAME)
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.riderextradb")
    public DataSource initDataSource() {
        if (dataSource == null) {
            dataSource = DataSourceBuilder.create().build();
        }
        return dataSource;
    }
    
    @Bean(name = TRANSACTION_MANAGER_NAME)
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(initDataSource());
    }
    
    @Bean(name = SESSION_FACTORY_NAME)
    @Primary
    public SqlSessionFactory initSqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(initDataSource());
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(env.getProperty("mybatis.riderextradb.mapper-locations")));
        return sessionFactory.getObject();
    }
    
    @Bean(name = JDBC_TEMPLATE_ENAME)
    public JdbcTemplate initJdbcTemplate() {
        return new JdbcTemplate(initDataSource());
    }
}
