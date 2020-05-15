package tasks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.model.TasksOperations;
import tasks.services.TasksService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class MockitoTasksOperations {

    private TasksOperations tasksOperations;
    private Task t1,t2;



    @BeforeEach
    public void setUp(){
        ArrayList<Task> tasks;
        ObservableList<Task> tasksList ;
        tasks = new ArrayList<>();
        t1 = mock(Task.class);
        t2 = mock(Task.class);
        tasks.add(t1); tasks.add(t2);
        tasksList =  FXCollections.observableArrayList(tasks);
        tasksOperations = new TasksOperations(tasksList);
    }

    @Test
    public void test_incoming(){
        Date d= new Date(1997,07,07,11,11);
        Date d1= new Date(1998,07,07,11,11);
        Date d2= new Date(2000,07,07,11,11);
        Date d3= new Date(1999,07,07,11,11);
        Mockito.when(t1.nextTimeAfter(d)).thenReturn(d1);
        Mockito.when(t2.nextTimeAfter(d)).thenReturn(d2);
        Mockito.when(t1.getTitle()).thenReturn("t1");
        Iterable<Task> filtered= tasksOperations.incoming(d,d3);
        List<Task> result = new ArrayList<>();
        filtered.forEach(result::add);
        assertEquals(result.size(),1);
        assertFalse(result.contains(t2));
        assertTrue(result.contains(t1));

    }
}
