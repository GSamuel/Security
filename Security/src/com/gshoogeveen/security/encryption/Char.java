package com.gshoogeveen.security.encryption;

public enum Char
{
	A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
	public static Char charToChar(char c)
	{
		int num = c;
		if (num >= 97 && num <= 122)
		{
			num -= 97;
			return Char.values()[num];// 97 122
		}
		return null;
	}
	
	public Char next()
	{
		return next(1);
	}
	
	public Char previous()
	{
		return previous(1);
	}
	
	public Char next(int count)
	{
		int num = this.ordinal() +count;
		while(num >= Char.values().length)
			num -= Char.values().length;
		return Char.values()[num];
	}
	
	public Char previous(int count)
	{
		int num = this.ordinal() -count;
		while(num < 0)
			num += Char.values().length;
		return Char.values()[num];
	}

	public static char charToChar(Char c)
	{
		int num = c.ordinal();
		if (num >= 0 && num <= 25)
			return (char) (num + 97);
		return ' ';
	}
}
