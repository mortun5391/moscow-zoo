package hse.moscowzoo.utils;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerInputProvider implements InputProvider {
    private Scanner scanner;

    public ScannerInputProvider() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}