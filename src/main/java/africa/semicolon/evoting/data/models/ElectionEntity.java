package africa.semicolon.evoting.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "elections")
public class ElectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private final LocalDateTime createdAt = LocalDateTime.now();


    @ManyToOne
    private GroupEntity group;
}
