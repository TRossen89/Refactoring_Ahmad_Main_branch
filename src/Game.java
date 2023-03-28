import java.util.ArrayList;
import model.Account;
import model.Player;

import util.TextUI;
import util.FileIO;

//Todo: - Rename class to Game,
//      - Change fields and methodnames so that it reflects precisely the Game class in the class diagram
//      - Add the setup method:
//      a. loads or prompts for gamedata,
//      b. creates the Player objects
//      (reuse the code from the main method)


//
public class Game {
    public int maxPlayers;


    //

    private ArrayList<Player> players = new ArrayList<>();

    private TextUI ui;
    private FileIO io;

    public Game(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }



    public Player registerPlayer(String name){
        Player p = new Player(name);
        players.add(p);
        return p;
    }


    void setup(){



        TextUI ui = new TextUI();
        int count = 0;

        FileIO fileIO = new FileIO();
        ArrayList<String> data = fileIO.readGameData("src/data.csv");


        if(data.size()>1) {



            for (String s : data) {
                String[] line = s.split(",");
                String name = line[0];
                int balance = Integer.parseInt(line[1].trim());
                Player c = registerPlayer(name);
                c.receiveAmount(balance);


            }



        }else {

            while (count < this.maxPlayers) {
                String name = ui.getInput("Skriv kundens navn: ");
                Player c = registerPlayer(name);
                c.receiveAmount(30000);
                count++;
            }


        }




    }

    private void endGame(){

        FileIO fileIO = new FileIO();


        fileIO.saveData("src/data.csv", getPlayers());

    }

    public void displayPlayers(){
        for (Player p: players) {
            System.out.println(p);
        }
    }


    public Player getPlayer(int i){

        return players.get(i);
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }
    //todo: add endGame method
}
