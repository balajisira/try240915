package learn.sira.java.data;

public class ReportData {
	long id;
	private String name;
	private String cData1;
	private String cData2;
	private String cData3;
	private String cData4;
	
	public ReportData(long id, String name, String cData1, String cData2,
			String cData3, String cData4) {
		super();
		this.id = id;
		this.name = name;
		this.cData1 = cData1;
		this.cData2 = cData2;
		this.cData3 = cData3;
		this.cData4 = cData4;
	}
	public ReportData (){
		
	}
	public static ReportData getTestReportData(long id) {
		return new ReportData(id,"Name","cData_1","cData_2","cData_3","cData_4");
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getcData1() {
		return cData1;
	}
	public void setcData1(String cData1) {
		this.cData1 = cData1;
	}
	public String getcData2() {
		return cData2;
	}
	public void setcData2(String cData2) {
		this.cData2 = cData2;
	}
	public String getcData3() {
		return cData3;
	}
	public void setcData3(String cData3) {
		this.cData3 = cData3;
	}
	public String getcData4() {
		return cData4;
	}
	public void setcData4(String cData4) {
		this.cData4 = cData4;
	}
	
	
}
