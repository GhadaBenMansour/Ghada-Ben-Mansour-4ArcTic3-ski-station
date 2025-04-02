package tn.esprit.ghadabenmansour_4arctic3.entities;

import jakarta.persistence.*;
import jdk.jshell.JShell;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numSub;

    @Column(nullable = false)
    LocalDate startDate;

    //@Column(nullable = false) : n'accepte pas une valeure nulle
    LocalDate endDate;

    Float price;

    @Enumerated(EnumType.STRING)
    TypeSubscription typeSub;
    //parent parceque il n y'a pas mapped by
    //le foreign key je le trouve toujours dans le parent
    @OneToOne
    Skier skier;
}

