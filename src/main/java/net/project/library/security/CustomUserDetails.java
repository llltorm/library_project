package net.project.library.security;

import net.project.library.model.Reader;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

/**
 * Класс реализации загрузки пользователя.
 */
public class CustomUserDetails implements UserDetails {

    private Reader reader;

    public CustomUserDetails(Reader reader) {
        super();
        this.reader = reader;
    }

    /**
     * Метод добавления ролей в систему.
     *
     * @return - возвращает все роли, которые были найдены в БД
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(reader.getRole()));
    }

    /**
     * Метод возвращения пароля пользователя.
     */
    @Override
    public String getPassword() {
        return reader.getPassword();
    }

    /**
     * Метод возвращения имени пользователя.
     */
    @Override
    public String getUsername() {
        return reader.getName();
    }

    /**
     * Метод проверяет не истёк ли срок действия учетной записи.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Метод проверяет не заблокирован ли пользователей.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Метод проверяет не истёк ли срок действия учетных данных.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Метод проверяет находится ли пользователь в системе.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
