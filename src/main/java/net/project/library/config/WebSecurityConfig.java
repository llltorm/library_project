package net.project.library.config;

//import net.project.library.repository.UserRepository;
//import net.project.library.service.CustomUserDetailsService;
import net.project.library.repository.ReaderRepository;
import net.project.library.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{ ////////////////////////////////////////важно!!!!!!!!!!!!!!!
public class WebSecurityConfig{
//    private final UserRepository userRepository;
//    private final PasswordConfig passwordEncoder;
//
//    @Autowired
//    public WebSecurityConfig( PasswordConfig passwordEncoder, UserRepository userRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.userRepository = userRepository;
//    }
//
//    @Bean
//    UserDetailsService userDetailsService() {
//        return new CustomUserDetailsService(userRepository);
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/registration").permitAll()
//                .antMatchers("/readers/create/**").hasRole("ADMIN")
//                .antMatchers("/readers/update/**").hasRole("ADMIN")
//                .antMatchers("/readers/create/**").hasRole("ADMIN")
//                .antMatchers("/readers/delete/**").hasRole("ADMIN")
//                .antMatchers("/readers/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()// !!! don't forget to add 'permitAll' when you're shaping a login or any page
//                .defaultSuccessUrl("/login",true)
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/403")
//                .and()
//                .build();
//    }

//    @Autowired
//    private UserDetailsService userDetailsService;

    private final ReaderRepository readerRepository;

    @Autowired
    public WebSecurityConfig(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Bean
    UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(readerRepository);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/", "/registration", "/login").permitAll()
//                .antMatchers("/readers/create/**").hasRole("ADMIN")
//                .antMatchers("/readers/update/**").hasRole("ADMIN")
//                .antMatchers("/readers/create/**").hasRole("ADMIN")
//                .antMatchers("/readers/delete/**").hasRole("ADMIN")
//                .antMatchers("/readers/**").hasRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()// !!! don't forget to add 'permitAll' when you're shaping a login or any page
//                //.defaultSuccessUrl("/login", true)
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/403");
//    }
    ///////////////////////////////////////////////////////////////////////////////////


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/registration", "/login").permitAll()
//                .antMatchers("/readers/create/**").hasRole("ADMIN")
//                .antMatchers("/readers/update/**").hasRole("ADMIN")
//                .antMatchers("/readers/create/**").hasRole("ADMIN")
//                .antMatchers("/readers/delete/**").hasRole("ADMIN")
//                .antMatchers("/readers/**").hasRole("ADMIN")
                .antMatchers("/readers/create/**").hasAuthority("ADMIN")
                .antMatchers("/readers/update/**").hasAuthority("ADMIN")
                .antMatchers("/readers/create/**").hasAuthority("ADMIN")
                .antMatchers("/readers/delete/**").hasAuthority("ADMIN")
                .antMatchers("/readers/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()// !!! don't forget to add 'permitAll' when you're shaping a login or any page
                //.defaultSuccessUrl("/login", true)
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .build();
    }










    //////////////////////////////////////////////////////////точно рабочий!!!!!!!!!!!!!!!!!!!
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                    .withUser("user")
//                    .password("$2y$10$zgH6ocwDstyk6xTUng6rR.0F2jhLcjwDgJ4cD1DkwjgA0EtxDHs6y")
//                    .roles("USER")
//                .and()
//                    .withUser("admin")
//                    .password("$2y$10$2p9KjO3kz61gSfwMbKjw/.inSKKTr7LzCYrFa.J1TH.2e/U0x6uee")
//                    .roles("ADMIN")
//                .and()
//                    .withUser("admin2")
//                    .password("$2y$10$S2528g1S2GQxNIp3Ccq7E..KFpjcj8ypEQOaF1bmPakjHlp1NZwR2")
//                    .roles("ADMIN", "USER");
//
//    }






}
