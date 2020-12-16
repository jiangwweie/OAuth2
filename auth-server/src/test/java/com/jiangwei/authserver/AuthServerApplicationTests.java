package com.jiangwei.authserver;


import com.jiangwei.authserver.domain.SysUser;
import com.jiangwei.authserver.service.UserEntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = AuthServerApplication.class)
@RunWith(SpringRunner.class)
public class AuthServerApplicationTests {

	@Autowired
	UserEntityService userEntityService ;

	@Test
	public void contextLoads() {
		SysUser jiangwei = userEntityService.selectByName("jiangwei");
		System.out.println(jiangwei);
	}

}
