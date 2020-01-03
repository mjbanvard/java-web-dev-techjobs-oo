package org.launchcode.techjobs_oo.Tests;

import static org.junit.jupiter.api.Assertions.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import javax.naming.Name;


public class JobTest {
    //@Before
    Job george;
    Job henry;

    public JobTest() {
        george = new Job();
        henry = new Job();
    }

    @Test
    public void testSettingJobId() {
        //assertTrue( george.getId() != henry.getId() );
        assertTrue(Math.abs(george.getId() - henry.getId()) == 1);

    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Job checker = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assert(checker.getName() instanceof String);
        assert(checker.getEmployer() instanceof Employer);
        assert(checker.getLocation() instanceof Location);
        assert(checker.getPositionType() instanceof PositionType);
        assert(checker.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForquality() {
        Job one = new Job( "Ape Handler", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job two = new Job( "Ape Handler", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(one.getId() == two.getId());
    }
}
