import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.chuangyejia.bean.ChatMessage;

public class testTemp {

	@SuppressWarnings("resource")
	@Test
	public static void main(String[] args) {

		HibernateTemplate hibernateTemplate = new ClassPathXmlApplicationContext("beans.xml").getBean("hibernateTemplate", HibernateTemplate.class);
		ChatMessage cm = new ChatMessage();
		cm.setFromUserId("402881fc56416d860156416e52330001");
		cm.setToChatRoomId("402881fc56416d860156416e52330001");
		cm.setChatMessage("testTemp");
		cm.setToChatRoomId("0");
		cm.setMessageSendTime(new Timestamp(System.currentTimeMillis()));
		hibernateTemplate.save(cm);
		
	}
}
