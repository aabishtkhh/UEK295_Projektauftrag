package ch.noseryoung.blj.OnlineBookStore.domain.users;

import ch.noseryoung.blj.OnlineBookStore.domain.role.Role;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "onlineBookStore_users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="users_Id")
    private Integer usrId;
    @Column(name="name")
    private String usrName;
    @Column(name="password")
    private String ps;
    @ManyToOne
    @JoinTable(
            name = "onlineBookStore_users_roles",
            joinColumns = @JoinColumn (name = "user_Id", referencedColumnName = "users_Id"),
            inverseJoinColumns = @JoinColumn
                    (name = "id_role", referencedColumnName = "id_role")
    )
    private Role usrRoles;

}






