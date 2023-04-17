package ch.noseryoung.blj.OnlineBookStore.domain.review;

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
@Table(name = "onlineBookStore_review")
public class Review {
    @Id
    private Integer Id;
    private String AutorIn;
    @Max (value = 5)
    private double stars;
    private Integer bookId;
}
