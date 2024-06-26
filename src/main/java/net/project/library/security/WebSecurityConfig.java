package net.project.library.security;

import net.project.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Конфигурационный класс безопасности.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    private final ReaderRepository readerRepository;

    @Autowired
    public WebSecurityConfig(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    /**
     * Компонент, используемый для загрузки пользовательских данных.
     *
     * @return - извлечённые данные пользователя
     */
    @Bean
    protected UserDetailsService userDetailsService() {
        return new CustomUserDetailsService(readerRepository);
    }

    /**
     * Метод Аутентификации, позволяющий идентифицировать пользователей сайта.
     *
     * @return - возвращает список аутентифицированных пользователей
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    /**
     * Фильтры безопасности для установления прав пользователя и безопасности.
     *
     * @param http - Объект безопасности http запросов
     * @return - фильтры для авторизации пользователя
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/registration", "/login").permitAll()
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
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .build();
    }
}
