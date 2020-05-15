package tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.model.ArrayTaskList;
import tasks.model.Task;
import tasks.model.TasksOperations;
import tasks.services.TaskIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class TopDownTaskIOArrayTaskList {
    private ArrayTaskList tasksList;
    private Task t1,t2;
    private File savedTasksFile;



    @BeforeEach
    public void setUp(){
        savedTasksFile = new File("src/main/resources/data/test2.txt");
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



        tasksList= new ArrayTaskList();
        tasksList.add(t1); tasksList.add(t2);

    }

    @Test
    public void test_write_text(){


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

    @Test
    public void test_read_text() throws IOException {
        ArrayTaskList ts = new ArrayTaskList();
        TaskIO.readText(ts,savedTasksFile);
        assertEquals(ts.getTask(1).getTitle(),"titlu2");
        assertEquals(ts.size(),2);
    }
}
