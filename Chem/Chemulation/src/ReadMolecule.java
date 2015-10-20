import java.util.*;
import java.io.*;
public class ReadMolecule {
	private String inString = "";
	private File inFile;
	private BufferedReader r;
	private FileReader fReader;
	private ArrayList<Atom> aList;
	private ArrayList<Bond> bList;
	// new File("C"/Users/Andrew Courtney/workspace/Chemulation/writeFolder");

	
	public ReadMolecule(String inString){
		this.inString = inString;
	}
	public void reading(){
		inFile = getFileName();
		try {
			fReader = new FileReader(inFile);
			r = new BufferedReader(fReader);
		} catch (FileNotFoundException e) {
			System.out.println("error finding read-in file");
		}
		readIn();
	}
	public File getFileName(){
		if(inString != ""){
			return (new File("C:/Users/Andrew Courtney/workspace/Chemulation/writeFolder/" + inString + ".txt"));
			
		} else {
			return (new File("C:/Users/Andrew Courtney/workspace/Chemulation/writeFolder/default.txt"));
		}
	}
	public void readIn(){
		System.out.println("test1");
		String temp = "";
		boolean title = false;
		boolean atom = false;
		boolean bond = false;
		try {
			System.out.println("test4");
			temp = r.readLine();
			title = true;
			while(temp != null){
				System.out.println(temp);
				
				if(temp.equals("end")){
					return;
				}
				if(bond){
					bList.add(new Bond());
				}
				if(temp.equals("bond")){
					bond = true;
					atom = false;
				}
				if(atom){
					aList.add(new Atom());
				}
				if(temp.equals("atom")){
					atom = true;
				}  
				temp = r.readLine();
			}
		} catch (IOException e) {
			System.out.println("error reading in from file");
		}
	}
		
	public Molecule getMolecule(){
		return new Molecule(aList, bList);
	}
		
	
	public void endReading(){
		try {
			r.close();
		} catch (IOException e) {
			System.out.println("error closing buffered reader");
		}
	}
	
	
}
