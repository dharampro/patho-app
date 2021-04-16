package com.techendear.api.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		String name = "user";
	    Optional<String> opt = Optional.of(name);
		return opt;
	}
}
