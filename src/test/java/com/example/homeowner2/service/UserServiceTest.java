package com.example.homeowner2.service;

import com.example.homeowner2.domain.User2;
import com.example.homeowner2.userrepo.UserRepo;
import com.sun.istack.Nullable;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class) //Tells Spring that this clas needs mockito
public class UserServiceTest {

    @InjectMocks // Tells Spring that class will be injecting mockito test dependency and to create a mock object
    private UserService service;

    @Mock // Creates a mock private UserRepo Object
    private UserRepo repo;

    // Dummy UserData for the tests to use
    User2 userDummyData1 = new User2("John", "Smith", "johnsmith@hotmail.com", 2L, 300000L);
    User2 userDummyOutput1= new User2(1l, "John", "Smith", "johnsmith@hotmail.com", 3L, 300000L);

    @Test
    public void testCreate(){
        //GIVEN TESTING DATA
        // Create a new user object to feed the service class into the create method
        //User usercreaterequest1 = new User("John", "Smith", "johnsmith@hotmail.com");
        // Create a new user object to compare the output of the create method in the service class against
        //User usercreateresponse1 = new User(1l, "John", "Smith", "johnsmith@hotmail.com");
        // This takes the two previous created test objects and inserts them into the mocked service.create method

        // When I enter the test data object into the create method then return the response object
        Mockito.when(this.repo.saveAndFlush(userDummyData1)).thenReturn(userDummyOutput1);

        // Compare that the response is equal to the expected outcome of the method
        Assert.assertEquals(userDummyOutput1, this.service.create(userDummyData1));
    }
    @Test
    public void testGetall(){
        List<User2> testUsers = new ArrayList<>();
        testUsers.add(userDummyData1);
        Mockito.when(this.repo.findAll()).thenReturn(testUsers);
        assertEquals(testUsers, this.service.getAll());
    }

    @Test
    public void testGetOne(){
        Long id=1L;

        Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(userDummyOutput1));
        Assert.assertEquals(userDummyOutput1, this.service.getById(id));
    }

    //User userDummyData1 = new User("John", "Smith", "johnsmith@hotmail.com");
    //    User userDummyOutput1= new User(1l, "John", "Smith", "johnsmith@hotmail.com");


}