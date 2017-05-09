package com.bem.utils;

import java.sql.Timestamp;

public class Time {
	public static Timestamp timestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
}
