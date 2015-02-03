import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;

import com.rngtng.launchpad.LColor;
import com.rngtng.launchpad.Launchpad;

import processing.core.PApplet;

@SuppressWarnings("serial")
public class LaunchpadRun extends PApplet {

	Launchpad launchpad;
	int i = 0;
	boolean done = false;

	public void setup() {
		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();

		while (i < infos.length && done == false) {
			System.out.println(infos[i]);
			if (infos[i].toString().contains("Launchpad")) {
				launchpad = new Launchpad(this, infos[i].toString(),
						infos[i].toString());
				done = true;
				System.out.println("Its Ok ! " + infos[i].toString()
						+ " was selected.");
			} else {
				i++;
			}
		}

	}

	public void draw() {
		background(0);
	}

	public void launchpadGridPressed(int x, int y) {
		println("GridButton pressed at: " + x + ", " + y);
		launchpad.changeGrid(x, y, LColor.YELLOW_HIGH);
	}

}
