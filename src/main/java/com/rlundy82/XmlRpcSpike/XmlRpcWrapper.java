package com.rlundy82.XmlRpcSpike;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class XmlRpcWrapper {

	XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
	XmlRpcClient client = new XmlRpcClient();
	
	XmlRpcWrapper(URL url) throws MalformedURLException {
		this.config.setServerURL(url);
		this.client.setConfig(config);
	}
	
//	public Object runCommand(String command, Object[] params) throws XmlRpcException {
	public Object runCommand(String command) throws XmlRpcException {
		Object[] params = new Object[]{};
		Object result = client.execute(command, params);
		return result;
	}
}
