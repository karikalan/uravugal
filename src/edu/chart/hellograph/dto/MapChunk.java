package edu.chart.hellograph.dto;

import java.util.Arrays;

import edu.chart.hellograph.domain.World;

public class MapChunk {
	private World[] dataSaveArray;

	/*
	 * private World[] dataDeleteArray; private World[] dataUpdateArray;
	 */
	public World[] getDataSaveArray() {
		return dataSaveArray;
	}

	public void setDataSaveArray(World[] dataSaveArray) {
		this.dataSaveArray = dataSaveArray;
	}
	/*
	 * public World[] getDataDeleteArray() { return dataDeleteArray; } public
	 * void setDataDeleteArray(World[] dataDeleteArray) { this.dataDeleteArray =
	 * dataDeleteArray; } public World[] getDataUpdateArray() { return
	 * dataUpdateArray; } public void setDataUpdateArray(World[]
	 * dataUpdateArray) { this.dataUpdateArray = dataUpdateArray; }
	 */

	@Override
	public String toString() {
		return "MapChunk [dataSaveArray=" + Arrays.toString(dataSaveArray) + "]";
	}
	
	

}
