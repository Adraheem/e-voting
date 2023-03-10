package africa.semicolon.evoting.data.dtos.responses;

import africa.semicolon.evoting.data.models.ElectionEntity;
import africa.semicolon.evoting.data.models.GroupEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ElectionDto {

    private Long id;

    private String name;

    private String description;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private LocalDateTime createdAt;

    private GroupEntity group;

    public ElectionDto(ElectionEntity election) {
        this.id = election.getId();
        this.name = election.getName();
        this.description = election.getDescription();
        this.startAt = election.getStartAt();
        this.endAt = election.getEndAt();
        this.createdAt = election.getCreatedAt();
        this.group = election.getGroup();
    }

    public static ElectionDto map(ElectionEntity election) {
        return new ElectionDto(election);
    }

}
