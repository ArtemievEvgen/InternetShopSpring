package springShop.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import springShop.service.AccountService;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "account",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"phone_number"})})
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id"/*insertable = false, updatable = false, nullable = false*/)
    private Integer id;

    @NotEmpty @NotNull
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @Min(value = 3,message = "Password must not be less than 3 characters")
    @NotEmpty @NotNull
    private String password;
    @Transient
    private String passwordConfirm;

    @NotEmpty @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @NotEmpty @NotNull
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @NotEmpty @NotNull
    @Column(name = "address")
    private String address;

    @NotEmpty @NotNull
    @Column(name = "city")
    private String city;

    @NotEmpty @NotNull
    @Column(name = "country")
    private String country;

    @NotEmpty @NotNull
    @Column(name = "zip")
    private String zip;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }




}


