package MyFiles.Backend;

public class AttachedDevice {
    private int attachedDeviceID;
    private String attachedDeviceName;

    public AttachedDevice(int attachedDeviceID, String attachedDeviceName) {
        this.attachedDeviceID = attachedDeviceID;
        this.attachedDeviceName = attachedDeviceName;

    }

    // Attached Device ID
    public int getID() {return attachedDeviceID;}
    public void setID(int id) {this.attachedDeviceID = id;}

    // Name
    public String getName() {return attachedDeviceName;}
    public void setName(String deviceName) {this.attachedDeviceName = deviceName;}

    @Override
    public String toString(){
        return "\nDevice ID " +attachedDeviceID+ " | Device Name "+attachedDeviceName;
    }
}
