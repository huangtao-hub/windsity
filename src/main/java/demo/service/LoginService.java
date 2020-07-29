package demo.service;

import demo.dao.LoginDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务处理层
 */
@Service
public class LoginService {
	
	@Autowired
	private LoginDaoMapper demoDao;

    public int adduser(String username, String passwork) {
		int count = demoDao.adduser(username, passwork );
		return count;
    }

	public String loginuser(String username) {
		return demoDao.loginuser(username);
	}
}
