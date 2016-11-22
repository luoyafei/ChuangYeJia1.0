import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.chuangyejia.bean.Product;
import com.chuangyejia.dao.IShopCarDao;

@ContextConfiguration("classpath:beans.xml")
public class TestShopCar extends AbstractJUnit4SpringContextTests {

	private static final String userId = "402881fc56416d860156416e52330001";
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate ht;
	
	@Resource(name="iscd")
	private IShopCarDao iscd;
	
	@Test
	public void testSave() {
		boolean ok = iscd.saveUserIdProductId(userId, "402881fc5684957d0156849ef02b0001");
		System.out.println(ok);
	}
	@Test
	public void testGet() {
//		Vector<String> userIds = iscd.getProductIdsInUserId(userId);
		Vector<Product> products = iscd.getProductsInUserId(userId);
		System.out.println(products.get(0));
	}
	
	@Test
	public void testgetProductIdsInUserId() {
		Vector<String> pps = iscd.getProductIdsInUserId(userId);
		System.out.println(Arrays.toString(pps.toArray()));
	}
	
	@Test
	public void userHt() {
		
		@SuppressWarnings("unchecked")
		List<String> strs = ht.executeFind(new HibernateCallback<List<String>>() {
			@Override
			public List<String> doInHibernate(Session session) throws HibernateException, SQLException {

				List<String> productIds = session.createQuery("select productId from UserId_ProductId up where up.userId = :userId").setString("userId", userId).list();

				return productIds;
			}
		});
		System.out.println(Arrays.toString(strs.toArray()));
	}
	
	@Test
	public void testDelete() {
		boolean res = iscd.deleteProductInShopCar(userId, new String[]{"402881fc5684957d0156849ef02b0001"});
		System.out.println(res);
	}
	
}
