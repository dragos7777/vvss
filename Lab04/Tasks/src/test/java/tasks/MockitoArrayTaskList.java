package tasks;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MockitoArrayTaskList {
    private ArrayTaskList tasksList ;

    private Task task1;

    @BeforeEach
    public void setUp(){
        task1 = mock(Task.class);
        tasksList =  new ArrayTaskList();
    }

    @Test
    public void test_add(){

        tasksList.add(task1);
        assertEquals(1,tasksList.size());

        tasksList.remove(task1);
        assertEquals(0,tasksList.size());

    }

    @Test
    public void test_get(){
        tasksList.add(task1);
        Mockito.when(task1.getTitle()).thenReturn("titlu");
        assertEquals(tasksList.getTask(0).getTitle(),"titlu");
    }
}
