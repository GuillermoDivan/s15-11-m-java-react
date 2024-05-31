
package com.s1511.ticketcine.domain.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Lazy;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String screening; //TIPO DE SALA: 2d,3d,etc

    @OneToMany(fetch = FetchType.LAZY)
    private List<FunctionDetails> functionDetails;

    @ManyToOne
    @JoinColumn(name = "cinemaId", referencedColumnName = "id")
    private Cinema cinema;

    private Boolean active;

}
