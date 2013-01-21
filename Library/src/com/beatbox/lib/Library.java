package com.beatbox.lib;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.beatbox.lib.song.Song;
import com.beatbox.lib.song.SongFactory;

public class Library {
	private TreeMap<String, List<Song>> library;

	public Library() {
		library = new TreeMap<String, List<Song>>();
	}

	public void addSong(Song song) {
		String key = song.getArtist();
		if (library.containsKey(key)) {
			library.get(key).add(song);
		} else {
			library.put(key, new ArrayList<Song>(Arrays.asList(song)));
		}
	}

	public void buildFromFilepath(File root) {
		if (root.isFile()) {
			Song song = SongFactory.buildSong(root);
			if (song != null) {
				addSong(song);
			}
		} else if (root.isDirectory()) {
			File[] files = root.listFiles();
			for (int i = 0; i < files.length; i++) {
				buildFromFilepath(files[i]);
			}
		}
	}

	public Set<String> getArtists() {
		SortedSet<String> artists = new TreeSet<String>(library.keySet());
		return artists;
	}

	public List<Song> getSongs(String artist) {
		return library.get(artist);
	}
}