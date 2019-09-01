package CNV_Relationnel.cnv.model;

/*import lombok.*;*/


import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @OneToMany
    @JoinColumn(name = "commentId")
    private Collection<LineComment> commentsLines;

    public Long getCommentId() {
        return commentId;
    }

    public Collection<LineComment> getCommentsLines() {
        return commentsLines;
    }

    public void setCommentsLines(Collection<LineComment> commentsLines) {
        this.commentsLines = commentsLines;
    }

    public Comments() {
    }

    public Comments(Collection<LineComment> commentsLines) {
        this.commentsLines = commentsLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(commentId, comments.commentId) &&
                Objects.equals(commentsLines, comments.commentsLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, commentsLines);
    }
}
