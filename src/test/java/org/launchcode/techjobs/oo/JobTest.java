package org.launchcode.techjobs.oo;

import org.junit.Test;
import org.junit.Assert;

import java.lang.reflect.Method;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        Assert.assertNotEquals(job1,job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertTrue(testJob.getEmployer() instanceof Employer);
        Assert.assertTrue(testJob.getLocation() instanceof Location);
        Assert.assertTrue(testJob.getPositionType() instanceof PositionType);
        Assert.assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertTrue(testJob.getName() instanceof String);

        Assert.assertEquals(testJob.getEmployer().getValue(),"ACME");
        Assert.assertEquals(testJob.getLocation().getValue(),"Desert");
        Assert.assertEquals(testJob.getPositionType().getValue(),"Quality control");
        Assert.assertEquals(testJob.getCoreCompetency().getValue(),"Persistence");
        Assert.assertEquals(testJob.getName(),"Product tester");
    }
    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        int firstLine = job.toString().indexOf(System.lineSeparator());
        int toStringLength = job.toString().length();
        int lastLine = job.toString().lastIndexOf(System.lineSeparator());

        Assert.assertEquals(firstLine,0);
        Assert.assertEquals(toStringLength,120);
        Assert.assertEquals(lastLine,119);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String correctLabelsAndDataFormat =
                System.lineSeparator() +
                "ID: " + job.getId() + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                System.lineSeparator();

        Assert.assertEquals(job.toString(),correctLabelsAndDataFormat);
    }

    @Test
    public void testToStringHandlesEmptyField(){

        Job job = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String toStringWithEmptyField =
                System.lineSeparator() +
                "ID: " + job.getId() + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                System.lineSeparator();

        Assert.assertEquals(toStringWithEmptyField,job.toString());
    }
}
