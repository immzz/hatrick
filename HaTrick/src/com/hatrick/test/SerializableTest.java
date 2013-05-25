package com.hatrick.test;

import com.hatrick.logic.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializableTest {
	public static int calcSize(java.io.Serializable o) {
		int ret = 0;
		class DumbOutputStream extends OutputStream {
			int count = 0;
			public void write(int b) throws IOException {
				count++; // 只计数，不产生字节转移
			}
		}
		DumbOutputStream buf = new DumbOutputStream();
		ObjectOutputStream os = null;
		try {
			os = new ObjectOutputStream(buf);
			os.writeObject(o);
			ret = buf.count;
		} catch (IOException e) {
		// No need handle this exception
		} finally {
			try {
				os.close();
			} catch (Exception e) {
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Hero newhero = new Hero(1, 2, 3, 4, 5);
		System.out.println("Size of Hero: " + calcSize(newhero));
		Operation newop = new Operation();
		System.out.println("Size of Operation: " + calcSize(newop));
	}
}