package com.kotlin.phonenumberverification.usecase.impl

import com.kotlin.phonenumberverification.usecase.phoneVerificationService
import org.springframework.stereotype.Service


@Service
class phoneVerificationServiceImpl: phoneVerificationService{

    override fun verifyPhoneNumber(phoneNumber: String): String{

        var patternAirtel: String = """(0701|0708|0808|0812|0901|0902|0907|0708|0802)"""
        var patternMtn: String = """(07025|07026|0703|0704|0706|0803|0810|0813|0814|0816|0903|0906)"""
        var patternGlobacom: String = """(0705|0805|0807|0811|0815|0905)"""
        var pattern9mobile: String = """(0809|0817|0818|0909|0908)"""
        var patternSmile: String  = """0702"""
        var patternStarcomms: String = """(07028|07029|0819)"""
        var patternNtel: String = """0804"""


        val airtelRegex = patternAirtel.toRegex()
        val mtnRegex = patternMtn.toRegex()
        val globacomRegex = patternGlobacom.toRegex()
        val nineMobileRegex = pattern9mobile.toRegex()
        val smileRegex = patternSmile.toRegex()
        val starcommsRegex = patternStarcomms.toRegex()
        val ntelRegex = patternNtel.toRegex()

        var numberExtract = phoneNumber.take(5)
        if(phoneNumber.length==11) {
            if (airtelRegex.containsMatchIn(numberExtract)) {
                return  "$phoneNumber is an Airtel number"
            } else if (mtnRegex.containsMatchIn(numberExtract)) {
                return  "$phoneNumber is an MTN number"
            } else if (globacomRegex.containsMatchIn(numberExtract)) {
                return "$phoneNumber is a GLO number"
            } else if (nineMobileRegex.containsMatchIn(numberExtract)) {
                return "$phoneNumber is a 9Mobile number"
            } else if (smileRegex.containsMatchIn(numberExtract)) {
                return "$phoneNumber is a Smile number"
            } else if (starcommsRegex.containsMatchIn(numberExtract)) {
                return "$phoneNumber is a Starcomms number"
            } else if (ntelRegex.containsMatchIn(numberExtract)) {
                return "$phoneNumber is an Ntel number"
            } else {
                return "Invalid phone number"
            }
        }
        else{
            return "Invalid phone number length"
        }
    }
}
