package com.jackmilner.gradecalc;

import java.util.ArrayList;

public class Module {
    
    private String name;
    private double targetGPA;
    private ArrayList<Exam> moduleExams;

    public Module(String name) {      
        this.name = name;
        moduleExams = new ArrayList<Exam>();
    }
    
    public boolean addExam(Exam exam) {
        if (canAddExam(exam.getWeight())){
            moduleExams.add(exam);
        } else {
            System.out.println("cant add");
            return false;
        }
        System.out.println(this.currentModuleGPA());
        
        return true;
    }
    
    public void displayExams() {
        for (int i = 0; i < moduleExams.size(); i++) {
            Exam exam = moduleExams.get(i);
            System.out.println(exam.getName() + " : " + exam.getExamPercentageWeighted());
        }
    }
    
    public boolean canAddExam(double weight) {
        double totalPercentage = 0;
        for (int i = 0; i < moduleExams.size(); i++) {
            Exam exam = moduleExams.get(i);
            totalPercentage += exam.getWeight();
        } 
        return (totalPercentage+weight)<= 100 && weight != 0; // can only add exam if all exams dont total over 100% and exam weight > 0
    }
    
    public double getCurrentTotalWeight() {
        double totalPercentage = 0;
        for (int i = 0; i < moduleExams.size(); i++) {
            Exam exam = moduleExams.get(i);
            totalPercentage += exam.getWeight();
        } 
        return totalPercentage;
    }
    
    public String percentageToGPA(double percentage) {
        if (percentage >= 80) {
            return "1st Class Honours (GPA:4.50)";
        } else if (percentage >= 75) {
            return "1st Class Honours (GPA:4.25)";
        } else if (percentage >= 70) {
            return "1st Class Honours (GPA:4.00)";
        } else if (percentage >= 67) {
            return "Upper Second-Class (2:1)(GPA:3.75)";
        } else if (percentage >= 64) {
            return "Upper Second-Class (2:1)(GPA:3.50)";
        } else if (percentage >= 60) {
            return "Upper Second-Class (2:1)(GPA:3.25)";
        } else if (percentage >= 57) {
            return "Lower Second-Class (2:2)(GPA:3.00)";
        } else if (percentage >= 54) {
            return "Lower Second-Class (2:2)(GPA:2.75)";
        } else if (percentage >= 50) {
            return "Referred or re-enrolled pass (2:2)(GPA:2.50)";
        } else {
            return "Fail";
        }
    }
    
    public String currentModuleGPA() {
        
        double totalPercentage = 0;
        
        for (int i = 0; i < moduleExams.size(); i++) {
            Exam exam = moduleExams.get(i);
            
            double percentage = exam.getExamPercentageWeighted();
            totalPercentage += percentage;
            String examName = exam.getName();
            
            System.out.println(examName + " : " + percentage);
        }
        
        return percentageToGPA(totalPercentage);
    }
    
    public String getName() {
        return this.name;
    }
}
