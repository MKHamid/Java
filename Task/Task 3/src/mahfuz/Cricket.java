package mahfuz;

public class Cricket extends Sports {
  String matchType;
  int over;
  Player player;

  Cricket(String matchType, int over, Player player) {
    this.matchType = matchType;
    this.over = over;
    this.player = player;
  }

  void display() {
  System.out.println("Match Type: " + matchType);
  System.out.println("Over of the match: " + over);
  System.out.println("Name of a player: " + player.playerName);
  System.out.println("Jersey number of a player: " + player.jerseyNumber);
  }
}

    /*
        Name: Mahfuzur Rahman Chowdhury
        ID: 2012020117
        Section: C
        Email: cse_2012020117@lus.ac.bd
        Date: 11th September, 2021
    */