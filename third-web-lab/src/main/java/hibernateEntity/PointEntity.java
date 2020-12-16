package hibernateEntity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "hitpoint")
public class PointEntity implements Serializable {
    private static final long serialVersionUID = 723253625362L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "coordinate_x")
    private double x;

    @Column(name = "coordinate_y")
    private double y;

    @Column(name = "parameter_r")
    private int r;

    @Column(name = "hit")
    private boolean hit;

}

