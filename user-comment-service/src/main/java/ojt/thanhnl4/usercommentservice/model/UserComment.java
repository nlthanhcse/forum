package ojt.thanhnl4.usercommentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {
    @EmbeddedId
    private UserCommentId id;
    private String type;
}
