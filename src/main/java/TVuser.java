import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVuser {

	public static void main(String[] args) {
		
		//1.스프링 컨테이너를 구동한다.
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");

		TV tv = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		List<String> addressList = bean.getAddressList();
		
		for (String addr : addressList) {
			System.out.println(addr);
		}
		
		
//		tv.powerOn();
//		tv.powerOff();
//		
//		tv.volumeUp();
//		tv.volumeDown();
		
		factory.close();
		
	}

}
