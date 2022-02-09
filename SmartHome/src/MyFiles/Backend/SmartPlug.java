package MyFiles.Backend;

public class SmartPlug {
    private int attachedToDeviceID;
    private int roomID;
    private int Identifier;
    private boolean status;



    public SmartPlug(int id, boolean status, int attachedToDeviceID, int roomID) {
        this.status = status;
        this.Identifier = id;
        this.roomID = roomID;
        this.attachedToDeviceID = attachedToDeviceID;
    }

    // Identifier
    public int getID() {return Identifier;}
    public void setID(int id) {this.Identifier = id;}

    // Room ID
    public int getRoomID() {return roomID;}
    public void setRoomID(int ID) {this.roomID = ID;}
    // Device ID
    public int getDeviceID() {return attachedToDeviceID;}
    public void setDeviceID(int ID) {this.attachedToDeviceID = ID;}


    // Status
    public boolean getStatus() {return status;}
    public void setStatus(boolean status) {this.status = status;}


    public String toString(String roomName, String deviceName){
        return "\nRoomID "+roomID+"\n" +
                "Smart Plug | ID: "+Identifier+" | Status: "+status+" | Room "+roomName+" | Attached to: "+deviceName;

    }
}
