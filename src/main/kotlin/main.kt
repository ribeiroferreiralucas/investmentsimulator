import com.ribeiroferreiralucas.SelicInvestmentSimulator

fun main() {

    val selicInvestmentSimulator = SelicInvestmentSimulator(0.0425,1.0, 36, 100.00)

    val rentability = selicInvestmentSimulator.rentability()
    val investedAmount = selicInvestmentSimulator.investedAmount()

    println("Você investiu um total de:")
    println("R$ $investedAmount")
    println("Com o rendimento:")
    println("R$ $rentability")
}