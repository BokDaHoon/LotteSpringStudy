
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		// TODO Auto-generated constructor stub
		System.out.println("===> SonySpeaker -- 객체생성");
	}
	
	/* (non-Javadoc)
	 * @see Speaker#volumeUp()
	 */
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker -- 소리올린다");
	}
	
	/* (non-Javadoc)
	 * @see Speaker#volumeDown()
	 */
	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker -- 소리 내린다.");
	}
}
