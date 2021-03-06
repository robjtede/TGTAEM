package sqlDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import command.Action;
import command.Word;
import objects.Item;
import objects.ItemContainer;
import objects.NPC;
import objects.Player;
import objects.Room;

public class InitialData {
	
	public static List<Pair<String, String>> getShortcuts() throws IOException {
		List<Pair<String, String>> shortcutList = new ArrayList<>();
		ReadCSV readShortcuts = new ReadCSV("shortcuts.csv");
		try {
			readShortcuts.next(); // skip headings
			while (true) {
				List<String> tuple = readShortcuts.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String shortcut = i.next();
				String action = i.next();
				Pair<String, String> p = new Pair<>(shortcut, action);
				shortcutList.add(p);
			}
			return shortcutList;
		} finally {
			readShortcuts.close();
		}
	}
	
	public static List<Word> getWords() throws IOException {
		List<Word> wordList = new ArrayList<Word>();
		ReadCSV readWords = new ReadCSV("words.csv");
		try {
			readWords.next(); // skip headings
			while (true) {
				List<String> tuple = readWords.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String prime = i.next();
				String name = i.next();
				int type = Integer.parseInt(i.next());
				Word word = new Word(name, prime, type);
				wordList.add(word);
			}
			return wordList;
		} finally {
			readWords.close();
		}
	}

	public static List<Action> getActions() throws IOException {
		List<Action> actionList = new ArrayList<Action>();
		ReadCSV readActions = new ReadCSV("actions.csv");
		try {
			readActions.next(); // skip headings
			while (true) {
				List<String> tuple = readActions.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String name = i.next();
				Word verb = Word.makeWord(i.next(), 1);
				Word noun = Word.makeWord(i.next(), 2);
				String method = i.next();
				Action action = new Action(name, verb, noun, method);
				actionList.add(action);
			}
			return actionList;
		} finally {
			readActions.close();
		}
	}

	public static List<Room> getRooms() throws IOException {
		List<Room> roomList = new ArrayList<Room>();
		ReadCSV readRooms = new ReadCSV("map.csv");
		try {
			readRooms.next(); // skip headings
			while (true) {
				List<String> tuple = readRooms.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String id = i.next();
				String name = i.next();
				String dscrpt = i.next();
				boolean visited = false;
				int x = Integer.parseInt(i.next());
				if (x == 1) {
					visited = true;
				}
				boolean dark = false;
				x = Integer.parseInt(i.next());
				if (x == 1) {
					dark = true;
				}
				boolean locked = false;
				x = Integer.parseInt(i.next());
				if (x == 1) {
					locked = true;
				}
				x = Integer.parseInt(i.next());
				Room r = new Room();
				r.setID(id);
				r.setDisplayName(name);
				r.setDescription(dscrpt);
				r.setVisited(visited);
				r.setDark(dark);
				r.setLocked(locked);
				r.setTemp(x);
				roomList.add(r);
			}
			return roomList;
		} finally {
			readRooms.close();
		}
	}

	public static List<Item> getItems() throws IOException { 
		List<Item> itemList = new ArrayList<Item>();
		ReadCSV readItems = new ReadCSV("items.csv");
		try {
			readItems.next(); // skip headings
			while (true) {
				List<String> tuple = readItems.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				
				Item item = new Item();
				
				item.setID(i.next());
				item.setName(i.next());
				item.setInitDscrpt(i.next());
				item.setInventDscrpt(i.next());				
				boolean hidden = false;
				boolean moved = false;
				boolean vowel = false;
				boolean plural = false;
				boolean container = false;
				int x = Integer.parseInt(i.next());
				if (x == 1) {
					hidden = true;
				}
				x = Integer.parseInt(i.next());
				if (x == 1) {
					moved = true;
				}
				x = Integer.parseInt(i.next());
				if (x == 1) {
					vowel = true;
				}
				x = Integer.parseInt(i.next());
				if (x == 1) {
					plural = true;
				}
				x = Integer.parseInt(i.next());
				if (x == 1) {
					container = true;
				}
				item.setHidden(hidden);
				item.setMoved(moved);
				item.setVowel(vowel);
				item.setPlural(plural);
				item.setIsContainer(container);
				item.setWeight(Integer.parseInt(i.next()));
				
				itemList.add(item);
			}
			return itemList;
		} finally {
			readItems.close();
		}
	}
	
	public static List<NPC> getNPCs() throws IOException {
		List<NPC> npcList = new ArrayList<NPC>();
		ReadCSV readNPCs = new ReadCSV("npcs.csv");
		try {
			readNPCs.next(); // skip headings
			while (true) {
				List<String> tuple = readNPCs.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				NPC npc = new NPC();
				npc.setID(i.next());
				npc.setName(i.next());
				npc.setHealth(Integer.parseInt(i.next()));
				npc.setAttack(Integer.parseInt(i.next()));
				npc.setDefense(Integer.parseInt(i.next()));
				npc.setDescription(i.next());
				
				npcList.add(npc);
			}
			return npcList;
		} finally {
			readNPCs.close();
		}
	}


	public static List<Pair<String, String>> getItemMap() throws IOException {
		List<Pair<String, String>> itemMap = new ArrayList<>();
		ReadCSV readItems = new ReadCSV("itemMap.csv");
		try {
			readItems.next(); // skip headings
			while (true) {
				List<String> tuple = readItems.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String id = i.next();
				String loc = i.next();
				Pair<String, String> p = new Pair<>(id, loc);
				itemMap.add(p);
			}
			return itemMap;
		} finally {
			readItems.close();
		}
	}
	
