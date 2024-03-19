package net.project.library.config;

//import net.project.library.repository.UserRepository;
//import net.project.library.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/registration", "/login").permitAll()
                .antMatchers("/readers/create/**").hasRole("ADMIN")
                .antMatchers("/readers/update/**").hasRole("ADMIN")
                .antMatchers("/readers/create/**").hasRole("ADMIN")
                .antMatchers("/readers/delete/**").hasRole("ADMIN")
                .antMatchers("/readers/**").hasRole("ADMIN")
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
                .exceptionHandling().accessDeniedPage("/403");
    }


//        http
//                .csrf().disable()
//                .authorizeRequests()
//                    .antMatchers("/").permitAll()
//                    .antMatchers("/reader/create/**").hasRole("ADMIN")
//                    .antMatchers("/reader/update/**").hasRole("ADMIN")
//                    .antMatchers("/reader/create/**").hasRole("ADMIN")
//                    .antMatchers("/reader/delete/**").hasRole("ADMIN")
//                    .antMatchers("/reader/**").access("hasRole('ADMIN') or hasRole('USER')")
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                .and()
//                    .httpBasic()
//                .and()мсаааувцы
//                    .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/auth/logout")
//                    .invalidateHttpSession(true)
//                    .permitAll();
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                    .antMatchers("/reader/create/**").hasRole("ADMIN")
//                    .antMatchers("/reader/update/**").hasRole("ADMIN")
//                    .antMatchers("/reader/create/**").hasRole("ADMIN")
//                    .antMatchers("/reader/delete/**").hasRole("ADMIN")
//                    .antMatchers("/reader/**").access("hasRole('ADMIN') or hasRole('USER')")
//                    .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                    .loginPage("/login")
//                    .permitAll()
//                .and()
//                    .logout()
//                    .permitAll();
//    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService());
//        provider.setPasswordEncoder(passwordEncoder.passwordEncoder());
//        return provider;
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //super.configure(auth);
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select name, email, telegram, password from readers where name=?")
//                .authoritiesByUsernameQuery
//                        ("select u.name, ur.roles from readers u inner join user_role ur on u.id = ur.user_id where u.name=&");
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                    .withUser("user")
                    .password("$2y$10$zgH6ocwDstyk6xTUng6rR.0F2jhLcjwDgJ4cD1DkwjgA0EtxDHs6y")
                    .roles("USER")
                .and()
                    .withUser("admin")
                    .password("$2y$10$2p9KjO3kz61gSfwMbKjw/.inSKKTr7LzCYrFa.J1TH.2e/U0x6uee")
                    .roles("ADMIN")
                .and()
                    .withUser("admin2")
                    .password("$2y$10$S2528g1S2GQxNIp3Ccq7E..KFpjcj8ypEQOaF1bmPakjHlp1NZwR2")
                    .roles("ADMIN", "USER");

    }

//        @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("user")
//                        .roles("USER")
//                        .build();
//
//        UserDetails nikita = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin2")
//                .password("admin2")
//                .roles("ADMIN","USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, nikita, admin);
//    }

}
