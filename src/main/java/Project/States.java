package Project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private int State_id;
    @Column(name = "state_name")
    private String State_name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    public States() {
    	super();
    }

    public int getState_id() {
		return State_id;
	}

	public void setState_id(int state_id) {
		State_id = state_id;
	}

	public String getState_name() {
		return State_name;
	}

	public void setState_name(String state_name) {
		State_name = state_name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	

   
}
