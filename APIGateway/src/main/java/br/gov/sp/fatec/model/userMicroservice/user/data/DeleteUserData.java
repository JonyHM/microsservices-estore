package br.gov.sp.fatec.model.userMicroservice.user.data;

public class DeleteUserData {

	private String deleteUser;
	
	public DeleteUserData() {}

	public DeleteUserData(String deleteUser) {
		this.deleteUser = deleteUser;
	}

	public String getDeleteUser() {
		return deleteUser;
	}

	public void setDeleteUser(String deleteUser) {
		this.deleteUser = deleteUser;
	}

	@Override
	public String toString() {
		return "DeleteUserData [deleteUser=" + deleteUser + "]";
	}
	
}
