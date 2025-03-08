package tn.esprit.ghadabenmansour_4arctic3.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long numCourse;

    int level;
    @Enumerated(EnumType.STRING)
    TypeCourse typeCourse;

    @Enumerated(EnumType.STRING)
    Support support;

    Float price;
    int timeSlot;
    @OneToMany(mappedBy = "course")
    Set<Registration> registrations;
}

