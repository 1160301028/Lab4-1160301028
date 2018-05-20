package vertex;

public class Word extends Vertex {

	public Word(String str,String[] args,String type) {
		super(str, type);
		this.fillVertexInfo(args);
		checkRep();
		// TODO Auto-generated constructor stub
	}
	
	
	private void checkRep() {
		assert this.getLabel() != "";
	}
	
	@Override
	void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		return;
	}

}
