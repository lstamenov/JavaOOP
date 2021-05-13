package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    Database database;
    Person[] people;

    @Before
    public void initializeDatabase() throws OperationNotSupportedException {
        people = new Person[]{new Person(1, "First"),
                new Person(2, "Second"), new Person(3, "Third")};
        database = new Database(people);
    }

    @Test
    public void testDatabaseConstructorWithCorrectValues(){
        Assert.assertArrayEquals(people, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithEmptyArray() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThanRequiredElements() throws OperationNotSupportedException {
        database = new Database(new Person[18]);
    }

    @Test
    public void testAddMethodWithCorrectPersonObject() throws OperationNotSupportedException {
        Person person = new Person(4, "Fourth");
        database.add(person);
        Assert.assertEquals(person, database.getElements()[3]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodWithNullPersonObject() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testRemoveMethodWithNonEmptyArray() throws OperationNotSupportedException {
        Person expectedPerson = database.getElements()[1];
        database.remove();
        Assert.assertEquals(expectedPerson, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveMethodWithEmptyArray() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.remove();
    }

    @Test
    public void testFindByUsernameWithExistingUser() throws OperationNotSupportedException {
        Assert.assertEquals(people[0], database.findByUsername(people[0].getUsername()));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithoutExistingUsername() throws OperationNotSupportedException {
        database.findByUsername("Fifth");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNullUsername() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test
    public void testFindByIdWithCorrectId() throws OperationNotSupportedException {
        Assert.assertEquals(people[0], database.findById(people[0].getId()));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdWithNonExistingId() throws OperationNotSupportedException {
        database.findById(32);
    }
}