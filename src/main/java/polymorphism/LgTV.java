package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	
	@Autowired
	@Qualifier("apple")
	private Speaker speaker;
	
	public LgTV() {
		// TODO Auto-generated constructor stub
		System.out.println(">>LGTV 객체생성");
	}
	public void powerOn () {
		// TODO Auto-generated method stub
		System.out.println("LGTV--전원 켠다");
	}
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LGTV--전원 끈다");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
	
}
