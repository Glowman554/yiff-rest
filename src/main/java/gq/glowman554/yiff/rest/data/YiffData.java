package gq.glowman554.yiff.rest.data;

import gq.glowman554.reflex.ReflexField;
import gq.glowman554.reflex.types.ReflexCustomArray;
import gq.glowman554.reflex.types.ReflexStringArray;
import gq.glowman554.starlight.StarlightAutoToString;

public class YiffData
{
	@SuppressWarnings("unchecked")
	@ReflexField(optional = true)
	public ReflexCustomArray<YiffImage> images = ReflexCustomArray.from(() -> new YiffImage());
	@ReflexField(optional = true)
	public String $schema;
	@ReflexField
	public boolean success;
	
	@ReflexField(optional = true)
	public String error;
	@ReflexField(optional = true)
	public YiffInfo info = new YiffInfo();

	public static class YiffImage extends StarlightAutoToString
	{
		@ReflexField
		public ReflexStringArray artists;
		@ReflexField
		public ReflexStringArray sources;
		@ReflexField
		public int width;
		@ReflexField
		public int height;
		@ReflexField
		public String url;
		@ReflexField
		public String yiffMediaURL;
		@ReflexField
		public String type;
		@ReflexField
		public String name;
		@ReflexField
		public String id;
		@ReflexField
		public String ext;
		@ReflexField
		public int size;
		@ReflexField
		public String shortURL;
	}

	public static class YiffInfo extends StarlightAutoToString
	{
		@ReflexField
		public int limit;
		@ReflexField
		public int remaining;
		@ReflexField
		public int reset;
		@ReflexField
		public int resetAfter;
		@ReflexField
		public int retryAfter;
		@ReflexField
		public String precision;
		@ReflexField
		public boolean global;
	}
}
