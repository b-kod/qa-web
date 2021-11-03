package demo;

public class Robots {
    String model;
    String exploitationPeriod;
    boolean incidentsWithHuman;
    String incidentsDescription;

    public void sayModel() {
        System.out.println("Model: " + model);
    }

    public void sayPeriodOfExploitation() {
        System.out.println("The exploitation period is " + exploitationPeriod + " years");
    }

    public void areThereAnyIncidentsWithPeople() {
        if(incidentsWithHuman) {
            System.out.println("Were there any incidents with previous owners: yes");
        } else {
            System.out.println("Were there any incidents with previous owners: no");
        }
    }

    public void whatHappened() {
        System.out.println("Detected incidents are: " + incidentsDescription);
    }

    public static void main(String[] args) {
        Robots modelZ2 = new Robots();
        modelZ2.model = "Z2";
        modelZ2.exploitationPeriod = "25";
        modelZ2.incidentsWithHuman = true;
        modelZ2.incidentsDescription = "The robot bitten 20 owners";

        Robots modelBB8 = new Robots();
        modelBB8.model = "BB8";
        modelBB8.exploitationPeriod = "45";
        modelBB8.incidentsWithHuman = false;
        modelBB8.incidentsDescription = "No incidents. BB8 loves human";

        modelZ2.sayModel();
        modelZ2.sayPeriodOfExploitation();
        modelZ2.areThereAnyIncidentsWithPeople();
        modelZ2.whatHappened();

        modelBB8.sayModel();
        modelBB8.sayPeriodOfExploitation();
        modelBB8.areThereAnyIncidentsWithPeople();
        modelBB8.whatHappened();

    }

}