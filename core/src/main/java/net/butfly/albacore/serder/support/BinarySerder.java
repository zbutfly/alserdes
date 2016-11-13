package net.butfly.albacore.serder.support;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.butfly.albacore.serder.Serder;
import net.butfly.albacore.utils.IOs;

public interface BinarySerder<PRESENT> extends Serder<PRESENT, byte[]>, ContentTypeSerder {
	default void ser(PRESENT from, OutputStream to) throws IOException {
		to.write(ser(from));
	}

	default <T extends PRESENT> T der(InputStream from, Class<T> to) throws IOException {
		return der(IOs.readAll(from), to);
	}
}