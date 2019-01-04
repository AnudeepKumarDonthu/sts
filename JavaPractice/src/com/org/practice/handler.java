/*
* @(#)BvoipenhPendingonPendingHandler.java   
*
*  AT&T-PROPRIETARY (Use Pursuant to Company Instructions)
*  All Rights Reserved
*
*  THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
*  AT&T BELL LABORATORIES
*
*  The copyright notice above does not evidence any
*  actual or intended publication of source code.
*
*  Author:  Uma Akurathi
*  Created: 04/19/2017
*


package com.att.iom.bvoip.handler;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.att.iom.bvoip.data.BvoipEnhPendingUIEntity;
import com.att.iom.bvoip.db.BvoipIpfrOrdStkDbUtil;
import com.att.iom.bvoip.obj.BvoipDBPojo;
import com.att.iom.bvoip.obj.BvoipResultBean;
import com.att.iom.common.logging.Logger;

import iom.AbstractUIEntity;
import iom.AjaxRequestHandlerInterface;
import iom.IOMActionHandler;
import iom.ResultBean;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


@SuppressWarnings("deprecation")
public class BvoipEnhPendingonPendingHandler extends IOMActionHandler implements AjaxRequestHandlerInterface{
		private static Logger logger = Logger.getLogger("com.att.iom.bvoip.handler.BvoipEnhPendingonPendingHandler");
		public ResultBean createResultBean(HttpServletRequest request, HttpServletResponse response){
			String METHOD = "createResultBean : ";
			logger.info("Entered "+METHOD);
			BvoipResultBean rb = new BvoipResultBean();
			rb.setErrorMessage(null);
			String subAction = request.getParameter("subAction");
			logger.info(METHOD+": subAction="+subAction);
			try
			{
				if("PendingonPendingOrders".equalsIgnoreCase(subAction)){
					rb.setNextPage("voip/jsp/BvoipEnhPendingonPending.jsp");
					return rb;
				}
				else if(subAction != null && ("COPY_TO_FILE".equals(subAction))){
					logger.debug("export functionality");
					String mcn = request.getParameter( "mcn" ) != null ? ( request.getParameter( "mcn" ) ).trim() : request.getParameter( "mcn" );
					String grc = request.getParameter( "grc" ) != null ? ( request.getParameter( "grc" ) ).trim() : request.getParameter( "grc" );
					String soc = request.getParameter( "soc" ) != null ? ( request.getParameter( "soc" ) ).trim() : request.getParameter( "soc" );
					String siteid = request.getParameter( "siteid" ) != null ? ( request.getParameter( "siteid" ) ).trim() : request.getParameter( "siteid" );
					logger.debug("siteid"+siteid);
					logger.debug("mcn"+mcn);
					logger.debug("grc"+grc);
					logger.debug("soc"+soc);
					exportToFile(request,response,null,"19AH10","DNE","12");
				}
				
			}catch(Exception e){
				logger.error("Exception in BvoipEnhPendingonPendingHandler...", e);
			}
			
			return rb;
		}
		
			public AbstractUIEntity processRequest(HttpServletRequest request, HttpServletResponse response)
			{
				String method = "processRequest";
				String subAction = request.getParameter("subAction");
				logger.debug(method+": called with subAction: "+subAction);
				if(subAction != null && ("getPendingOrders".equals(subAction)))
				{
					try{
						return processAjaxRqst(request,response);
					}catch(Exception e)
					{
						logger.debug("processRequest",e);
					}
				}
				return null;
			}
			public BvoipEnhPendingUIEntity processAjaxRqst(HttpServletRequest request, HttpServletResponse response)
			{
				String METHOD = "BvoipEnhPendingUIEntity : ";
				Map<String, ArrayList<BvoipDBPojo>> penOrdMap = null;
				BvoipEnhPendingUIEntity entity = null;
				try {
					String subAction = request.getParameter("subAction");
					logger.debug("subAction :"+subAction);
					HttpSession session = request.getSession(false);
					logger.debug("session: "+session);
						if(session == null){
							logger.error("Session does not exist");
							return null;
						}
						String mcn = request.getParameter( "mcn" ) != null ? ( request.getParameter( "mcn" ) ).trim() : request.getParameter( "mcn" );
						String grc = request.getParameter( "grc" ) != null ? ( request.getParameter( "grc" ) ).trim() : request.getParameter( "grc" );
						String soc = request.getParameter( "soc" ) != null ? ( request.getParameter( "soc" ) ).trim() : request.getParameter( "soc" );
						String siteid = request.getParameter( "siteid" ) != null ? ( request.getParameter( "siteid" ) ).trim() : request.getParameter( "siteid" );
						if("getPendingOrders".equals(subAction)){
							logger.debug( METHOD+"subAction="+subAction+" : mcn=" + mcn +" : grc=" + grc +" : soc=" + soc +" : siteid="+ siteid );
							logger.debug(METHOD +"processing siteid & mcn triplets");
							penOrdMap = BvoipIpfrOrdStkDbUtil.getAllPendOrdIdsBySiteId(siteid,mcn,grc,soc);	
							logger.debug("penordmap size: "+penOrdMap.size());
							 entity = new BvoipEnhPendingUIEntity(penOrdMap);
							 logger.debug("entity"+entity);
							return entity;
							
						}
					}
				catch (Exception e) {
					logger.debug("Exception: ",e);
				}
				return entity;
			}
			
			public void exportToFile(HttpServletRequest request,HttpServletResponse response,String siteid,String mcn,String grc,String soc){
				
				String method="processCopyToFile";
				String voipHome = System.getProperty("VOIPHOME");
				String mcn = request.getParameter( "mcn" ) != null ? ( request.getParameter( "mcn" ) ).trim() : request.getParameter( "mcn" );
				String grc = request.getParameter( "grc" ) != null ? ( request.getParameter( "grc" ) ).trim() : request.getParameter( "grc" );
				String soc = request.getParameter( "soc" ) != null ? ( request.getParameter( "soc" ) ).trim() : request.getParameter( "soc" );
				String siteid = request.getParameter( "siteid" ) != null ? ( request.getParameter( "siteid" ) ).trim() : request.getParameter( "siteid" );
				Map<String, ArrayList<BvoipDBPojo>> penOrdMap = null;
				penOrdMap = BvoipIpfrOrdStkDbUtil.getAllPendOrdIdsBySiteId(siteid,mcn,grc,soc);	
				logger.debug("penOrdMap"+penOrdMap);
				Iterator<String> itr  = null;
				
				String fileName="UpLoad_PENDING_ORDERS_List.xls";
				String sheetName="UpLoad_PENDING_ORDERS_List";
			    String outputFile=voipHome+"/admin/log/"+fileName;
			    logger.info(method+" : outputFile : "+outputFile);
				
				int rowcount=0;
				int colcount=0;
				Row row=null;
				Cell cell=null;
				int rowPosition=0,rowHeight=300,cellPosition=0,cellWidth=4000;
				
				ArrayList<BvoipDBPojo> pendOrd = new ArrayList<BvoipDBPojo>();
				ArrayList<BvoipDBPojo> penOrdList = null;
				
				
				BvoipDBPojo dbpojo = null;
				try{
					HSSFWorkbook wb = new HSSFWorkbook();
					Sheet sheet=null;
					sheet = wb.createSheet(sheetName);//it will create sheet with name provided as 'sheetName'
					sheet.createFreezePane(0,1,0,1);
					//start : header row
					//here we will prepare first row of excel sheet for header
					rowPosition=rowcount;
					row=sheet.createRow((short)rowPosition);//this will create new row for each object
					row.setHeight((short)rowHeight);
					rowcount++;
					colcount=0;
					//customer name 
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("Customer Name");
					colcount++;
					
					//site id
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("Site ID");
					colcount++;
					//Order Number
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("Order Number");
					colcount++;
					//ACTIVITY
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("ACTIVITY");
					colcount++;
					//ACDD mm/dd/yy
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("ACDD mm/dd/yy");
					colcount++;
					//Scheduled Test and Turn up date mm/dd/yy
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("Scheduled Test and Turn up date mm/dd/yy");
					colcount++;
					//end : header row
					logger.info(method+" : after creating header : rowcount : "+rowcount);
					itr =  penOrdMap.keySet().iterator();
					while(itr.hasNext()){
						Object key = itr.next();
						pendOrd = penOrdMap.get((String)key);
							if(pendOrd == null) {
								logger.debug("continue: "+key);
								continue;
							}
					 penOrdList = new ArrayList<BvoipDBPojo>();
					   int count = pendOrd.size();
					   logger.info("size of the pendOrd object....."+count);
					   for(BvoipDBPojo pojo :pendOrd){
						   if(pojo == null){
							   logger.debug("continue: ");
								continue; 
						   }
						   penOrdList.add(pojo);
					   }
					   if(penOrdList.size()>0 && penOrdList != null ){
					   for(int i =0;i<penOrdList.size();i++){
						   rowPosition=rowcount;
							row=sheet.createRow((short)rowPosition);//this will create new row for each error object
							row.setHeight((short)rowHeight);
							rowcount++;
							colcount=0; 
						   dbpojo =(BvoipDBPojo)penOrdList.get(i);
						   logger.debug("dbpojo"+dbpojo.toString());
						   logger.debug("dbpojo"+dbpojo);
						
							//Customer Name
							cellPosition=colcount;
							cell= row.createCell((short)cellPosition);
							sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							ArrayList<BvoipDBPojo> tmpList = new ArrayList<BvoipDBPojo>();
							for (BvoipDBPojo tmpPojo : penOrdList) {
								if(dbpojo.getSiteid().equalsIgnoreCase(tmpPojo.getSiteid())) {
									tmpList.add(tmpPojo);
								}
							}
							   int tmpCount = tmpList.size();
							   logger.debug("tmpcount"+tmpCount);
							   int temprowposition = rowPosition;
							   boolean isflag = false;
							   if(tmpCount>1 && isflag ){
								   
								   for(int j=tmpCount;j>0;j--){
								   logger.debug("dbpojo.getCustomerName()"+dbpojo.getCustomerName());
								   cell.setCellValue(dbpojo.getCustomerName());
								   sheet.addMergedRegion(new CellRangeAddress(temprowposition,temprowposition+1,cellPosition,cellPosition));
								   logger.debug("rowPosition"+temprowposition);
								   logger.debug("rowPosition+1"+(temprowposition+1));
								   logger.debug("cellPosition"+cellPosition);
								   logger.debug("tmpCount"+(cellPosition));	
								   tmpCount--;
								   temprowposition = temprowposition+1;
								   logger.debug("rowPosition"+temprowposition);
								   }
								   isflag =true;
								  
							   }
							   else{
								   logger.debug("dbpojo.getCustomerName() in else"+dbpojo.getCustomerName());
								   cell.setCellValue(dbpojo.getCustomerName());
							   }
							
							colcount++;
							logger.debug("colcount"+colcount);
							//SiteID
							cellPosition=colcount;
							cell= row.createCell((short)cellPosition);
							sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							ArrayList<BvoipDBPojo> tmpList1 = new ArrayList<BvoipDBPojo>();
							for (BvoipDBPojo tmpPojo : penOrdList) {
								if(dbpojo.getSiteid().equalsIgnoreCase(tmpPojo.getSiteid())) {
									tmpList1.add(tmpPojo);
								}
							}
							   int tmpCount1 = tmpList1.size();
							   int temprowposition1 = rowPosition;
							   if(tmpCount1>1){
								   for(int j=tmpCount1;j>0;j--){
								   logger.debug("dbpojo.getSiteid()"+dbpojo.getSiteid());
								   cell.setCellValue(dbpojo.getSiteid());
							
								   sheet.addMergedRegion(new CellRangeAddress(temprowposition1,temprowposition1+1,cellPosition,cellPosition));
								   logger.debug("rowPosition"+temprowposition1);
								   logger.debug("rowPosition+1"+(temprowposition1+1));
								   logger.debug("cellPosition"+cellPosition);
								   logger.debug("tmpCount"+(cellPosition));	
								   tmpCount1--;
								   temprowposition1 = temprowposition1+1;
								   logger.debug("rowPosition"+temprowposition1);
								   }
								  
							   }
							   else{
								   logger.debug("dbpojo.getSiteid() in else"+dbpojo.getSiteid());
								   cell.setCellValue(dbpojo.getSiteid());
							   }
							
							colcount++;
							//Order Number
							cellPosition=colcount;
							cell= row.createCell((short)cellPosition);
							sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							cell.setCellValue(dbpojo.getOrderName());
							logger.debug("dbpojo.getOrderName()"+dbpojo.getOrderName());
							colcount++;
							//Activity description list
							cellPosition=colcount;
							cell= row.createCell((short)cellPosition);
							sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							ArrayList<String> actyDescList = dbpojo.getActyDescriptionList();
							String actDescFinalString = "";
							int size = actyDescList.size();
							logger.debug("description size"+size);
							for(String actyDesc : actyDescList ){
								actDescFinalString += actyDesc + "\n";
							}
							
							actDescFinalString = actDescFinalString.substring(0, actDescFinalString.length()-1);
							cell.setCellValue(actDescFinalString);
							logger.debug("actDescFinalString"+actDescFinalString);
							colcount++;
							//ACDD mm/dd/yy
							cellPosition=colcount;
							cell= row.createCell((short)cellPosition);
							sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							cell.setCellValue(dbpojo.getAcdd());
							logger.debug("dbpojo.getAcdd()"+dbpojo.getAcdd());
							colcount++;
							//Scheduled Test and Turn up date mm/dd/yy
							cellPosition=colcount;
							cell= row.createCell((short)cellPosition);
							sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							cell.setCellValue(dbpojo.getScttd());
							logger.debug("dbpojo.getScttd()"+dbpojo.getScttd());
							colcount++;
					   	}
					   }
					
					}			
					//write data to file
					try{
			            FileOutputStream fOut = new FileOutputStream(outputFile);
			            wb.write(fOut);//this line will write data from above created workbook 'wb' to file 'fOut'
			            fOut.flush();
			            fOut.close();
			            logger.info("File Created ..");            
			        }catch(Exception e) {
			        	logger.info("Exception while writing workbook to file : " + e );
			        }
					logger.info(method+" : after creating complete excel");
					//below code will allow to download the file
					request.getRequestDispatcher("/servlet/iom.BvoipFileDownloadServlet?filename="+outputFile).forward(request, response);
				}
				catch(Exception e) {
			    	logger.info("Exception while writing workbook to file : " + e );
			    }
			}	
			public void exportToFile(HttpServletRequest request,HttpServletResponse response,String mcn,String grc,String soc,String siteid){
				
				String method="processCopyToFile";
				String voipHome = System.getProperty("VOIPHOME");
				
				Map<String, ArrayList<BvoipDBPojo>> penOrdMap = null;
				penOrdMap = BvoipIpfrOrdStkDbUtil.getAllPendOrdIdsBySiteId(siteid,mcn,grc,soc);	
				
				Iterator<String> itr  = null;
				
				String fileName="UpLoad_PENDING_ORDERS_List.xls";
				String sheetName="UpLoad_PENDING_ORDERS_List";
			    String outputFile=voipHome+"/admin/log/"+fileName;
			    logger.info(method+" : outputFile : "+outputFile);
				
				int rowcount=0;
				int colcount=0;
				Row row=null;
				Cell cell=null;
				int rowPosition=0,rowHeight=300,cellPosition=0,cellWidth=4000;
				ArrayList<BvoipDBPojo> pendOrd = null;
				ArrayList<BvoipDBPojo> penOrdList = null;
				
				BvoipDBPojo dbpojo = null;
				
				while(itr.hasNext()){
					Object key = itr.next();
					pendOrd = penOrdMap.get((String)key);
						if(pendOrd == null) {
							logger.debug("continue: "+key);
							continue;
						}
				   int count = pendOrd.size();
				   logger.info("size of the pendOrd object.....");
				   for(BvoipDBPojo pojo :pendOrd){
					   if(pojo == null){
						   
					   }
					   penOrdList.add(pojo);
				   }
				try{
					HSSFWorkbook wb = new HSSFWorkbook();
					Sheet sheet=null;
					sheet = wb.createSheet(sheetName);//it will create sheet with name provided as 'sheetName'
					sheet.createFreezePane(0,1,0,1);
					//start : header row
					//here we will prepare first row of excel sheet for header
					rowPosition=rowcount;
					row=sheet.createRow((short)rowPosition);//this will create new row for each object
					row.setHeight((short)rowHeight);
					rowcount++;
					colcount=0;
					//customer name 
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("Customer Name");
					colcount++;
					//site id
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("Site ID");
					colcount++;
					//Order Number
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("Order Number");
					colcount++;
					//ACTIVITY
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("ACTIVITY");
					colcount++;
					//ACDD mm/dd/yy
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("ACDD mm/dd/yy");
					colcount++;
					//Scheduled Test and Turn up date mm/dd/yy
					cellPosition=colcount;
					cell= row.createCell((short)cellPosition);
					sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("Scheduled Test and Turn up date mm/dd/yy");
					colcount++;
					//end : header row
					logger.info(method+" : after creating header : rowcount : "+rowcount);
					itr =  penOrdMap.keySet().iterator();
					
					while(itr.hasNext()){
						Object key = itr.next();
						pendOrd = penOrdMap.get((String)key);
							if(pendOrd == null) {
								logger.debug("continue: "+key);
								continue;
							}
					   int count = pendOrd.size();
					   logger.info("size of the pendOrd object....."+count);
					   for(BvoipDBPojo pojo :pendOrd){
						   if(pojo == null){
							   logger.debug("continue: ");
								continue; 
						   }
						   penOrdList.add(pojo);
					   }
					if(penOrdList != null && penOrdList.size()>0){
					for(int i=0;i<penOrdList.size();i++){
						
						rowPosition=rowcount;
						row=sheet.createRow((short)rowPosition);//this will create new row for each error object
						row.setHeight((short)rowHeight);
						rowcount++;
						colcount=0;						
						dbpojo =(BvoipDBPojo)penOrdList.get(i);
						
						ArrayList<BvoipDBPojo> tmpList = new ArrayList<BvoipDBPojo>();
						   
						   for (BvoipDBPojo tmpPojo : penOrdList) {
							if(dbpojo.getSiteid().equalsIgnoreCase(tmpPojo.getSiteid())) {
								tmpList.add(tmpPojo);
							}
						}
						   int tmpCount = tmpList.size();
						  
						   if(tmpCount > 1) {
							  
							   //Customer Name
								cellPosition=colcount;
								cell= row.createCell((short)cellPosition);
								sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								cell.setCellValue(dbpojo.getCustomerName());
								sheet.addMergedRegion(new CellRangeAddress(cellPosition,tmpCount-1,0,0));
								colcount++;
								//SiteID
								cellPosition=colcount;
								cell= row.createCell((short)cellPosition);
								sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								cell.setCellValue(dbpojo.getSiteid());
								colcount++;
								sheet.addMergedRegion(new CellRangeAddress(cellPosition,tmpCount-1,0,0));
						   }else{
						
						//Customer Name
						cellPosition=colcount;
						cell= row.createCell((short)cellPosition);
						sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(dbpojo.getCustomerName());
						colcount++;
						//SiteID
						cellPosition=colcount;
						cell= row.createCell((short)cellPosition);
						sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(dbpojo.getSiteid());
						colcount++;
					
						}		  
						//Order Number
						cellPosition=colcount;
						cell= row.createCell((short)cellPosition);
						sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(dbpojo.getOrderName());
						colcount++;
						//Activity description list
						cellPosition=colcount;
						cell= row.createCell((short)cellPosition);
						sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						ArrayList<String> actyDescList = dbpojo.getActyDescriptionList();
						String actDescFinalString = "";
						int size = actyDescList.size();
						logger.debug("description size"+size);
						for(String actyDesc : actyDescList ){
							actDescFinalString += actyDesc + "\n ";
						}
						
						actDescFinalString = actDescFinalString.substring(0, actDescFinalString.length()-1);
						cell.setCellValue(actDescFinalString);
						colcount++;
						//ACDD mm/dd/yy
						cellPosition=colcount;
						cell= row.createCell((short)cellPosition);
						sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(dbpojo.getAcdd());
						colcount++;
						//Scheduled Test and Turn up date mm/dd/yy
						cellPosition=colcount;
						cell= row.createCell((short)cellPosition);
						sheet.setColumnWidth((short)cellPosition,(short)cellWidth);
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell.setCellValue(dbpojo.getScttd());
						colcount++;
					}
					}
					}
					try{
			            FileOutputStream fOut = new FileOutputStream(outputFile);
			            wb.write(fOut);//this line will write data from above created workbook 'wb' to file 'fOut'
			            fOut.flush();
			            fOut.close();
			            logger.info("File Created ..");            
			        }
					catch(Exception e) {
			        	logger.info("Exception while writing workbook to file : " + e );
			        }
					logger.info(method+" : after creating complete excel");
					//below code will allow to download the file
					request.getRequestDispatcher("/servlet/iom.BvoipFileDownloadServlet?filename="+outputFile).forward(request, response);
				}
				catch(Exception e) {
			    	logger.info("Exception while writing workbook to file : " + e );
			    }
		}
}



			
*/