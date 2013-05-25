package com.hatrick.resource;

import java.util.HashMap;

import com.hatrick.graphic.Map;

public class MapResource {
	public static HashMap<Integer,short[][]> floors = new HashMap<Integer,short[][]>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = -7214051255436555730L;

		{
			put(Map.SNOW,new short[][]{
				{10021,10021,10030,10023,10023}
				,{10021,10021,10015,10023,10023}
				,{10022,10022,10015,10024,10024}
				,{10022,10022,10030,10024,10024}
			});
		}
	};
	public static HashMap<Integer,short[][]> assets = new HashMap<Integer,short[][]>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = -5292153081342635988L;

		{
			put(Map.SNOW,new short[][]{
				{10013,10013,10013}
				,{10013,10013,10013}
			});
		}
	};
}
