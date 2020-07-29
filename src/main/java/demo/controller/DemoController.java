package demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.DemoEntity;
import demo.entity.Pager;
import demo.service.DemoService;

/**
 * @RestController api形式，返回json数据
 * 1：addOne 单条增加
 * 2: addList 多条增加
 * 3: remove 删除操作
 * 4: removeIn 删除的in操作
 * 5: modify 修改操作
 * 6: queryOne 查找单条，不存在返回null
 * 7: queryList 多条查询，不存在返回[]空数组
 * 8: queryPage 分页查询
 * 9：transaction 事务测试
 *  * 9：transaction 事务测试
 *  10: addtodaycost
 *  11: addtodaycost
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	private DemoService demoService;

	/**
	 * 单条插入
	 * @return
	 */
	@RequestMapping("/addOne")
	public int addOne(){
		//构造数据
		DemoEntity demo = new DemoEntity();
		demo.setName("demo");
		demo.setIntro("demo is a insertOne test!");
		//执行业务
		int count = demoService.addOne(demo);
		return count;
	}
	
	/**
	 * 多条插入
	 * @return
	 */
	@RequestMapping("/addList")
	public int addList(){
		//构造数据 length=3的list
		List<DemoEntity> demolist = new ArrayList<DemoEntity>();
		DemoEntity demo1 = new DemoEntity();
		demo1.setName("demo");
		demo1.setIntro("demo is a insertList test!");
		demolist.add(demo1);
		DemoEntity demo2 = new DemoEntity();
		demo2.setName("demo");
		demo2.setIntro("demo is a insertList test!");
		demolist.add(demo2);
		DemoEntity demo3 = new DemoEntity();
		demo3.setName("demo");
		demo3.setIntro("demo is a insertList test!");
		demolist.add(demo3);
		//执行业务
		int count = demoService.addList(demolist);
		return count;
	}
	
	/**
	 * 更新数据 
	 * @return
	 */
	@RequestMapping("/modify")
	public int modify(){
		//构造数据
		DemoEntity demo = new DemoEntity();
		demo.setId(45);
		demo.setName("demoUpdate");
		demo.setIntro("demo is a updateDemo test!");
		//执行业务
		int count = demoService.modify(demo);
		return count;
	}
	
	/**
	 * 删除数据
	 * @return
	 */
	@RequestMapping("/remove")
	public int remove(){
		//构造数据
		int id = 58;
		//执行业务
		int count = demoService.remove(id);
		return count;
	}
	
	/**
	 * 批量删除(in操作)
	 * @return
	 */
	@RequestMapping("/removeIn")
	public int removeIn(){
		//构造数据
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(2);
		ids.add(45);
		ids.add(47);
		ids.add(57);
		ids.add(59);
		ids.add(60);
		//执行业务
		int count = demoService.removeIn(ids);
		return count;
	}
	
	/**
	 * 单条查询
	 * @return
	 */
	@RequestMapping("/queryOne")
	public DemoEntity queryOne(){
		//构造数据
		int id = 5;
		//执行业务(不存在null)
		DemoEntity demo = demoService.queryOne(id);
		return demo;
	}
	
	/**
	 * 多条查询
	 * @return
	 */
	@RequestMapping("/queryList")
	public List<DemoEntity> queryList(){
		//构造数据
		String name = "demo";
		//执行业务
		List<DemoEntity> demos = demoService.queryList(name);
		return demos;
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	@RequestMapping("/queryPage")
	public Pager<DemoEntity> queryPage(){
		//构造数据
		//页码
		int page = 2;
		//每页条数
		int size = 2;
		Pager<DemoEntity> pager = new Pager<DemoEntity>(page, size);
		String name = "demo";
		List<String> ids = new ArrayList<>();
		ids.add("5");
		ids.add("7");
		ids.add("54");
		ids.add("9");
		//执行业务
		Pager<DemoEntity> result = demoService.queryPage(ids, name,pager);
		return result;
	}
	
	/**
	 * 事务测试
	 * @return
	 */
	@RequestMapping("/transaction")
	public void transaction(){
		demoService.transaction();
	}




}
