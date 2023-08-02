package com.example.demo.services.impli;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import com.example.demo.exceptionhandling.ResourceNotFoundException;
import com.example.demo.models.user;
import com.example.demo.payload.user_payload;
import com.example.demo.repository.users_repo;
import com.example.demo.services.user_services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class userserviceimpli implements user_services {
    @Autowired
	users_repo repo;
	@Autowired
	ModelMapper modelmappper;
	@Override
	public user_payload adduser(user_payload adu) {
		// TODO Auto-generated method stub
		user e=this.dto_user(adu);
		user savesuser=this.repo.save(e);
		return this.user_dto(savesuser);}
    @Override
	public user_payload updateuser(user_payload adu, int id) {
		// TODO Auto-generated method stub
		user us=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));
		us.setName(adu.getName());
		us.setEmail(adu.getEmail());
		us.setPassword(adu.getPassword());
		user u1=this.repo.save(us);
		user_payload up=this.user_dto(u1);
		return up;
	}
    @Override
	public void deleteusers(int id) {
		user e=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("user","id",id));  
        this .repo.delete(e);}
	public user dto_user(user_payload ep) {
		user u = this.modelmappper.map(ep, user.class);
		return u;
	}
    public user_payload user_dto(user emp) {
		user_payload p = this.modelmappper.map(emp, user_payload.class);
		return p;
     }
	@Override
	public List<user_payload> getalluser() {
		List<user> u=(List<user>) this.repo.findAll();
		List<user_payload> up=u.stream().map(imp->this.user_dto(imp)).collect(Collectors.toList());
		return up;}
    @Override
	public user_payload getuserbyid(int id) {
		// TODO Auto-generated method stub
		user u=this.repo.findById(id).orElseThrow(()->new ResourceNotFoundException("user", "id", id));
		return this.user_dto(u);
		}}
