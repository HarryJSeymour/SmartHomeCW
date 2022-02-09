package MyFiles;
import MyFiles.Backend.SmartHome;

import java.util.Scanner;

public class ConsoleHelper {
    // Do not store data here!

    // Dashboard
        public void displayDashboard(SmartHome sH){
            output("---------------DASHBOARD--------------");
            output(sH.display());

        }
        public int displayOptions(SmartHome sH){
            output("\n-------------MENU OPTIONS-------------");
            output("---------Please select option:--------\n");

            output("1 - House level options\n" +
                    "2 - Room level options\n" +
                    "3 - Plug level options\n" +
                    "4 - System options\n" +
                    "5 - Exit\n");

            int userChoice = inputInt("");

            switch(userChoice){
                case 1:
                    houseLevelOptions(sH);
                    break;
                case 2:
                    roomLevelOptions(sH);
                    break;
                case 3:
                    plugLevelOption(sH);
                    break;
                case 4:
                    systemOption(sH);
                    break;
                case 5:
                    return 0;

                default:
                    output("please enter a valid option");

            }

            return 1;
        }

        // Options
    public void houseLevelOptions(SmartHome sH){
            output("HOUSE LEVEL OPTIONS\n" +
                    "1 - Switch all plugs off\n" +
                    "2 - Switch all plugs on\n" +
                    "Select an option\n");
            switch(inputInt("")){
                case 1:
                    sH.setAllLights(false);
                    break;
                case 2:
                    sH.setAllLights(true);
                    break;
                default:
                    output("please enter a valid option");

        }
    }

    public void roomLevelOptions(SmartHome sH){
            int roomChange = inputInt("Please select a room ID to change: ");
            output(sH.displayRoomsSpecific(roomChange));
            output("\nROOM LEVEL OPTIONS\n" +
                    "1 - Switch all plugs off in room\n" +
                    "2 - Switch all plugs on in room\n" +
                    "3 - Select a plug in the room and toggle its on/off status\n"+
                    "Select an option\n");
            switch (inputInt("")){
                case 1:
                    sH.setRoomLights(false, roomChange);
                    break;
                case 2:
                    sH.setRoomLights(true, roomChange);
                    break;
                case 3:
                    output("Please enter the ID of the specific light to change: ");
                    sH.toggleState(inputInt(""));




                default:
                    output("please enter a valid option");

            }
    }

    public void  plugLevelOption(SmartHome sH){
            output(sH.display());
        int ID = inputInt("\nPlease enter the ID of the specific light to change: ");

        output("PLUG LEVEL OPTIONS\n" +
                "1 - Switch plug off\n" +
                "2 - Switch plug on\n" +
                "3 - Change attached device\n" +
                "4 - Move plug to different room\n");

        switch(inputInt("")){
            case 1:
                sH.setPlugOffOn(ID, false);
                break;
            case 2:
                sH.setPlugOffOn(ID, true);

                break;
            case 3:
                output(sH.displayDevices());
                sH.changeDevice(ID, inputInt(""));
                break;
            case 4:
                output(sH.displayRooms());
                sH.changeRoom(ID, inputInt(""));
                break;
            default:
                output("please enter a valid option");

        }

    }

    public void systemOption(SmartHome sH){

        output("System OPTIONS\n" +
                "1 - Add new Plugs\n" +
                "2 - Add new System devices\n" +
                "3 - Add new rooms\n");

        switch(inputInt("")){
            case 1:
                int stPosv = sH.size();
                sH.addNewPlugSlots((inputInt("Please enter the amount of additional plugs to be added: ")));
                populate(sH, stPosv);
                break;
            case 2:
                stPosv = sH.numberODevices();
                output("Current Devices");
                output(sH.displayDevices());
                sH.addNewDevices((inputInt("Please enter the amount of additional devices to be added: ")));
                populateDevices(sH, stPosv);
                output("Updated Devices");
                output(sH.displayDevices());
                break;
            case 3:
                stPosv = sH.numberOfRooms();
                output("Current Rooms");
                output(sH.displayRooms());
                sH.addNewRooms((inputInt("Please enter the amount of additional rooms to be added: ")));
                populateRooms(sH, stPosv);
                output("Updated Rooms");
                output(sH.displayRooms());
                break;
            default:
                output("please enter a valid option");

        }

    }


    // Methods/Functions for sending data from the user to the server objects.
        public void populateRooms(SmartHome sH, int stPosv){
            for(int i = stPosv; i< sH.numberOfRooms(); i++){
                String roomName = inputStr("Please enter the name of room: ");
                sH.createRoom(roomName);
            }
        }
        public void populateDevices(SmartHome sH, int stPosv){
            for(int i = stPosv; i< sH.numberODevices(); i++){
                String deviceName = inputStr("Please enter the name of device: ");
                sH.createDevice(deviceName, stPosv);
                stPosv++;
            }
        }
        public void populate(SmartHome sH, int startPos) {
                int x = startPos;
                for (int i = x; i < sH.size(); i++) {
                    output("Plug "+(i+1)+"/"+sH.size());
                    output(sH.displayDevices());
                    output(sH.displayRooms());
                    output("\nUsing the above list, please select the device/room to attach to the smart plug (integer only):");
                    int roomID = inputInt("Room ID: ");
                    int aTdID = inputInt("Device ID: ");

                    sH.add(false, aTdID, roomID);
                }
            }


    // Outputting to the console.
    public void output(String prompt){ System.out.println(prompt);}
    public void output(int prompt){ System.out.println(prompt);}
    public void output(double prompt){ System.out.println(prompt);}
    public void output(boolean prompt){ System.out.println(prompt);}

    // Inputs from the user.
    public int inputInt(String prompt){ //Int inputs.
        Scanner in = new Scanner(System.in);
        int i;
        output(prompt);
        try {
            i = in.nextInt();
        } catch (Exception e){
            //extra messages
            return inputInt(prompt);
        }
        return i;
    }
    public String inputStr(String prompt){ // String inputs.
        Scanner in = new Scanner(System.in);
        String s;
        output(prompt);
        try {
            s = in.nextLine();
        } catch (Exception e){
            return inputStr(prompt);
        }
        return s;
    }
    public boolean inputBool(String prompt){ // Boolean inputs.
        Scanner in = new Scanner(System.in);
        boolean b;
        output(prompt);
        try {
            b = in.nextBoolean();
        } catch (Exception e){
            return inputBool(prompt);
        }
        return b;
    }

}
