package Applications;

public enum PeriodeApplication {
	
	PERIODE_1("PERIODE_1"),
	PERIODE_2("PERIODE_2"),
	PERIODE_3("PERIODE_3"),
	PERIODE_4("PERIODE_4");
	
	private String name = "";
	   
	PeriodeApplication(String name){
	    this.name = name;
	  }
	   
	  public String toString(){
	    return name;
	  }
}
