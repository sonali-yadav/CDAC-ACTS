package com.app.pojos;

public class Analysis {
	private String political_party;
	private long votes;

	public Analysis() {
		super();
		System.out.println("inside Analysis ctor");
	}

	public Analysis(String political_party, long votes) {
		super();
		this.political_party = political_party;
		this.votes = votes;
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

}
