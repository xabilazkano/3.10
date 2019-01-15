package com.zubiri;
import java.util.ArrayList;

public class Users {
	
	private ArrayList<User> users = new ArrayList<User>();
	
	public void setUsers(ArrayList<User> users) {
		this.users=users;
	}
	
	public ArrayList<User> getUsers(){
		return this.users;
	}

	public void register(User user) {
		users.add(user);
	}
	
	public void changePassword(String username,String password) {
		for (int i=0;i<users.size();i++) {
			if (users.get(i).getUsername().equals(username)) {
				users.get(i).setPassword(password);
			}
		}
		
	}
	
	public boolean login(String user,String pass) {
		boolean verify=false;
		for (int i=0;i<users.size();i++) {
			if (users.get(i).getUsername().equals(user) && users.get(i).getPassword().equals(pass)) {
				verify=true;
			}
		}
		return verify;
		
	}
	
}
