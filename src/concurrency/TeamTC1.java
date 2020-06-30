package concurrency;


import java.util.ArrayList;
import java.util.List;

class TeamTC1 implements Runnable {


    String name;
    List<String> team = new ArrayList<>();
    String[] names = {"Dylan Fellows", "George Torres", "Jeramie Andrews", "Jessica Ulysse", "John Kol",
            "Katherine Kim", "Kevin Ibanez", "Matthew Castiglione" , "Nancy Golden", "Norita Sieffert",
            "Sabitha","Vani Muppuru", "Victor Betts", "Vimala Murthy"};

    TeamTC1(String name) {
        this.name = name;
    }
    // This thread should be created by implementing the Runnable interface, NOT by extending the Thread class.
    // In the run method of this thread, print out the name of each student in your TA group, (starting with your
    // TA).  There should be a pause of 1 second before each name is printed to the console.The name should then
    // be pushed to the team List  After all the names have been pushed to this List, print out the entire list
    // of all the students in your TA group. Don't forget your TA as well!  All of these steps should be done
    // whenever the thread is started.  (i.e. it can be done directly in the run() method of the thread itself).
    // Kick off the thread in the Main class of the concurrency package.

    public void run() {
        int colorCode = -1;
        for (String name : names) {
            colorCode++;
            String personName =  "\u001b[38;5;" + colorCode + "m " + name;
            System.out.println(this.name + " - " + personName);
            team.add(personName);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(team);
    }
}