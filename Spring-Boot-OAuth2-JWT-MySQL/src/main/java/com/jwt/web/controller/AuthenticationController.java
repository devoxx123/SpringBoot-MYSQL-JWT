package com.jwt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import com.jwt.web.model.Account;
import com.jwt.web.service.AccountService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class AuthenticationController extends BaseController {

	@Autowired
	protected AuthenticationManager authenticationManager;

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/api/sample", method = RequestMethod.GET)
	public ResponseEntity<Account> sampleGet(HttpServletResponse response) {
		return new ResponseEntity<Account>(accountService.findByUsername("kishore"), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/sample", method = RequestMethod.POST)
	public ResponseEntity<Account> sample(HttpServletResponse response) {
		return new ResponseEntity<Account>(accountService.findByUsername("papidakos"), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Account> register(@Valid @RequestBody Account account) {
		Account createdAccount = accountService.createNewAccount(account);
		return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
	}

}
