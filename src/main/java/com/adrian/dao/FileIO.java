package com.adrian.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO<T> {
	
	private String filename;
	
	public FileIO(String filename) {
		this.filename = filename;
	}
	
	public void writeObject(T object) {
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filename));
			oos.writeObject(object);
			oos.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public T readObject() {
		T ret;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			ret = (T)ois.readObject();
			ois.close();
			return ret;
		} catch(FileNotFoundException e) {
			System.out.println("File has not been created yet");
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
