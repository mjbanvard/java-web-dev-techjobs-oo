package org.launchcode.techjobs_oo.Tests;

import static org.junit.jupiter.api.Assertions.*;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import javax.naming.Name;

public class JobTest {

//    @Before
    Job george;
    Job henry;

    public JobTest() {
        george = new Job();
        henry = new Job();
    }

    @Test
    public void testSettingJobId() {
        //assertTrue( george.getId() != henry.getId() );
        assertTrue( 1 == Math.abs( george.getId() - henry.getId() ) );
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
    public void testJobsForQuality() {
        Job one = new Job( "Ape Handler", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job two = new Job( "Ape Handler", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(one.getId() == two.getId());
    }

    @Test
    public void itShouldStartAndEndWithAnEmptyLine() {
        Job doesJobIncludeSpace = new Job( "Ape Handler", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(doesJobIncludeSpace.toString().startsWith(" "));
        assertTrue(doesJobIncludeSpace.toString().endsWith( " " ));
    }

    @Test
    public void itShouldMatchExample() {
        Job isJobStructureCorrectly = new Job( "Ape Handler", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(isJobStructureCorrectly.toString().contains("ID: "));
        assertTrue(isJobStructureCorrectly.toString().contains("Name: "));
        assertTrue(isJobStructureCorrectly.toString().contains("Employer: "));
        assertTrue(isJobStructureCorrectly.toString().contains("Location: "));
        assertTrue(isJobStructureCorrectly.toString().contains("Position Type: "));
        assertTrue(isJobStructureCorrectly.toString().contains("Core Competency: "));
    }

    @Test
    public void missingData() {
        Job missingEntry = new Job( "Ape Handler", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency());

        assertTrue(missingEntry.toString().contains("Data not available"));
    }

    @Test
    public void emptyObject() {
        Job emptyObject = new Job();

//        assertNotNull(emptyObject.getId());
//        assertNull(emptyObject.getName());
//        assertNull(emptyObject.getEmployer());
//        assertNull(emptyObject.getLocation());
//        assertNull(emptyObject.getPositionType());
//        assertNull(emptyObject.getCoreCompetency());
        assertTrue(emptyObject.toString() == "OOPS! This job does not seem to exist.");
    }
}
