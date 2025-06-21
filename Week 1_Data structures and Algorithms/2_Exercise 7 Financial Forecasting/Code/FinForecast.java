public class FinForecast
{
    public double predictFutureValue(double iv, double gr, int ny)
    {
        if (ny == 0)
            return iv;
        return predictFutureValue(iv*(1+gr), gr, ny-1);
    }
    public static void main(String[] args) {
        FinForecast forecaster = new FinForecast();
        double inamt = 1000.0;
        double agr = 0.05;
        int fy = 10;
        System.out.println("--- Financial Forecasting Tool ---");
        double fv = forecaster.predictFutureValue(inamt, agr, fy);
        System.out.printf("Initial Amount: $%.2f%n", inamt);
        System.out.printf("Annual Growth Rate: %.2f%%%n", agr*100);
        System.out.printf("Number of Years: %d%n", fy);
        System.out.printf("Predicted Future Value: $%.2f%n", fv);
    }
}