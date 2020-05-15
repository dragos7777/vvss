package tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.model.TasksOperations;
import tasks.services.TasksService;

import java.util.Date;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MockitoTasksService {

    private ArrayTaskList tasksList;
    private Task t1;



    @BeforeEach
    public void setUp(){
        t1 = mock(Task.class);
        Mockito.when(t1.getRepeatInterval()).thenReturn(2);
        tasksList= mock(ArrayTaskList.class);




    }

    @Test
    public void test_get_interval(){
        TasksService tasksService=new TasksService(tasksList);
        assertEquals(tasksService.getIntervalInHours(t1),"00:00");
    }


}
