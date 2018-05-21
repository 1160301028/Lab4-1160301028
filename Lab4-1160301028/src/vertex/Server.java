package vertex;

public class Server extends Vertex {
	
	private NetworkTopologyState state = new NetworkTopologyState();
	private String ip;
	
	public Server(String str,String[] args,String type) {
		super(str,type);
		this.fillVertexInfo(args);
		checkRep();
		// TODO 自动生成的构造函数存根
	}
	
	
	private void checkRep() {
		assert Isipv4(ip);
		assert (state.getState().equals("open") || state.getState().equals("close"));
	}
	
	@Override
	void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		if(Isipv4(args[0])) {
			this.ip = args[0];
		}
		checkRep();
	}

	public String getIp(){
		return this.ip;
	}
	
	public static boolean Isipv4(String ipv4) {
		if (ipv4 == null || ipv4.length() == 0) {
			return false;
		}
		String[] parts = ipv4.split("\\.");
		if (parts.length != 4) {
			return false;
		}
		for (int i = 0; i < parts.length; i++) {
			try {
				int n = Integer.parseInt(parts[i]);
				if (n < 0 || n > 255) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}
}
