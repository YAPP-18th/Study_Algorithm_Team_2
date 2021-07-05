import java.util.*;
import java.util.stream.*;

class Solution {
    String[] operands = {
        "*",
        "-",
        "+"
    };
    boolean[] visited = new boolean[operands.length];
    ArrayList<ArrayList<String>> operandList = new ArrayList<>();
    String[] visitResult =  new String[operands.length];
    
    public long solution(String expression) {
        long answer = 0;
        makeOperandList(0);
        Result firstResult = splitExpression(expression);
        
        for(ArrayList<String> opList : operandList) {
            Result result = firstResult;
            for(String op : opList) {
                result = solve(op, result);
            }
            
            Long solveResult = Math.abs(
                result.valueList
                    .get(0)
            );
            
            if (answer < solveResult)
                answer = solveResult;
        }
        
        return answer;
    }
    
    private Result solve(String operand, Result target) {
        Long lastValue = target.valueList.get(0);
        ArrayList<Long> valueList = new ArrayList<>();
        ArrayList<String> operandList = new ArrayList<>();
        
        for(int i = 0; i < target.valueList.size() - 1; i ++) {
            Long currentValue = target.valueList.get(i+1);
            String currentOperand = target.operandList.get(i);
            
            if(currentOperand.equals(operand)) {
                lastValue = operation(lastValue, currentValue, currentOperand);
                continue;
            }
            
            valueList.add(lastValue);
            operandList.add(currentOperand);
            lastValue = currentValue;
        }
        
        valueList.add(lastValue);
        
        return new Result(valueList, operandList);
    }
    
    private Long operation(Long first, Long second, String operand) {
        Long result = Long.valueOf(0);
        switch(operand) {
            case "+":
                result = first + second;
                break;
            case "-":
                result =  first - second;
                break;
            case "*":
                result = first * second;   
                break;
        }
        return result;
    }
    
    private Result splitExpression(String expression) {
        ArrayList<Long> valueList = Arrays.stream(
            expression.split("\\*|\\+|\\-")
        ).map(
            value -> Long.parseLong(value)
        ).collect(
            Collectors.toCollection(ArrayList::new)
        );
        
        ArrayList<String> operandList = new ArrayList<String> (
            Arrays.asList(
                expression.replaceAll("[0-9]","")
                    .split("")
            )
        );

        return new Result(valueList, operandList);
    }
    
    private void makeOperandList(int depth) {
        if(depth == operands.length) {
            operandList.add(
                new ArrayList<String>(
                    Arrays.asList(visitResult)
                )
            );
            return;
        }
        
        for (int i = 0; i < operands.length; i ++) {
            if(!visited[i]) {
                visitResult[depth] = operands[i];
                visited[i] = true;
                makeOperandList(depth + 1);
                visited[i] = false;
            }
        }
    }
}

class Result {
    ArrayList<Long> valueList;
    ArrayList<String> operandList;
    
    public Result(ArrayList<Long> vList, ArrayList<String> oList) {
        this.valueList = vList;
        this.operandList = oList;
    }
}
