
public class AppleSpeaker implements Speaker{
	public AppleSpeaker() {
		System.out.println("---> AppleSpeaker 객체생성");
	}
	
	
	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker -- 소리울린다");
	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker -- 소리줄인다");
	}

}
