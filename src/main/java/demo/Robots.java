package demo;

public class Robots {
    String model;
    String exploitationPeriod;
    boolean incidentsWithHuman;
    String incidentsDescription;
    Characteristics characteristics;

    public Robots(String model, String exploitationPeriod, boolean incidentsWithHuman, String incidentsDescription) {
        this.model = model;
        this.exploitationPeriod = exploitationPeriod;
        this.incidentsWithHuman = incidentsWithHuman;
        this.incidentsDescription = incidentsDescription;
    }

    public void printModel() {
        System.out.println("Model: " + model);
    }

    public void printPeriodOfExploitation() {
        System.out.println("The exploitation period is " + exploitationPeriod + " years");
    }

    public void areThereAnyIncidentsWithPeople() {
        if(incidentsWithHuman) {
            System.out.println("Were there any incidents with previous owners: yes");
        } else {
            System.out.println("Were there any incidents with previous owners: no");
        }
    }

    public void printWhatHappened() {
        System.out.println("Detected incidents are: " + incidentsDescription);
    }

    static class Characteristics {
        int intelligence;
        int sensePerception;
        int dexterity;
        int power;

        public Characteristics(int intelligence, int sensePerception, int dexterity, int power) {
            this.intelligence = intelligence;
            this.sensePerception = sensePerception;
            this.dexterity = dexterity;
            this.power = power;
        }

        public void printIntelligenceLevel() {
            System.out.println("Intelligence: " + intelligence);
        }

        public void printSensePerceptionLevel() {
            System.out.println("Sense perception: " + sensePerception);
        }

        public void printDexterityLevel() {
            System.out.println("Dexterity: " + dexterity);
        }

        public void printPowerLevel() {
            System.out.println("Power: " + power);
        }
    }
}