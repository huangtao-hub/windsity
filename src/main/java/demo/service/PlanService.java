package demo.service;

import demo.dao.LoginDaoMapper;
import demo.dao.PlanDaoMapper;
import demo.entity.PlanDayEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务处理层
 */
@Service
public class PlanService {
	
	@Autowired
	private PlanDaoMapper demoDao;

    public int planaddDay(PlanDayEntity planday) {
		int count = demoDao.planaddDay(planday);
		return count;
    }

	public String loginuser(String username) {
		return demoDao.loginuser(username);
	}
}
