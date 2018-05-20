package vertex;

public class Actor extends Vertex{
	
	private int age;
	private String sex;
	
	public Actor(String str,String[] args,String type) {
		super(str,type);
		this.fillVertexInfo(args);
		checkRep();
		// TODO 自动生成的构造函数存根
	}

	@Override
	void fillVertexInfo(String[] args) {
		// TODO 自动生成的方法存根
		if (args.length == 2) {
			if (args[0].matches("[0-9]+")) {
				age = Integer.valueOf(args[0]);
			}
			sex = args[1];
		}
		checkRep();
	}
	
	private void checkRep() {
		assert age >= 0;
		assert (sex.equals("M") || sex.equals("F"));
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String getSex(){
		return this.sex;
	}
}
