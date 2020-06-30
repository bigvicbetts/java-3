package concurrency;

class Reasoning extends Thread{
    //set up this class so it can become a valid thread. 
    void distinguish() {
        //print to the console the difference between a thread and a process
        //print out you think will happen if you invoke the run() method of a
        // thread as opposed to the start() method of a thread.

        System.out.println("A process can contain multiple threads.  The process is the computer " +
                "application and the threads are the smallest parts of that computer application that " +
                "can operate concurrently.  Processes operate in their own address space and threads all " +
                "share the process' address space (they are not assigned their own space.");

        System.out.println("If you invoke the .run() method on a Thread, a new thread will NOT be created " +
                "and the method will run on the calling thread itself.  Since it will only run on a single " +
                "thread, this defeats the whole idea of concurrency (i.e. multiple threads running simultaneously).  " +
                "There will also be no error if .run() is called multiple times, like there would be if .start() " +
                "was called more than once; you would just get a repeat of the same behavior that, theoretically, " +
                "is not what was desired.");
    }

    public void run() {
        distinguish();
    }
}

