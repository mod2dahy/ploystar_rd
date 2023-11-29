package com.ploystar.server.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.ploystar.server.Server;

import junit.framework.Assert;

public class ServerTest {
	Server appServer;

	@Before
	public void setUp() throws Exception {
	
		

	}

	@Test(expected = Server.MissingFileException.class)
	public void testFileExist() {
		Server firstServer = new Server(9595, " 2232");
	}

	
	@Test
	public void Testing()
	{
		
		String fileName = "testing";///for Testing propuse
		
		Server firstServer = new Server(9595, fileName);
		firstServer.loadAndSendData();
		assertEquals(10, firstServer.getTotalLines());

	}
}
