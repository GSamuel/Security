import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.gshoogeveen.security.encryption.SubstitutionCipher;

public class Main
{

	public static void main(String[] args)
	{

		String s = "abcdefghijklmnopqrstuvwxyz";
		char[] alphabet = s.toCharArray();

		ArrayList<HashMap<Character, Character>> list = new ArrayList<HashMap<Character, Character>>();
		char[] keys = "gslmrh".toCharArray();
		char[] values = "TAOINS".toCharArray();
		function(keys, values, new HashMap<Character, Character>(), list);

		for (HashMap<Character, Character> mapje : list)
		{
			Character[] output;
			mapje.put('v', 'E');

			output = SubstitutionCipher.encrypt(
					createScanner("as2_2_cipher.txt"), mapje);
			
			for(int i=0; i<output.length;i++)
			{
				if(output[i]!= null)
					System.out.print(output[i]);
				else
					System.out.print('X');
			}
				
			System.out.println();
		}

		/*
		 * for (Character c : output) System.out.print(c); System.out.println();
		 */

		/*
		 * Scanner input = createScanner("as2_2_cipher.txt");
		 * 
		 * HashMap<Character, Integer> map =
		 * SubstitutionCipher.countCharacters(input);
		 * 
		 * for(char c : alphabet) { System.out.println(c+" : "+map.get(c)); }
		 */

	}

	public static int function(char[] keys, char[] values,
			HashMap<Character, Character> map,
			ArrayList<HashMap<Character, Character>> list)
	{
		if (keys.length == 1)
		{
			map.put(keys[0], values[0]);
			list.add(map);
			return 0;
		}

		for (int i = 0; i < keys.length; i++)
		{
			HashMap<Character, Character> newMap = (HashMap<Character, Character>) map
					.clone();
			newMap.put(keys[0], values[i]);
			char[] newKeys = new char[keys.length - 1];
			char[] newValues = new char[values.length - 1];
			for (int j = 1; j < keys.length; j++)
			{
				System.out.println(j + " " + keys.length);
				newKeys[j - 1] = keys[j];
				if (j < i)
					newValues[j] = values[j];
				else
					newValues[j - 1] = values[j];
				function(newKeys, newValues, newMap, list);
			}
		}
		return 0;
	}

	public static Scanner createScanner(String s)
	{
		try
		{
			return new Scanner(new File(s));
		} catch (FileNotFoundException e)
		{
			System.exit(1234567890);
		}
		return null;
	}

}
