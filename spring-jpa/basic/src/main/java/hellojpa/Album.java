package hellojpa;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Album extends Item{

    private String artist;
}
