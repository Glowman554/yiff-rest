package gq.glowman554.yiff.rest;

import java.io.IOException;

import gq.glowman554.reflex.Reflex;
import gq.glowman554.reflex.loaders.ReflexJsonLoader;
import gq.glowman554.yiff.rest.data.YiffData;
import gq.glowman554.yiff.rest.data.YiffData.YiffImage;
import gq.glowman554.yiff.rest.utils.HttpClient;
import net.shadew.json.JsonSyntaxException;

public class Yiff
{
	private static String[] methods = new String[] {"furry/fursuit", "animals/birb", "animals/blep", "furry/boop", "furry/cuddle", "furry/flop", "furry/hold", "furry/howl", "furry/hug", "furry/kiss", "furry/lick", "furry/propose", "furry/bulge", "furry/yiff/gay", "furry/yiff/straight", "furry/yiff/lesbian", "furry/yiff/gynomorph",};
	private static int limit = 5;
	
	public static YiffImage[] request(String method) throws IllegalArgumentException, IllegalAccessException, JsonSyntaxException, IOException, InterruptedException
	{
		for (String m : methods)
		{
			if (m.equals(method))
			{
				while (true)
				{
					YiffData result = (YiffData) new Reflex(new ReflexJsonLoader(HttpClient.get(String.format("https://v2.yiff.rest/%s?limit=%d&notes=disabled", method, limit)))).load(new YiffData());

					if (!result.success)
					{
						if (result.info != null)
						{
							// System.out.println(result.info);
							// System.out.println(result.error);
							
							Thread.sleep(result.info.retryAfter * 1000);
						}
					}
					else
					{
						YiffImage[] images = new YiffImage[result.images.len()];
						
						for (int i = 0; i < result.images.len(); i++)
						{
							images[i] = result.images.get(i);
						}
						
						return images;
					}
				}
			}
		}

		throw new IllegalArgumentException("Method " + method + " unknown!");
	}

	public static YiffImage[] request() throws IllegalArgumentException, IllegalAccessException, JsonSyntaxException, IOException, InterruptedException
	{
		return request(methods[0]);
	}
	
	public static String[] getMethods()
	{
		return methods;
	}
	
	public static int getLimit()
	{
		return limit;
	}
	
	public static void setLimit(int limit)
	{
		Yiff.limit = limit;
	}
}
