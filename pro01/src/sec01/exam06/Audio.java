package sec01.exam06;

public class Audio implements RemoteControl {
	
	//필드
	private int volume;
	
	//turnOn() 추상 메소드의 실제 메소드
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
	
	//turnOff() 추상 메소드의 실제 메소드
	public void turnOff() {
		System.out.println("AudioTV를 끕니다.");
	}
	
	//setVolume() 추상 메소드의 실제 메소드
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUNE) {
			this.volume = RemoteControl.MIN_VOLUNE;			
		} else {
			this.volume = volume;
		}
		
		System.out.println("현재 Audio 볼륨: " + this.volume);
	}
}
