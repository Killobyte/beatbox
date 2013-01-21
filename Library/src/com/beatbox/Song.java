package com.beatbox;

import org.json.JSONException;
import org.json.JSONObject;

public class Song {
	private String title;
	private String artist;

	public Song() {
		title = "";
		artist = "";
	}

	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public JSONObject toJSON() {
		JSONObject song = new JSONObject();
		try {
			song.put("title", title);
			song.put("artist", artist);
		} catch (JSONException e) {
			System.err.println("Error creating JSONObject for " + artist
					+ " - " + title);
			e.printStackTrace();
		}
		return song;
	}
}
