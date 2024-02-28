package com.gsd.daw.prog.ApacheLogLoader;

public class Log {
private String ip;
private String timeStamp;
private String request;
private String result;
private String bytes;
private String ua;
public Log(String ip, String timeStamp, String request, String result, String bytes, String ua) {
	super();
	this.ip = ip;
	this.timeStamp = timeStamp;
	this.request = request;
	this.result = result;
	this.bytes = bytes;
	this.ua = ua;
}


}
