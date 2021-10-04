package br.gov.sp.fatec.kafka.model;

public class Topic {
	public static final String userCreated = "USER_CREATED";
	public static final String userDeleted = "USER_DELETED";
	public static final String userUpdated = "USER_UPDATED";
	
	public static final String addressCreated = "ADDRESS_CREATED";
	public static final String addressDeleted = "ADDRESS_DELETED";
	public static final String addressUpdated = "ADDRESS_UPDATED";
	
	public static final String contactCreated = "CONTACT_CREATED";
	public static final String contactDeleted = "CONTACT_DELETED";
	public static final String contactUpdated = "CONTACT_UPDATED";
	
	
	public static final String orderPaid = "ORDER_PAID";
	public static final String orderStarted = "ORDER_STARTED";
	public static final String orderCanceled = "ORDER_CANCELED";
}
