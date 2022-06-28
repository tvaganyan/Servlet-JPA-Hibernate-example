package lottery.model;
import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name="getAllParticipant",
                query="SELECT p FROM Participant p"
        ),
        @NamedQuery(
                name="deleteAllParticipant",
                query="DELETE FROM Participant"
        ),
        @NamedQuery(
                name="ParticipantCount",
                query="SELECT COUNT(p) FROM Participant p"
        )
})

@Entity
@Table(name="PARTICIPANT")
public class Participant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private Long age;
    @Column(name="city")
    private String city;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
