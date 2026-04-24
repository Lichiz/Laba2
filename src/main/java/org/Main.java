package org;

import org.models.Mission;
import org.output.DetailedSum;
import org.output.Sum;
import org.output.SumModels;
import org.parsers.IMissionParser;
import org.parsers.MissionParserFactory;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Магический Анализатор 2.0 запущен.");
        System.out.print("Введите путь к файлу миссии: ");
        String path = scanner.nextLine();

        try {
            File file = new File(path);

            IMissionParser parser = MissionParserFactory.getParser(file);
            Mission mission = parser.parse(file);

            Sum report = new SumModels(mission);
            report = new DetailedSum(report, mission);

            report.print();

        } catch (Exception e) {
            System.err.println("Ошибка при обработке: " + e.getMessage());
            e.printStackTrace();
        }
    }
}