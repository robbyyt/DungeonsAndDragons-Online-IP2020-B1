package Server;

import java.util.ArrayList;
import java.util.List;

public class ServerRooms {
    List<Room> roomList = new ArrayList<>();
    public void addRoom(Room room) {
        roomList.add(room);
    }

    public List<Room> getRoomList() {
        return roomList;
    }
}
