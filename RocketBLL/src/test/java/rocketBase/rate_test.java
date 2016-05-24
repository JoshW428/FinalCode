package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void rTest(){
		try{
			assertTrue(RateBLL.getRate(700) == 4);
		}catch(RateException e){
			System.err.println("Error: LOAN QUALIFICATION DENIED");
		}
		}
	@Test
	public void eTest() throws Exception {
		ArrayList <RateDomainModel> Y = new ArrayList <RateDomainModel> (RateDAL.getAllRates());
			double Q = RateBLL.getRate(900);
			assertFalse(Y.contains(Q));
	}
	@Test
	public void pTest(){
		double G = RateBLL.getPayment(4, 30, 3000000, 0, false);
		assert(G == 1432.25);
	}
	@Test
	public void test() {
		assert(1==1);
	}

}
