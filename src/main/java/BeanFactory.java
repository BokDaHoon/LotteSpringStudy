

public class BeanFactory {
	public Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		} else {
			return new LgTV();
		}
	}
}
