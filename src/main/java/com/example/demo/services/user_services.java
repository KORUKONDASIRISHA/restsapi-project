package com.example.demo.services;


import java.util.List;

import com.example.demo.payload.user_payload;

public interface user_services {
	user_payload adduser(user_payload adu);
	user_payload updateuser(user_payload adu,int id);
	void deleteusers(int id);
	List<user_payload>getalluser();
	user_payload getuserbyid(int id);
		
	}
