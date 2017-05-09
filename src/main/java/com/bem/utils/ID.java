package com.bem.utils;

import java.util.UUID;

public class ID {
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
