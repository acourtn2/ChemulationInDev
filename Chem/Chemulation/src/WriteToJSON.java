import java.util.*;
import java.io.*;
public class WriteToJSON {
	
	private String outString = "";		
	private File outFile;
	private BufferedWriter w;
	private OutputStreamWriter outWrite;
	private FileOutputStream outStream;
	private ArrayList<Atom> aList;
	private ArrayList<Bond> bList;
	
	public WriteToJSON(String out, ArrayList<Atom> aList, ArrayList<Bond> bList){
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
			return (new File("C:/Users/Andrew Courtney/workspace/Chemulation/writeFolder/" + outString + ".json"));
		} else {
			System.out.println("File creation error, using default");
			return (new File("C:/Users/Andrew Courtney/workspace/Chemulation/writeFolder/default.json"));
		}
	}
	public void writeMeat(){
		
		try {
			for( int i = 0; i < aList.size(); i++){

				w.write("{");
				w.newLine();
				Atom tempA = aList.get(i);
				
				w.write("\t" + "\"" + "vertexNum" + "\":" + tempA.getVertexNum() + "\",");
				w.newLine();
				w.write("\t" + "\"" + "atomicNum" + "\":" + tempA.getAtomicNum()+ "\",");
				w.newLine();
				w.write("\t" + "\"" + "atomicWeight" + "\":" + tempA.getAtomicWeight()+ "\",");
				w.newLine();
				w.write("\t" + "\"" + "electroNeg" + "\":" + tempA.getElectroNeg()+ "\",");
				w.newLine();
				w.write("\t" + "\"" + "atomName" + "\":" + tempA.getAtomName()+ "\",");
				w.newLine();
				w.write("\t" + "\"" + "adjacentBonds" + "\": {");
				w.newLine();
				
				
				for(int z = 0; z < tempA.getAdjacentBonds().size(); z++){
					w.write("\t\t" +"[");
					w.newLine();
					w.write("\t\t\t" + "\"" + "edgeNum" + "\":"+ tempA.getAdjacentBonds().get(z).getEdgeNum() +"\",");
					w.newLine();
					w.write("\t\t\t" + "\"" + "bondType" + "\":"+ tempA.getAdjacentBonds().get(z).getBondType() + "\",");
					w.newLine();
					w.write("\t\t\t" + "\"" + "exist" + "\":"  +  tempA.getAdjacentBonds().get(z).getExist()+"\",");
					w.newLine();
					w.write("\t\t\t" + "\"" + "weight" + "\":"+ tempA.getAdjacentBonds().get(z).getWeight());
					w.newLine();
					w.write("\t\t" + "]");
					w.newLine();
					
				}
				w.write("\t" + "}");
				w.newLine();
			}
			for(int p = 0; p < bList.size(); p++){
				Bond tempB = bList.get(p);
				w.write("{");
				w.newLine();
				w.write("\t" + "\"" + "edgeNum" + "\":"+ tempB.getEdgeNum() + "\",");
				w.newLine();
				w.write("\t" + "\"" + "bondType" + "\":" + tempB.getBondType() +"\",");
				w.newLine();
				w.write("\t" + "\"" + "exist" + "\":"  + tempB.getExist() +"\",");
				w.newLine();
				w.write("\t" + "\"" + "weight" + tempB.getWeight() + "\":");
				w.newLine();
				w.write("\t"+ "\"" + "adjacentAtoms"+ "\": {");
				w.newLine();
					w.write("\t\t" + "\"" + "vertexNum" + "\":" + "\",");
					w.newLine();
					w.write("\t\t" + "\"" + "atomicNum" + "\":" + "\",");
					w.newLine();
					w.write("\t\t" + "\"" + "atomicWeight" + "\":" +  "\",");
					w.newLine();
					w.write("\t\t" + "\"" + "electroNeg" + "\":" + "\",");
					w.newLine();
					w.write("\t\t" + "\"" + "atomName" + "\":" +  "\",");
					w.newLine();
			}
				w.write("\t" + "}");
				w.newLine();
			
			
			
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
