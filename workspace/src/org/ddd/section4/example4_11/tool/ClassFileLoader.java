package org.ddd.section4.example4_11.tool;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class ClassFileLoader {

	public static Class<?> loadClass(File file) throws Exception {
		Map<Integer, Integer> offsetMap = new HashMap<Integer, Integer>();
		Map<Integer, String> classNameMap = new HashMap<Integer, String>();
		DataInputStream data = new DataInputStream(new FileInputStream(file));
		int magic = data.readInt(); // 0xcafebabe
		int minorVersion = data.readShort();
		int majorVersion = data.readShort();
		int constant_pool_count = data.readShort();
		int[] constant_pool = new int[constant_pool_count];
		for (int i = 1; i < constant_pool_count; i++) {
			int tag = data.read();
			int tableSize;
			switch (tag) {
			case 1: // UTF
				int length = data.readShort();
				char[] bytes = new char[length];
				for (int k = 0; k < bytes.length; k++)
					bytes[k] = (char) data.read();
				String className = new String(bytes);
				classNameMap.put(i, className);
				break;
			case 5: // LONG
			case 6: // DOUBLE
				data.readLong(); // discard 8 bytes
				i++; // Special skip necessary
				break;
			case 7: // CLASS
				int offset = data.readShort();
				offsetMap.put(i, offset);
				break;
			case 8: // STRING
				data.readShort(); // discard 2 bytes
				break;
			case 3: // INTEGER
			case 4: // FLOAT
			case 9: // FIELD_REF
			case 10: // METHOD_REF
			case 11: // INTERFACE_METHOD_REF
			case 12: // NAME_AND_TYPE
				data.readInt(); // discard 4 bytes;
				break;
			default:
				throw new RuntimeException("Bad tag " + tag);
			}
		}
		short access_flags = data.readShort();
		int this_class = data.readShort();
		int super_class = data.readShort();
		int classNameOffset = offsetMap.get(this_class);
		String className = classNameMap.get(classNameOffset).replace("/", ".");
		Class<?> clazz = Class.forName(className);
		return clazz;
	}

}
