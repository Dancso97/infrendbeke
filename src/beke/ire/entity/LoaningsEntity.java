package beke.ire.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "loanings", schema = "beke_library")
public class LoaningsEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id")
    private UsersEntity who_borrowed;

    @OneToOne
    @JoinColumn(name = "id")
    private LoaningsEntity what_borrowed;

    @Basic
    @Column(name = "when_borrowed")
    private Timestamp when_borrowed;


    @Column(name = "when_got_back")
    private Timestamp when_got_back;

    public LoaningsEntity(){

    }

    public LoaningsEntity(UsersEntity who_borrowed, LoaningsEntity what_borrowed, Timestamp when_borrowed, Timestamp when_got_back) {
        this.who_borrowed = who_borrowed;
        this.what_borrowed = what_borrowed;
        this.when_borrowed = when_borrowed;
        this.when_got_back = when_got_back;
    }

    public int getId() {
        return id;
    }


    public UsersEntity getWho_borrowed() {
        return who_borrowed;
    }

    public void setWho_borrowed(UsersEntity who_borrowed) {
        this.who_borrowed = who_borrowed;
    }

    public LoaningsEntity getWhat_borrowed() {
        return what_borrowed;
    }

    public void setWhat_borrowed(LoaningsEntity what_borrowed) {
        this.what_borrowed = what_borrowed;
    }

    public Timestamp getWhen_borrowed() {
        return when_borrowed;
    }

    public void setWhen_borrowed(Timestamp when_borrowed) {
        this.when_borrowed = when_borrowed;
    }

    public Timestamp getWhen_got_back() {
        return when_got_back;
    }

    public void setWhen_got_back(Timestamp when_got_back) {
        this.when_got_back = when_got_back;
    }

    @Override
    public String toString() {
        return "Loanings{" +
                "id=" + id +
                ", who_borrowed=" + who_borrowed +
                ", what_borrowed=" + what_borrowed +
                ", when_borrowed=" + when_borrowed +
                ", when_got_back=" + when_got_back +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoaningsEntity loanings = (LoaningsEntity) o;
        return id == loanings.id &&
                who_borrowed.equals(loanings.who_borrowed) &&
                what_borrowed.equals(loanings.what_borrowed) &&
                when_borrowed.equals(loanings.when_borrowed) &&
                when_got_back.equals(loanings.when_got_back);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, who_borrowed, what_borrowed, when_borrowed, when_got_back);
    }
}
