package bsl.co.ke.kephis.Pojo;
// Generated Dec 15, 2015 12:42:43 PM by Hibernate Tools 4.3.1


import org.idempiere.webservice.client.base.LoginRequest;

/**
 * SubCounty generated by hbm2java
 */

public class SubCounty  implements java.io.Serializable {


     private String subCountyId;
     private String countyId;
     private String subCountyName;
     private String subCountyDesc;
	 private String serviceType="QuerySubCounty";


	 private LoginRequest loginRequest;

	public LoginRequest getLoginRequest() {
		return loginRequest;
	}

	public void setLoginRequest(LoginRequest loginRequest) {
		this.loginRequest = loginRequest;
	}

	public String getSubCountyId() {
		return subCountyId;
	}

	public void setSubCountyId(String subCountyId) {
		this.subCountyId = subCountyId;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getSubCountyName() {
		return subCountyName;
	}

	public void setSubCountyName(String subCountyName) {
		this.subCountyName = subCountyName;
	}

	public String getSubCountyDesc() {
		return subCountyDesc;
	}

	public void setSubCountyDesc(String subCountyDesc) {
		this.subCountyDesc = subCountyDesc;
	}


	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String toString()
	{
		return( subCountyName  );
	}



}


