package tasks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.model.TasksOperations;
import tasks.services.TaskIO;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MockitoTaskIO {
    private ArrayTaskList tasksList;
    private Iterator<Task> iterator;
    private TasksOperations tasksOperations;
    private Task t1,t2;



    @BeforeEach
    public void setUp(){
        Date d= new Date(1997,07,07,11,11);
        t1 = mock(Task.class);
        t2 = mock(Task.class);
        Mockito.when(t1.isActive()).thenReturn(true);
        Mockito.when(t1.getTitle()).thenReturn("titlu1");
        Mockito.when(t1.isRepeated()).thenReturn(false);
        Mockito.when(t1.getTime()).thenReturn(d);
        Mockito.when(t1.getStartTime()).thenReturn(d);


        Mockito.when(t2.isActive()).thenReturn(true);
        Mockito.when(t2.getTitle()).thenReturn("titlu2");
        Mockito.when(t2.isRepeated()).thenReturn(false);
        Mockito.when(t2.getTime()).thenReturn(d);
        Mockito.when(t2.getStartTime()).thenReturn(d);


        iterator = mock(Iterator.class);
        Mockito.when(iterator.hasNext()).thenReturn(true, true,  false);
        Mockito.when(iterator.next()).thenReturn(t1)
                .thenReturn(t2);

        tasksList= mock(ArrayTaskList.class);
        Mockito.when(tasksList.iterator()).thenReturn(iterator);

        Mockito.when(tasksList.getTask(0)).thenReturn(t2);
        Mockito.when(tasksList.size()).thenReturn(2);


    }
    @Test
    public void test_string_builder(){
        assertEquals(TaskIO.getFormattedTask(t1),"\"titlu1\" at [3897-08-07 11:11:00.000]");
    }

    @Test
    public void test_write_text(){
        File savedTasksFile = new File("src/main/resources/data/test.txt");

        try{
        TaskIO.writeText(tasksList,savedTasksFile);}
        catch (IOException e ){
            System.out.println(e);
        }

        try {

            Scanner myReader = new Scanner(savedTasksFile);

                String data = myReader.nextLine();
                assertEquals(data,"\"titlu1\" at [3897-08-07 11:11:00.000]");

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
