import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class Analytics {
	
	public static void PrintQuestion(FileWriter fw, String question, double time, double attempts) throws IOException{
		
		fw.write("Answered: " + question + " in: " + time + " seconds in " + attempts + " attempt(s)." + "\n");
	}
	
	public static void SetUp(FileWriter fw) throws IOException {
		fw.write(new Date().toString() + "\n");
	}
	
	public static void Print(FileWriter fw, String message) throws IOException{
		
		fw.write(message + "\n");
	}
}
