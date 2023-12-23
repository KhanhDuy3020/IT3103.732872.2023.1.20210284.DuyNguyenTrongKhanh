// Nguyễn Trọng Khánh Duy - 20210284
package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks;

	public String getArtist() {
		return artist;
	}

	public CompactDisc(String title, String artist) {
		super(title);
		this.artist = artist;
	}

	public CompactDisc(String title, String category, int length, float cost, String artist) {
		super(title, category, length, cost);
		this.artist = artist;
	}

	public void addTrack(Track newTrack) {
		if (tracks.contains(newTrack)) {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The disc has been added");
		} else {
			tracks.add(newTrack);
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Add successfull");
		}
	}

	public void removeTrack(Track aTrack) {
		if (tracks.contains(aTrack)) {
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("Remove successfull");
		} else {
			tracks.add(aTrack);
			System.out.print("Nguyen Trong Khanh Duy - 20210284: ");
			System.out.println("The disc has not been added");
		}
	}

	public float getLength() {
		float totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}

	@Override
	public String toString() {
		return "CD - " + super.getTitle() + " - " + category + " - " + artist + " - " + length + " : " + cost + "$";
	}
	public void play() {	// Nguyễn Trọng Khánh Duy - 20210284
		System.out.println("Playing CompactDisc of artist: " + artist);
		System.out.println("Number of tracks: " + tracks.size());
		int i = 1;
		for (Track track : tracks) {
			System.out.println("Play track number" + i);
			System.out.println("Track title: " + track.getTitle());
			System.out.println("Track length: " + track.getLength());
			i++;
		}
	}
}
