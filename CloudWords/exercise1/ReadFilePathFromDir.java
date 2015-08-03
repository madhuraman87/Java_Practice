package exercise1;

/**
 * 
Exercise 1 
 
Please write a program that can read the contents of any directory (and it’s subdirectories) in 
the filesystem, and display the files sorted in order of file size to System.out.  The directory to 
search should be passed as a parameter to the “main” method of the program.  
 
The output should show the full path of the file, the file name, and the file size. 
 *
 */

import java.io.*;
import java.util.*;

public class ReadFilePathFromDir {
	
	private List<File> getFileListing(File root) throws FileNotFoundException {
		List<File> result = new ArrayList<File>();
		List<File> filepathList = Arrays.asList(root.listFiles());
		for (File file : filepathList) {
			result.add(file); // add all the file and directory path
			if (!file.isFile()) { // if its a directory, then recursive call to get the nested files
				List<File> innerList = getFileListing(file);
				result.addAll(innerList);
			}
		}
				
		Collections.sort( result, new Comparator<File>() { // sorts in ascending order.
		    public int compare( File a, File b ) {
		        int aSize = (int) a.length();
		        int bSize = (int) b.length();
		        if ( aSize == bSize ) {
		            return 0;
		        }
		        else {
		            return Integer.compare(aSize, bSize);
		        }
		    }
		} );
		
		return result;
	}	
	
	public static void main(String[] args) throws FileNotFoundException {

		ReadFilePathFromDir listing = new ReadFilePathFromDir();
		File startingDirectory = new File(args[0]);		
		List<File> files = listing.getFileListing(startingDirectory);
		System.out.println("Struc Type : FileName : FilePath : File size in bytes");		
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.println("Directory : " + file.getName() + " : " + file.getPath() + " : " + file.length() + " bytes");                
            }else
			System.out.println("File : " + file.getName() + " : " + file.getPath() + " : " + file.length() + " bytes");
		}
	}

}
