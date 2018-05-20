package vertex;

public class Movie extends Vertex {

	private int year;
	private String country;
	private double IMDb;
	
	public Movie(String str,String args[],String type) {
		super(str,type);
		this.fillVertexInfo(args);
		checkRep();
		// TODO 自动生成的构造函数存根
	}
	
	@Override
	void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 3) {
			if (args[0].matches("[0-9]+")) {
				year = Integer.valueOf(args[0]);
			}
			country = args[1];
			if (args[2].matches("-?[0-9]+.?[0-9]+")) {
				IMDb = Double.parseDouble(args[2]);
			}
		}
		checkRep();
	}
	
	private void checkRep() {
		assert year >= 0;
		assert country.length() > 0;
		assert (((IMDb * 100) - (int) (IMDb * 100)) == 0);
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	public String getCountry()
	{
		return this.country;
	}
	
	public double getIMDb()
	{
		return this.IMDb;
	}

}
