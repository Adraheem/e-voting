package africa.semicolon.evoting.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String office;

    @ManyToOne(fetch = FetchType.EAGER)
    private ElectionEntity election;

    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity user;

}
