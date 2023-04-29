package com.pasanabeysekara.securitywithswagger.entity.meta;

import com.pasanabeysekara.securitywithswagger.enums.Gender;
import com.pasanabeysekara.securitywithswagger.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "FirstName", nullable = false, length = 100)
    private String firstname;

    @Column(name = "LastName", nullable = false, length = 100)
    private String lastname;

    @Column(name = "Address", nullable = false, length = 100)
    private String address;

    @Column(name = "mobileNumber", nullable = false, length = 20)
    private String mobileNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "Email", nullable = false, length = 100, unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
