// Nguyễn Trọng Khánh Duy 20210284
package hust.soict.hedspi.aims.screen;

import java.util.*;

import javax.swing.JOptionPane;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	private static int nbCD = 0;

	public CompactDisc(String title, String category, float cost, String artist) {
		super();
		this.id = ++nbCD;
		this.artist = artist;
		this.title = title;
		this.category = category;
		this.cost = cost;

	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track is already in the list");
		} else {
			tracks.add(track);
			System.out.println("Track added title: ' " + getTitle() + "'");
		}
	}

	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Track removed title: ' " + getTitle() + "'");
		} else {
			System.out.println("Track is not in the list");
		}
	}

	public int getLength() {
		int length = 0;
		for (Track track : tracks) {
			length += track.getLength();
		}
		return length;
	}

	// Phương thức play()
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD's total length: " + this.getLength());
		JOptionPane.showMessageDialog(null,
				"Playing CD : " + this.getTitle() + "\nCD's total length: " + this.getLength(), "",
				JOptionPane.INFORMATION_MESSAGE);
		for (Track track : tracks) {
			track.play();
		}
	}

	// toString() method
	public String toString() {
		return "CD_id: " + getId() + " //- Title: " + getTitle() + " //- Artist: " + getArtist() + " //- Category:  "
				+ getCategory() + " //- Length:  " + getLength() + " //- Cost:  " + getCost() + " $";
	}
}
