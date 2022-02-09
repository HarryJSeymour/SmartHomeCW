package MyFiles;

import MyFiles.Backend.SmartHome;
import MyFiles.Backend.SmartPlug;

public class Dashboard {

    public static void main(String[] args) {
        // Do not store data here!
        int x = 1;

        //BUILD SMARTHOME & CONSOLE HELPER OBJECTS
        ConsoleHelper cH = new ConsoleHelper();

        int numOfRooms = cH.inputInt("How many rooms are there in this property? ");
        int numOfPlugs = cH.inputInt("How many plugs do you want to place in this property: ");

        SmartHome sH = new SmartHome(numOfPlugs,numOfRooms);
        cH.populateRooms(sH, 0);

//      POPULATE SMARTHOME
        cH.populate(sH, 0);

        //while
        while (x == 1) {
            //DISPLAY DASHBOARD
            cH.displayDashboard(sH);

            //DISPLAY OPTIONS / PROCESS OPTIONS/ACTIONS
            x = cH.displayOptions(sH);
        }
    }
}
