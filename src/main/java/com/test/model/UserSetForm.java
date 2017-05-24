package com.test.model;

import java.util.HashSet;
import java.util.Set;

public class UserSetForm {
	
	private Set<User> userset = new HashSet<User>();
	
	public Set<User> getUserset() {
		return userset;
	}

	public void setUserset(Set<User> userset) {
		this.userset = userset;
	}

	public UserSetForm(){
		userset.add(new User());
		userset.add(new User());
		userset.add(new User());
		userset.add(new User());
		
	}

}
