package com.kotlin.phonenumberverification.web.controller

import com.kotlin.phonenumberverification.usecase.phoneVerificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping(value = [""])
class PhoneNumberVerificationController {


    @Autowired
    lateinit var phoneVerificationService: phoneVerificationService

    @RequestMapping("")
    fun verification(): String {
        return "index"
    }

    @RequestMapping( "/verify")
    fun verifyPhoneNumber(@RequestParam phoneNumber: String): String {
        val result = phoneVerificationService.verifyPhoneNumber(phoneNumber)
        if (result.contains('0')) {
            return "redirect:/?q=$result"
        }

        return "redirect:/?p=$result"
    }
}