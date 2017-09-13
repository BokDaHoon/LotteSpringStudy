

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("===>Samsung Tv(1) 객체생성");
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	public void initMethod() {
		// TODO Auto-generated method stub
		System.out.println("객체 초기화 작업처리...");
	}
	
	public void destoryMethod() {
		// TODO Auto-generated method stub
		System.out.println("객체 삭제전에 처리할 로직처리.");
	}
	
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV--전원 켠다 (가격:"+price+")");
	}
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV--전원 끈다");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}

}
