package com.kotlin.phonenumberverification.usecase

interface phoneVerificationService {
    fun verifyPhoneNumber(phoneNumber: String): String
}