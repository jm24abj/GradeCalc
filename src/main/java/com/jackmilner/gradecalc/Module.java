package com.jackmilner.gradecalc;

import java.util.ArrayList;

public class Module {
    
    private String name;
    private double targetGPA;
    private ArrayList<Exam> moduleExams;
    
    public Module() {      
        moduleExams = new ArrayList<Exam>();
    }
    
    public void addExam(Exam exam) {
        moduleExams.add(exam);
        System.out.println(moduleExams.size());
    }
    
    public void displayExams() {
        //System.out.println(moduleExams.size());
        
        for (int i = 0; i < moduleExams.size(); i++) {
            //System.out.println(i);
            Exam exam = moduleExams.get(i);
            System.out.println(exam.getName() + " : " + exam.getExamPercentage());
        }
    }
}
