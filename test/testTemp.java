import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class testTemp {

	@SuppressWarnings("resource")
	@Test
	public static void main(String[] args) {

		HibernateTemplate hibernateTemplate = new ClassPathXmlApplicationContext("beans.xml").getBean("hibernateTemplate", HibernateTemplate.class);
		/*ChatMessage cm = new ChatMessage();
		cm.setFromUserId("402881fc56416d860156416e52330001");
		cm.setToChatRoomId("402881fc56416d860156416e52330001");
		cm.setChatMessage("testTemp");
		cm.setToChatRoomId("0");
		cm.setMessageSendTime(new Timestamp(System.currentTimeMillis()));
		hibernateTemplate.save(cm);*/
		//final String ebjqlForCM = "select distinct cm.fromUserId from ChatMessage cm where cm.toUserId = '402881fc56416d860156416e52330001' and cm.needRead = 1";
		String ebj = "select count(*) from ChatMessage cm where cm.fromUserId = '402881fc56416d860156416e52330001' and cm.toUserId = '402881fc56415b8001564162f8330001' and cm.needRead = 1";
		//System.out.println(hibernateTemplate.find(ebjqlForCM).size());
		System.out.println(hibernateTemplate.find(ebj));
		
	}
}
