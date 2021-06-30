package com.ribeiroferreiralucas

import java.lang.IllegalArgumentException
import kotlin.math.pow

class SelicInvestmentSimulator(
    private val selicTax: Double,
    private val investmentTax: Double,
    private val weeksCount: Int,
    private val weeklyInvestment: Double ) {

    private val resultantTax : Double = investmentTax * selicTax
    private val dailyResultantTax : Double = (1 + resultantTax).pow(1/252.toDouble()) - 1
    private val weeklyResultantTax : Double = (1 + dailyResultantTax).pow(5.toDouble()) - 1

    init {
        if(selicTax < 0)
            throw IllegalArgumentException("selicTax must be greater or equals then 0")
        if(investmentTax < 0)
            throw IllegalArgumentException("investmentTax must be greater or equals then 0")
        if(weeksCount < 0)
            throw IllegalArgumentException("weeksCount must be greater or equals then 0")
        if(weeklyInvestment < 0)
            throw IllegalArgumentException("weeklyInvestment must be greater or equals then 0")
    }

    fun investedAmount(): Double {
        return weeklyInvestment * weeksCount
    }

    fun rentability(): Double {
        val finalValue = (weeklyInvestment * ((1 + weeklyResultantTax).pow(weeksCount.toDouble()) - 1)) / weeklyResultantTax;
        return finalValue
    }



}