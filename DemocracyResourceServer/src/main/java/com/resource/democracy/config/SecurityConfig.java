package com.resource.democracy.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	
	
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.addFilterAfter( new CsrfTokenLogger(), CsrfFilter.class)
	 * .authorizeRequests() .anyRequest().permitAll(); }
	 */
	//private BearerTokenResolver re;

	/*
	 * @Value("${spring.queries.users-query}") private String usersQuery;
	 * 
	 * @Value("${spring.queries.roles-query}") private String rolesQuery;
	 */

	//@Autowired
	//private AuthenticationEntryPoint authEntryPoint;
	
	
	//@Bean
	//public PasswordEncoder passwordEncoder() {
	//	return new BCryptPasswordEncoder();
	//}
	
	
	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * DefaultWebSecurityExpressionHandler handler = new
	 * DefaultWebSecurityExpressionHandler(); handler.setPermissionEvaluator(new
	 * CustomPermissionEvaluator()); web.expressionHandler(handler); }
	 */
	 
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { //Authentication user =
	 * (Authentication)SecurityContextHolder.getContext().getAuthentication();
	 * //User users =
	 * (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * //System.out.println("User: "+users.getUsername()+", authorities: "+users.
	 * getAuthorities());
	 * //auth.authenticationProvider(authenticationProvider).userDetailsService();
	 * .passwordEncoder(passwordEncoder())
	 * 
	 * auth // .and() // .eraseCredentials(false); .inMemoryAuthentication()
	 * .withUser("car").password(passwordEncoder().encode("12345")).roles( "USER")
	 * .and() .withUser("car2").password(passwordEncoder().encode("12345")).roles(
	 * "USER") .and()
	 * .withUser("mon").password(passwordEncoder().encode("12345")).roles( "ADMIN")
	 * .and() .withUser("raul").password(passwordEncoder().encode("12345")).roles(
	 * "MARKETING") .and()
	 * .withUser("sales").password(passwordEncoder().encode("12345")).roles(
	 * "SALES") .and()
	 * .withUser("counter").password(passwordEncoder().encode("12345")).roles(
	 * "COUNTER") .and()
	 * .withUser("guess").password(passwordEncoder().encode("12345")).roles(
	 * "GUESS") .and()
	 * .withUser("anonimous").password(passwordEncoder().encode("12345")).roles(
	 * "ANONIMOUS") .and()
	 * .withUser("config").password(passwordEncoder().encode("12345")).roles(
	 * "CONFIG") .and()
	 * .withUser("rrhh").password(passwordEncoder().encode("12345")).roles( "RRHH");
	 * 
	 * }
	 */

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .csrf() .and() .authorizeRequests() .antMatchers("/","/login","/logout.do",
	 * "/anon", "/health").permitAll() .antMatchers("/**").authenticated() .and()
	 * .formLogin() .loginProcessingUrl("/login.do") .usernameParameter("username")
	 * .passwordParameter("password") .loginPage("/login") .and() .logout()
	 * .logoutRequestMatcher(new AntPathRequestMatcher("/logout.do")); }
	 * 
	 * 
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http. authorizeRequests() .antMatchers("/").permitAll()
	 * .antMatchers("/login").permitAll() .antMatchers("/registration").permitAll()
	 * .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
	 * .authenticated().and().csrf().disable().formLogin()
	 * .loginPage("/login").failureUrl("/login?error=true")
	 * .defaultSuccessUrl("/admin/home") .usernameParameter("email")
	 * .passwordParameter("password") .and().logout() .logoutRequestMatcher(new
	 * AntPathRequestMatcher("/logout"))
	 * .logoutSuccessUrl("/").and().exceptionHandling()
	 * .accessDeniedPage("/access-denied"); }
	 */
	//@Override
	
	/*
	 * public void configure(WebSecurity web) throws Exception { web .ignoring()
	 * .antMatchers("/resources/**", "/static/**", "/css/**","/js/**", "/images/**")
	 * .and().expressionHandler(null); }
	 */
	 

	
	/*
	 * @Override public void configure(HttpSecurity http) throws Exception {
	 * 
	 * 
	 * http.httpBasic().authenticationEntryPoint(authEntryPoint);
	 * 
	 * http .csrf().disable() .authorizeRequests()
	 * .antMatchers(HttpMethod.POST,"/listaPreciosSearch").authenticated()
	 * .antMatchers(HttpMethod.POST, "/login").permitAll()
	 * .antMatchers(HttpMethod.GET,"/forum").authenticated()
	 * .antMatchers(HttpMethod.POST,"/forum").authenticated()
	 * .antMatchers(HttpMethod.GET,"/grupoCuenta").permitAll()
	 * .antMatchers(HttpMethod.POST,"/grupoCuenta").permitAll()
	 * .antMatchers(HttpMethod.PUT,"/grupoCuenta").permitAll()
	 * .antMatchers(HttpMethod.DELETE,"/grupoCuenta").permitAll()
	 * .antMatchers(HttpMethod.POST,"/grupoCuentaSearch").permitAll()
	 * 
	 * .antMatchers(HttpMethod.PUT,"/cuenta").permitAll()
	 * .antMatchers(HttpMethod.DELETE,"/cuenta").permitAll()
	 * .antMatchers(HttpMethod.GET,"/cuenta").permitAll()
	 * .antMatchers(HttpMethod.POST,"/cuenta").permitAll()
	 * .antMatchers(HttpMethod.POST,"/cuentas").permitAll()
	 * 
	 * .antMatchers(HttpMethod.POST,"/tipoProducto").permitAll()
	 * .antMatchers(HttpMethod.PUT,"/tipoProducto").permitAll()
	 * .antMatchers(HttpMethod.DELETE,"/tipoProducto").permitAll()
	 * .antMatchers(HttpMethod.GET,"/tipoProducto").permitAll()
	 * .antMatchers(HttpMethod.POST,"/tipoProductoSearch").permitAll()
	 * .anyRequest().permitAll();
	 * 
	 * }
	 */
	 
	/*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
            .and()
              .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/grupoCuenta")
                  .hasAuthority("ROLE_COUNTER")
                .antMatchers(HttpMethod.POST, "/grupoCuentas")
                  .hasAuthority("ROLE_COUNTER")
                .anyRequest()
                  .authenticated()
            .and()
              .oauth2ResourceServer()
              .bearerTokenResolver(re);
        
    }*/
	
	 
	 
}