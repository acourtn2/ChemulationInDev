
public class MoleculeIUPACtoGraph {
	
	public int getPrefixNum(String prefix){
		if(prefix.equals("meth")){
			return 1;
		} else if(prefix.equals("eth")){
			return 2;
		} else if(prefix.equals("prop")){
			return 3;
		} else if(prefix.equals("but")){
			return 4;
		} else if(prefix.equals("pent")){
			return 5;
		} else if(prefix.equals("hex")){
			return 6;
		} else if(prefix.equals("hept")){
			return 7;
		} else if(prefix.equals("oct")){
			return 8;
		} else if(prefix.equals("non")){
			return 9;
		} else if(prefix.equals("dec")){
			return 10;
		} else { 
			return -1;
		}
	}
}
