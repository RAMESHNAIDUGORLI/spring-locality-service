package com.org.postal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPostalServiceApplication {
	private static final Logger LOG = LoggerFactory.getLogger(SpringPostalServiceApplication.class);

	public static void main(String[] args) {
		LOG.debug("Locality service initiated");
		SpringApplication.run(SpringPostalServiceApplication.class, args);
	}

}
