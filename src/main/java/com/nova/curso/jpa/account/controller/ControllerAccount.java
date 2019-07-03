package com.nova.curso.jpa.account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nova.curso.jpa.account.entity.Account;
import com.nova.curso.jpa.account.repository.AccountRepository;

@RestController
public class ControllerAccount {

	@Autowired
	AccountRepository repository;
	
	@RequestMapping(value="/recoveryAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Account> recoverAccount(){
		return repository.findAll();
	}
	
	@RequestMapping(value="/recoveryById/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Optional<Account> recoverAccountById(@PathVariable int id){
		return repository.findById(id);
	}
	
	@RequestMapping(value="/saveAccount")
	public ResponseEntity<Object> saveAccount(@RequestBody Account account){

		ResponseEntity<Object> response;
		
		try{
			repository.save(account);
			response = new ResponseEntity<>("Ok", HttpStatus.OK);
		} catch(Exception ex){
			response = new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return response;
		
	}
}
