public class BenchmarkResult {
    private final String algorithmName;
    private final String caseType;
    private final int arraySize;
    private final long[] executionTimes;

    public BenchmarkResult(String algorithmName, String caseType, int arraySize, long[] executionTimes) {
        this.algorithmName = algorithmName;
        this.caseType = caseType;
        this.arraySize = arraySize;
        this.executionTimes = executionTimes;
    }

    public String getAlgorithmName() {
        return algorithmName;
    }

    public String getCaseType() {
        return caseType;
    }

    public int getArraySize() {
        return arraySize;
    }

    public long[] getExecutionTimes() {
        return executionTimes;
    }

    public double getMean() {
        return Statistics.mean(executionTimes);
    }

    public double getMedian() {
        return Statistics.median(executionTimes);
    }

    public double getStandardDeviation() {
        return Statistics.standardDeviation(executionTimes);
    }

    public long getMin() {
        return Statistics.min(executionTimes);
    }

    public long getMax() {
        return Statistics.max(executionTimes);
    }
}
