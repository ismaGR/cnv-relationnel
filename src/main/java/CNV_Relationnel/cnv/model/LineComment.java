package CNV_Relationnel.cnv.model;

//import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
public class LineComment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineCommentId;


    @Column(name = "author")
    private String author;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "content")
    private String content;

    public Long getLineCommentId() {
        return lineCommentId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LineComment() {
    }

    public LineComment(String author, Date date, String content) {
        this.author = author;
        this.date = date;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineComment that = (LineComment) o;
        return Objects.equals(lineCommentId, that.lineCommentId) &&
                Objects.equals(author, that.author) &&
                Objects.equals(date, that.date) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineCommentId, author, date, content);
    }
    /*@ManyToOne
    @JoinColumn (name="sampleAnalysisId")
    private SampleAnalysis sampleAnalysis;*/
}

