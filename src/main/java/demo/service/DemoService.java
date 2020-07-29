package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.DemoDaoMapper;
import demo.entity.DemoEntity;
import demo.entity.Pager;

/**
 * 业务处理层
 */
@Service
public class DemoService {
	
	@Autowired
	private DemoDaoMapper demoDao;

	public int addOne(DemoEntity demo) {
		return demoDao.addOne(demo);
	}

	public int addList(List<DemoEntity> demolist) {
		int count = demoDao.addList(demolist);
		return count;
	}

	public int modify(DemoEntity demo) {
		int count = demoDao.modify(demo);
		return count;
	}

	public int remove(int id) {
		int count = demoDao.remove(id);
		return count;
	}

	public int removeIn(List<Integer> ids) {
		int count = demoDao.removeIn(ids);
		return count;
	}

	/**
	 * 事务
	 */
	@Transactional
	public void transaction() {
		//构造数据
		DemoEntity demo = new DemoEntity();
		demo.setName("demo");
		demo.setIntro("demo is a insertOne test!");
		addOne(demo);
		//添加以下一行会抛异常，事务回滚
		Integer.parseInt("sss");
		addOne(demo);
	}

	public DemoEntity queryOne(int id) {
		return demoDao.queryOne(id);
	}

	public List<DemoEntity> queryList(String name) {
		List<DemoEntity> demos = demoDao.queryList(name);
		return demos;
	}

	public Pager<DemoEntity> queryPage(List<String> ids, String name, Pager<DemoEntity> pager) {
		List<DemoEntity> demos = demoDao.queryPage(ids,name,pager);
		int count = demoDao.count(ids,name);
		pager.setTotal(count);
		pager.setEndNo();
		pager.setResult(demos);
		return pager;
	}
}
