package VowelFile;
import java.io.*;
import java.util.*;

public class FileRead {
	
	public void fileReadForVowel(String inpath,String outpath)throws IOException {
		
		File f1=new File("C:\\Users\\Nandhini\\Desktop\\bct training\\"+inpath);
		File f2=new File("C:\\Users\\Nandhini\\Desktop\\bct training\\"+outpath);
		f2.createNewFile();
		
		Scanner scan=new Scanner(f1);
		List<String> splitlist=new ArrayList<String>();
		char[] vowels={'a','e','i','o','u'};
		
		while (scan.hasNextLine()){
			String str=scan.next().toLowerCase();			
			splitlist.add(str);
		}
		scan.close();
		
		try {
			new FileWriter("C:\\Users\\Nandhini\\Desktop\\bct training\\output.txt").close();
			for(String i:splitlist){
				if(i.length()>1) {
					if(contains(i.charAt(1),vowels)){
						FileOutputStream fOut = new FileOutputStream("C:\\Users\\Nandhini\\Desktop\\bct training\\output.txt", true);
					    OutputStreamWriter osw = new OutputStreamWriter(fOut);
					    osw.write(i +" , ");
					    osw.flush();
					    osw.close();
					}
				}
			}
		}
		catch (IOException e) {
		      e.printStackTrace();
		}
	}
		
	
	public boolean contains(char c, char[] array) {
		for (char x : array) {
			if (x == c) {
				return true;
	        }
	    }
	    return false;
	}
	
	
	public static void main(String[] args) throws IOException
    {
		//String in;String out;
       FileRead read=new FileRead();
       read.fileReadForVowel(args[0],args[1]);
    }
}
