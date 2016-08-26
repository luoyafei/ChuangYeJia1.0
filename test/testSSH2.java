import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.chuangyejia.bean.User;
import com.chuangyejia.service.IUserService;

@ContextConfiguration("classpath:beans.xml")
public class testSSH2 extends AbstractJUnit4SpringContextTests {
	
	@Resource(name="us")
	private IUserService ius;
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate ht;
	@Test
	public void testSSH() {
		User user = new User();
		user.setUserNickName("测试胜多负少地方就是的");
		user.setUserPassword("cksejrksejkf");
		ht.save(user);
	}

	
}
