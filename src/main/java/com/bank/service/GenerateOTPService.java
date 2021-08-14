package com.bank.service;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateOTPService {
	public int getOTP() {
		return ThreadLocalRandom.current().nextInt(100000, 999999);
	}
}
