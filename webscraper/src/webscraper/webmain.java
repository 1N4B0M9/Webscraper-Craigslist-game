package webscraper;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class webmain {
	public static void main(String[] args) {
		int i = 1;
		int z = 1;
		int ans = 0;
		Scanner s = new Scanner(System.in);

		String webname = "";
		try {
			

			
			int you = 0;
			int pc = 0;
		
			int pick;
			int gogo = 1;
			while (gogo == 1 ) {
			you = 0;
			System.out.println("------Welcome to craigslist guesser!------");
			System.out.println("In this game you guess the category of what the item is being sold from! Your goal is to get 3 points before the computer get 3 point by outsmarting you");
			System.out.println("Are you ready? 1 for yes, 2 for no");
			int choice = s.nextInt();
			if (choice == 1) {
				//u choose yes
				while (you != 3) {
					if (pc == 3) {
						System.out.println("You lose!");
						System.exit(1);

					} else {
						int hehe = (int) (Math.random() * 6);
						ans = hehe;
						

						// fancy if statement 
						webname = hehe == 0 ? "https://philadelphia.craigslist.org/d/boats/search/boo" :hehe == 1 ? "https://philadelphia.craigslist.org/d/computers/search/sya":hehe == 2 ? "https://philadelphia.craigslist.org/d/skilled-trade-services/search/sks" : hehe == 3 ? "https://philadelphia.craigslist.org/d/parking-storage/search/prk" : hehe == 4 ? "https://philadelphia.craigslist.org/d/baby-kid-stuff/search/baa" : hehe == 5 ? "https://philadelphia.craigslist.org/d/heavy-equipment/search/hva" :  "https://philadelphia.craigslist.org/d/wanted/search/waa";
						//website html getter
						Document web1 = Jsoup.connect(webname).get();
						//title getter
						Elements result = web1.getElementsByClass("result-row");
						//loop for title counter for array
						for (Element repository1 : result) {
							i++;
						}
						String[] arraystuff = new String[i];
						//loop to get title also info like time if needed (prob won't)
						for (Element repository : result) {
							String title = repository.getElementsByClass("result-title hdrlnk").text();
							String info = repository.getElementsByClass("result-info").text();
							arraystuff[z] = title;
							z++;

						}
						//title pickers
						int rand = (int) (Math.random() * i);
						
						while (arraystuff[rand] == null) {
						
							 rand = (int) (Math.random() * i);

						}
						
				     
						System.out.println(arraystuff[rand]);
						System.out.println("-----What category is this from?----");
						System.out.println("");
						System.out.println("(0) boats");
						System.out.println("");
						System.out.println("(1) Computers");
						System.out.println("");

						System.out.println("(2) skilled trade");
						System.out.println("");

						System.out.println("(3) storage parking");
						System.out.println("");

						System.out.println("(4) baby + kid");
						System.out.println("");
						System.out.println("(5) Heavy machinery");
						System.out.println("");
						System.out.println("(6) Wanted");
						System.out.println("");
						


						pick = s.nextInt();
						if (pick == ans) {
							you++;
							System.out.println("You scored a point!");
				
						
						} else {
							System.out.println("You guessed wrong!");
							pc++;
						}

					}
				}
			}
				

		
			//u choose no
			else {
				System.exit(1);
			}
			//win
			if (you == 3) {
				System.out.println("You win!");
				//lose
			} else {
				System.out.println("You lose! :(");
			}
			
			//play again
			System.out.println("Would you like to play again? 1 for yes, 2 for no");
			gogo = s.nextInt();
			
			}
				
			
			
		}
				
		//catch print errors (last thing)
		catch (IOException e) {
			e.printStackTrace();
		}
			}
		}

