package com.comptel.mc.node.examples.simplebusinesslogic;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import com.comptel.mc.node.EventRecordService;
import com.comptel.mc.node.Field;
import com.comptel.mc.node.NodeContext;
import com.comptel.mc.node.EventRecord;


/**
 * Unit test node application
 */
public class NodeApplicationTest {
  
    private NodeApplication app;

    @Before
    public void setUp() throws Exception {
        app = new NodeApplication();
    }

    @After
    public void cleanUp() throws Exception {
        // Clean up after test
    }

    @Test
    public void testProcess() throws Exception {
        // mock the event record service as well as event record
 /*       EventRecordService eventRecordService = mock(EventRecordService.class);
        EventRecord mockOut = mock(EventRecord.class);
        Field f = mock(Field.class);
        f.setName("Message");
        when(eventRecordService.newRecord()).thenReturn(mockOut);
        when(mockOut.addField("Message")).thenReturn(f);
    
        // Mock context. Parameter "Greeting" will have value "Hello"
        NodeContext ctx = mock(NodeContext.class);
        when(ctx.getParameter("Greeting")).thenReturn("Hello");

        // inject the service
        app.setService(eventRecordService);

        // call init
        app.init(ctx);

        EventRecord mockIn = mock(EventRecord.class);
        Field input = mock(Field.class);
        when(input.getName()).thenReturn("Name");
        when(input.getValue()).thenReturn("Henri");
        when(mockIn.getField("Name")).thenReturn(input);

        app.process(mockIn);

        // verify that output er was written
        verify(eventRecordService).write("OUT", mockOut);

        // verify that output fields are ok
        verify(f).setValue("Hello Henri");

        app.end();*/
    }
}
