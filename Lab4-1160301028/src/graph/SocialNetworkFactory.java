package graph;

import java.io.IOException;

public class SocialNetworkFactory extends GraphFactory {
	public  static SocialNetwork creatGraph(String filepath) throws IOException {
		// TODO �Զ����ɵķ������
		SocialNetwork re = (SocialNetwork) GraphFactory.creatGraph(filepath);
		return re;
	}
}
