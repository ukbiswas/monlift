package me.didia.monlift.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import me.didia.monlift.helper.ToJSON;
import me.didia.monlift.securities.AuthentificationErrorException;
import me.didia.monlift.securities.AuthentificationManager;
import me.didia.monlift.securities.Session;

@Path("/oauth")
public class Oauth {
	
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public Response login(DataSent user){
		AuthentificationManager am = AuthentificationManager.getInstance();
		JSONArray jsonResponse = new JSONArray();
		
		Session session = new Session();
		String email = user.getEmail();
		String password = user.getPassword();
		
		try {
			session = am.createSession(email,password);
		} catch (AuthentificationErrorException e) {
			e.printStackTrace();
		}
		if(session!=null){
			jsonResponse = ToJSON.sessionToJSON(session);
			
		}
		String returnString=jsonResponse.toString();
		return Response.ok(returnString).build();
	}
	
	@POST
	@Path("/signup")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON }) 
	public Response signup(){
		return null;
		
	}
}


class DataSent{
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

