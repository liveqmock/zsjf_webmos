package com.cattsoft.pub.commthread;

import java.util.ArrayList;
import java.util.List;

public class ThreadMessageCenter  extends Thread{
	 
	    private List lData = new ArrayList();
	    private volatile boolean stop = false;
	    public synchronized String getData(String threadName) {
	        if (lData.isEmpty()) {
	            try {
	               System.out.println("wait"+threadName);
	                wait();
	            }
	            catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        else {
	            String str = (String) lData.get(0);
	            lData.remove(0);
	            return str;
	        }
	        return null;
	    }

	    public synchronized void addNewData(String date) {
	        lData.add(date);
	        notify();
	    }

	    public synchronized void setNewData(List list) {
	        this.lData = list;
	    }

	    public synchronized int getDataSize() {
	        return lData.size();
	    }

	    public void run() {
	        while (!stop) {
	            try {
	                sleep(10);
	            }
	            catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public void requestStop() {
	        stop = true;
	    }
}
