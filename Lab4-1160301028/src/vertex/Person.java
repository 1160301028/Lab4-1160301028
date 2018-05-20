package vertex;

public class Person extends Vertex {
	
	private SocialNetworkState state = new SocialNetworkState();
	private int age;
	private String sexual;
	
	public Person(String str,String[] args,String type) {
		super(str,type);
		this.fillVertexInfo(args);
		checkRep();
		// TODO 自动生成的构造函数存根
	}
	
	@Override
	void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 2) {
			if (args[0].matches("[0-9]+")) {
				age = Integer.valueOf(args[0]);
			}
			sexual = args[1];
		}
		checkRep();
	}
	
	private void checkRep() {
		assert age >= 0;
		assert (sexual.equals("M") || sexual.equals("F"));
		assert (state.getState().equals("deactive") || state.getState().equals("active") || state.getState().equals("locked"));
	}
	
	public String getSexual()
	{
		return this.sexual;
	}
	
	public int getAge()
	{
		return this.age;
	}

}
