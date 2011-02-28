package com.rlundy82.XmlRpcSpike;

import org.apache.xmlrpc.XmlRpcException;

public class Spike {
	XmlRpcWrapper xwrapper;
	
	Spike(XmlRpcWrapper xwrapper) {
		this.xwrapper = xwrapper;
	}
	
	public void SpikeItOut() {
		String command = "echo";
		//Object[] params = new Object[]{new Integer(33), new Integer(9)};
		try {
			Object result = xwrapper.runCommand(command);
		} catch (XmlRpcException e) {
			System.out.println("Could not run command " + command);
			e.printStackTrace();
		}
	}
}
