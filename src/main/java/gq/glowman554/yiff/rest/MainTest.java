package gq.glowman554.yiff.rest;

import java.io.IOException;

import gq.glowman554.reflex.Reflex;
import gq.glowman554.yiff.rest.data.YiffData.YiffImage;
import net.shadew.json.JsonSyntaxException;

public class MainTest
{
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, JsonSyntaxException, IOException, InterruptedException
	{
		// Reflex.setDebug(true);
		for (int x = 0; x < 20; x++)
		{
			YiffImage[] images = Yiff.request();

			for (YiffImage i : images)
			{
				System.out.println(i);
			}
		}
	}
}
