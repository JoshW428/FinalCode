package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.management.Query;

import org.hibernate.Session;
import org.junit.Test;

import antlr.collections.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import rocketDomain.RateDomainModel;
import util.HibernateUtil;

public class Rate_Test {

	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		assert(1==1);
	}
	//@Test
	//public void rate_test(){
		//ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		//Session session = HibernateUtil.getSessionFactory().openSession();
		//String hql = "SELECT MINCREDITSCORE FROM TBLRATE";

	//}

}
