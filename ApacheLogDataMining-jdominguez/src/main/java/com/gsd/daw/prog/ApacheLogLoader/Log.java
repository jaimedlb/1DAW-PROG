package com.gsd.daw.prog.ApacheLogLoader;

public class Log {
private String ip;
private String timeStamp;
private String request;
private String result;
private String bytes;
private String ua;
public Log(String[] log) {
	super();
	this.ip = log[0];
	this.timeStamp = log[1];
	this.request = log[2];
	this.result = log[3];
	this.bytes = log[4];
	this.ua = log[5];
}


}
