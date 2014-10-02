package com.gshoogeveen.security.encryption;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class SubstitutionCipher
{
	public static Character[] encrypt(Scanner input, HashMap<Character, Character> mapping)
	{
		String s;
		LinkedList<Character> output = new LinkedList<Character>();
		
		while (input.hasNext())
		{
			s = input.next();
			for(char c: s.toCharArray())
				output.add(mapping.get(c));
		}
		
		Character[] outputArray = new Character[output.size()];
		output.toArray(outputArray);
		input.close();
		return outputArray;
	}
	
	public static HashMap<Character,Character> rotateMapping(char[] alphabet, int rot)
	{
		HashMap<Character, Character> mapping = new HashMap<Character, Character>();
		for(int i = 0; i < alphabet.length; i++)
		{
			int x = i+ rot;
			while(alphabet.length<=x)
				x -= alphabet.length;
			while(x<0)
				x += alphabet.length;
			mapping.put(alphabet[i], alphabet[x]);
			
		}
		return mapping;
	}
	
	public static HashMap<Character, Integer> countCharacters(Scanner input)
	{
		String s;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		while (input.hasNext())
		{
			s = input.next();
			for(char c: s.toCharArray())
			{
				Integer value = map.get(c);
				if(value == null)
					value = new Integer(1);
				else
					value ++;
				map.put(c, value);
				
			}
		}
		return map;
		
	}
}
