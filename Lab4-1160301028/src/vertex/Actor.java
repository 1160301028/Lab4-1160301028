package vertex;

public class Actor extends Vertex{
	
	private int age;
	private String sex;
	
	public Actor(String str,String[] args,String type) {
		super(str,type);
		this.fillVertexInfo(args);
		checkRep();
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	void fillVertexInfo(String[] args) {
		// TODO �Զ����ɵķ������
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
