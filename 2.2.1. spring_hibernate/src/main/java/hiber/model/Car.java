package hiber.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int series;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Car(String model, int series, User user) {
        this.model = model;
        this.series = series;
        this.user = user;
    }
}
