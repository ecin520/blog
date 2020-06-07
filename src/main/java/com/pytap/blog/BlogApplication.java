package com.pytap.blog;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ecin520
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(BlogApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

	public static void generator() throws IOException, XMLParserException, SQLException, InterruptedException, InvalidConfigurationException {
		List<String> warnings  = new ArrayList<>();

		InputStream is = BlogApplication.class.getResourceAsStream("/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(is);
		is.close();

		DefaultShellCallback callback = new DefaultShellCallback(true);

		//创建 MBG
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);

		//执行生成代码
		myBatisGenerator.generate(null);

		//输出警告信息
		for (String warning : warnings) {
			System.out.println(warning);
		}
	}

}
