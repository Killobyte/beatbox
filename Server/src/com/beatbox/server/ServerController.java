package com.beatbox.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.beatbox.lib.Library;
import com.beatbox.lib.song.Song;

public class ServerController {
	private Library library;

	public ServerController() {
		library = new Library();

		System.out.print("Enter the source folder for your library: ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String filepath = null;
		try {
			filepath = br.readLine();
		} catch (IOException e) {
			System.err.println("Error reading line from user");
			e.printStackTrace();
		}

		library.buildFromFilepath(new File(filepath));

		for (String artist : library.getArtists()) {
			for (Song song : library.getSongs(artist)) {
				System.out.println(artist + " - " + song.getTitle());
			}
		}
	}

	public static void main(String[] argv) {
		@SuppressWarnings("unused")
		ServerController main = new ServerController();
	}
}
