package br.com.orangetalent5.proposta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                        		.antMatchers("/actuator/**").permitAll()//hasAuthority("SCOPE_userscopo")
                                .antMatchers("/**").permitAll()//.hasAuthority("SCOPE_userscopo")
                                .anyRequest().authenticated()
                )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .sessionManagement(x->x.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                
    }

}
