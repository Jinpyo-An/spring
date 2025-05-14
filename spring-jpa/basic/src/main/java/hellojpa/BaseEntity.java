package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {

    @Column(name = "insert_member")
    private String createdBy;
    private LocalDateTime createdDate;
    @Column(name = "update_member")
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDate;
}
