package soacc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class PoxCreator {
	/**
	 * @author Tim-Lukas Schnell (c)2009
	 * 
	 * @TO-DO: Oger komische laufende Rütung aus Kapitel 5, Astralwächterin FRAU die
	 *         andern blutrosen schneewölfe Muir :D *scherz* feuerkäfer Lava Krabbe
	 *         König Vortigerm auf Pferd
	 */
	private static final String nl = System.getProperty("line.separator");
	String anfang = "POXALC" + nl + "[HEADER]" + nl + "FileName=Player.gif" + nl + "GameClass=Character" + nl
			+ "Blend=None" + nl + "BlendAmount=0" + nl + "UseLighting=Vert" + nl + "TransparentColor=16776960" + nl
			+ "ImagePacking=IndividualFrames" + nl + "Highlightable=Yes" + nl + "CollisionHeight=101" + nl
			+ "FrameMultiplier=2" + nl + "ImageWidth=148" + nl + "ImageHeight=130" + nl + "EditorImage=0" + nl
			+ "CollisionRadius=16" + nl + "CollisionOffset=70" + nl;

	private SoA_CC parent;

	public PoxCreator(SoA_CC parent) {
		this.parent = parent;
	}

	private String actions() {
		String action = nl + "Actions=Stand,Attack1,Attack2,Attack3,BowAttack,Cast,Pain,Death,Walk,Run";
		String actionStand = nl + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
				+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
				+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
				+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl
				+ "FrameMultiplier=70";
		String actionAttack1 = nl + nl + "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
				+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
				+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
				+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
				+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6";
		String actionAttack2 = nl + nl + "[Action Attack2]" + nl + "NWFrames=33,42,51,44,37,38,39,40,END" + nl
				+ "NNFrames=41,50,59,52,45,46,47,48,END" + nl + "NEFrames=49,58,67,60,53,54,55,56,END" + nl
				+ "EEFrames=57,66,75,68,61,62,63,64,END" + nl + "SEFrames=65,74,83,76,69,70,71,72,END" + nl
				+ "SSFrames=73,82,91,84,77,78,79,80,END" + nl + "SWFrames=81,90,35,92,85,86,87,88,END" + nl
				+ "WWFrames=89,34,43,36,93,94,95,96,END" + nl + "MovementPerFrame=0";
		String actionAttack3 = nl + nl + "[Action Attack3]" + nl + "NWFrames=153,153,38,37,37,34,33,END" + nl
				+ "NNFrames=97,97,46,45,45,42,41,END" + nl + "NEFrames=105,105,54,53,53,50,49,END" + nl
				+ "EEFrames=113,113,62,61,61,58,57,END" + nl + "SEFrames=121,121,70,69,69,66,65,END" + nl
				+ "SSFrames=129,129,78,77,77,74,73,END" + nl + "SWFrames=137,137,86,85,85,82,81,END" + nl
				+ "WWFrames=145,145,94,93,93,90,89,END" + nl + "MovementPerFrame=0";
		String actionBowAttack = nl + nl + "[Action BowAttack]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
				+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl + "NEFrames=113,114,115,116,117,118,119,120,END"
				+ nl + "EEFrames=121,122,123,124,125,126,127,128,END" + nl
				+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl + "SSFrames=137,138,139,140,141,142,143,144,END"
				+ nl + "SWFrames=145,146,147,148,149,150,151,152,END" + nl
				+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6";
		String actionCast = nl + nl + "[Action Cast]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
				+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl + "NEFrames=113,114,115,116,117,118,119,120,END"
				+ nl + "EEFrames=121,122,123,124,125,126,127,128,END" + nl
				+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl + "SSFrames=137,138,139,140,141,142,143,144,END"
				+ nl + "SWFrames=145,146,147,148,149,150,151,152,END" + nl
				+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6";
		String actionDeath = nl + nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
				+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl + "NEFrames=177,178,179,180,181,182,183,184,END"
				+ nl + "EEFrames=185,186,187,188,189,190,191,192,END" + nl
				+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl + "SSFrames=201,202,203,204,205,206,207,208,END"
				+ nl + "SWFrames=209,210,211,212,213,214,215,216,END" + nl
				+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1";
		String actionPain = nl + nl + "[Action Pain]" + nl + "NWFrames=161,162,163,163,162,161,END" + nl
				+ "NNFrames=169,170,171,171,170,169,END" + nl + "NEFrames=177,178,179,179,178,177,END" + nl
				+ "EEFrames=185,186,187,187,186,185,END" + nl + "SEFrames=193,194,195,195,194,193,END" + nl
				+ "SSFrames=201,202,203,203,202,201,END" + nl + "SWFrames=209,210,211,211,210,209,END" + nl
				+ "WWFrames=217,218,219,219,218,217,END" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=1";
		String actionWalk = nl + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
				+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl + "NEFrames=241,242,243,244,245,246,247,248,LOOP"
				+ nl + "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
				+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl + "SSFrames=265,266,267,268,269,270,271,272,LOOP"
				+ nl + "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
				+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		String actionRun = nl + nl + "[Action Run]" + nl + "NWFrames=297,298,299,300,301,302,303,304,LOOP" + nl
				+ "NNFrames=305,306,307,308,309,310,311,312,LOOP" + nl + "NEFrames=313,314,315,316,317,318,319,320,LOOP"
				+ nl + "EEFrames=321,322,323,324,325,326,327,328,LOOP" + nl
				+ "SEFrames=329,330,331,332,333,334,335,336,LOOP" + nl + "SSFrames=337,338,339,340,341,342,343,344,LOOP"
				+ nl + "SWFrames=345,346,347,348,349,350,351,352,LOOP" + nl
				+ "WWFrames=353,354,355,356,357,358,359,360,LOOP" + nl + "MovementPerFrame=10";
		String actions = "";

		int index = parent.getIndex();
		if (index == 0) {
			actions = nl + "Actions=Stand,Cast,Pain,Death,Run,Walk" + nl + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=65" + nl + nl
					+ "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Death]"
					+ nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99" + nl + "98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";// MageBlue
		} else if (index == 1) {
			actions = nl + "Actions=Stand,Cast,Pain,Death,Run,Walk" + nl + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=61" + nl + nl
					+ "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Death]"
					+ nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99" + nl + "98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";// MageRed
		} else if (index == 2) {
			actions = nl + "Actions=Stand,Cast,Pain,Death,Run,Walk" + nl + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=61" + nl + nl
					+ "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Death]"
					+ nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99" + nl + "98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 3) {
			actions = nl + "Actions=Stand,Cast,Pain,Death,Run,Walk" + nl + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=61" + nl + nl
					+ "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Death]"
					+ nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99" + nl + "98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 4) {
			actions = nl + "Actions=Stand,Cast,Pain,Death,Run,Walk" + nl + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=61" + nl + nl
					+ "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Death]"
					+ nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99" + nl + "98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 5) {
			actions = nl + "Actions=Stand,Cast,Pain,Death,Run,Walk" + nl + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=61" + nl + nl
					+ "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Death]"
					+ nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99" + nl + "98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 6) {
			actions = "Actions=Stand,Cast,Pain,Death,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
					+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
					+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=62" + nl + nl + "[Action Cast]" + nl
					+ "NWFrames=33,34,35,36,37,38,39,40,END" + nl + "NNFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "NEFrames=49,50,51,52,53,54,55,56,END" + nl + "EEFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "SEFrames=65,66,67,68,69,70,71,72,END" + nl + "SSFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "SWFrames=81,82,83,84,85,86,87,88,END" + nl + "WWFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "MovementPerFrame=0" + nl + nl + "[Action Death]" + nl
					+ "NWFrames=97,98,99,100,101,102,103,104,END" + nl + "NNFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99,98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Walk]"
					+ nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=5";
		} // Mithras
		else if (index == 7) {
			actions = "Actions=Stand,Attack1,BowAttack,Cast,MinorCast,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=86" + nl + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ nl + "[Action BowAttack]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + nl + "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + nl
					+ "[Action MinorCast]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + nl
					+ "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=161,162,163,163,162,161,END" + nl
					+ "NNFrames=169,170,171,171,170,169,END" + nl + "NEFrames=177,178,179,179,178,177,END" + nl
					+ "EEFrames=185,186,187,187,186,185,END" + nl + "SEFrames=193,194,195,195,194,193,END" + nl
					+ "SSFrames=201,202,203,203,202,201,END" + nl + "SWFrames=209,210,211,211,210,209,END" + nl
					+ "WWFrames=217,218,219,219,218,217,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Walk]"
					+ nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=10";// Lich
		} else if (index == 8) {
			actions = "Actions=Stand,Attack1,BowAttack,Cast,Pain,Death,Walk,Run" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=70" + nl + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ nl + "[Action BowAttack]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + nl + "[Action Cast]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + nl + "[Action Pain]" + nl + "NWFrames=161,162,163,163,162,161,END" + nl
					+ "NNFrames=169,170,171,171,170,169,END" + nl + "NEFrames=177,178,179,179,178,177,END" + nl
					+ "EEFrames=185,186,187,187,186,185,END" + nl + "SEFrames=193,194,195,195,194,193,END" + nl
					+ "SSFrames=201,202,203,203,202,201,END" + nl + "SWFrames=209,210,211,211,210,209,END" + nl
					+ "WWFrames=217,218,219,219,218,217,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Death]"
					+ nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5" + nl + nl
					+ "[Action Run]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=10";// Bones
		} else if (index == 10) {
			actions = "Actions=Stand,Attack1,Cast,Pain,Death,Walk,Run" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "" + nl + "FrameMultiplier=59"
					+ nl + nl + "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ nl + "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=5" + nl
					+ nl + "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99,98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";// Blutrose
		} else if (index == 11) {
			actions = "Actions=Stand,Attack1,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,RANDOM" + nl + "NNFrames=9,10,11,12,13,14,15,16,RANDOM" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,RANDOM" + nl + "EEFrames=25,26,27,28,29,30,31,32,RANDOM" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,RANDOM" + nl + "SSFrames=41,42,43,44,45,46,47,48,RANDOM" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,RANDOM" + nl + "WWFrames=57,58,59,60,61,62,63,64,RANDOM" + nl
					+ "MovementPerFrame=0" + nl + "FrameMultiplier=78" + nl + nl + "[Action Attack1]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + nl + "[Action Death]" + nl
					+ "NWFrames=129,130,131,132,133,134,135,136,137,138,139,140,141,142,END" + nl
					+ "NNFrames=143,144,145,146,147,148,149,150,151,152,153,154,155,156,END" + nl
					+ "NEFrames=157,158,159,160,161,162,163,164,165,166,167,168,169,170,END" + nl
					+ "EEFrames=171,172,173,174,175,176,177,178,179,180,181,182,183,184,END" + nl
					+ "SEFrames=185,186,187,188,189,190,191,192,193,194,195,196,197,198,END" + nl
					+ "SSFrames=199,200,201,202,203,204,205,206,207,208,209,210,211,212,END" + nl
					+ "SWFrames=213,214,215,216,217,218,219,220,221,222,223,224,225,226,END" + nl
					+ "WWFrames=227,228,229,230,231,232,233,234,235,236,237,238,239,240,END" + nl
					+ "MovementPerFrame=-1" + nl + nl + "[Action Pain]" + nl + "NWFrames=129,130,131,131,130,129,END"
					+ nl + "NNFrames=143,144,145,145,144,143,END" + nl + "NEFrames=157,158,159,159,158,157,END" + nl
					+ "EEFrames=171,172,173,173,172,171,END" + nl + "SEFrames=185,186,187,187,186,185,END" + nl
					+ "SSFrames=199,200,201,201,200,199,END" + nl + "SWFrames=213,214,215,215,214,213,END" + nl
					+ "WWFrames=227,228,229,229,228,227,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Walk]"
					+ nl + "NWFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "NNFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "NEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "EEFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SEFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "SSFrames=281,282,283,284,285,286,287,288,LOOP" + nl
					+ "SWFrames=289,290,291,292,293,294,295,296,LOOP" + nl
					+ "WWFrames=297,298,299,300,301,302,303,304,LOOP" + nl + "MovementPerFrame=5";// Naga
			// 1
		} else if (index == 12) {
			actions = "Actions=Stand,Attack1,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,RANDOM" + nl + "NNFrames=9,10,11,12,13,14,15,16,RANDOM" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,RANDOM" + nl + "EEFrames=25,26,27,28,29,30,31,32,RANDOM" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,RANDOM" + nl + "SSFrames=41,42,43,44,45,46,47,48,RANDOM" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,RANDOM" + nl + "WWFrames=57,58,59,60,61,62,63,64,RANDOM" + nl
					+ "MovementPerFrame=0" + nl + "FrameMultiplier=78" + nl + nl + "[Action Attack1]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + nl + "[Action Death]" + nl
					+ "NWFrames=129,130,131,132,133,134,135,136,137,138,139,140,141,142,END" + nl
					+ "NNFrames=143,144,145,146,147,148,149,150,151,152,153,154,155,156,END" + nl
					+ "NEFrames=157,158,159,160,161,162,163,164,165,166,167,168,169,170,END" + nl
					+ "EEFrames=171,172,173,174,175,176,177,178,179,180,181,182,183,184,END" + nl
					+ "SEFrames=185,186,187,188,189,190,191,192,193,194,195,196,197,198,END" + nl
					+ "SSFrames=199,200,201,202,203,204,205,206,207,208,209,210,211,212,END" + nl
					+ "SWFrames=213,214,215,216,217,218,219,220,221,222,223,224,225,226,END" + nl
					+ "WWFrames=227,228,229,230,231,232,233,234,235,236,237,238,239,240,END" + nl
					+ "MovementPerFrame=-1" + nl + nl + "[Action Pain]" + nl + "NWFrames=129,130,131,131,130,129,END"
					+ nl + "NNFrames=143,144,145,145,144,143,END" + nl + "NEFrames=157,158,159,159,158,157,END" + nl
					+ "EEFrames=171,172,173,173,172,171,END" + nl + "SEFrames=185,186,187,187,186,185,END" + nl
					+ "SSFrames=199,200,201,201,200,199,END" + nl + "SWFrames=213,214,215,215,214,213,END" + nl
					+ "WWFrames=227,228,229,229,228,227,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Walk]"
					+ nl + "NWFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "NNFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "NEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "EEFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SEFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "SSFrames=281,282,283,284,285,286,287,288,LOOP" + nl
					+ "SWFrames=289,290,291,292,293,294,295,296,LOOP" + nl
					+ "WWFrames=297,298,299,300,301,302,303,304,LOOP" + nl + "MovementPerFrame=5";// Naga
			// 2
		} else if (index == 14) {
			actions = "colorred=-64" + nl + "colorblue=192" + nl + "Actions=Attack1,Pain,Death,Cast,Run,Stand,Walk" + nl
					+ "[Action Attack1]" + nl + "NWFrames=1,2,3,4,5,6,7,8,END" + nl
					+ "NNFrames=9,10,11,12,13,14,15,16,END" + nl + "NEFrames=17,18,19,20,21,22,23,24,END" + nl
					+ "EEFrames=25,26,27,28,29,30,31,32,END" + nl + "SEFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "SSFrames=41,42,43,44,45,46,47,48,END" + nl + "SWFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "WWFrames=57,58,59,60,61,62,63,64,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Cast]" + nl + "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END"
					+ nl + "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,LOOP"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,LOOP" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,LOOP" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,LOOP" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,LOOP" + nl + "MovementPerFrame=10" + nl
					+ "[Action Stand]" + nl + "NWFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,LOOP" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,LOOP" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=2" + nl + "[Action Walk]" + nl + "NWFrames=257,258,259,260,261,262,263,264,LOOP"
					+ nl + "NNFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,LOOP" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,LOOP" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,LOOP" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,LOOP" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,LOOP" + nl + "MovementPerFrame=5";// doomfrost
		} else if (index == 15) {
			actions = "Actions=Attack1,Pain,Death,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Stand]" + nl
					+ "NWFrames=129,130,131,132,133,134,135,136,LOOP" + nl
					+ "NNFrames=137,138,139,140,141,142,143,144,LOOP" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,LOOP" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,LOOP" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,LOOP" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=5" + nl + "[Action Walk]" + nl + "NWFrames=193,194,195,196,197,198,199,200,LOOP"
					+ nl + "NNFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,LOOP" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 16) {
			actions = "Actions=Attack1,Pain,Death,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Stand]" + nl
					+ "NWFrames=129,130,131,132,133,134,135,136,RANDOM" + nl
					+ "NNFrames=137,138,139,140,141,142,143,144,RANDOM" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,RANDOM" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,RANDOM" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=84" + nl + "[Action Walk]" + nl + "NWFrames=193,194,195,196,197,198,199,200,LOOP"
					+ nl + "NNFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,LOOP" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 17) {
			actions = "Actions=Stand,Attack1,Pain,Death,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM"
					+ nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl
					+ "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=69" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 18) {
			actions = "Actions=Stand,Attack1,Pain,Death,Run,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=74" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=10" + nl + "[Action Walk]"
					+ nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 19) {
			actions = "Actions=Stand,Attack1,Attack2,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=67" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Attack2]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=161,162,163,163,162,161,END" + nl + "NNFrames=169,170,171,171,170,169,END" + nl
					+ "NEFrames=177,178,179,179,178,177,END" + nl + "EEFrames=185,186,187,187,186,185,END" + nl
					+ "SEFrames=193,194,195,195,194,193,END" + nl + "SSFrames=201,202,203,203,202,201,END" + nl
					+ "SWFrames=209,210,211,211,210,209,END" + nl + "WWFrames=217,218,219,219,218,217,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 20) {
			actions = "Actions=Stand,Attack1,Pain,Death,Walk" + nl + "[Action Pain]" + nl + "MovementPerFrame=0" + nl
					+ "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl
					+ "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM" + nl
					+ "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=60" + nl + "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END"
					+ nl + "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Walk]"
					+ nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 21) {
			actions = "Actions=Cast,Pain,Death,Run,Walk,Stand" + nl + "[Action Cast]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,LOOP"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,LOOP" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,LOOP" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,LOOP" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,LOOP" + nl + "MovementPerFrame=10" + nl
					+ "[Action Walk]" + nl + "NWFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,LOOP" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,LOOP" + nl + "MovementPerFrame=5" + nl
					+ "[Action Stand]" + nl + "NWFrames=257,258,259,260,261,262,263,264,265,LOOP" + nl
					+ "NNFrames=266,267,268,269,270,271,272,273,274,LOOP" + nl
					+ "NEFrames=275,276,277,278,279,280,281,282,283,LOOP" + nl
					+ "EEFrames=284,285,286,287,288,289,290,291,292,LOOP" + nl
					+ "SEFrames=293,294,295,296,297,298,299300,301,LOOP" + nl
					+ "SSFrames=302,303,304,305,306,307,308,309,310,LOOP" + nl
					+ "SWFrames=311,312,313,314,315,316,317,318,319,LOOP" + nl
					+ "WWFrames=320,321,322,323,324,325,326,327,328,LOOP" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=2";
		} else if (index == 22) {
			actions = "Actions=Stand,Attack1,Pain,Death,Run,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=64" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,27,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 23) {
			actions = "Actions=Attack1,Pain,Death,Run,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,LOOP"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,LOOP" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,LOOP" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,LOOP" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,LOOP" + nl + "MovementPerFrame=10" + nl
					+ "[Action Stand]" + nl + "NWFrames=193,194,195,196,197,198,199,200,RANDOM" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,RANDOM" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,RANDOM" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,RANDOM" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,RANDOM" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,RANDOM" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,RANDOM" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=51" + nl + "[Action Walk]" + nl + "NWFrames=257,258,259,260,261,262,263,264,LOOP"
					+ nl + "NNFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,LOOP" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,LOOP" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,LOOP" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,LOOP" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 24) {
			actions = "Actions=Stand,Attack1,Attack2,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=56" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Attack2]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=161,162,163,163,162,161,END" + nl + "NNFrames=169,170,171,171,170,169,END" + nl
					+ "NEFrames=177,178,179,179,178,177,END" + nl + "EEFrames=185,186,187,187,186,185,END" + nl
					+ "SEFrames=193,194,195,195,194,193,END" + nl + "SSFrames=201,202,203,203,202,201,END" + nl
					+ "SWFrames=209,210,211,211,210,209,END" + nl + "WWFrames=217,218,219,219,218,217,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 25) {
			actions = "Actions=Stand,Attack1,Attack2,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=59" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Attack2]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=161,162,163,163,162,161,END" + nl + "NNFrames=169,170,171,171,170,169,END" + nl
					+ "NEFrames=177,178,179,179,178,177,END" + nl + "EEFrames=185,186,187,187,186,185,END" + nl
					+ "SEFrames=193,194,195,195,194,193,END" + nl + "SSFrames=201,202,203,203,202,201,END" + nl
					+ "SWFrames=209,210,211,211,210,209,END" + nl + "WWFrames=217,218,219,219,218,217,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 26) {
			actions = "Actions=Stand,Attack1,Attack2,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=59" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Attack2]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=161,162,163,163,162,161,END" + nl + "NNFrames=169,170,171,171,170,169,END" + nl
					+ "NEFrames=177,178,179,179,178,177,END" + nl + "EEFrames=185,186,187,187,186,185,END" + nl
					+ "SEFrames=193,194,195,195,194,193,END" + nl + "SSFrames=201,202,203,203,202,201,END" + nl
					+ "SWFrames=209,210,211,211,210,209,END" + nl + "WWFrames=217,218,219,219,218,217,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 27) {
			actions = "Actions=Stand,Attack1,Attack2,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=59" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Attack2]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=161,162,163,163,162,161,END" + nl + "NNFrames=169,170,171,171,170,169,END" + nl
					+ "NEFrames=177,178,179,179,178,177,END" + nl + "EEFrames=185,186,187,187,186,185,END" + nl
					+ "SEFrames=193,194,195,195,194,193,END" + nl + "SSFrames=201,202,203,203,202,201,END" + nl
					+ "SWFrames=209,210,211,211,210,209,END" + nl + "WWFrames=217,218,219,219,218,217,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 28) {
			actions = "Actions=Stand,Cast,Walk,Pain,Death,Trap" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM"
					+ nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl
					+ "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=82" + nl
					+ "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=5" + nl
					+ "[Action Walk]" + nl + "NWFrames=97,98,99,100,101,102,103,104,LOOP" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,LOOP" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,LOOP" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,LOOP" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,LOOP" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,LOOP" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,LOOP" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,LOOP" + nl + "MovementPerFrame=5" + nl
					+ "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,169,END" + nl
					+ "NNFrames=170,171,172,173,174,175,176,177,178,END" + nl
					+ "NEFrames=179,180,181,182,183,184,185,186,187,END" + nl
					+ "EEFrames=188,189,190,191,192,193,194,195,196,END" + nl
					+ "SEFrames=197,198,199,200,201,202,203,204,205,END" + nl
					+ "SSFrames=206,207,208,209,210,211,212,213,214,END" + nl
					+ "SWFrames=215,216,217,218,219,220,221,222,223,END" + nl
					+ "WWFrames=224,225,226,227,228,229,230,231,232,END" + nl + "MovementPerFrame=-1" + nl
					+ "[Action Pain]" + nl + "NWFrames=161,162,163,163,162,161,END" + nl
					+ "NNFrames=170,171,172,172,171,170,END" + nl + "NEFrames=179,180,181,181,180,179,END" + nl
					+ "EEFrames=188,189,190,190,189,188,END" + nl + "SEFrames=197,198,199,199,198,197,END" + nl
					+ "SSFrames=206,207,208,208,207,206,END" + nl + "SWFrames=215,216,217,217,216,215,END" + nl
					+ "WWFrames=224,225,226,226,225,224,END" + nl + "MovementPerFrame=0" + nl + "[Action Trap]" + nl
					+ "NWFrames=214,END" + nl + "NNFrames=214,END" + nl + "NEFrames=214,END" + nl + "EEFrames=214,END"
					+ nl + "SEFrames=214,END" + nl + "SSFrames=214,END" + nl + "SWFrames=214,END" + nl
					+ "WWFrames=214,END";
		} else if (index == 29) {
			actions = "Actions=Stand,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
					+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
					+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=55" + nl + "[Action Walk]" + nl + "NWFrames=33,34,35,36,37,38,39,40,LOOP"
					+ nl + "NNFrames=41,42,43,44,45,46,47,48,LOOP" + nl + "NEFrames=49,50,51,52,53,54,55,56,LOOP" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,LOOP" + nl + "SEFrames=65,66,67,68,69,70,71,72,LOOP" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,LOOP" + nl + "SWFrames=81,82,83,84,85,86,87,88,LOOP" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 30) {
			actions = "Actions=Stand,Attack1,Attack2,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=59" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Attack2]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=161,162,163,163,162,161,END" + nl + "NNFrames=169,170,171,171,170,169,END" + nl
					+ "NEFrames=177,178,179,179,178,177,END" + nl + "EEFrames=185,186,187,187,186,185,END" + nl
					+ "SEFrames=193,194,195,195,194,193,END" + nl + "SSFrames=201,202,203,203,202,201,END" + nl
					+ "SWFrames=209,210,211,211,210,209,END" + nl + "WWFrames=217,218,219,219,218,217,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 31) {
			actions = "Actions=Stand,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
					+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
					+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=55" + nl + "[Action Walk]" + nl + "NWFrames=33,34,35,36,37,38,39,40,LOOP"
					+ nl + "NNFrames=41,42,43,44,45,46,47,48,LOOP" + nl + "NEFrames=49,50,51,52,53,54,55,56,LOOP" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,LOOP" + nl + "SEFrames=65,66,67,68,69,70,71,72,LOOP" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,LOOP" + nl + "SWFrames=81,82,83,84,85,86,87,88,LOOP" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 32) {
			actions = "Actions=Pain,Death,Attack1,Stand,Walk" + nl + "[Action Death]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,9,10,11,12,END" + nl
					+ "NNFrames=13,14,15,16,17,18,19,20,21,22,23,24,END" + nl
					+ "NEFrames=25,26,27,28,29,30,31,32,33,34,35,36,END" + nl
					+ "EEFrames=37,38,39,40,41,42,43,44,45,46,47,48,END" + nl
					+ "SEFrames=49,50,51,52,53,54,55,56,57,58,59,60,END" + nl
					+ "SSFrames=61,62,63,64,65,66,67,68,69,70,71,72,END" + nl
					+ "SWFrames=73,74,75,76,77,78,79,80,81,82,83,84,END" + nl
					+ "WWFrames=85,86,87,88,89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=-1" + nl
					+ "[Action Pain]" + nl + "NWFrames=1,2,3,3,2,1,END" + nl + "NNFrames=13,14,15,15,14,13,END" + nl
					+ "NEFrames=25,26,27,27,26,25,END" + nl + "EEFrames=37,38,39,39,38,37,END" + nl
					+ "SEFrames=49,50,51,51,50,49,END" + nl + "SSFrames=61,62,63,63,62,61,END" + nl
					+ "SWFrames=73,74,75,75,74,73,END" + nl + "WWFrames=85,86,87,87,86,85,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Attack1]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END"
					+ nl + "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Stand]" + nl + "NWFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,RANDOM" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,RANDOM" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,RANDOM" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,RANDOM" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=77" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 33) {
			actions = "Actions=Pain,Death,Attack1,Stand,Walk" + nl + "[Action Death]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,9,10,11,12,END" + nl
					+ "NNFrames=13,14,15,16,17,18,19,20,21,22,23,24,END" + nl
					+ "NEFrames=25,26,27,28,29,30,31,32,33,34,35,36,END" + nl
					+ "EEFrames=37,38,39,40,41,42,43,44,45,46,47,48,END" + nl
					+ "SEFrames=49,50,51,52,53,54,55,56,57,58,59,60,END" + nl
					+ "SSFrames=61,62,63,64,65,66,67,68,69,70,71,72,END" + nl
					+ "SWFrames=73,74,75,76,77,78,79,80,81,82,83,84,END" + nl
					+ "WWFrames=85,86,87,88,89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=-1" + nl
					+ "[Action Pain]" + nl + "NWFrames=1,2,3,3,2,1,END" + nl + "NNFrames=13,14,15,15,14,13,END" + nl
					+ "NEFrames=25,26,27,27,26,25,END" + nl + "EEFrames=37,38,39,39,38,37,END" + nl
					+ "SEFrames=49,50,51,51,50,49,END" + nl + "SSFrames=61,62,63,63,62,61,END" + nl
					+ "SWFrames=73,74,75,75,74,73,END" + nl + "WWFrames=85,86,87,87,86,85,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Attack1]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END"
					+ nl + "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Stand]" + nl + "NWFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,RANDOM" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,RANDOM" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,RANDOM" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,RANDOM" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=77" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 34) {
			actions = "Actions=Pain,Death,Attack1,Stand,Walk" + nl + "[Action Death]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,9,10,11,12,END" + nl
					+ "NNFrames=13,14,15,16,17,18,19,20,21,22,23,24,END" + nl
					+ "NEFrames=25,26,27,28,29,30,31,32,33,34,35,36,END" + nl
					+ "EEFrames=37,38,39,40,41,42,43,44,45,46,47,48,END" + nl
					+ "SEFrames=49,50,51,52,53,54,55,56,57,58,59,60,END" + nl
					+ "SSFrames=61,62,63,64,65,66,67,68,69,70,71,72,END" + nl
					+ "SWFrames=73,74,75,76,77,78,79,80,81,82,83,84,END" + nl
					+ "WWFrames=85,86,87,88,89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=-1" + nl
					+ "[Action Pain]" + nl + "NWFrames=1,2,3,3,2,1,END" + nl + "NNFrames=13,14,15,15,14,13,END" + nl
					+ "NEFrames=25,26,27,27,26,25,END" + nl + "EEFrames=37,38,39,39,38,37,END" + nl
					+ "SEFrames=49,50,51,51,50,49,END" + nl + "SSFrames=61,62,63,63,62,61,END" + nl
					+ "SWFrames=73,74,75,75,74,73,END" + nl + "WWFrames=85,86,87,87,86,85,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Attack1]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END"
					+ nl + "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Stand]" + nl + "NWFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,RANDOM" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,RANDOM" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,RANDOM" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,RANDOM" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=77" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 35) {
			actions = "Actions=Pain,Death,Attack1,Stand,Walk" + nl + "[Action Death]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,9,10,11,12,END" + nl
					+ "NNFrames=13,14,15,16,17,18,19,20,21,22,23,24,END" + nl
					+ "NEFrames=25,26,27,28,29,30,31,32,33,34,35,36,END" + nl
					+ "EEFrames=37,38,39,40,41,42,43,44,45,46,47,48,END" + nl
					+ "SEFrames=49,50,51,52,53,54,55,56,57,58,59,60,END" + nl
					+ "SSFrames=61,62,63,64,65,66,67,68,69,70,71,72,END" + nl
					+ "SWFrames=73,74,75,76,77,78,79,80,81,82,83,84,END" + nl
					+ "WWFrames=85,86,87,88,89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=-1" + nl
					+ "[Action Pain]" + nl + "NWFrames=1,2,3,3,2,1,END" + nl + "NNFrames=13,14,15,15,14,13,END" + nl
					+ "NEFrames=25,26,27,27,26,25,END" + nl + "EEFrames=37,38,39,39,38,37,END" + nl
					+ "SEFrames=49,50,51,51,50,49,END" + nl + "SSFrames=61,62,63,63,62,61,END" + nl
					+ "SWFrames=73,74,75,75,74,73,END" + nl + "WWFrames=85,86,87,87,86,85,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Attack1]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END"
					+ nl + "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Stand]" + nl + "NWFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,RANDOM" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,RANDOM" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,RANDOM" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,RANDOM" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=77" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 36) {
			actions = "Actions=Pain,Death,Attack1,Stand,Walk" + nl + "[Action Death]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,9,10,11,12,END" + nl
					+ "NNFrames=13,14,15,16,17,18,19,20,21,22,23,24,END" + nl
					+ "NEFrames=25,26,27,28,29,30,31,32,33,34,35,36,END" + nl
					+ "EEFrames=37,38,39,40,41,42,43,44,45,46,47,48,END" + nl
					+ "SEFrames=49,50,51,52,53,54,55,56,57,58,59,60,END" + nl
					+ "SSFrames=61,62,63,64,65,66,67,68,69,70,71,72,END" + nl
					+ "SWFrames=73,74,75,76,77,78,79,80,81,82,83,84,END" + nl
					+ "WWFrames=85,86,87,88,89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=-1" + nl
					+ "[Action Pain]" + nl + "NWFrames=1,2,3,3,2,1,END" + nl + "NNFrames=13,14,15,15,14,13,END" + nl
					+ "NEFrames=25,26,27,27,26,25,END" + nl + "EEFrames=37,38,39,39,38,37,END" + nl
					+ "SEFrames=49,50,51,51,50,49,END" + nl + "SSFrames=61,62,63,63,62,61,END" + nl
					+ "SWFrames=73,74,75,75,74,73,END" + nl + "WWFrames=85,86,87,87,86,85,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Attack1]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END"
					+ nl + "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Stand]" + nl + "NWFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,RANDOM" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,RANDOM" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,RANDOM" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,RANDOM" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=77" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 37) {
			actions = "Actions=Attack1,Pain,Death,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Stand]" + nl
					+ "NWFrames=129,130,131,132,133,134,135,136,RANDOM" + nl
					+ "NNFrames=137,138,139,140,141,142,143,144,RANDOM" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,RANDOM" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,RANDOM" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=84" + nl + "[Action Walk]" + nl + "NWFrames=193,194,195,196,197,198,199,200,LOOP"
					+ nl + "NNFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,LOOP" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 38) {
			actions = "Actions=Attack1,Pain,Death,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Stand]" + nl
					+ "NWFrames=129,130,131,132,133,134,135,136,RANDOM" + nl
					+ "NNFrames=137,138,139,140,141,142,143,144,RANDOM" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,RANDOM" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,RANDOM" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=84" + nl + "[Action Walk]" + nl + "NWFrames=193,194,195,196,197,198,199,200,LOOP"
					+ nl + "NNFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,LOOP" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 39) {
			actions = "Actions=Attack1,Pain,Death,Run,Sit,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,END"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,END" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,END" + nl + "MovementPerFrame=10" + nl + "[Action Sit]"
					+ nl + "NWFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,END" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,END" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,END" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,END" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,END" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Stand]" + nl
					+ "NWFrames=257,258,259,260,261,262,263,264,RANDOM" + nl
					+ "NNFrames=265,266,267,268,269,270,271,272,RANDOM" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,RANDOM" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,RANDOM" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,RANDOM" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,RANDOM" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,RANDOM" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Walk]" + nl + "NWFrames=321,322,323,324,325,326,327,328,LOOP"
					+ nl + "NNFrames=329,330,331,332,333,334,335,336,LOOP" + nl
					+ "NEFrames=337,338,339,340,341,342,343,344,LOOP" + nl
					+ "EEFrames=345,346,347,348,349,350,351,352,LOOP" + nl
					+ "SEFrames=353,354,355,356,357,358,359,360,LOOP" + nl
					+ "SSFrames=361,362,363,364,365,366,367,368,LOOP" + nl
					+ "SWFrames=369,370,371,372,373,374,375,376,LOOP" + nl
					+ "WWFrames=377,378,379,380,381,382,383,384,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 40) {
			actions = "Actions=Attack1,Pain,Death,Run,Sit,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,END"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,END" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,END" + nl + "MovementPerFrame=10" + nl + "[Action Sit]"
					+ nl + "NWFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,END" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,END" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,END" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,END" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,END" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Stand]" + nl
					+ "NWFrames=257,258,259,260,261,262,263,264,RANDOM" + nl
					+ "NNFrames=265,266,267,268,269,270,271,272,RANDOM" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,RANDOM" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,RANDOM" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,RANDOM" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,RANDOM" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,RANDOM" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Walk]" + nl + "NWFrames=321,322,323,324,325,326,327,328,LOOP"
					+ nl + "NNFrames=329,330,331,332,333,334,335,336,LOOP" + nl
					+ "NEFrames=337,338,339,340,341,342,343,344,LOOP" + nl
					+ "EEFrames=345,346,347,348,349,350,351,352,LOOP" + nl
					+ "SEFrames=353,354,355,356,357,358,359,360,LOOP" + nl
					+ "SSFrames=361,362,363,364,365,366,367,368,LOOP" + nl
					+ "SWFrames=369,370,371,372,373,374,375,376,LOOP" + nl
					+ "WWFrames=377,378,379,380,381,382,383,384,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 41) {
			actions = "Actions=Attack1,Pain,Death,Run,Sit,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,END"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,END" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,END" + nl + "MovementPerFrame=10" + nl + "[Action Sit]"
					+ nl + "NWFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,END" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,END" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,END" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,END" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,END" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Stand]" + nl
					+ "NWFrames=257,258,259,260,261,262,263,264,RANDOM" + nl
					+ "NNFrames=265,266,267,268,269,270,271,272,RANDOM" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,RANDOM" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,RANDOM" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,RANDOM" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,RANDOM" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,RANDOM" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Walk]" + nl + "NWFrames=321,322,323,324,325,326,327,328,LOOP"
					+ nl + "NNFrames=329,330,331,332,333,334,335,336,LOOP" + nl
					+ "NEFrames=337,338,339,340,341,342,343,344,LOOP" + nl
					+ "EEFrames=345,346,347,348,349,350,351,352,LOOP" + nl
					+ "SEFrames=353,354,355,356,357,358,359,360,LOOP" + nl
					+ "SSFrames=361,362,363,364,365,366,367,368,LOOP" + nl
					+ "SWFrames=369,370,371,372,373,374,375,376,LOOP" + nl
					+ "WWFrames=377,378,379,380,381,382,383,384,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 42) {
			actions = "Actions=Stand,Cast,Pain,Death,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
					+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
					+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=50" + nl + "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END"
					+ nl + "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "[Action Death]" + nl
					+ "NWFrames=97,98,99,100,101,102,103,104,END" + nl + "NNFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 43) {
			actions = "Actions=Stand,Cast,Pain,Death,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
					+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
					+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=50" + nl + "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END"
					+ nl + "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "[Action Death]" + nl
					+ "NWFrames=97,98,99,100,101,102,103,104,END" + nl + "NNFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 44) {
			actions = "Actions=Stand,Cast,Pain,Death,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
					+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
					+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=50" + nl + "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END"
					+ nl + "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "[Action Death]" + nl
					+ "NWFrames=97,98,99,100,101,102,103,104,END" + nl + "NNFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 45) {
			actions = "Actions=Stand" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
					+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
					+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=63";
		} else if (index == 46) {
			actions = "Actions=Stand,Attack1,Cast,Pain,Death,Walk,Run" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "" + nl + "FrameMultiplier=59"
					+ nl + nl + "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ nl + "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=5" + nl
					+ nl + "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99,98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";// Blutrose
		} else if (index == 47) {
			actions = "Actions=Stand,Attack1,Cast,Pain,Death,Walk,Run" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "" + nl + "FrameMultiplier=59"
					+ nl + nl + "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ nl + "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=5" + nl
					+ nl + "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99,98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";// Blutrose
		} else if (index == 48) {
			actions = "Actions=Stand,Attack1,Cast,Pain,Death,Walk,Run" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "" + nl + "FrameMultiplier=59"
					+ nl + nl + "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ nl + "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=5" + nl
					+ nl + "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99,98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";// Blutrose
		} else if (index == 49) {
			actions = "Actions=Stand,Attack1,Cast,Pain,Death,Walk,Run" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "" + nl + "FrameMultiplier=59"
					+ nl + nl + "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ nl + "[Action Cast]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=5" + nl
					+ nl + "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + nl
					+ "[Action Pain]" + nl + "NWFrames=97,98,99,99,98,97,END" + nl
					+ "NNFrames=105,106,107,107,106,105,END" + nl + "NEFrames=113,114,115,115,114,113,END" + nl
					+ "EEFrames=121,122,123,123,122,121,END" + nl + "SEFrames=129,130,131,131,130,129,END" + nl
					+ "SSFrames=137,138,139,139,138,137,END" + nl + "SWFrames=145,146,147,147,146,145,END" + nl
					+ "WWFrames=153,154,155,155,154,153,END" + nl + "MovementPerFrame=0" + nl + nl + "[Action Run]" + nl
					+ "NWFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=10" + nl + nl
					+ "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";// Blutrose
		} else if (index == 50) {
			actions = "Actions=Stand,Attack1,Pain,Death,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM"
					+ nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl
					+ "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=55" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 51) {
			actions = "Actions=Stand,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
					+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
					+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=55" + nl + "[Action Walk]" + nl + "NWFrames=33,34,35,36,37,38,39,40,LOOP"
					+ nl + "NNFrames=41,42,43,44,45,46,47,48,LOOP" + nl + "NEFrames=49,50,51,52,53,54,55,56,LOOP" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,LOOP" + nl + "SEFrames=65,66,67,68,69,70,71,72,LOOP" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,LOOP" + nl + "SWFrames=81,82,83,84,85,86,87,88,LOOP" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 52) {
			actions = "Actions=Stand,Attack1,Attack2,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=56" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Attack2]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=161,162,163,163,162,161,END" + nl + "NNFrames=169,170,171,171,170,169,END" + nl
					+ "NEFrames=177,178,179,179,178,177,END" + nl + "EEFrames=185,186,187,187,186,185,END" + nl
					+ "SEFrames=193,194,195,195,194,193,END" + nl + "SSFrames=201,202,203,203,202,201,END" + nl
					+ "SWFrames=209,210,211,211,210,209,END" + nl + "WWFrames=217,218,219,219,218,217,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 53) {
			actions = "Actions=Stand,Attack1,Attack2,Pain,Death,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=56" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Attack2]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=161,162,163,163,162,161,END" + nl + "NNFrames=169,170,171,171,170,169,END" + nl
					+ "NEFrames=177,178,179,179,178,177,END" + nl + "EEFrames=185,186,187,187,186,185,END" + nl
					+ "SEFrames=193,194,195,195,194,193,END" + nl + "SSFrames=201,202,203,203,202,201,END" + nl
					+ "SWFrames=209,210,211,211,210,209,END" + nl + "WWFrames=217,218,219,219,218,217,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 54) {
			actions = "Actions=Stand,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,5,6,7,8,RANDOM" + nl
					+ "NNFrames=9,10,11,12,13,14,15,16,RANDOM" + nl + "NEFrames=17,18,19,20,21,22,23,24,RANDOM" + nl
					+ "EEFrames=25,26,27,28,29,30,31,32,RANDOM" + nl + "SEFrames=33,34,35,36,37,38,39,40,RANDOM" + nl
					+ "SSFrames=41,42,43,44,45,46,47,48,RANDOM" + nl + "SWFrames=49,50,51,52,53,54,55,56,RANDOM" + nl
					+ "WWFrames=57,58,59,60,61,62,63,64,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=65"
					+ nl + "[Action Walk]" + nl + "NWFrames=65,66,67,68,69,70,71,72,LOOP" + nl
					+ "NNFrames=73,74,75,76,77,78,79,80,LOOP" + nl + "NEFrames=81,82,83,84,85,86,87,88,LOOP" + nl
					+ "EEFrames=89,90,91,92,93,94,95,96,LOOP" + nl + "SEFrames=97,98,99,100,101,102,103,104,LOOP" + nl
					+ "SSFrames=105,106,107,108,109,110,111,112,LOOP" + nl
					+ "SWFrames=113,114,115,116,117,118,119,120,LOOP" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 55) {
			actions = "Actions=Stand,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,5,6,7,8,RANDOM" + nl
					+ "NNFrames=9,10,11,12,13,14,15,16,RANDOM" + nl + "NEFrames=17,18,19,20,21,22,23,24,RANDOM" + nl
					+ "EEFrames=25,26,27,28,29,30,31,32,RANDOM" + nl + "SEFrames=33,34,35,36,37,38,39,40,RANDOM" + nl
					+ "SSFrames=41,42,43,44,45,46,47,48,RANDOM" + nl + "SWFrames=49,50,51,52,53,54,55,56,RANDOM" + nl
					+ "WWFrames=57,58,59,60,61,62,63,64,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=65"
					+ nl + "[Action Walk]" + nl + "NWFrames=65,66,67,68,69,70,71,72,LOOP" + nl
					+ "NNFrames=73,74,75,76,77,78,79,80,LOOP" + nl + "NEFrames=81,82,83,84,85,86,87,88,LOOP" + nl
					+ "EEFrames=89,90,91,92,93,94,95,96,LOOP" + nl + "SEFrames=97,98,99,100,101,102,103,104,LOOP" + nl
					+ "SSFrames=105,106,107,108,109,110,111,112,LOOP" + nl
					+ "SWFrames=113,114,115,116,117,118,119,120,LOOP" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 56) {
			actions = "Actions=Stand,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,5,6,7,8,RANDOM" + nl
					+ "NNFrames=9,10,11,12,13,14,15,16,RANDOM" + nl + "NEFrames=17,18,19,20,21,22,23,24,RANDOM" + nl
					+ "EEFrames=25,26,27,28,29,30,31,32,RANDOM" + nl + "SEFrames=33,34,35,36,37,38,39,40,RANDOM" + nl
					+ "SSFrames=41,42,43,44,45,46,47,48,RANDOM" + nl + "SWFrames=49,50,51,52,53,54,55,56,RANDOM" + nl
					+ "WWFrames=57,58,59,60,61,62,63,64,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=65"
					+ nl + "[Action Walk]" + nl + "NWFrames=65,66,67,68,69,70,71,72,LOOP" + nl
					+ "NNFrames=73,74,75,76,77,78,79,80,LOOP" + nl + "NEFrames=81,82,83,84,85,86,87,88,LOOP" + nl
					+ "EEFrames=89,90,91,92,93,94,95,96,LOOP" + nl + "SEFrames=97,98,99,100,101,102,103,104,LOOP" + nl
					+ "SSFrames=105,106,107,108,109,110,111,112,LOOP" + nl
					+ "SWFrames=113,114,115,116,117,118,119,120,LOOP" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 57) {
			actions = "Actions=Stand,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,5,6,7,8,RANDOM" + nl
					+ "NNFrames=9,10,11,12,13,14,15,16,RANDOM" + nl + "NEFrames=17,18,19,20,21,22,23,24,RANDOM" + nl
					+ "EEFrames=25,26,27,28,29,30,31,32,RANDOM" + nl + "SEFrames=33,34,35,36,37,38,39,40,RANDOM" + nl
					+ "SSFrames=41,42,43,44,45,46,47,48,RANDOM" + nl + "SWFrames=49,50,51,52,53,54,55,56,RANDOM" + nl
					+ "WWFrames=57,58,59,60,61,62,63,64,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=65"
					+ nl + "[Action Walk]" + nl + "NWFrames=65,66,67,68,69,70,71,72,LOOP" + nl
					+ "NNFrames=73,74,75,76,77,78,79,80,LOOP" + nl + "NEFrames=81,82,83,84,85,86,87,88,LOOP" + nl
					+ "EEFrames=89,90,91,92,93,94,95,96,LOOP" + nl + "SEFrames=97,98,99,100,101,102,103,104,LOOP" + nl
					+ "SSFrames=105,106,107,108,109,110,111,112,LOOP" + nl
					+ "SWFrames=113,114,115,116,117,118,119,120,LOOP" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 58) {
			actions = "Actions=Pain,Death,Run,Walk,Stand" + nl + "[Action Death]" + nl + "NWFrames=1,2,3,4,5,6,7,8,END"
					+ nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl + "NEFrames=17,18,19,20,21,22,23,24,END" + nl
					+ "EEFrames=25,26,27,28,29,30,31,32,END" + nl + "SEFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "SSFrames=41,42,43,44,45,46,47,48,END" + nl + "SWFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "WWFrames=57,58,59,60,61,62,63,64,END" + nl + "MovementPerFrame=0" + nl + "[Action Pain]" + nl
					+ "NWFrames=1,2,3,3,2,1,END" + nl + "NNFrames=9,10,11,11,10,9,END" + nl
					+ "NEFrames=17,18,19,19,18,17,END" + nl + "EEFrames=25,26,27,27,26,25,END" + nl
					+ "SEFrames=33,34,35,35,34,33,END" + nl + "SSFrames=41,42,43,43,42,41,END" + nl
					+ "SWFrames=49,50,51,51,50,49,END" + nl + "WWFrames=57,58,59,59,58,57,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=65,66,67,68,69,70,71,72,LOOP" + nl
					+ "NNFrames=73,74,75,76,77,78,79,80,LOOP" + nl + "NEFrames=81,82,83,84,85,86,87,88,LOOP" + nl
					+ "EEFrames=89,90,91,92,93,94,95,96,LOOP" + nl + "SEFrames=97,98,99,100,101,102,103,104,LOOP" + nl
					+ "SSFrames=105,106,107,108,109,110,111,112,LOOP" + nl
					+ "SWFrames=113,114,115,116,117,118,119,120,LOOP" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,LOOP" + nl + "MovementPerFrame=13" + nl
					+ "[Action Walk]" + nl + "NWFrames=129,130,131,132,133,134,135,136,LOOP" + nl
					+ "NNFrames=137,138,139,140,141,142,143,144,LOOP" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,LOOP" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,LOOP" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,LOOP" + nl + "MovementPerFrame=8" + nl
					+ "[Action Stand]" + nl + "NWFrames=129,130,131,132,133,134,135,136,RANDOM" + nl
					+ "NNFrames=137,138,139,140,141,142,143,144,RANDOM" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,RANDOM" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,RANDOM" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=25";
		} else if (index == 59) {
			actions = "Actions=Stand,Attack1,Pain,Death,Run,Walk" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=74" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=10" + nl + "[Action Walk]"
					+ nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP" + nl
					+ "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 60) {
			actions = "Actions=Attack1,Pain,Death,Run,Sit,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,END"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,END" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,END" + nl + "MovementPerFrame=10" + nl + "[Action Sit]"
					+ nl + "NWFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,END" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,END" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,END" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,END" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,END" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Stand]" + nl
					+ "NWFrames=257,258,259,260,261,262,263,264,RANDOM" + nl
					+ "NNFrames=265,266,267,268,269,270,271,272,RANDOM" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,RANDOM" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,RANDOM" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,RANDOM" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,RANDOM" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,RANDOM" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Walk]" + nl + "NWFrames=321,322,323,324,325,326,327,328,LOOP"
					+ nl + "NNFrames=329,330,331,332,333,334,335,336,LOOP" + nl
					+ "NEFrames=337,338,339,340,341,342,343,344,LOOP" + nl
					+ "EEFrames=345,346,347,348,349,350,351,352,LOOP" + nl
					+ "SEFrames=353,354,355,356,357,358,359,360,LOOP" + nl
					+ "SSFrames=361,362,363,364,365,366,367,368,LOOP" + nl
					+ "SWFrames=369,370,371,372,373,374,375,376,LOOP" + nl
					+ "WWFrames=377,378,379,380,381,382,383,384,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 61) {
			actions = "Actions=Pain,Death,Attack1,Stand,Walk" + nl + "[Action Death]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,9,10,11,12,END" + nl
					+ "NNFrames=13,14,15,16,17,18,19,20,21,22,23,24,END" + nl
					+ "NEFrames=25,26,27,28,29,30,31,32,33,34,35,36,END" + nl
					+ "EEFrames=37,38,39,40,41,42,43,44,45,46,47,48,END" + nl
					+ "SEFrames=49,50,51,52,53,54,55,56,57,58,59,60,END" + nl
					+ "SSFrames=61,62,63,64,65,66,67,68,69,70,71,72,END" + nl
					+ "SWFrames=73,74,75,76,77,78,79,80,81,82,83,84,END" + nl
					+ "WWFrames=85,86,87,88,89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=-1" + nl
					+ "[Action Pain]" + nl + "NWFrames=1,2,3,3,2,1,END" + nl + "NNFrames=13,14,15,15,14,13,END" + nl
					+ "NEFrames=25,26,27,27,26,25,END" + nl + "EEFrames=37,38,39,39,38,37,END" + nl
					+ "SEFrames=49,50,51,51,50,49,END" + nl + "SSFrames=61,62,63,63,62,61,END" + nl
					+ "SWFrames=73,74,75,75,74,73,END" + nl + "WWFrames=85,86,87,87,86,85,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Attack1]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END"
					+ nl + "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Stand]" + nl + "NWFrames=161,162,163,164,165,166,167,168,RANDOM" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,RANDOM" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,RANDOM" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,RANDOM" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,RANDOM" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,RANDOM" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,RANDOM" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=77" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 62) {
			actions = "Actions=Stand,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,5,6,7,8,RANDOM" + nl
					+ "NNFrames=9,10,11,12,13,14,15,16,RANDOM" + nl + "NEFrames=17,18,19,20,21,22,23,24,RANDOM" + nl
					+ "EEFrames=25,26,27,28,29,30,31,32,RANDOM" + nl + "SEFrames=33,34,35,36,37,38,39,40,RANDOM" + nl
					+ "SSFrames=41,42,43,44,45,46,47,48,RANDOM" + nl + "SWFrames=49,50,51,52,53,54,55,56,RANDOM" + nl
					+ "WWFrames=57,58,59,60,61,62,63,64,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=65"
					+ nl + "[Action Walk]" + nl + "NWFrames=65,66,67,68,69,70,71,72,LOOP" + nl
					+ "NNFrames=73,74,75,76,77,78,79,80,LOOP" + nl + "NEFrames=81,82,83,84,85,86,87,88,LOOP" + nl
					+ "EEFrames=89,90,91,92,93,94,95,96,LOOP" + nl + "SEFrames=97,98,99,100,101,102,103,104,LOOP" + nl
					+ "SSFrames=105,106,107,108,109,110,111,112,LOOP" + nl
					+ "SWFrames=113,114,115,116,117,118,119,120,LOOP" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 63) {
			actions = "Actions=Attack1,Pain,Death,Run,Sit,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,END"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,END" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,END" + nl + "MovementPerFrame=10" + nl + "[Action Sit]"
					+ nl + "NWFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,END" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,END" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,END" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,END" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,END" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Stand]" + nl
					+ "NWFrames=257,258,259,260,261,262,263,264,RANDOM" + nl
					+ "NNFrames=265,266,267,268,269,270,271,272,RANDOM" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,RANDOM" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,RANDOM" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,RANDOM" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,RANDOM" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,RANDOM" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Walk]" + nl + "NWFrames=321,322,323,324,325,326,327,328,LOOP"
					+ nl + "NNFrames=329,330,331,332,333,334,335,336,LOOP" + nl
					+ "NEFrames=337,338,339,340,341,342,343,344,LOOP" + nl
					+ "EEFrames=345,346,347,348,349,350,351,352,LOOP" + nl
					+ "SEFrames=353,354,355,356,357,358,359,360,LOOP" + nl
					+ "SSFrames=361,362,363,364,365,366,367,368,LOOP" + nl
					+ "SWFrames=369,370,371,372,373,374,375,376,LOOP" + nl
					+ "WWFrames=377,378,379,380,381,382,383,384,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 64) {
			actions = "Actions=Attack1,Pain,Death,Run,Sit,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,END"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,END" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,END" + nl + "MovementPerFrame=10" + nl + "[Action Sit]"
					+ nl + "NWFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,END" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,END" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,END" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,END" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,END" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Stand]" + nl
					+ "NWFrames=257,258,259,260,261,262,263,264,RANDOM" + nl
					+ "NNFrames=265,266,267,268,269,270,271,272,RANDOM" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,RANDOM" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,RANDOM" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,RANDOM" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,RANDOM" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,RANDOM" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Walk]" + nl + "NWFrames=321,322,323,324,325,326,327,328,LOOP"
					+ nl + "NNFrames=329,330,331,332,333,334,335,336,LOOP" + nl
					+ "NEFrames=337,338,339,340,341,342,343,344,LOOP" + nl
					+ "EEFrames=345,346,347,348,349,350,351,352,LOOP" + nl
					+ "SEFrames=353,354,355,356,357,358,359,360,LOOP" + nl
					+ "SSFrames=361,362,363,364,365,366,367,368,LOOP" + nl
					+ "SWFrames=369,370,371,372,373,374,375,376,LOOP" + nl
					+ "WWFrames=377,378,379,380,381,382,383,384,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 65) {
			actions = "Actions=Attack1,Pain,Death,Run,Sit,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,END"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,END" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,END" + nl + "MovementPerFrame=10" + nl + "[Action Sit]"
					+ nl + "NWFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,END" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,END" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,END" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,END" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,END" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Stand]" + nl
					+ "NWFrames=257,258,259,260,261,262,263,264,RANDOM" + nl
					+ "NNFrames=265,266,267,268,269,270,271,272,RANDOM" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,RANDOM" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,RANDOM" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,RANDOM" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,RANDOM" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,RANDOM" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Walk]" + nl + "NWFrames=321,322,323,324,325,326,327,328,LOOP"
					+ nl + "NNFrames=329,330,331,332,333,334,335,336,LOOP" + nl
					+ "NEFrames=337,338,339,340,341,342,343,344,LOOP" + nl
					+ "EEFrames=345,346,347,348,349,350,351,352,LOOP" + nl
					+ "SEFrames=353,354,355,356,357,358,359,360,LOOP" + nl
					+ "SSFrames=361,362,363,364,365,366,367,368,LOOP" + nl
					+ "SWFrames=369,370,371,372,373,374,375,376,LOOP" + nl
					+ "WWFrames=377,378,379,380,381,382,383,384,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 66) {
			actions = "Actions=Stand,Attack1,BowAttack,Cast,Pain,Death,Walk,Run" + nl + "[Action Stand]" + nl
					+ "NWFrames=1,2,3,4,RANDOM" + nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM"
					+ nl + "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=52" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action BowAttack]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Cast]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Death]" + nl + "NWFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "NNFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,END" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=161,162,163,163,162,161,END" + nl + "NNFrames=169,170,171,171,170,169,END" + nl
					+ "NEFrames=177,178,179,179,178,177,END" + nl + "EEFrames=185,186,187,187,186,185,END" + nl
					+ "SEFrames=193,194,195,195,194,193,END" + nl + "SSFrames=201,202,203,203,202,201,END" + nl
					+ "SWFrames=209,210,211,211,210,209,END" + nl + "WWFrames=217,218,219,219,218,217,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=225,226,227,228,229,230,231,232,LOOP"
					+ nl + "NNFrames=233,234,235,236,237,238,239,240,LOOP" + nl
					+ "NEFrames=241,242,243,244,245,246,247,248,LOOP" + nl
					+ "EEFrames=249,250,251,252,253,254,255,256,LOOP" + nl
					+ "SEFrames=257,258,259,260,261,262,263,264,LOOP" + nl
					+ "SSFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "SWFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "WWFrames=281,282,283,284,285,286,287,288,LOOP" + nl + "MovementPerFrame=5" + nl + "[Action Run]"
					+ nl + "NWFrames=297,298,299,300,301,302,303,304,END" + nl
					+ "NNFrames=305,306,307,308,309,310,311,312,END" + nl
					+ "NEFrames=313,314,315,316,317,318,319,320,END" + nl
					+ "EEFrames=321,322,323,324,325,326,327,328,END" + nl
					+ "SEFrames=329,330,331,332,333,334,335,336,END" + nl
					+ "SSFrames=337,338,339,340,341,342,343,344,END" + nl
					+ "SWFrames=345,346,347,348,349,350,351,352,END" + nl
					+ "WWFrames=353,354,355,356,357,358,359,360,END" + nl + "MovementPerFrame=10";
		} else if (index == 67) {
			actions = "Actions=Attack1,Pain,Death,Run,Sit,Stand,Walk,Cast" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Cast]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,END"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,END" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,END" + nl + "MovementPerFrame=10" + nl + "[Action Sit]"
					+ nl + "NWFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,END" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,END" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,END" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,END" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,END" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=52" + nl + "[Action Stand]" + nl
					+ "NWFrames=257,258,259,260,261,262,263,264,RANDOM" + nl
					+ "NNFrames=265,266,267,268,269,270,271,272,RANDOM" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,RANDOM" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,RANDOM" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,RANDOM" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,RANDOM" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,RANDOM" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=52" + nl + "[Action Walk]" + nl + "NWFrames=321,322,323,324,325,326,327,328,LOOP"
					+ nl + "NNFrames=329,330,331,332,333,334,335,336,LOOP" + nl
					+ "NEFrames=337,338,339,340,341,342,343,344,LOOP" + nl
					+ "EEFrames=345,346,347,348,349,350,351,352,LOOP" + nl
					+ "SEFrames=353,354,355,356,357,358,359,360,LOOP" + nl
					+ "SSFrames=361,362,363,364,365,366,367,368,LOOP" + nl
					+ "SWFrames=369,370,371,372,373,374,375,376,LOOP" + nl
					+ "WWFrames=377,378,379,380,381,382,383,384,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 68) {
			actions = "Actions=Attack1,Pain,Death,Run,Sit,Stand,Walk" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Death]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=65,66,67,67,66,65,END" + nl + "NNFrames=73,74,75,75,74,73,END" + nl
					+ "NEFrames=81,82,83,83,82,81,END" + nl + "EEFrames=89,90,91,91,90,89,END" + nl
					+ "SEFrames=97,98,99,99,98,97,END" + nl + "SSFrames=105,106,107,107,106,105,END" + nl
					+ "SWFrames=113,114,115,115,114,113,END" + nl + "WWFrames=121,122,123,123,122,121,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,END"
					+ nl + "NNFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,END" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,END" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,END" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,END" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,END" + nl + "MovementPerFrame=10" + nl + "[Action Sit]"
					+ nl + "NWFrames=193,194,195,196,197,198,199,200,END" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,END" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,END" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,END" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,END" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,END" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,END" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,END" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Stand]" + nl
					+ "NWFrames=257,258,259,260,261,262,263,264,RANDOM" + nl
					+ "NNFrames=265,266,267,268,269,270,271,272,RANDOM" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,RANDOM" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,RANDOM" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,RANDOM" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,RANDOM" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,RANDOM" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=63" + nl + "[Action Walk]" + nl + "NWFrames=321,322,323,324,325,326,327,328,LOOP"
					+ nl + "NNFrames=329,330,331,332,333,334,335,336,LOOP" + nl
					+ "NEFrames=337,338,339,340,341,342,343,344,LOOP" + nl
					+ "EEFrames=345,346,347,348,349,350,351,352,LOOP" + nl
					+ "SEFrames=353,354,355,356,357,358,359,360,LOOP" + nl
					+ "SSFrames=361,362,363,364,365,366,367,368,LOOP" + nl
					+ "SWFrames=369,370,371,372,373,374,375,376,LOOP" + nl
					+ "WWFrames=377,378,379,380,381,382,383,384,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 69) {
			actions = "Actions=Stand,Pain,Death,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM" + nl
					+ "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl + "EEFrames=13,14,15,16,RANDOM"
					+ nl + "SEFrames=17,18,19,20,RANDOM" + nl + "SSFrames=21,22,23,24,RANDOM" + nl
					+ "SWFrames=25,26,27,28,RANDOM" + nl + "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0"
					+ nl + "FrameMultiplier=81" + nl + "[Action Death]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END"
					+ nl + "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]" + nl
					+ "NWFrames=33,34,35,35,34,33,END" + nl + "NNFrames=41,42,43,43,42,41,END" + nl
					+ "NEFrames=49,50,51,51,50,49,END" + nl + "EEFrames=57,58,59,59,58,57,END" + nl
					+ "SEFrames=65,66,67,67,66,65,END" + nl + "SSFrames=73,74,75,75,74,73,END" + nl
					+ "SWFrames=81,82,83,83,82,81,END" + nl + "WWFrames=89,90,91,91,90,89,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=97,98,99,100,101,102,103,104,LOOP"
					+ nl + "NNFrames=105,106,107,108,109,110,111,112,LOOP" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,LOOP" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,LOOP" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,LOOP" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,LOOP" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,LOOP" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 71) {
			actions = "Actions=Stand,Attack1,Pain,Death,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM"
					+ nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl
					+ "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=52" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 72) {
			actions = "Actions=Stand,Attack1,Pain,Death,Walk" + nl + "[Action Stand]" + nl + "NWFrames=1,2,3,4,RANDOM"
					+ nl + "NNFrames=5,6,7,8,RANDOM" + nl + "NEFrames=9,10,11,12,RANDOM" + nl
					+ "EEFrames=13,14,15,16,RANDOM" + nl + "SEFrames=17,18,19,20,RANDOM" + nl
					+ "SSFrames=21,22,23,24,RANDOM" + nl + "SWFrames=25,26,27,28,RANDOM" + nl
					+ "WWFrames=29,30,31,32,RANDOM" + nl + "MovementPerFrame=0" + nl + "FrameMultiplier=52" + nl
					+ "[Action Attack1]" + nl + "NWFrames=33,34,35,36,37,38,39,40,END" + nl
					+ "NNFrames=41,42,43,44,45,46,47,48,END" + nl + "NEFrames=49,50,51,52,53,54,55,56,END" + nl
					+ "EEFrames=57,58,59,60,61,62,63,64,END" + nl + "SEFrames=65,66,67,68,69,70,71,72,END" + nl
					+ "SSFrames=73,74,75,76,77,78,79,80,END" + nl + "SWFrames=81,82,83,84,85,86,87,88,END" + nl
					+ "WWFrames=89,90,91,92,93,94,95,96,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl
					+ "[Action Death]" + nl + "NWFrames=97,98,99,100,101,102,103,104,END" + nl
					+ "NNFrames=105,106,107,108,109,110,111,112,END" + nl
					+ "NEFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "EEFrames=121,122,123,124,125,126,127,128,END" + nl
					+ "SEFrames=129,130,131,132,133,134,135,136,END" + nl
					+ "SSFrames=137,138,139,140,141,142,143,144,END" + nl
					+ "SWFrames=145,146,147,148,149,150,151,152,END" + nl
					+ "WWFrames=153,154,155,156,157,158,159,160,END" + nl + "MovementPerFrame=-1" + nl + "[Action Pain]"
					+ nl + "NWFrames=97,98,99,99,98,97,END" + nl + "NNFrames=105,106,107,107,106,105,END" + nl
					+ "NEFrames=113,114,115,115,114,113,END" + nl + "EEFrames=121,122,123,123,122,121,END" + nl
					+ "SEFrames=129,130,131,131,130,129,END" + nl + "SSFrames=137,138,139,139,138,137,END" + nl
					+ "SWFrames=145,146,147,147,146,145,END" + nl + "WWFrames=153,154,155,155,154,153,END" + nl
					+ "MovementPerFrame=0" + nl + "[Action Walk]" + nl + "NWFrames=161,162,163,164,165,166,167,168,LOOP"
					+ nl + "NNFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "NEFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "EEFrames=185,186,187,188,189,190,191,192,LOOP" + nl
					+ "SEFrames=193,194,195,196,197,198,199,200,LOOP" + nl
					+ "SSFrames=201,202,203,204,205,206,207,208,LOOP" + nl
					+ "SWFrames=209,210,211,212,213,214,215,216,LOOP" + nl
					+ "WWFrames=217,218,219,220,221,222,223,224,LOOP" + nl + "MovementPerFrame=5";
		} else if (index == 73) {
			actions = "Actions=Attack1,Attack2,Run,Stand,Walk,Pain,Death" + nl + "[Action Attack1]" + nl
					+ "NWFrames=1,2,3,4,5,6,7,8,END" + nl + "NNFrames=9,10,11,12,13,14,15,16,END" + nl
					+ "NEFrames=17,18,19,20,21,22,23,24,END" + nl + "EEFrames=25,26,27,28,29,30,31,32,END" + nl
					+ "SEFrames=33,34,35,36,37,38,39,40,END" + nl + "SSFrames=41,42,43,44,45,46,47,48,END" + nl
					+ "SWFrames=49,50,51,52,53,54,55,56,END" + nl + "WWFrames=57,58,59,60,61,62,63,64,END" + nl
					+ "MovementPerFrame=0" + nl + "TriggerFrame=6" + nl + "[Action Attack2]" + nl
					+ "NWFrames=65,66,67,68,69,70,71,72,END" + nl + "NNFrames=73,74,75,76,77,78,79,80,END" + nl
					+ "NEFrames=81,82,83,84,85,86,87,88,END" + nl + "EEFrames=89,90,91,92,93,94,95,96,END" + nl
					+ "SEFrames=97,98,99,100,101,102,103,104,END" + nl + "SSFrames=105,106,107,108,109,110,111,112,END"
					+ nl + "SWFrames=113,114,115,116,117,118,119,120,END" + nl
					+ "WWFrames=121,122,123,124,125,126,127,128,END" + nl + "MovementPerFrame=0" + nl + "TriggerFrame=6"
					+ nl + "[Action Run]" + nl + "NWFrames=129,130,131,132,133,134,135,136,LOOP" + nl
					+ "NNFrames=137,138,139,140,141,142,143,144,LOOP" + nl
					+ "NEFrames=145,146,147,148,149,150,151,152,LOOP" + nl
					+ "EEFrames=153,154,155,156,157,158,159,160,LOOP" + nl
					+ "SEFrames=161,162,163,164,165,166,167,168,LOOP" + nl
					+ "SSFrames=169,170,171,172,173,174,175,176,LOOP" + nl
					+ "SWFrames=177,178,179,180,181,182,183,184,LOOP" + nl
					+ "WWFrames=185,186,187,188,189,190,191,192,LOOP" + nl + "MovementPerFrame=10" + nl
					+ "[Action Stand]" + nl + "NWFrames=193,194,195,196,197,198,199,200,RANDOM" + nl
					+ "NNFrames=201,202,203,204,205,206,207,208,RANDOM" + nl
					+ "NEFrames=209,210,211,212,213,214,215,216,RANDOM" + nl
					+ "EEFrames=217,218,219,220,221,222,223,224,RANDOM" + nl
					+ "SEFrames=225,226,227,228,229,230,231,232,RANDOM" + nl
					+ "SSFrames=233,234,235,236,237,238,239,240,RANDOM" + nl
					+ "SWFrames=241,242,243,244,245,246,247,248,RANDOM" + nl
					+ "WWFrames=249,250,251,252,253,254,255,256,RANDOM" + nl + "MovementPerFrame=0" + nl
					+ "FrameMultiplier=66" + nl + "[Action Walk]" + nl + "NWFrames=257,258,259,260,261,262,263,264,LOOP"
					+ nl + "NNFrames=265,266,267,268,269,270,271,272,LOOP" + nl
					+ "NEFrames=273,274,275,276,277,278,279,280,LOOP" + nl
					+ "EEFrames=281,282,283,284,285,286,287,288,LOOP" + nl
					+ "SEFrames=289,290,291,292,293,294,295,296,LOOP" + nl
					+ "SSFrames=297,298,299,300,301,302,303,304,LOOP" + nl
					+ "SWFrames=305,306,307,308,309,310,311,312,LOOP" + nl
					+ "WWFrames=313,314,315,316,317,318,319,320,LOOP" + nl + "MovementPerFrame=5" + nl
					+ "[Action Death]" + nl + "NWFrames=321,322,323,324,325,326,327,328,329,END" + nl
					+ "NNFrames=330,331,332,333,334,335,336,337,338,END" + nl
					+ "NEFrames=339,340,341,342,343,344,345,346,347,END" + nl
					+ "EEFrames=348,349,350,351,352,353,354,355,356,END" + nl
					+ "SEFrames=357,358,359,360,361,362,363,364,365,END" + nl
					+ "SSFrames=366,367,368,369,370,371,372,373,374,END" + nl
					+ "SWFrames=375,376,377,378,379,380,381,382,383,END" + nl
					+ "WWFrames=384,385,386,387,388,389,390,391,392,END" + nl + "MovementPerFrame=-1" + nl
					+ "[Action Pain]" + nl + "NWFrames=321,322,323,323,322,321,END" + nl
					+ "NNFrames=330,331,332,332,331,330,END" + nl + "NEFrames=339,340,341,341,340,339,END" + nl
					+ "EEFrames=348,349,350,350,349,348,END" + nl + "SEFrames=357,358,359,359,358,357,END" + nl
					+ "SSFrames=366,367,368,368,367,366,END" + nl + "SWFrames=375,376,377,377,376,375,END" + nl
					+ "WWFrames=384,385,386,386,385,384,END" + nl + "MovementPerFrame=0";
		} else {
			actions = action + actionStand + actionAttack1 + actionAttack2 + actionAttack3 + actionBowAttack
					+ actionCast + actionDeath + actionPain + actionWalk + actionRun;
		}
		return actions;
	}

	public void create(int index) {
		String prefix = "naked=";
		String[] layers = { "SoACC\\MageBlue.gif", "SoACC\\MageRed.gif", "SoACC\\MageYellow.gif",
				"SoACC\\MageGreen.gif", "SoACC\\MagePurple.gif", "SoACC\\MageOrange.gif", "SoACC\\Mithras.gif",
				"SoACC\\Lich.gif", "SoACC\\BaseSkeleton.gif", "HumanMaleLayers\\BaseHumanMale.gif",
				"SoACC\\FemKnight3.gif", "NagaMale\\BaseNaga1.gif", "NagaMale\\BaseNaga2.gif",
				"ElfMaleLayers\\BaseElf.gif", "SoACC\\Wraith.gif", "SoACC\\Beetle1.gif", "SoACC\\CryptLearker.gif",
				"SoACC\\Spider1.gif", "SoACC\\RockGolem.gif", "SoACC\\Lizardman.gif", "SoACC\\Crockopod.gif",
				"SoACC\\FireGolem.gif", "SoACC\\IceGolom.gif", "SoACC\\LavaGolom.gif", "SoACC\\LavaCrab.gif",
				"SoACC\\YellowLizardman.gif", "SoACC\\BrownLizardman.gif", "SoACC\\RedLizardman.gif",
				"SoACC\\AstralGodess.gif", "SoACC\\BlackRabbit.gif", "SoACC\\BlueLizardman.gif",
				"SoACC\\BrownRabbit.gif", "SoACC\\Clydesdale.gif", "SoACC\\ClydesSadd2.gif", "SoACC\\ClydesSadd4.gif",
				"SoACC\\ClydesSadd5.gif", "SoACC\\ClydesSadd6.gif", "SoACC\\CryptLearkerLite.gif",
				"SoACC\\CryptLearkerSilverBack.gif", "SoACC\\DireWolf.gif", "SoACC\\Dog1.gif", "SoACC\\Dog2.gif",
				"SoACC\\DreamWalker1.gif", "SoACC\\DreamWalker2.gif", "SoACC\\DreamWalker3.gif",
				"SoACC\\FemGhostWarrior.gif", "SoACC\\FemKnight1.gif", "SoACC\\FemKnight2.gif", "SoACC\\FemKnight4.gif",
				"SoACC\\FemKnight5.gif", "SoACC\\FemZombie.gif", "SoACC\\GrayRabbit.gif", "SoACC\\LavaCrabLrg.gif",
				"SoACC\\LavaCrabSml.gif", "SoACC\\MountedKnight1.gif", "SoACC\\MountedKnight3.gif",
				"SoACC\\MountedKnight4.gif", "SoACC\\MountedKnight5.gif", "SoACC\\Rat.gif", "SoACC\\RockGolemDark.gif",
				"SoACC\\SnowWolf.gif", "SoACC\\Unicorn.gif", "SoACC\\Vortigerm.gif", "SoACC\\WarDog1.gif",
				"SoACC\\WarDog2.gif", "SoACC\\WarDog4.gif", "SoACC\\BaseHumanBlank.gif", "SoACC\\Wolf1.gif",
				"SoACC\\Wolf2.gif", "HumanFemaleLayers\\BaseHumanFemale.gif", "HumanFemaleLayers\\BaseHumanFemale2.gif",
				"SoACC\\Ogre.gif", "SoACC\\ShadowOgre.gif", "SoACC\\Yeti1.gif" };

		String layer = prefix + layers[index];

		String alles = "";
		String ende = nl + "leg1=" + nl + "leg2=" + nl + "boot=LowLeatherBoots" + nl + "chest1=" + nl + "chest2=" + nl
				+ "arm=" + nl + "belt=" + nl + "chest3=" + nl + "gauntlet=" + nl + "outer=" + nl + "head=" + nl
				+ "helmet=" + nl + "weapon=" + nl + "shield=" + nl + "misc2=comletter";
		String ende2 = nl + "leg1=WeiblKnightPlateGreavesBlack" + nl + "leg2=WeiblLegPlate" + nl + "boot=WeiblWBoot"
				+ nl + "chest1=WeiblChainShirt1" + nl + "chest2=WeiblChainShirt2" + nl + "arm=WeiblKnightUpperArm" + nl
				+ "belt=WeiblKiltGold" + nl + "chest3=WeiblBreastplateGold" + nl + "gauntlet=WeiblSteelGauntlet" + nl
				+ "outer=WeiblBreastplate" + nl + "head=HumanFemaleLayers\\LongHairDark2.gif" + nl + "helmet=" + nl
				+ "weapon=WeiblBastardSword" + nl + "shield=WeiblTShield";
		String aktion = actions().toString();

		if (index == 69) {
			alles = anfang + aktion + nl + nl + "[Layers]" + nl + layer + ende2;
		} else if (index == 70) {
			alles = anfang + aktion + nl + nl + "[Layers]" + nl + layer + ende2;
		} else {
			alles = anfang + aktion + nl + nl + "[Layers]" + nl + layer + ende;
		}

		writeData(alles);

	}

	private void writeData(String outputString) {
		BufferedWriter out;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Player.pox")));
			try {
				out.write(outputString);
			} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Schreiben fehlgeschlagen", "Fehler", JOptionPane.OK_CANCEL_OPTION);
			}
			out.newLine();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Zielordner nicht gefunden", "Fehler", JOptionPane.OK_CANCEL_OPTION);
		} finally {
		}
		File src = new File("Player.pox");
		File dest = new File("ArtLib\\Resources\\Players\\Player.pox");
		try {
			PoxCreator.copyFile(src, dest, 500000, true);
			src.delete();
			JOptionPane.showMessageDialog(null, parent.getSelectedListValue() + " wurde erfolgreich eingesetzt",
					"Erfolgreich", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Kopieren fehlgeschlagen", "Fehler", JOptionPane.OK_CANCEL_OPTION);
		}
	}

	public static void copyFile(File src, File dest, int bufSize, boolean force) throws IOException {
		if (dest.exists()) {
			if (force) {
				dest.delete();
			} else {
				throw new IOException("Cannot  overwrite  existing  file:  " + dest);

			}
		}
		byte[] buffer = new byte[bufSize];
		int read = 0;
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			while (true) {
				read = in.read(buffer);
				if (read == -1) {
					// -1 means EOF
					break;
				}
				out.write(buffer, 0, read);
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} finally {
					if (out != null) {
						out.close();
					}
				}
			}
		}
	}

}
