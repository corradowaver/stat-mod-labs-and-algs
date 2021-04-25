package lab1;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Math.pow;
import static java.util.stream.Collectors.toList;

public class LabOne {

  private static final int N = 1000;

  public static void main(String[] args) throws IOException {
    List<Double> pseudoRandomList = getPseudoRandomList(N);

    System.out.println(pseudoRandomList);

    var median = pseudoRandomList.stream().mapToDouble(Double::valueOf).sum() / N;
    var dispersion = pseudoRandomList.stream().mapToDouble(u -> pow(u - median, 2)).sum() / N;
    var correlation = getCorrelation(pseudoRandomList, median, N);

    System.out.println("median: " + median);
    System.out.println("dispersion: " + dispersion);
    System.out.println("correlation: " + correlation);

    new PlotBuilder().addStickData("Correlation", listOfDoubles(1, N, 1), correlation).build();
    new PlotBuilder().addBarData("Density", listOfDoubles(1, 10, 10), calcNumberFrequency(pseudoRandomList, N)).build();
    new PlotBuilder().addLineData("Integral function distribution",
        listOfDoubles(1, N, 1),
        pseudoRandomList.stream().sorted().collect(toList())
    ).build();
  }

  private static List<Double> getPseudoRandomList(int N) {
    return IntStream.rangeClosed(1, N).mapToDouble((i) -> Math.random()).boxed().collect(toList());
  }

  private static List<Double> getCorrelation(List<Double> numbers, double median, int fMax) {
    return IntStream.rangeClosed(1, fMax)
        .mapToDouble((f) -> {
          var numerator = getNumerator(numbers, median, f, N);
          var denominator = getDenominator(numbers, median, N);
          return numerator / denominator;
        }).boxed()
        .collect(toList());
  }

  private static double getNumerator(List<Double> numbers, double median, int f, int N) {
    return IntStream.rangeClosed(1, N - f)
        .mapToDouble(i ->
            (numbers.get(i - 1) - median) * (numbers.get(i - 1 + f) - median)
        ).sum();
  }

  private static double getDenominator(List<Double> numbers, double median, int N) {
    return IntStream.rangeClosed(1, N)
        .mapToDouble(i ->
            pow((numbers.get(i - 1) - median), 2)
        ).sum();
  }

  private static List<Double> listOfDoubles(int start, int end, double divisor) {
    return IntStream.rangeClosed(start, end)
        .mapToDouble(i -> i / divisor).boxed()
        .collect(toList());
  }

  private static List<Double> calcNumberFrequency(List<Double> numbers, int N) {
    return IntStream.rangeClosed(0, 9)
        .mapToDouble(i -> {
              double left = i * 0.1;
              double right = left + 0.1;
              return (double) numbers.stream().filter(number -> (left < number && number < right)).count() / N;
            }
        ).boxed()
        .collect(toList());
  }
}
