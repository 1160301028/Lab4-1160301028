package vertex;

public class SocialNetworkState extends State {
	
	public SocialNetworkState() {
		setState("active");
	}
	
	public void lock() {
		if (!getState().equals("locked"))
			setState("locked");
	}
	
	public void unlock() {
		if (getState().equals("locked"))
			setState("active");
	}
	
	public void deactive() {
		if (getState().equals("active"))
			setState("deactive");
	}
	
	public void active() {
		if (getState().equals("deactive"))
			setState("active");
	}
	
}
