package com.example.entity;

import com.example.entity.enums.ERole;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, updatable = false)
    private String username;
    @Column(nullable = false)
    private String lastname;
    @Column(unique = true)
    private String email;
    @Column(columnDefinition = "text")
    private String bio;
    @Column(length = 3000)
    private String password;

//    @Transient
//    private Set<? extends GrantedAuthority> grantedAuthorities;

    private String roles; //ROLE_USER, ROLE_ADMIN
    private String[] authorities;
    private Boolean isNotLocked;
    private Boolean enabled = false;


//    @ElementCollection(targetClass = ERole.class)//зависимость ролей
//    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
//    private Collection<ERole> role = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "user", orphanRemoval = true)
    private List<PostEntity> posts = new ArrayList<>();

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime createDate;

    public UserEntity(Long id,
                      String username,
                      String email,
                      String password
    ) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return  stream(authorities).map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }




    @PrePersist // создается до создания этого обьекта
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isNotLocked;
    }

    public boolean isNotLocked() {
        return isNotLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


}
