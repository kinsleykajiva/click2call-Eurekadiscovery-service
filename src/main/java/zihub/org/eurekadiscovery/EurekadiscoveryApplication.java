package zihub.org.eurekadiscovery;

import com.netflix.appinfo.AmazonInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.annotation.PreDestroy;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class EurekadiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekadiscoveryApplication.class, args);
	}
	@Bean
	ApplicationRunner applicationRunner(Environment environment) {
		return args -> {
			log.error("XXXXXXXX-Systrem starting up " );

		};
	}
	@PreDestroy
	public void onExit() {
		log.info("###STOPing###");
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			log.error("", e);;
		}
		log.info("###STOP FROM THE LIFECYCLE###");
	}

	/*@Bean
	@Profile("!default")
	public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
		EurekaInstanceConfigBean b = new EurekaInstanceConfigBean(inetUtils);
		AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
		b.setDataCenterInfo(info);
		return b;
	}*/

}
