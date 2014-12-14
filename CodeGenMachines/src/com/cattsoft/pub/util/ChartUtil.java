package com.cattsoft.pub.util;

import java.awt.Font;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import com.cattsoft.pub.ReportBeanList;
import com.cattsoft.pub.exception.SysException;

public class ChartUtil {
	
	
	/**
	 * 生成图片并返回地址
	 * @param bean
	 * @return
	 * @throws SysException 
	 */
	public static void chart(ReportBeanList list,ServletOutputStream sos,
			HttpServletResponse response,String title) throws SysException{
		
		List beanList = list.getBeanList();
		Map aBean = (HashMap)beanList.get(beanList.size()-1);
				
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		String[] columnName = list.getColumnName();
		String[] columnLabel = list.getColumnLabel();
		
		for(int j=0;j<columnName.length;j++){
	    	dataset.addValue(new Integer(aBean.get(columnName[j]).toString()).intValue(),aBean.get(columnName[j]).toString()+"="+columnLabel[j],columnLabel[j]);
	    }
	    
		JFreeChart chart = ChartFactory.createBarChart3D("", // 图表标题
		"定单状态", // 目录轴的显示标签
		"各状态下数量", // 数值轴的显示标签
		dataset, // 数据集
		PlotOrientation.VERTICAL, // 图表方向：水平、垂直
		true, // 是否显示图例(对于简单的柱状图必须是false)
		false, // 是否生成工具
		false // 是否生成URL链接
		);
		     
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		plot.setDomainAxis(domainAxis);
		ValueAxis rangeAxis = plot.getRangeAxis();
		     
		BarRenderer renderer = (BarRenderer)plot.getRenderer();
		renderer.setItemMargin(0.1);
		renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setItemLabelsVisible(true);
		plot.setRenderer(renderer);
		chart.setTitle(new TextTitle(title, new Font("Dailog", Font.PLAIN,10)));   
		try{
			response.setContentType("text/html;charset=UTF-8"); 
			sos = response.getOutputStream();
		    ChartUtilities.writeChartAsJPEG(sos,chart,900,600);
		    
	    }catch(IOException ioe){
	    	throw new SysException("","生成条形图时发生IO异常",ioe);
	    }finally{
	    	if(sos!=null){
	    		try {
					sos.close();
				} catch (IOException e) {
					throw new SysException("","关闭输出流时发生IO异常",e);
				}
	    	}
	    }
		
	}
	
	

}
