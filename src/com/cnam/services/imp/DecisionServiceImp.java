package com.cnam.services.imp;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.cnam.dao.DecisionDao;
import com.cnam.entity.Decision;
import com.cnam.services.DecisionService;

public class DecisionServiceImp implements DecisionService {
	
private DecisionDao  decisionDao  ; 
	
	@Override
	public boolean saveDecision (Decision D) throws Exception {

		Criterion cr = Restrictions.eq("codDecision", D.getCodDecision());
		boolean var = false;
		int codDec = findPersByCritertia(cr).size();
		

		if (codDec== 0) {
			decisionDao.save(D);
			var = true;
		
		}
		return var ; 
	}

	@Override
	public void updateDecision(Decision D) throws Exception {
					decisionDao.save(D);
			}

	@Override
	public void deleteDecision(Decision D) throws Exception {
		decisionDao.delete(D);
	}

	@Override
	public List<Decision> findAllPers() throws Exception {

		return decisionDao.findAll(Decision.class);
	}

	@Override
	public List<Decision> findPersByCritertia(Criterion cr) throws Exception {

		return decisionDao.findByCritertia(Decision.class, cr);
	}

	@Override
	public List<Decision> findPersByCritertia(Criterion cr, Criterion cr2) throws Exception {
		return decisionDao.findByCritertia(Decision.class, cr, cr2);
	}

	public DecisionDao getDecisionDao() {
		return decisionDao;
	}

	public void setDecisionDao(DecisionDao decisionDao) {
		this.decisionDao = decisionDao;
	}




}
