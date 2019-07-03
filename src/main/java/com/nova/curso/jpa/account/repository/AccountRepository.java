package com.nova.curso.jpa.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.nova.curso.jpa.account.entity.Account;

public interface AccountRepository extends CrudRepository<Account, Integer>{

}
