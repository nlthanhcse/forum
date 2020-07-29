package ojt.thanhnl4.forumapigateway.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPost {
    @EmbeddedId
    private UserPostId id;
    private String type;
}
