package rpc.example;

public class CalcServiceImpl implements CalcServer {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a  - b;
    }
}
