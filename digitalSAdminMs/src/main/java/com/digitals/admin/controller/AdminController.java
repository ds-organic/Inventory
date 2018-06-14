package com.digitals.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.lucene.util.CollectionUtil;
import org.elasticsearch.common.util.CollectionUtils;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digitals.admin.request.entities.UserDetails;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/")
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AdminController {

	private static List<UserDetails> userDetailList =new ArrayList<>();
	
	@ApiOperation(value = "Register user details to create user id and password", notes = "The service creates user specific roles and user credentials.", response = String.class,tags={ "Register User", })
	@ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "Success", response = String.class),
	        @ApiResponse(code = 404, message = "Not found", response = Void.class),
	        @ApiResponse(code = 500, message = "Internal Server Error", response = com.digitals.admin.response.entities.Error.class) })
	@RequestMapping(value = "/user", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> registerUser(@RequestBody UserDetails userDetails) {
			userDetailList.add(userDetails);
	     	return new ResponseEntity<String>("User Created successfully", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Validate user login", notes = "The service responsible to valiadte/authorize user credentials.", response = String.class,tags={ "Register User", })
	@ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "Success", response = String.class),
	        @ApiResponse(code = 404, message = "Not found", response = Void.class),
	        @ApiResponse(code = 500, message = "Internal Server Error", response = com.digitals.admin.response.entities.Error.class) })
	@RequestMapping(value = "/user/{userName}/{password}", method = RequestMethod.GET,  consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<String> validateUser(@PathVariable("userName") String userName, @PathVariable("password")String password) {
		if (!CollectionUtils.isEmpty(userDetailList.toArray())) {
		for (UserDetails userDetail: userDetailList) {
			if (userDetail!=null && userDetail.getPassword().equals(password) && (userDetail.getEmail().equalsIgnoreCase(userName))) {
				 return new ResponseEntity<String>("User successfully loggedin", HttpStatus.OK);
			}
		}
		}
		 return new ResponseEntity<String>("Login failed try again", HttpStatus.OK); 	
	}
}
