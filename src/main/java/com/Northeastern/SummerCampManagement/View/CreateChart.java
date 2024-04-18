/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Northeastern.SummerCampManagement.View;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Chitra
 * @version 
 */
public class CreateChart extends JFrame{

    public CreateChart(String appTitle, String chartTitle)
    {
        PieDataset dataset = createDataset();
        JFreeChart chart = CreateChart(dataset, chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
        setContentPane(chartPanel);
      
    }
    
    private PieDataset createDataset(){
        DefaultPieDataset  result = new DefaultPieDataset();
        result.setValue("Windows", 65);
        result.setValue("Linux", 15);
        result.setValue("MAC", 20);
        return result;
    }
    
    private JFreeChart CreateChart(PieDataset dataset, String title)
    {
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset,true,true,false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(0);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }
}
