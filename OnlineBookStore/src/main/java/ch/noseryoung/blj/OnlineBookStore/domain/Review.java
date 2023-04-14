package ch.noseryoung.blj.OnlineBookStore.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//or @Data
@Table(name = "review_onlineBookStore")
public class Review {
    @Id
    private Integer Id;
    private String AutorIn;
    @Max ( = 5)
    @Column(name="Anzahl Sterne (Max: 5 Sterne)")
    private double stars;
    @Column(name="Book ID") //Foreign Key
    private int bookId;
}
