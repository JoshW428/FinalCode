package exceptions;
import rocketDomain.RateDomainModel;
public class RateException extends Exception {
	private RateDomainModel Q;
	public RateException(RateDomainModel Q) {
		System.out.println("ERROR: Do not qualify for a Loan");
	}
	public RateDomainModel getQ(){
		return Q;
	}
	//	 - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
