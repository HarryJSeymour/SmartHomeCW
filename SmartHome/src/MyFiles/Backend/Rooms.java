package MyFiles.Backend;

public class Rooms {
    private int roomID;
    private String roomName;

    public Rooms(int roomID, String roomName) {
        this.roomID = roomID;
        this.roomName = roomName;

    }

    // RoomID
    public int getID() {return roomID;}
    public void setID(int id) {this.roomID = id;}

    // Name
    public String getName() {return roomName;}
    public void setName(String roomName) {this.roomName = roomName;}

    @Override
    public String toString(){
        return "\nRoom ID " +roomID+ " | Room Name "+roomName;
    }


}
