package com.cattsoft.pub.commthread;

import com.cattsoft.pub.util.StringUtil;

public class ThreadExecute extends Thread {
	private ThreadMessageCenter resource = null;

	private volatile boolean stop = false;

	private String id = null;

	public ThreadExecute(ThreadMessageCenter resource, String threadName) {
		super(threadName);
		this.resource = resource;
	}

	public void run() {
		while (!stop) {
			System.out.println("thread="+getName());
			id = resource.getData(getName());
			
			if (StringUtil.toString(id).length() > 0) {
				System.out.println("id="+id+"threaname="+getName());
				// 调用业务逻辑
			}

		}
	}
}
