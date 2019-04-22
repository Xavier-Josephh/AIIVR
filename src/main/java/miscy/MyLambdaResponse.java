package miscy;

public class MyLambdaResponse {

    boolean isIsBase64Encoded;;
	String statusCode;
	String headers;
	String responseMessage;
    String transactionID;	
    String body;
    
    public boolean isIsBase64Encoded() {
		return isIsBase64Encoded;
	}

	public void setIsBase64Encoded(boolean isIsBase64Encoded) {
		this.isIsBase64Encoded = isIsBase64Encoded;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}
	
    public String getstatusCode() {
		return statusCode;
	}

	public void setstatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getResponseMessage() {
        return responseMessage;
    }
 
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
 
    public String getTransactionID() {
        return transactionID;
    }
 
    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
 
    @Override
    public String toString() {
        return "MyLambdaResponse [responseMessage=" + responseMessage + ", transactionID=" + transactionID + "]";
    }
}
