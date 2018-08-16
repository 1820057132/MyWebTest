package com.neusoft.servletTest.common;

import com.neusoft.servletTest.bean.user.UserBean;
import com.neusoft.servletTest.service.user.IUserSevice;
import com.neusoft.servletTest.service.user.impl.UserServiceImpl;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Servlet implementation class ExportExcelServlet
 */
@WebServlet("/ExportExcelServlet")
public class ExportExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WritableWorkbook wwb = null;
	private WritableSheet sheetk = null;
	private IUserSevice user = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserBean> list = user.getUserList();
		try {
			exportCheckOrgMember(list,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		exportExcel(response,wwb);
	}
	private void exportCheckOrgMember(List<UserBean> list, HttpServletResponse response)
			throws IOException, WriteException {
		response.setContentType("application/ms-excel");
		String sheetName = "用户信息列表";//文件名==》用户信息列表
		sheetName = new String(sheetName.getBytes(),"iso8859-1");
		response.addHeader("Content-Disposition", "attachment;filename="+ sheetName + ".xls");
		OutputStream os = response.getOutputStream();
		wwb = Workbook.createWorkbook(os);
		wwb.setProtected(false);
		//EXECL中的一个sheet
		sheetk = wwb.createSheet("用户信息", 0);
		//============设置execl表的一些属性===========
		String[] title = {"", "账号", "昵称", "身份证", "电话", "性别"};
		Label label;
		for (int i = 0; i < title.length; i++) {
			// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
			// 在Label对象的子对象中指明单元格的位置和内容
			label = new Label(i, 0, title[i]);
			// 将定义好的单元格添加到工作表中
			sheetk.addCell(label);
		}
		//循环数据，将数据填充到单元格内
		int t = 1;
		for (UserBean user:list) {
			sheetk.addCell(new Label(0, t, t+""));
			sheetk.addCell(new Label(1, t, user.getLoginName()));
			sheetk.addCell(new Label(2, t, user.getNickName()));
			sheetk.addCell(new Label(3, t, user.getIDCard()));
			sheetk.addCell(new Label(4, t, user.getPhone()));
			sheetk.addCell(new Label(5, t, user.getSex()));
			t++;
		}
		
	}
	private void exportExcel(HttpServletResponse response,
			WritableWorkbook retValue) {
		response.setContentType("application/ms-excel");
		try {
			retValue.write();
			retValue.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
