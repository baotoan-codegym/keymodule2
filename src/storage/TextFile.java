package storage;

import model.Room;

import java.io.*;
import java.util.ArrayList;

public class TextFile {

    public static final String FILEPATH = "rom.txt";
    File baotoan =new File(FILEPATH );
    public void wirteFile(ArrayList<Room> rooms){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(baotoan);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(rooms);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Room> readFile(){
        ArrayList<Room> rooms = new ArrayList<>();
        File file = new File(FILEPATH);
        if (file.length() > 0){
            try {
                FileInputStream fileInputStream = new FileInputStream(FILEPATH);
                ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);
                rooms = (ArrayList<Room>) objectOutputStream.readObject();
                objectOutputStream.close();
                fileInputStream.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return rooms;


    }


}
