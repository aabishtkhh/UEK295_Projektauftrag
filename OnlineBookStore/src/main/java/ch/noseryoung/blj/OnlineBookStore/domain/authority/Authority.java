package ch.noseryoung.blj.OnlineBookStore.domain.authority;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Data
@Table(name = "onlineBookStore_authorities")
public class Authority {
    @Id
    @Column(name="id_auth")
    private Integer authId;
    @Column(name="name")
    private String authName;
}
