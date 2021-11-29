package demo;

public class RobotsDemo {
    public static void main(String[] args) {
        Robots model1 = new Robots("Z2", "25", true, "The robot bitten 20 owners");
        model1.characteristics = new Robots.Characteristics(4, 10, 10, 10);

        Robots model2 = new Robots("Z2", "45", false, "No incidents. BB8 loves human");
        model2.characteristics = new Robots.Characteristics(10, 10, 6, 6);

        model1.printModel();
        model1.characteristics.printIntelligenceLevel();
        model1.characteristics.printSensePerceptionLevel();
        model1.characteristics.printDexterityLevel();
        model1.characteristics.printPowerLevel();
        model1.printPeriodOfExploitation();
        model1.areThereAnyIncidentsWithPeople();
        model1.printWhatHappened();


        model2.printModel();
        model2.characteristics.printIntelligenceLevel();
        model2.characteristics.printSensePerceptionLevel();
        model2.characteristics.printDexterityLevel();
        model2.characteristics.printPowerLevel();
        model2.printPeriodOfExploitation();
        model2.areThereAnyIncidentsWithPeople();
        model2.printWhatHappened();
    }
}
