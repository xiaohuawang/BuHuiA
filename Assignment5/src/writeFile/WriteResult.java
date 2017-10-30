package writeFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class WriteResult {

	public String getFileName(String filenamePart) {
		String filename = System.getProperty("user.dir") + File.separatorChar + "resultFolder" + File.separatorChar
				+ filenamePart;
		return filename;
	}

	public void writeResult(List<String> resultList, String filenamePart) {
		PrintWriter writer;
		try {
			String filename = getFileName(filenamePart);
			System.out.println(filename);
			writer = new PrintWriter(new File(filename));
			writer.println("TID " + "Date and Time                 " + "ClientID  " + "Message " + " Verified "
					+ "Transaction Status    " + "EncodedStr ");

			for (String s : resultList) {
				writer.println(s);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
