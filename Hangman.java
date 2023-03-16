import java.util.Scanner;
public class Hangman {
	int turns = 9;
	String dash = "";

	public static void main(String[] args) 
	{
		Hangman hm = new Hangman();
		hm.runIt2();
	}
	public String runIt() 
	{
		String[] words = { "QUIXOTIC", "JUKEBOX","FLAPJACK", "MAXIMIZE", "WHEEZILY", "EQUALIZE", "CHUTZPAH", "EXORCISE", "WHIZBANG","JEZEBEL","SQUEEZE"};
		int num = (int)(Math.random()*words.length);
		return words[num];
	}
	public void runIt2()
	{
		Scanner sc = new Scanner(System.in);
		String word = runIt();
		int wordCount = word.length();
		int wrongCount = 0;
		String letterChain = "";
		String arr[]= new String[word.length()];
		for (int i=0; i<word.length(); i++)
			arr[i]="-";
		System.out.print("\n\n\n");
		while (turns>0){
			if (wrongCount==0) {
				System.out.println("   ____"); 
				System.out.println("  |    |");
				System.out.println("  |    "); 
				System.out.println("  |  "); 
				System.out.println("  |    ");
				System.out.println("  | "); 
				System.out.println(" _|_"); 
				System.out.println("|   |______");
				System.out.println("|          |");
				System.out.println("|__________|"); 
			}
			else 
				body(wrongCount);
			printArray(arr);
			System.out.println();
			if(wordCount==0)
				break;
			System.out.println("You have "+turns+" chances");
			System.out.print("Guess a letter to the word: ");
			String letter = sc.next();
			letter=letter.toUpperCase();
			int count = 0;
			for (int i =0; i<word.length();i++){
				if((word.charAt(i)+"").equals(letter)&&letterChain.indexOf(word.charAt(i)+"")==-1){
					count++;
					arr[i]=letter;
					wordCount--;
				}
			}
			letterChain+=letter;
			if (count==0) {
				wrongCount++;
				turns--;
			}
			if (count==1)
				System.out.println("There is "+count+" '"+letter+"' in the word");
			else
				System.out.println("There are "+count+" '"+letter+"' in the word");		
		}	
		if (turns>0) {
			System.out.println("You have "+turns+" chances");
			System.out.println("You won!"); 
		}
		else {
			body(wrongCount);
			printArray(arr);System.out.println();
			System.out.println("You have "+turns+" chances");
			System.out.println("The word was: "+word);
		}
		System.out.print("\n\n\n");
	}
	public void printArray(String [] arr){
		for (int i=0; i<arr.length;i++){
			System.out.print(arr[i]);
		}
	}
	public void body (int count) {
		System.out.println("   ____"); 
		System.out.print("  |    |");System.out.println(); 
		String [] part = {"O","/","|","\\","|","_","/","\\","_"};
		if (count==1) {
			System.out.print("  |    "); System.out.println(part[0]);
			System.out.println("  |    ");
			System.out.println("  |    ");
			System.out.println("  |    ");
		}
		if (count==2) {
			System.out.print("  |    "); System.out.println(part[0]);
			System.out.print("  |  "); System.out.println(" "+part[1]);
			System.out.println("  |    ");
			System.out.println("  |    ");

		}
		if (count==3) {
			System.out.print("  |    "); System.out.println(part[0]);
			System.out.print("  |  "); System.out.print(" "+part[1]);
			System.out.println(part[2]);
			System.out.println("  |    ");
			System.out.println("  |    ");
		}
		if (count==4) {
			System.out.print("  |    "); System.out.println(part[0]);
			System.out.print("  |  "); System.out.print(" "+part[1]);
			System.out.print(part[2]);
			System.out.println(part[3]);
			System.out.println("  |    ");
			System.out.println("  |    ");
		}
		if (count==5) {
			System.out.print("  |    "); System.out.println(part[0]);
			System.out.print("  |  "); System.out.print(" "+part[1]);
			System.out.print(part[2]);
			System.out.println(part[3]);
			System.out.print("  |    "); System.out.println(part[4]);
			System.out.println("  |    ");

		}
		if (count==6) {
			System.out.print("  |    "); System.out.println(part[0]);
			System.out.print("  |  "); System.out.print(" "+part[1]);
			System.out.print(part[2]);
			System.out.println(part[3]);
			System.out.print("  |    "); System.out.println(part[4]);
			System.out.print("  | "); System.out.println(" "+part[5]);	
		}
		if (count==7) {
			System.out.print("  |    "); System.out.println(part[0]);
			System.out.print("  |  "); System.out.print(" "+part[1]);
			System.out.print(part[2]);
			System.out.println(part[3]);
			System.out.print("  |    "); System.out.println(part[4]);
			System.out.print("  | "); System.out.print(" "+part[5]);	
			System.out.println(part[6]);
		}
		if (count==8) {
			System.out.print("  |    "); System.out.println(part[0]);
			System.out.print("  |  "); System.out.print(" "+part[1]);
			System.out.print(part[2]);
			System.out.println(part[3]);
			System.out.print("  |    "); System.out.println(part[4]);
			System.out.print("  | "); System.out.print(" "+part[5]);	
			System.out.print(part[6]);
			System.out.println(" "+part[7]);
		}
		if (count==9) {
			System.out.print("  |    "); System.out.println(part[0]);
			System.out.print("  |  "); System.out.print(" "+part[1]);
			System.out.print(part[2]);
			System.out.println(part[3]);
			System.out.print("  |    "); System.out.println(part[4]);
			System.out.print("  | "); System.out.print(" "+part[5]);	
			System.out.print(part[6]);
			System.out.print(" "+part[7]);
			System.out.println(part[8]);
		}
		System.out.println(" _|_"); 
		System.out.println("|   |______");
		System.out.println("|          |");
		System.out.println("|__________|"); 
	}
}



