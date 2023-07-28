package country_primeMinister;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Country {
	@Id
	private int id;
	private String name;
	private int noOfState;
	@OneToOne
	private PrimeMinister pm;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfState() {
		return noOfState;
	}

	public void setNoOfState(int noOfState) {
		this.noOfState = noOfState;
	}

	public PrimeMinister getPm() {
		return pm;
	}

	public void setPm(PrimeMinister pm) {
		this.pm = pm;
	}

}
