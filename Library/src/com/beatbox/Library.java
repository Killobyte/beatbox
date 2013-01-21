package com.beatbox;

import java.util.HashMap;

public class Library {
	private HashMap<String, Song> library;

	public Library() {
		library = new HashMap<String, Song>();
	}

	public void addSong(Song song) {
		library.put(song.getArtist(), song);
	}

	public HashMap<String, Song> getLibrary() {
		return library;
	}
}