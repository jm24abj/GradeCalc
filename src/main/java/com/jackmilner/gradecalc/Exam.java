package com.jackmilner.gradecalc;

public class Exam {
    
    private String examName;
    private double maxMark;
    private double yourMark;
    private double examWeight;
    
    public Exam(String examName, double yourMark , double maxMark, double examWeight) {
        this.examName = examName;
        this.examWeight = examWeight/100;
        this.maxMark = maxMark;
        this.yourMark = yourMark;
    }
    
    public Exam(String examName, double maxMark, double examWeight) {
        this.examName = examName;
        this.examWeight = examWeight/100;
        this.maxMark = maxMark;
    }
    
    public double getExamPercentage() {
        
        return (yourMark / maxMark); 
    }
    
    public double getExamPercentageWeighted() {
        return (yourMark / maxMark) * examWeight * 100; 
    }
    
    public double getWeight() {
        return examWeight*100;
    }
    
    public String getName() {
        return this.examName;
    }
}
