package ch.noseryoung.blj.OnlineBookStore.domain.role;

import ch.noseryoung.blj.OnlineBookStore.domain.authority.Authority;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
@Table(name = "onlineBookStore_roles")
public class Role {
    @Id
    @Column(name="id_role")
    private Integer roleId;
    @Column(name="name")
    private String roleName;

    @ManyToMany
    @JoinTable(
            name = "onlineBookStore_users_roles",
            joinColumns = {
                    @JoinColumn(name = "id_role", referencedColumnName = "id_role"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_auth", referencedColumnName = "id_auth")
            }
    )
    private Set<Authority> roleAuth;
}
