package numricalanalysis.Maths;

import java.util.*;

public class HelpingMethods {
    public static double[] generateDouble(String equation) {
        for (double i = 0; i < 10; i ++) {

            if ((calculateValue(toFuctions(equation), i) > 0 && calculateValue(toFuctions(equation), i + 1) < 0)||(calculateValue(toFuctions(equation), i) < 0 && calculateValue(toFuctions(equation), i + 1) > 0)) {
                return new double[]{i, i + 1};
            }
        }
        return new double[]{generateDouble(), generateDouble()};

    }

    public static LinkedList<String> toFuctions(String equation) {
        LinkedList<String> list = new LinkedList();
        for (int i = 0; i < equation.length(); i++) {
            if ((equation.charAt(i) == '+') || (equation.charAt(i) == '-')
                    || (equation.charAt(i) == '*') || (equation.charAt(i) == '/' || equation.charAt(i) == '^')) {
                list.add(equation.substring(0, i));
                list.add(Character.toString(equation.charAt(i)));
                equation = equation.substring(i + 1);
                i = 0;
            }
        }
        list.add(equation);

        return list;
    }

    public static double generateDouble() {
        Random number = new Random();
        String d = String.format("%f", number.nextFloat() / 1000);
        double d1 = Double.parseDouble(d) * 10000;
        return d1;

    }

    public static double calculateValue(LinkedList<String> functions, double number) {
        double res = 0;
        LinkedList<String> resultX = new LinkedList<>();

        String numberString = Double.toString(number);
        for (int i = 0; i < functions.size(); i++) {
            String temp = functions.get(i);
            resultX.add(temp.replaceAll("X", numberString));

        }
        System.out.println(resultX);
        resultX = calculateString(resultX);
        for (int i = 1; i < resultX.size(); i++) {
            if (resultX.get(i).contains("^")) {
                res = res + (Math.pow(Double.parseDouble(resultX.get(i - 1)), Double.parseDouble(resultX.get(i + 1).substring(1, resultX.get(i + 1).length() - 1))));
                resultX.set(i + 1, Double.toString(res));
                resultX.remove(i);
                resultX.remove(i - 1);
                i = 1;
            }
        }
        for (int i = 1; i < resultX.size(); i++) {
            if (resultX.get(i).contains("/")) {
                res = Double.parseDouble(resultX.get(i - 1)) / Double.parseDouble(resultX.get(i + 1));
                resultX.set(i + 1, Double.toString(res));
                resultX.remove(i);
                resultX.remove(i - 1);
                i = 1;
            } else if (resultX.get(i).contains("*")) {
                res = Double.parseDouble(resultX.get(i - 1)) * Double.parseDouble(resultX.get(i + 1));
                resultX.set(i + 1, Double.toString(res));
                resultX.remove(i);
                resultX.remove(i - 1);
                i = 1;
            }
        }
        for (int i = 1; i < resultX.size(); i++) {
            if (resultX.get(i).contains("+")) {
                res = Double.parseDouble(resultX.get(i - 1)) + Double.parseDouble(resultX.get(i + 1));
                resultX.set(i + 1, Double.toString(res));
                resultX.remove(i);
                resultX.remove(i - 1);
                i = 1;
            } else if (resultX.get(i).contains("-")) {
                res = Double.parseDouble(resultX.get(i - 1)) - Double.parseDouble(resultX.get(i + 1));
                resultX.set(i + 1, Double.toString(res));
                resultX.remove(i);
                resultX.remove(i - 1);
                i = 1;
            }
        }

        return Double.parseDouble(resultX.get(0));
    }

    private static LinkedList<String> calculateString(LinkedList<String> equation) {
        LinkedList<String> resultE = new LinkedList<>();
        for (int i = 0; i < equation.size(); i++) {
            if (equation.get(i).contains("e")) {
                resultE.add(equation.get(i).replaceAll("e", Double.toString(Math.E)));
            } else if (equation.get(i).startsWith("sin(")) {
                double value = Double.parseDouble(equation.get(i).substring(4, equation.get(i).length() - 1));
                resultE.add(Double.toString(Math.sin(value)));
            } else if (equation.get(i).startsWith("cos(")) {
                double value = Double.parseDouble(equation.get(i).substring(4, equation.get(i).length() - 1));

                resultE.add(Double.toString(Math.cos(value)));
            } else if (equation.get(i).startsWith("tan(")) {
                double value = Double.parseDouble(equation.get(i).substring(4, equation.get(i).length() - 1));

                resultE.add(Double.toString(Math.tan(value)));
            } else if (equation.get(i).startsWith("log(")) {
                double value = Double.parseDouble(equation.get(i).substring(4, equation.get(i).length() - 1));

                resultE.add(Double.toString(Math.log10(value)));
            } else if (equation.get(i).startsWith("ln(")) {
                double value = Double.parseDouble(equation.get(i).substring(3, equation.get(i).length() - 1));
                resultE.add(Double.toString(Math.log(value)));
            } else {
                resultE.add(equation.get(i));
            }
        }
        return resultE;

    }
}
