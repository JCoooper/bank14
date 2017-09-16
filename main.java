
import java.util.ArrayList;
import java.util.Scanner;
//------------------------------------------------------------------------------

class main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int acNum = 2;
		int acnump;
		double money;
		int acc = 0;
		int accType;
		String Cacc;
		String Cacc2;
		String Cacc3;
		double numsDoub;
		int numsint;

		double inter;
		int withs;

		double higher = 10;

		double doll;
		double timeP;

		// --saving--
		double lowmoney;
		double intreovertime = 0;
		// ------

		// --checking--
		int acT;
		int wi = 0;
		// -----

		boolean q = false;

		ArrayList<BAccount> index = new ArrayList<BAccount>();
		index.add(new BAccount(1000, 2, 0));// 0
		index.add(new Checking(100, 2, 1, wi));// 1
		index.add(new Savings(10, 2, 0, higher, 7));// 2
		higher = index.get(2).getBal();

		System.out.println("Create New Account? (y) or (n): ");
		Cacc = s.nextLine();

		if (Cacc.equals("n")) {
			System.out.println("Please Press 'Enter' Once More");
			Cacc = s.nextLine();
			q = true;

		} else if (Cacc.equals("y")) {
			System.out.println("Checking or Savings? (c) or (s) ");
			Cacc2 = s.nextLine();

			if (Cacc2.equals("c")) { // CHECKING
				System.out.println("Enter Money in Account: ");
				numsDoub = s.nextDouble();
				doll = numsDoub;

				System.out.println("Enter Time Open: ");
				numsDoub = s.nextDouble();
				timeP = numsDoub;

				System.out.println("Enter Account type:  (For Check. Enter 1 or For Savings Enter 0)");
				numsint = s.nextInt();
				acT = numsint;

				System.out.println("Enter Amount of Withdrawls: "); // no need set wi to 0
				numsint = s.nextInt();
				wi = numsint;

				acNum++;
				System.out.println("Your Account Number is " + acNum++);
				System.out.println(" ");

				index.add(new Checking(doll, timeP, acT, wi));
				System.out.println(" ");

				System.out.println(index.get(2).getBal() + " , " + index.get(2).getAccType() + " , " // show acc num
						+ index.get(2).getTimeMonths());
				q = true;

			} else if (Cacc2.equals("s")) { // SAVING
				System.out.println("Enter Money in Account: ");
				numsDoub = s.nextDouble();
				doll = numsDoub;

				System.out.println("Enter Time Open: ");
				numsDoub = s.nextDouble();
				timeP = numsDoub;

				System.out.println("Enter Account type:  (For Check. Enter 1 or For Savings Enter 0)");
				numsint = s.nextInt();
				acT = numsint;

				System.out.println("Enter lowest Bal : ");
				numsint = s.nextInt();
				lowmoney = numsint;

				acNum++;
				System.out.println("Your Account Number is " + acNum++);
				System.out.println(" ");

				index.add(new Savings(doll, timeP, acT, lowmoney, intreovertime));
				higher = lowmoney;
				System.out.println(" ");

				System.out.println(index.get(2).getBal() + " , " + index.get(2).getAccType() + " , "
						+ index.get(2).getTimeMonths());
				q = true;
			}
		}

		// Checking check = new Checking(0, 0, 0, 0);

		// accType = acc.getAccType();
		String input;
		System.out.println("Enter account number: ");
		acc = s.nextInt();

		if (index.size() < acc) {
			System.out.println("INVALID NUMBER, PLEASE RESTART");
			q = false;
		}

		while (q == true) { // ATM mode
			accType = index.get(acc).getAccType();

			System.out.println(
					"Enter (d) if you want to make a deposit, (w) for Withdrawal, (m) to reset the month or (q) to quit");
			input = s.next();

			if (input.equals("d")) {
				System.out.println("Enter The Money: ");
				money = s.nextInt();
				index.get(acc).setBal(index.get(acc).getBal() + money);
				System.out.println("Your New Balance Is: $" + index.get(acc).getBal());

			} else if (input.equals("w")) {

				if (accType == 1) { // checking
					System.out.println("Enter withdraw amount: ");
					money = s.nextInt();
					index.get(acc).setBal(index.get(acc).getBal() - money);// stand with

					((Checking) index.get(acc)).setWit(wi++);

					if (wi > 3) {
						index.get(acc).setBal(index.get(acc).getBal() - 1); // HERE
					}

					withs = 3 - wi;
					System.out.println("Your New Balance Is: $" + index.get(acc).getBal());
					System.out.println(withs + " Withdrawls Before A Fee");

				} else if (accType != 1) {
					System.out.println("Enter withdraw amount: ");
					money = s.nextInt();
					index.get(acc).setBal(index.get(acc).getBal() - money);
					System.out.println("Your New Balance Is: $" + index.get(acc).getBal());
				}

			} else if (input.equals("m")) {
				System.out.println(accType);
				if (accType != 1) {
					if (higher > index.get(acc).getBal()) {
						higher = index.get(acc).getBal();
					}
					// **lowest = ((Savings) index.get(acc)).getLowestBal2() * .5;
					// **inter = ((Savings) index.get(acc)).getLowestBal2();
					// ((Savings) index.get(acc)).setInterBal(inter);
					System.out.println("The Money Deposited In Your Account is: $" + higher * .5);
					index.get(acc).setBal(index.get(acc).getBal() + higher * .5);
					System.out.println("New Balance is: $" + index.get(acc).getBal());
				} else if (accType == 1) { // check
					// System.out.print("New With Count: ");
					wi = 0;
					System.out.println("Your Withdrawls Have Been Reset");
				}
			} else if (input.equals("q")) {
				System.out.println("Thank You For Using This ATM");
				q = false;
			}

			// index.get(acc)
			// with = with + 1;// here
			/*
			 * if (withd > 3) {// here index.get(acc).setBal(index.get(acc).getBal() - 1); }
			 * if (index.get(acc).get)
			 * 
			 * System.out.println(index.get(acc).getBal()); System.out.println(withd);
			 * 
			 * }
			 */

		}

	}
}

/*
 * import java.util.Scanner;
 * //---------------------------------------------------------------------------
 * ---
 * 
 * class main { public static void main(String[] args) { Scanner s = new
 * Scanner(System.in);
 * 
 * double money; double acc;
 * 
 * BAccount acc1 = new BAccount(0, 2, 001);
 * 
 * boolean q = true; String input;
 * System.out.println("Enter da moneyz account number"); acc = s.nextInt();
 * while (q == true) { System.out.println(
 * "Enter D if you want to make a deposit, W for Withdrawal, M to reset the month, or Q to quit"
 * ); input = s.nextLine();
 * 
 * if (input.equals("D")) { System.out.println("Enter da moneyz"); money =
 * s.nextInt();
 * 
 * acc1.setBal(acc1.getBal() + money);
 * 
 * System.out.println(acc1.getBal());
 * 
 * } else if (input.equals("W")) {
 * 
 * }
 * 
 * } } }
 */