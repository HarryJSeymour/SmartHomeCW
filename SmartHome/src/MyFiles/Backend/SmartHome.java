package MyFiles.Backend;

public class SmartHome {
    // Private data types.
    private SmartPlug[] sPlug;
    private SmartPlug[] tempSPlug;
    private int currentIndex;
    private int newindex;
    private int roomIndex;
    private Rooms[] room;
    private Rooms[] tempRooms;
    private AttachedDevice[] attachedDevices;
    private AttachedDevice[] tempAttachedDevices;

    // Predefined devices.
    private String[] predefinedDevices = {"Lamp", "Tv", "Computer", "Phone Recharger", "Heater"};


    // Constructor
    public SmartHome(int numOfPlugs, int numberOfRooms) {
        sPlug = new SmartPlug[numOfPlugs];
        room = new Rooms[numberOfRooms];

        attachedDevices = new AttachedDevice[5];
        populateAttachedDevices();

        currentIndex = 0;
    }

    // Populating Arrays
    public void createRoom(String roomName){
        if(roomIndex >= numberOfRooms()){return;}
        Rooms object = new Rooms(roomIndex,roomName);
        room[roomIndex] = object;
        roomIndex++;

    }
    public void populateAttachedDevices(){
        for(int i = 0; i < attachedDevices.length; i++){
            AttachedDevice object = new AttachedDevice(i, predefinedDevices[i]);
            attachedDevices[i] = object;
        }
    }
    public void add(boolean status, int attachedToDeviceID, int roomID){
        if(currentIndex >= size()){return;}

        SmartPlug object = new SmartPlug(currentIndex,status,attachedToDeviceID,roomID);
        sPlug[currentIndex] = object;
        currentIndex++;
    }
    public void createDevice(String deviceName, int stPosv){
        if(stPosv >= numberODevices()){return;}
        AttachedDevice object = new AttachedDevice(stPosv,deviceName);
        attachedDevices[stPosv] = object;
    }


    // Array Sizes/Lengths
    public int numberOfRooms() {return room.length;}
    public int numberODevices() {return attachedDevices.length;}
    public int size(){return sPlug.length;}
    public boolean isFull() { if(currentIndex == size()){return true;} return false;}

    // Display methods.
    public String displayDevices(){
        String s ="";
        for(AttachedDevice object : attachedDevices){
            s += object.toString() + " ";

        }
        return s;
    }
    public String displayRooms(){
        String s ="";
        for(Rooms object : room){
            s += object.toString() + " ";

        }
        return s;
    }
    public String display(){
        newindex = 0;
        String s = "";
        for(SmartPlug object : sPlug){
            String roomName = room[sPlug[newindex].getRoomID()].getName();
            String deviceName = attachedDevices[sPlug[newindex].getDeviceID()].getName();

            s += object.toString(roomName, deviceName);
            newindex++;
        }
        return s;
    }
    public String displayRoomsSpecific(int roomID){
        newindex = 0;
        String s = "";
        for(SmartPlug object : sPlug){
            if(sPlug[newindex].getRoomID() == roomID){
                String roomName = room[sPlug[newindex].getRoomID()].getName();
                String deviceName = attachedDevices[sPlug[newindex].getDeviceID()].getName();

                s += object.toString(roomName, deviceName);
                newindex++;
            }
        }
        return s;

    }
    // Options.


    public void setAllLights(boolean state){
        for(int i = 0; i < size(); i++){
            sPlug[i].setStatus(state);
        }
    }
    public void setRoomLights(boolean state, int room){
        for(int i = 0; i < size(); i++){
            if (sPlug[i].getRoomID() == room){sPlug[i].setStatus(state);}
        }


    }
    public void toggleState(int ID){
        for(int i = 0; i < size(); i++){
            if (sPlug[i].getID() == ID){
                boolean stateHolder = sPlug[i].getStatus();
                sPlug[i].setStatus(!stateHolder);

            }
        }
    }

    // Plug Level Options.
    public void setPlugOffOn(int ID, boolean state){
        for(int i = 0; i < size(); i++){
            if (sPlug[i].getID() == ID){
                sPlug[i].setStatus(state);

            }
        }
    }
    public void changeDevice(int ID, int deviceID){
        sPlug[ID].setDeviceID(deviceID);
    }
    public void changeRoom(int ID, int roomID){
        sPlug[ID].setRoomID(roomID);
    }

    // System Operations.

//  1 - Add new Plug
    public void addNewPlugSlots(int amountOfPlugs){
        tempSPlug = new SmartPlug[size()+amountOfPlugs];
        for (int i = 0; i < size(); i++){
            tempSPlug[i] = sPlug[i];
        }

        sPlug = new SmartPlug[tempSPlug.length];

        for (int i = 0; i < tempSPlug.length; i++){
            sPlug[i] = tempSPlug[i];
        }
    }
//    2 - Add new System devices
    public void addNewDevices(int amountOfDevices){
        tempAttachedDevices = new AttachedDevice[attachedDevices.length + amountOfDevices];
        for (int i = 0; i < attachedDevices.length; i++){
            tempAttachedDevices[i] = attachedDevices[i];
        }

        attachedDevices = new AttachedDevice[tempAttachedDevices.length];

        for (int i = 0; i < tempAttachedDevices.length; i++){
            attachedDevices[i] = tempAttachedDevices[i];
        }
    }
//    3 - Add new rooms
    public void addNewRooms(int amountOfRooms){
        tempRooms = new Rooms[numberOfRooms() + amountOfRooms];

        for (int i = 0; i < numberOfRooms(); i++){
            tempRooms[i] = room[i];
        }

        room = new Rooms[tempRooms.length];

        for (int i = 0; i < tempRooms.length; i++){
            room[i] = tempRooms[i];
        }
    }





}
