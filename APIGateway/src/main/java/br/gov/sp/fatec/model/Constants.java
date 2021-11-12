package br.gov.sp.fatec.model;

public final class Constants {
  public static final String USER_QUERY = " id, "
										+ " name, "
										+ " email, "
										+ " cpf ";
  
  public static final String ADDRESS_QUERY = "  { "
												+ " id, "
												+ " street, "
												+ " number, "
												+ " district, "
												+ " complement, "
												+ " city, "
												+ " state, "
												+ " country "
											+ "}";
  
  public static final String CONTACTS_QUERY = " { "
												+ " id, "
												+ " title, "
												+ " type, "
												+ " value "
											+ "}";
  
  public static final String CUSTOMER_QUERY = " id, "
											+ " userId, "
											+ " name, "
											+ " cpf "; 
	  
}
