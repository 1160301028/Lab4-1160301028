package vertex;

public class NetworkTopologyState extends State {
	
	public NetworkTopologyState() {
		setState("open");
	}
	
	public void open() {
		if (getState().equals("close"))
			setState("open");
	}
	
	public void close() {
		if (getState().equals("open"))
			setState("close");
	}
}
