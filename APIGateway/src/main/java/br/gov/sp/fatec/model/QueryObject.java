package br.gov.sp.fatec.model;

public class QueryObject {

	private String query;
	
	public QueryObject() {}

	public QueryObject(String query) {
		this.query = query;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public String toString() {
		return "QueryObject [query=" + query + "]";
	}
	
}
