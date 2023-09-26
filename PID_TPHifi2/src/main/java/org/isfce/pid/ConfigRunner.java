package org.isfce.pid;

import java.util.List;

import org.isfce.pid.hifi.Ampli;
import org.isfce.pid.hifi.IAmpli;
import org.isfce.pid.hifi.IAmpli.Sources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Profile("!test")
@Slf4j
public class ConfigRunner {
	@Autowired
	Environment env;
	@Autowired
	IAmpli ampli;
	
	@Bean
	@Profile("!jukebox")
	CommandLineRunner getClassique() {
		return (args) -> {
			System.out.println("HELLO Classique");
			log.info(List.of(env.getActiveProfiles()).toString());
			ampli.setSource(Sources.TUNER);
			ampli.setVolume(4);
			ampli.setSource(Sources.CD);
			ampli.setVolume(10);
			ampli.getCdPlayer().autoPlay();
		};
	};
	
	@Bean
	@Profile("jukebox")
	CommandLineRunner getJukebox() {
		return (args) -> {
			System.out.println("HELLO Jukebox");
			log.info(List.of(env.getActiveProfiles()).toString());
			ampli.setSource(Sources.CD);
			ampli.setVolume(7);
			ampli.getCdPlayer().autoPlay();
			ampli.setSource(Sources.TUNER);
			};
	};
}