	public static List<Pair<String, String>> getNPCMap() throws IOException {
		List<Pair<String, String>> npcMap = new ArrayList<>();
		ReadCSV readNPCs = new ReadCSV("npcs_loc.csv");
		try {
			readNPCs.next(); // skip headings
			while (true) {
				List<String> tuple = readNPCs.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String id = i.next();
				String loc = i.next();
				Pair<String, String> p = new Pair<>(id, loc);
				npcMap.add(p);
			}
			return npcMap;
		} finally {
			readNPCs.close();
		}
	}
	
	public static List<Player> getPlayers() throws IOException {
		List<Player> playerList = new ArrayList<Player>();
		ReadCSV readPlayers = new ReadCSV("player.csv");
		try {
			readPlayers.next(); // skip headings
			while (true) {
				List<String> tuple = readPlayers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Player player = new Player();
				player.setID(i.next());
				player.setLocation(i.next());
				player.setHealth(Integer.parseInt(i.next()));
				player.setAttack(Integer.parseInt(i.next()));
				player.setDefense(Integer.parseInt(i.next()));
				
				playerList.add(player);
			}
			return playerList;
		} finally {
			readPlayers.close();
		}
	}	
	
	public static List<Pair<String, String>> getPlayerMap() throws IOException {
		List<Pair<String, String>> playerMap = new ArrayList<>();
		ReadCSV readPlayers = new ReadCSV("player_loc.csv");
		try {
			readPlayers.next(); // skip headings
			while (true) {
				List<String> tuple = readPlayers.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String id = i.next();
				String loc = i.next();
				Pair<String, String> p = new Pair<>(id, loc);
				playerMap.add(p);
			}
			return playerMap;
		} finally {
			readPlayers.close();
		}
	}
	
	public static List<Pair<String, Pair<String, String>>> getConnections() throws IOException {
		List<Pair<String, Pair<String, String>>> connections = new ArrayList<>();
		ReadCSV readConnections = new ReadCSV("connections.csv");
		try {
			String o = "";
			while (true) {
				List<String> tuple = readConnections.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String x = i.next();
				if(x.equals("room"))
				{
					o = i.next();
				}
				else
				{
					String action = x;
					String destination = i.next();
					Pair<String, String> p = new Pair<>(action, destination);
					Pair<String, Pair<String, String>> p2 = new Pair<>(o, p);
					connections.add(p2);
				}
			}
			return connections;
		} finally {
			readConnections.close();
		}
	}
	
	public static List<Pair<String, String>> getDialogue() throws IOException {
		List<Pair<String, String>> dialogueList = new ArrayList<Pair<String, String>>();
		ReadCSV readDialogue = new ReadCSV("dialogue.csv");
		try {
			readDialogue.next(); // skip headings
			while (true) {
				List<String> tuple = readDialogue.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String id = i.next();
				String dialogue = i.next();
				Pair<String, String> p = new Pair<>(id, dialogue);
				dialogueList.add(p);
			}
			return dialogueList;
		} finally {
			readDialogue.close();
		}
	}
	
	public static List<String> getDialogueTree() throws IOException {
		List<String> dialogueTreeList = new ArrayList<String>();
		ReadCSV readDialogueTree = new ReadCSV("dialogue_tree.csv");
		try {
			readDialogueTree.next(); // skip headings
			while (true) {
				List<String> tuple = readDialogueTree.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String newickTree = i.next();
				dialogueTreeList.add(newickTree);
			}
			return dialogueTreeList;
		} finally {
			readDialogueTree.close();
		}
	}
	
	public static List<ItemContainer> getItemContainers() throws IOException {
		List<ItemContainer> containers = new ArrayList<>();
		ReadCSV readItemContainers = new ReadCSV("itemContainers.csv");
		try {
			while (true) {
			readItemContainers.next(); //skip headings
			List<String> tuple = readItemContainers.next();
			if (tuple == null) {
				break;
			}
			Iterator<String> i = tuple.iterator();
			
			ItemContainer ic = new ItemContainer();
			
			String id = i.next();
			ic.setID(id);
			ic.setMaxWeight(Integer.parseInt(i.next()));
			containers.add(ic);
			}
			return containers;
		} finally {
			readItemContainers.close();
		}
	}
	
	public static List<Pair<String, String>> getNPCDialogueMap() throws IOException {
		List<Pair<String, String>> npcDialogueMap = new ArrayList<>();
		ReadCSV readDialogueMap = new ReadCSV("npcDialogueMap.csv");
		try {
			readDialogueMap.next(); // skip headings
			while (true) {
				List<String> tuple = readDialogueMap.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String npcID = i.next();
				String dialogueID = i.next();
				Pair<String, String> p = new Pair<>(npcID, dialogueID);
				npcDialogueMap.add(p);
			}
			return npcDialogueMap;
		} finally {
			readDialogueMap.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		//List<Pair<String, String>> list = getShortcuts();
		//for(Pair<String, String> i : list) {
			//String s = i.getLeft();
			//String s2 = i.getRight();
			//System.out.println("-"+s + "-" + s2 + "-");
		//}
		List<Item> list = getItems();
		for(Item i : list) {
			System.out.println("" + i.isContainer() + "");
		}
		return;
	}
}
