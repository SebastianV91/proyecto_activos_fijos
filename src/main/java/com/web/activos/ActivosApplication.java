package com.web.activos;

import java.time.ZoneOffset;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ActivosApplication {

	private static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone(ZoneOffset.UTC);
	private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
	
	public static void main(String[] args) {
		init();
		SpringApplication.run(ActivosApplication.class, args);
	}

	private static void init() {
	    TimeZone.setDefault(DEFAULT_TIME_ZONE);
	    Locale.setDefault(DEFAULT_LOCALE);
	}
	
}
