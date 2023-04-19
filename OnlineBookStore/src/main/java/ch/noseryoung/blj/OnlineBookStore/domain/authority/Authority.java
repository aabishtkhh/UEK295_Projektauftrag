package ch.noseryoung.blj.OnlineBookStore.domain.authority;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "onlineBookStore_authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_auth")
    private Integer authId;
    @Column(name="name")
    private String authName;
}
