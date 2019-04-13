package com.cnam.utils;

import java.util.HashSet;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cnam.dao.AssureDao;
import com.cnam.entity.Filiere;
import com.cnam.dao.imp.AssureDaoImp;
import com.cnam.entity.Assuresociale;
import com.cnam.entity.Beneficiaire;
import com.cnam.entity.Plafons;
import com.cnam.services.AssureService;

public class Test {

	public static void main(String[] args) {
	/*	Filiere filiere = new Filiere ();

		ApplicationContext ctx = new ClassPathXmlApplicationContext("/com/cnam/utils/applicationContext.xml");
		
	Assuresociale assure = new Assuresociale(21,filiere, 2,"CNSS",new HashSet<Beneficiaire>(0), new HashSet<Plafons>(0));
		
		AssureService assureServ = (AssureService) ctx.getBean("assureServ");

		PersonneDao persDao = new PersonneDaoImp();
		try {
			assureServ.saveAssure(assure);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		AssureDao persDao = new AssureDaoImp();
	List<Assuresociale> listpers;
	try {
		listpers = persDao.findAll(Assuresociale.class);
		for (Assuresociale p : listpers) {
			System.out.println(p.getMatriculeAssure() + " " + p.getCaisseOriginale() );}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	//	Criterion cr = Restrictions.eq("age", 25);
	//	List<Assuresociale> listpers ;
	//	try {
	//		listpers = persDao.findByCritertia(Personne.class,cr );
	//	} catch (Exception e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	} // on a ajouter à la methode findbyCriteria cr2
	//	for (Personne p : listpers) {
	//		System.out.println(p.getNom() + " " + p.getAdresse() + "  " + p.getAge());

	//	}
//	}

}}
