/**
 * 
 */
package test.didia.monlift.factories;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import test.didia.monlift.AbstractTest;
import me.didia.monlift.entities.Lift;
import me.didia.monlift.factories.DuplicateValueException;
import me.didia.monlift.factories.LiftFactory;
import me.didia.monlift.requests.CreateLiftRequest;


/**
 * @author didia
 *
 */
public class LiftFactoryTest extends AbstractTest {
	
	LiftFactory liftFactory = LiftFactory.getInstance();
	private final String from = "Québec";
	private final String to = "Montréal";
	private final Double price = 15.0;
	private final String meetingPlace = "Pavillon DesjarDins, Université Laval";
	private final int totalPlace = 20;
	

	
	@Test
	public void testCreateLift()
	{
		
		CreateLiftRequest testRequest = new CreateLiftRequest();
		
		Integer id;
		try {
			id = liftFactory.createLift(testRequest);
			if(id == null)
				fail("createLift returned a null value instead of the Lift id");
			Lift newLift = liftFactory.getLiftById(id);
			if(newLift == null)
				fail("Calling getLiftById with the id returned by createLift returned a null value");
		} catch (DuplicateValueException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testGetLiftById()
	{
		
	}
	
	@Test
	public void testGetLiftsByIds()
	{
		
	}
	
	@Test
	public void testGetLiftsByUser()
	{
		
	}
	
	@Test
	public void testGetLiftsByUsers()
	{
		
	}
	
	
}