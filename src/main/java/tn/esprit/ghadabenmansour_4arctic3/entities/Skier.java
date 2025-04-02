package tn.esprit.ghadabenmansour_4arctic3.entities;

import jakarta.persistence.*;
import jdk.jshell.JShell;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numSkier;

    String firstName;
    String lastName;
    @Column(nullable = false)
    LocalDate dateOfBirth;
    String city;
    //dans le child / maximiser le role de child dans le diagramme
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE} )
    Subscription subscription;
    @OneToMany (mappedBy = "skier")
    Set<Registration> registrations;
    @ManyToMany (mappedBy = "skiers")
    Set<Piste> pistes;
    public int getAge() {
        return dateOfBirth != null ? LocalDate.now().getYear() - dateOfBirth.getYear() : 0;
    }

}

