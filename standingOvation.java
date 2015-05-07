import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class standingOvation{
	public static void main(String[] args){
		Scanner sc = null;
		try{
			sc = new Scanner(new File("A-large.txt"));
		}catch(Exception e){
			System.out.println("Didn't work");
		}
		PrintWriter pw = null;
		try{
			pw = new PrintWriter(new File("outputLarge.txt"));
		} catch(Exception e){
			System.out.println("Didn't work");
		}

		int total = sc.nextInt();
		sc.nextLine();

		int smax = 0;
		String currentLine = "";
		int toAdd = 0;
		int soFar = 0;
		for(int i =0; i<total; i++){
			smax = sc.nextInt();
			//System.out.println(smax);
			sc.skip(" ");
			currentLine = sc.nextLine();
			int[] currentA = new int[smax+1];
			for(int j=0;j<=smax; j++){
				currentA[j] = Integer.parseInt(currentLine.substring(j, j+1));
				//System.out.print(currentA[j]);
			}
			soFar += currentA[0];
			for(int j=1; j<=smax; j++){
				if(soFar >= j || currentA[j] == 0){
					//System.out.println("k:j=" + j + ":" + soFar);
					soFar += currentA[j];
				}else{
					while(soFar < j ){
						toAdd++;
						soFar++;

					}
					soFar += currentA[j];
				}
			}
			//System.out.println("end of case" + (i+1));
			pw.print("Case #" + (i+1) + ": " + toAdd);
			if(i+1 != total){
				pw.println("");
			}
			soFar = 0;
			toAdd = 0;
			//System.out.println();
		}

		sc.close();
		pw.close();
	}
}