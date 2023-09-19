package ao.com.school.avaluation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ManyToAny;

import java.io.Serializable;
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
@Entity
@SuperBuilder

public class Staff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
