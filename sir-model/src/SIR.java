public class SIR {

    private final int population;
    private final int vaccinated;
    private final double rConstant;
    private final double infected;
    private final double iConstant;

    protected SIR(int population, double transRate, double recovery, int vaccinated, int infected) {
        this.population = population;
        this.vaccinated = vaccinated;
        this.infected = infected;
        this.rConstant =  1/recovery;
        this.iConstant = (transRate * rConstant) / (population-infected-(vaccinated*0.95));



    }

    public String getInfo(int days){
        double[] R = new double[days+1];
        R[0] = Math.ceil(vaccinated*0.95);

        double[] I = new double[days+1];
        I[0] = infected;

        double[] S = new double[days+1];
        S[0] = (population - R[0] - I[0]);

        for (int i = 1; i <= days; i++) {
            S[i] = S[i - 1] - (iConstant * I[i - 1] * S[i - 1]);
            I[i] = I[i-1] + (iConstant*I[i-1]*S[i-1]) - (rConstant*I[i-1]);
            R[i] = R[i-1] + (rConstant*I[i-1]);
        }
        return("S="+Math.round(S[days])+" I="+Math.round(I[days])+" R="+Math.round(R[days]));

    }


}
