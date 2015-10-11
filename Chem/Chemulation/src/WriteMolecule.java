import java.util.*;
import java.io.*;
public class WriteMolecule {
	private String outString = "";
	private File outFile;
	private BufferedWriter w;
	private OutputStreamWriter outWrite;
	private FileOutputStream outStream;
	private ArrayList<Atom> aList;
	private ArrayList<Bond> bList;
	// new File("C"/Users/Andrew Courtney/workspace/Chemulation/writeFolder");
	
	
	public WriteMolecule(String out, ArrayList<Atom> aList, ArrayList<Bond> bList){
		this.outString = out;
		this.aList = aList;
		this.bList = bList;
	}
	public void writing(){
		outFile = getFileName();
		try{
		outStream = new FileOutputStream(outFile);
		outWrite = new OutputStreamWriter(outStream);
		w = new BufferedWriter(outWrite);
		
		} catch (IOException e) {
			System.out.println("writing() error creating "+ outString);
		}
		writeMeat();
	}
	public File getFileName(){
		if(outString != ""){
			return (new File("C:/Users/Andrew Courtney/workspace/Chemulation/writeFolder/" + outString + ".txt"));
		} else {
			System.out.println("File creation error, using default");
			return (new File("C:/Users/Andrew Courtney/workspace/Chemulation/writeFolder/default.txt"));
		}
	}
	public void writeMeat(){
		
		try {
			System.out.println("test1");
			w.write(outString); //name of molecule
			w.newLine();
			w.write("Atoms");
			w.newLine();
			for( int i = 0; i < aList.size(); i++){
				Atom tempA = aList.get(i);
				String aString = tempA.toString();
				w.write(aString);
				w.newLine();
			}
			w.write("Bonds");
			w.newLine();
			for(int i = 0; i < bList.size(); i++){
				Bond tempB = bList.get(i);
				String bString = tempB.toString();
				w.write(bString);
				w.newLine();
			}
			w.write("end");
			
		} catch (IOException e) {
			System.out.println("error writing meat of file");
		}
		
	}
	public void endWriter(){
		try {
			w.close();
		} catch (IOException e) {
			System.out.println("error closing writer");
		}
	}
	
	
	
	
}
