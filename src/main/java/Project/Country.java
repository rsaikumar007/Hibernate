package Project;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Countries")
public class Country {
    @Id
    @Column(name = "country_Code")
    private int Code;
    @Column(name = "country_name")
    private String Countryname;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<States> states=new ArrayList<States>();

    public Country() {
    	super();
    }
    public int getCode() {
		return Code;
	}

	public void setCode(int code) {
		Code = code;
	}

	public String getCountryname() {
		return Countryname;
	}

	public void setCountryname(String countryname) {
		Countryname = countryname;
	}

	public List<States> getStates() {
		return states;
	}

	public void setStates(List<States> states) {
		this.states = states;
	}

   
}
