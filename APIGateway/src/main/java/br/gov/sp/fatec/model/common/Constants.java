package br.gov.sp.fatec.model.common;

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
  
  public static final String PAYMENT_ADDRESS_QUERY = "  { "
														+ " id, "
														+ " userAddressId, "
														+ " street, "
														+ " number, "
														+ " district, "
														+ " complement, "
														+ " city, "
														+ " state, "
														+ " country "
													+ "}";
  
  public static final String PAYMENT_CONTACTS_QUERY = " { "
														+ " id, "
														+ " userContactId, "
														+ " title, "
														+ " type, "
														+ " value "
													+ "}";
  
  public static final String CARDS_QUERY = " { "
											+ " id, "
											+ " nickname, "
											+ " holderName, "
											+ " number, "
											+ " cvv, "
											+ " expirationDate "
										+ "}";
  
  public static final String ORDERS_QUERY = " { "
											+ " id, "
											+ " cartId, "
											+ " userId, "
											+ " description, "
											+ " status "
											+ " price" + Constants.PRICE_QUERY
										+ "}";
  
  public static final String PRICE_QUERY = " { "
											+ " amount, "
											+ " currency "
										+ "}";
  
  public static final String PRICE_DETAIL_QUERY = " { "
												  	+ " id,"
													+ " amount, "
													+ " currency "
												+ "}";
  
  public static final String PRODUCT_QUERY = " id,"
											+ " name, "
											+ " description, "
											+ " quantity, "
											+ " unavailableQuantity ";
 
  public static final String ATTRIBUTE_QUERY = " { "
											  	+ " id,"
												+ " name, "
												+ " value "
											+ "}";
}
