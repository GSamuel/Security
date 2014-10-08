package com.gshoogeveen.security.encryption;

import java.util.LinkedList;


public class LoopList<T>
{
	private LinkedList<T> list;
	private int count;
	
	public LoopList()
	{
		list = new LinkedList<T>();
		count =0;
	}
	
	public boolean add(T e)
	{
		return list.add(e);
	}
	
	public T next()
	{
		int prev = count;
		count ++;
		if(count >= list.size())
			count =0;
		return list.get(prev);
	}
}
