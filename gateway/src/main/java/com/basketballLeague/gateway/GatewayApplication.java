package com.basketballLeague.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(
			RouteLocatorBuilder builder,
			@Value("${player.url}") String playerUrl,
			@Value("${basketball.club.url}") String clubUrl,
			@Value("${gateway.host}") String host
	){
		return builder
				.routes()
				.route("basketballClubs", route -> route
						.host(host)
						.and()
						.path(
								"/basketballLeague/clubs",
								"/basketballLeague/clubs/{uuid}"
						)
						.uri(clubUrl))
				.route("players", route -> route
						.host(host)
						.and()
						.path(
								"/basketballLeague/players",
								"/basketballLeague/players/{uuid}",
								"/basketballLeague/clubs/{uuid}/players"
						)
						.uri(playerUrl))
				.build();
	}

}
