package com.app.pojos;

public class Candidate {
	private int id;
	private String name;
	private String political_party;
	private long votes;

	
	public Candidate(int id, String name, String political_party, long votes) {
		this.id = id;
		this.name = name;
		this.political_party = political_party;
		this.votes = votes;
	}

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

	public String getPolitical_party() {
		return political_party;
	}

	public void setPolitical_party(String political_party) {
		this.political_party = political_party;
	}

	public long getVotes() {
		return votes;
	}

	public void setVotes(long votes) {
		this.votes = votes;
	}
	
	@Override
	public String toString() {
		return "id->"+id+" name->"+name+" party->"+political_party+" votes->"+votes;
	}
	
}
