package demo.controller;

import demo.entity.PlanDayEntity;
import demo.entity.RespEntity;
import demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController 计划接口控制器
 * 日
 * 1：planaddDay 添加一条日计划
 * 2: planDayList  查询日计划列表
 * 3:
 *  * 周
 *  * 1：planadd 添加一条日计划
 *  * 2: planlist  查询计划列表
 *  * 3:
 *   * 月
 *  * 1：planadd 添加一条日计划
 *  * 2: planlist  查询计划列表
 *  * 3:
 *   * 季
 *  * 1：planadd 添加一条日计划
 *  * 2: planlist  查询计划列表
 *  * 3:
 *  * 年
 *  * 1：planadd 添加一条日计划
 *  * 2: planlist  查询计划列表
 *  * 3:
 * 4: updata 更新用户信息
 */
@RestController
@RequestMapping("/plan")
public class PlanController {

	@Autowired
	private LoginService loginService;
	/**
	 * 注册账号@RequestParam Long userId
	 * @return
	 */
	@RequestMapping("/c")
	public ResponseEntity<RespEntity> planaddDay(@RequestBody PlanDayEntity planday) {
		System.out.println(planday);
		System.out.println(planday.getTimes());
		System.out.println(planday.getAffiliation());
		System.out.println(planday.getData1());
		System.out.println(planday.toString());
		int count = 1;
		if (count == 1) {
			return ResponseEntity.status(200).body(RespEntity.code(200).message("注册成功").build());
		} else {
			return ResponseEntity.status(400).body(RespEntity.code(400).message("注册失败").body("567").build());
		}
	}
	/**
	 * 登录账号
	 * @return
	 */
	@RequestMapping("/loginuser{test}{username}{password}")
	public ResponseEntity<RespEntity> loginuser(@PathVariable String test, String username, String password) {
		String res = loginService.loginuser(username);
		System.out.println(res);
		if (password.equals(res)) {
			return ResponseEntity.status(200).body(RespEntity.code(200).message("登录成功").build());
		} else {
			return ResponseEntity.status(400).body(RespEntity.code(400).message("密码错误").body("567").build());
		}

	}

	/**
	 * 注册账号
	 * @return
	 */
	@RequestMapping("/adduser{test}{username}{passwork}")

	public ResponseEntity<RespEntity> adduser(@PathVariable String test, String username, String passwork) {
		int count = loginService.adduser(username, passwork);
		if (count == 1) {
			return ResponseEntity.status(200).body(RespEntity.code(200).message("注册成功").build());
		} else {
			return ResponseEntity.status(400).body(RespEntity.code(400).message("注册失败").body("567").build());
		}

	}
}
