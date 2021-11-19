package br.gov.sp.fatec.model.storeMicroservice.attribute.data;

public class DeleteAttributeData {

	private String deleteAttribute;
	
	public DeleteAttributeData() {}

	public DeleteAttributeData(String deleteAttribute) {
		this.deleteAttribute = deleteAttribute;
	}

	public String getDeleteAttribute() {
		return deleteAttribute;
	}

	public void setDeleteAttribute(String deleteAttribute) {
		this.deleteAttribute = deleteAttribute;
	}

	@Override
	public String toString() {
		return "DeleteAttributeData [deleteAttribute=" + deleteAttribute + "]";
	}
	
}
