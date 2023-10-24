import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.tha103.artion.activityComment.model.ActivityCommentDAO;
import com.tha103.artion.activityComment.model.ActivityCommentVO;

@WebServlet("/TicketOrderPic")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class TicketOrderPic extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得表單數據
		int memId = Integer.parseInt(request.getParameter("memId"));
		int actId = Integer.parseInt(request.getParameter("actId"));
		String actComContent = request.getParameter("actComContent");
		// 取得上傳的圖片檔案
		Part coverPicturePart = request.getPart("actComCoverPicture");
		Part picture1Part = request.getPart("actComPicture1");
		Part picture2Part = request.getPart("actComPicture2");
		Part picture3Part = request.getPart("actComPicture3");

		// 將圖片檔案轉換成byte
		byte[] coverPictureBytes = convertPartToByteArray(coverPicturePart);
		byte[] picture1Bytes = convertPartToByteArray(picture1Part);
		byte[] picture2Bytes = convertPartToByteArray(picture2Part);
		byte[] picture3Bytes = convertPartToByteArray(picture3Part);

		ActivityCommentVO comment = new ActivityCommentVO();
		comment.setMemId(memId);
		comment.setActId(actId);
		comment.setActComContent(actComContent);
		comment.setActComCoverPicture(coverPictureBytes);
		comment.setActComPicture1(picture1Bytes);
		comment.setActComPicture2(picture2Bytes);
		comment.setActComPicture3(picture3Bytes);
		comment.setActComStatus(true);
		ActivityCommentDAO activityCommentDAO = new ActivityCommentDAO();
		activityCommentDAO.insert(comment);
	}

	private byte[] convertPartToByteArray(Part part) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int bytesRead;
		try (InputStream inputStream = part.getInputStream()) {
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, bytesRead);
			}
		}
		return byteArrayOutputStream.toByteArray();
	}
}