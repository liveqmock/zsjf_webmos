package com.cattsoft.pub.commthread;

public class TestThread {
	
	private static ThreadMessageCenter resource=null;
	private static ThreadExecute[] threadExecute=null;
	
	public synchronized void put(String id){
		if(resource==null){
			resource=new ThreadMessageCenter();
			resource.start();
		}
		if(threadExecute==null){
			threadExecute=new ThreadExecute[8];
			for(int i=0;i<threadExecute.length;i++){
				if(threadExecute[i]==null){
					threadExecute[i]=new ThreadExecute(resource,"ThreadName="+i);
					threadExecute[i].start();
				}
			}
		}
		resource.addNewData(id);
	}
	
	public static void main(String args[]){
		String id="0";
		
		TestThread test=new TestThread();
		for(int i=0;i<10;i++){
		test.put(i+"");
		}
	}

}
