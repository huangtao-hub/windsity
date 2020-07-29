package demo.controller;

import demo.entity.RespEntity;
import demo.entity.User;
import demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController api形式，返回json数据
 * 1：adduser 用户注册
 * 2: loginuser  用户登录
 * 3: repass 找回密码
 * 4: updata 更新用户信息
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	/**
	 * 注册账号@RequestParam Long userId
	 * @return
	 */
	@RequestMapping("/ceshi01{id}{usernames}{password}")
	public ResponseEntity<RespEntity> ceshi01(@PathVariable String id, String usernames, String password) {
		System.out.println(usernames);
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
