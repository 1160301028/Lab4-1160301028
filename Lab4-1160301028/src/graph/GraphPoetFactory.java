package graph;

import java.io.IOException;

public class GraphPoetFactory extends GraphFactory {
	public  static GraphPoet creatGraph(String filepath) throws IOException {
		// TODO �Զ����ɵķ������
		GraphPoet re = (GraphPoet) GraphFactory.creatGraph(filepath);
		return re;
	}
}
