package graph;

import java.io.IOException;

public class MovieGraphFactory extends GraphFactory {
	public  static MovieGraph creatGraph(String filepath) throws IOException {
		// TODO �Զ����ɵķ������
		MovieGraph re = (MovieGraph) GraphFactory.creatGraph(filepath);
		return re;
	}
}
