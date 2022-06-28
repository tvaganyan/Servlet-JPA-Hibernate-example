package lottery.model;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name="getAllWinners",
                query="SELECT p FROM Winners p"
        )
})

@Entity
@Table(name="WINNERS")
public class Winners {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        @Column(name="name")
        private String name;
        @Column(name="age")
        private Long age;
        @Column(name="city")
        private String city;
        @Column(name="win_sum")
        private Long win_sum;

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

        public Long getWin_sum() {
                return win_sum;
        }

        public void setWin_sum(Long win_sum) {
                this.win_sum = win_sum;
        }
}
