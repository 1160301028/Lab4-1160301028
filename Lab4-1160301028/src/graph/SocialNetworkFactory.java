package graph;

import java.io.IOException;

public class SocialNetworkFactory extends GraphFactory {
	public  static SocialNetwork creatGraph(String filepath) throws IOException {
		// TODO 自动生成的方法存根
		SocialNetwork re = (SocialNetwork) GraphFactory.creatGraph(filepath);
		return re;
	}
}
