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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_role")
    private Integer roleId;
    @Column(name="name")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER) //relationship was lazy(defer initialization of an object as long as it's possible), now its eager -->  data initialization occurs on the spot.
    @JoinTable(
            name = "onlineBookStore_roles_authorities",
            joinColumns = {
                    @JoinColumn(name = "id_role", referencedColumnName = "id_role"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_auth", referencedColumnName = "id_auth")
            }
    )
    private Set<Authority> roleAuth;
}
