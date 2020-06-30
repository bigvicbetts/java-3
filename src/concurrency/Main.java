package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.

        Reasoning reason = new Reasoning();
        reason.start();

        TeamTC1 team = new TeamTC1("Team Semicolon;");
        Thread myTeam = new Thread(team);
        myTeam.start();
    }
}