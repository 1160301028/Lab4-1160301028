package graph;

import java.io.IOException;

public class NetworkTopoloygFactory extends GraphFactory {
	public  static NetworkTopoloyg creatGraph(String filepath) throws IOException {
		// TODO �Զ����ɵķ������
		NetworkTopoloyg re = (NetworkTopoloyg) GraphFactory.creatGraph(filepath);
		return re;
	}
}
