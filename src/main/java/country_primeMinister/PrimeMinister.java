package country_primeMinister;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PrimeMinister {
	@Id
	private int id;
	private String name;
	private String party;

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

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

}
