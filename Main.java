import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws IOException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("AnalyticsForMath.txt",true);
		Analytics.SetUp(fw);
		double beginning, end, totalTime = 0, difficulty;
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		System.console().printf("\t" + "How many times would you like to practice?\n");	
		System.console().printf("\t");			
		double numberOfQuestions = -1;
		try {
			numberOfQuestions = Double.parseDouble(bufferRead.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.console().printf("\t" + "What difficulty?\n");
		System.console().printf("\t");	
		long difficulty1 = -1, difficulty2 = -1;
		try {
			difficulty1 = Integer.parseInt(bufferRead.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		difficulty = difficulty1;
		if(difficulty1 % 2 == 1) {
			difficulty2 = difficulty1/2 + 1;
			difficulty1 = difficulty2;
		}
		else { 
			difficulty2 = difficulty1/2;
			difficulty1 = difficulty2 + 1;
		}
		int number1, number2, answer = -1;
		double attempts = 1, totalAttempts = 0;
		Random r_generator = new Random();
		long track = (long)numberOfQuestions;
		long position = 1;
		while(numberOfQuestions != 0) {
			
			number1 = r_generator.nextInt((int)(Math.pow(10, difficulty1)*0.9)) + (int)Math.pow(10,difficulty1-1);
			number2 = r_generator.nextInt((int)(Math.pow(10, difficulty2)*0.9)) + (int)Math.pow(10,difficulty2-1);
			System.console().printf("Question: " + position + "\n");
			System.console().printf("\t" + number1 + " * " + number2 + " = " + "\n");
			System.console().printf("\t");
			beginning = ((double)System.currentTimeMillis())/((double)1000);			
			try {
				answer = Integer.parseInt(bufferRead.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.console().printf("Not a valid entry!\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.console().printf("Not a valid entry!\n");
			}
			while(answer != number1 * number2) {
				System.console().printf("\t" + "Wrong answer! Try it again \n");
				System.console().printf("\t");	
				try {
					answer = Integer.parseInt(bufferRead.readLine());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				attempts++;
			}
			end = ((double)System.currentTimeMillis())/((double)1000);
			totalTime += (end - beginning);
			totalAttempts += attempts;
			System.console().printf("\t" + "Correct! You took " + (end - beginning) + " second(s).\n");
			Analytics.PrintQuestion( fw,number1 + " * " + number2, (end - beginning), attempts);
			numberOfQuestions--;
			attempts = 1;
			position++;
		}
		Analytics.Print(fw,"Average time: " + totalTime/track + " second(s).");
		Analytics.Print(fw,"Average number of Attempts: " + (totalAttempts/track));
		Analytics.Print(fw,"Difficulty for session: " + difficulty + ".");
		System.console().printf("Average time: " + totalTime/track + " second(s).\n");
		System.console().printf("Average number of Attempts: " + totalAttempts/track + "\n");
		fw.close();
	}

}
