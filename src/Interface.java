import java.util.Scanner;
import com.zubiri.*;

public class Interface {

	public static void main(String[] args) {
		Users users = new Users();
		User user = new User();
		Scanner sc = new Scanner(System.in);
		boolean play = true;

		while (play == true) {
			System.out.println("1.- Register");
			System.out.println("2.- Login");
			System.out.println("3.- Quit");

			String option = sc.next();

			switch (option) {

			default:
				System.out.println("Please enter a valid option");
				break;

			case "1":
				System.out.println("Enter a username:");
				String username = sc.next();
				System.out.println("Enter a password");
				String password = sc.next();

				
				boolean userverify = user.verifyUsername(username);
				boolean passverify = user.verifyPassword(password);
				

				if (userverify == true && passverify == true) {
					
					user.setUsername(username);
					user.setPassword(password);
					users.register(user);
					System.out.println("Properly registered");
				} else {
					if (userverify = false) {
						System.out.println("Incorrect username. It must be just letters");
					}

					else {
						System.out.println(
								"Incorrect password. It must be minimum 8 characters and content letters, digits and symbols");
					}
				}
				break;

			case "2":
				System.out.println("Enter the username:");
				username = sc.next();
				System.out.println("Enter the password");
				password = sc.next();

				if (users.login(username, password) == false) {
					System.out.println("Incorrect combination");
				} else {
					System.out.println("Welcome " + username);
					boolean flag = true;
					while (flag) {
						System.out.println("What do you want to do?");
						System.out.println("1.- Change password");
						System.out.println("2.- LogOut");

						switch (sc.next()) {
						default:
							System.out.println("Enter a valid option");
							break;
							
						case "1":
							System.out.println("Enter the new password");
							String newpass = sc.next();
							
							if(user.verifyPassword(newpass)) {
								users.changePassword(username, newpass);
								System.out.println("Password succesfully changed.");
								
							}
							break;
							
						case "2":
								System.out.println("Bye!");
								flag=false;
						}
					}
				}
				break;

			case "3":
				play = false;
				break;
			}
		}
	}
}
