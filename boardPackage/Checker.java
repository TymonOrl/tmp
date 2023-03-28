package boardPackage;

public enum Checker {
	NONE(0),
	WCHECKER(1),
	WKINGCHECKER(2),
	BCHECKER(3),
	BKINGCHECKER(4);
	
	final int value;
	
	Checker (int value){
		this.value = value;
	}
}
