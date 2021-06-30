package com.ribeiroferreiralucas

import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class SelicInvestmentSimulatorTest {

    @Test
    fun negativeSelicException() {
        assertFailsWith<IllegalArgumentException> {
            SelicInvestmentSimulator(-0.1,0.0, 0, 0.0)
        }
    }
    @Test
    fun negativeInvestmentTaxException() {
        assertFailsWith<IllegalArgumentException> {
            SelicInvestmentSimulator(0.0,-0.1, 0, 0.0)
        }
    }
    @Test
    fun negativeWeeksCountException() {
        assertFailsWith<IllegalArgumentException> {
            SelicInvestmentSimulator(0.0,0.0, -1, 0.0)
        }
    }
    @Test
    fun negativeWeeklyInvestmentException() {
        assertFailsWith<IllegalArgumentException> {
            SelicInvestmentSimulator(0.0,0.0, 0, -10.0)
        }
    }

    @Test
    fun investedAmount() {
        val selicInvestmentSimulator = SelicInvestmentSimulator(0.0425,1.0, 36, 100.00)
        val investedAmount = selicInvestmentSimulator.investedAmount()
        assertEquals(3600.0, investedAmount,0.001)
    }

    @Test
    fun investedAmountZeroWeeks() {
        val selicInvestmentSimulator = SelicInvestmentSimulator(0.0425,1.0, 0, 100.00)
        val investedAmount = selicInvestmentSimulator.investedAmount()
        assertEquals(0.0, investedAmount,0.001)
    }
    @Test
    fun investedAmountZeroInvestment() {
        val selicInvestmentSimulator = SelicInvestmentSimulator(0.0425,1.0, 36, 0.0)
        val investedAmount = selicInvestmentSimulator.investedAmount()
        assertEquals(0.0, investedAmount,0.001)
    }

    @Test
    fun rentabilityMoreThenOneWeeks () {
        val selicInvestmentSimulator = SelicInvestmentSimulator(0.0425,1.0, 36, 100.00)

        val rentability = selicInvestmentSimulator.rentability()
        assertEquals(3652.54, rentability,0.01)
    }

    @Test
    fun rentabilityZeroWeeks () {

        val selicInvestmentSimulator = SelicInvestmentSimulator(0.05,1.2, 0, 100.00)

        val rentability = selicInvestmentSimulator.rentability()
        assertEquals(0.0, rentability,0.01)
    }

    @Test
    fun rentabilityTwoWeek () {

        val selicInvestmentSimulator = SelicInvestmentSimulator(0.05,1.2, 2, 100.00)

        val rentability = selicInvestmentSimulator.rentability()
        assertEquals(200.12, rentability,0.01)
    }

    @Test
    fun rentabilityOneYear () {

        val selicInvestmentSimulator = SelicInvestmentSimulator(0.05,1.0, 52, 100.00)
        val rentability = selicInvestmentSimulator.rentability()
        assertEquals(5330.52, rentability,0.01)
    }

    @Test
    fun rentabilityZeroInvestment () {

        val selicInvestmentSimulator = SelicInvestmentSimulator(0.05,1.0, 32, 0.0)
        val rentability = selicInvestmentSimulator.rentability()
        assertEquals(0.0, rentability,0.01)
    }
}