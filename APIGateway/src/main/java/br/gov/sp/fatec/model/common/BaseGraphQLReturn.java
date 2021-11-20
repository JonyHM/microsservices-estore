package br.gov.sp.fatec.model.common;

public class BaseGraphQLReturn<T> {
	
	private T data;
	
	public BaseGraphQLReturn() {}

	public BaseGraphQLReturn(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	@SuppressWarnings("unchecked")
	static public <T2> Class<BaseGraphQLReturn<T2>> of(Class<T2> tClass) {
        return (Class<BaseGraphQLReturn<T2>>)(Class<?>)(BaseGraphQLReturn.class);
    }

	@Override
	public String toString() {
		return "BaseGraphQLReturn [data=" + data + "]";
	}
	
}
