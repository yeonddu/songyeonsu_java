package sec01.exam06;

public interface RemoteControl {
	//상수
	int MAX_VOLUME = 10;
	int MIN_VOLUNE = 0;
	
	//추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
}
