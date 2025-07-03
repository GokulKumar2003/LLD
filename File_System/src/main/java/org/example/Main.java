package org.example;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Directory interviewPrep = new Directory("Interview_Prep", null);

        File file1 = new File("Crack_FAANG", interviewPrep);
        Directory sysDesign = new Directory("System_Design", interviewPrep);

        Directory hld = new Directory("HLD", sysDesign);
        Directory lld = new Directory("LLD", sysDesign);

        File lldpattern1 = new File("lld_pattern1", lld);
        File rate_limiting = new File("rate_limiting", hld);

        /* to observe last modified */
        try {
            sleep(10000);
        }
        catch(InterruptedException e) {
            System.out.println("Interupted Exception");
        }
        rate_limiting.updateLastModifiedAt();
        interviewPrep.print(" ");
    }
}