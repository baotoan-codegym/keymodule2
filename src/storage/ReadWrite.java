package storage;

import java.io.*;
import java.util.ArrayList;

public class ReadWrite<E> {
    private  static ReadWrite INSTANCE;
    private  ReadWrite(){

    }
    public static  ReadWrite getINSTANCE(){
        if (INSTANCE == null) INSTANCE = new ReadWrite();
        return INSTANCE;
    }
    public  void  writeFile(ArrayList<E> arrayList, String path){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arrayList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<E> readFile(String path){
        ArrayList<E> arrayList = new ArrayList<>();
        File file = new File(path);
        if (file.length() > 0){
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                arrayList = (ArrayList<E>) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}