package com.joheul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.joheul.conf.DataConfig;
import com.joheul.conf.WebConfig;

@SpringBootApplication
@Import({
	DataConfig.class,
	WebConfig.class
})
public class JtopsRenewalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtopsRenewalApplication.class, args);
	}
}
