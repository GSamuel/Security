import java.util.Scanner;

import com.gshoogeveen.security.encryption.Char;
import com.gshoogeveen.security.encryption.LoopList;

public class SecondMain
{
	public static void main(String[] args)
	{
		LoopList<Char> list = new LoopList<Char>();
		list.add(Char.S);
		list.add(Char.N);
		list.add(Char.O);
		list.add(Char.W);
		list.add(Char.D);
		list.add(Char.E);
		list.add(Char.N);
		
		Scanner input = Main.createScanner("as3_1_cipher.txt");
		while(input.hasNext())
		{
			String s = input.next();
			for(char c: s.toCharArray())
			{
				System.out.print(Char.charToChar(c).previous(list.next().ordinal()));
			}
		}

		
	}
}
